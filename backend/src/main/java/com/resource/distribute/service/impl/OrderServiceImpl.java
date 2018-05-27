package com.resource.distribute.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.Constant;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.AreaDao;
import com.resource.distribute.dao.OrderDao;
import com.resource.distribute.dao.RecordDao;
import com.resource.distribute.dto.OrderQueryReq;
import com.resource.distribute.dto.OrderUpdateReq;
import com.resource.distribute.dto.ReceiveOrderReq;
import com.resource.distribute.entity.Area;
import com.resource.distribute.entity.MobileOrder;
import com.resource.distribute.entity.Record;
import com.resource.distribute.entity.User;
import com.resource.distribute.service.OrderService;
import com.resource.distribute.utils.AuthCurrentUser;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:53:54
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private RecordDao recordDao;

    @Override
    public ReturnInfo updateOrder(OrderUpdateReq orderReq) {
        MobileOrder order = new MobileOrder();
        BeanUtils.copyProperties(orderReq, order);
        order.setUpdateBy(AuthCurrentUser.getUserId());
        orderDao.updateByPrimaryKeySelective(order);
        insertRecord("更新", orderReq.getId());
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo listOrder(OrderQueryReq queryReq) {
        PageHelper.startPage(queryReq.getPageNum(), queryReq.getPageSize());
        List<MobileOrder> orders = new ArrayList<MobileOrder>();
        String hadDial = "待拨打";
        if ("已拨打".equals(queryReq.getHandSituation())) {
            queryReq.setHandSituation(null);
        } else {
            hadDial = null;
        }
        if (AuthCurrentUser.get().getUserInfo().getRoleType().equals(Constant.USER.ADMIN)) {
            orders = orderDao.listOrder(queryReq, null, hadDial);
        } else {
            orders =
                    orderDao.listOrder(queryReq,
                            AuthCurrentUser.get().getUserInfo().getJobNumber(), hadDial);
        }
        return ReturnInfo.createReturnSucces(orders);
    }

    @Override
    public ReturnInfo importOrder(MultipartFile orderfile, Integer areaId) throws Exception {
        Area area = areaDao.selectByPrimaryKey(areaId);
        if (area == null) {
            return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR);
        }
        // 1.得到Excel常用对象
        InputStream inputStream;
        String fileName = orderfile.getOriginalFilename();
        Workbook workbook = null;
        inputStream = orderfile.getInputStream();
        if (fileName.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileName.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        }
        if (workbook == null) {
            // return new SyncReturnInfo(false, "444", "workbook为null", "");
        }
        // 读取工作表
        Sheet sheet = workbook.getSheetAt(0);
        // 总行数
        int trLength = sheet.getLastRowNum();
        // 4.得到Excel工作表的行
        Row row = sheet.getRow(0);
        // 总列数
        int tdLength = row.getLastCellNum();
        List<MobileOrder> orders = new ArrayList<MobileOrder>();
        for (int i = 1; i <= trLength; i++) {
            MobileOrder order = new MobileOrder();
            order.setAreaId(areaId);
            order.setState("");
            order.setHandSituation(Constant.ORDER.DEFAULT_SISUATION);
            order.setJobNumber("");
            order.setUserName("");
            order.setCreateBy(AuthCurrentUser.getUserId());
            order.setMobileJobNumber(AuthCurrentUser.getMobileJobNum());
            order.setCreateTime(new Date());
            // 得到Excel工作表的行
            Row row1 = sheet.getRow(i);
            for (int j = 0; j < tdLength; j++) {
                // 得到Excel工作表指定行的单元格
                Cell cell1 = row1.getCell(j);
                // 获得每一列中的值
                String value = "";
                if (cell1 != null) {
                    value = cell1.getStringCellValue();
                }
                switch (j) {
                    case 0: {
                        order.setMobileNumber(value);
                        break;
                    }
                    case 1: {
                        order.setMainMeal(value);
                        break;
                    }
                    case 2: {
                        order.setSecondMeal(value);
                        break;
                    }
                    case 3: {
                        order.setUpValue(value);
                        break;
                    }
                    case 4: {
                        order.setOverFlow(value);
                        break;
                    }
                    case 5: {
                        order.setBroadband(value);
                        break;
                    }
                    case 6: {
                        order.setRemarks(value);
                        break;
                    }
                    default:
                        break;
                }
            }
            orders.add(order);
        }
        int result = orderDao.insertList(orders);
        return ReturnInfo.createReturnSuccessOne(result);
    }

    @Override
    public synchronized ReturnInfo receiveOrderSearch(ReceiveOrderReq receiveOrderReq) {

        return ReturnInfo.createReturnSucces(searchOrder(receiveOrderReq));
    }

    @Override
    public ReturnInfo receiveOrder(ReceiveOrderReq receiveOrderReq) {
        receiveOrderReq.setPageSize(receiveOrderReq.getOrderNum());
        List<MobileOrder> orders = searchOrder(receiveOrderReq);
        User user = AuthCurrentUser.get().getUserInfo();
        for (MobileOrder order : orders) {
            order.setMobileJobNumber(AuthCurrentUser.getMobileJobNum());
            order.setJobNumber(user.getJobNumber());
            order.setUserName(user.getUserName());
            orderDao.updateByPrimaryKeySelective(order);
        }
        insertRecord("领取单子:" + orders.size(), null);
        return ReturnInfo.createReturnSuccessOne(orders.size());
    }

    private List<MobileOrder> searchOrder(ReceiveOrderReq receiveOrderReq) {
        if (!StringUtils.isEmpty(receiveOrderReq.getUpValue())) {
            String upValue = receiveOrderReq.getUpValue().trim();
            String upNum = "0";
            int flag = 0;
            for (int i = 0; i < upValue.length(); i++) {
                if (upValue.charAt(i) >= 48 && upValue.charAt(i) <= 57) {
                    upNum += upValue.charAt(i);
                } else {
                    flag = i;
                    break;
                }
            }
            Integer startValue = Integer.valueOf(upNum);
            if (upValue.indexOf("上") != -1) {
                receiveOrderReq.setStartValue(startValue);
            } else if (upValue.indexOf("下") != -1) {
                receiveOrderReq.setEndValue(startValue);
            } else {
                int endValue =
                        Integer.valueOf(upValue.split(String.valueOf(upValue.charAt(flag)))[1]);
                receiveOrderReq.setStartValue(startValue);
                receiveOrderReq.setEndValue(endValue);
            }
        }
        PageHelper.startPage(receiveOrderReq.getPageNum(), receiveOrderReq.getPageSize());
        List<MobileOrder> orders = orderDao.recieveListOrder(receiveOrderReq);
        return orders;
    }

    void insertRecord(String content, Integer orderId) {
        Record record = new Record();
        record.setJobNum(AuthCurrentUser.get().getUserInfo().getJobNumber());
        record.setUserName(AuthCurrentUser.get().getUserInfo().getUserName());
        record.setMobileJobNum(AuthCurrentUser.getMobileJobNum());
        record.setContent(content);
        record.setOrderId(orderId);
        recordDao.insertSelective(record);
    }
}
