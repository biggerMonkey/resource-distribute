package com.resource.distribute.service.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.Constant;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.AreaDao;
import com.resource.distribute.dao.OrderDao;
import com.resource.distribute.dao.RecordDao;
import com.resource.distribute.dao.SysConfigDao;
import com.resource.distribute.dao.UserOrderDao;
import com.resource.distribute.dto.CountReq;
import com.resource.distribute.dto.CountRes;
import com.resource.distribute.dto.OrderQueryReq;
import com.resource.distribute.dto.OrderUpdateReq;
import com.resource.distribute.dto.ReceiveOrderReq;
import com.resource.distribute.dto.UserOrderQueryInfo;
import com.resource.distribute.entity.Area;
import com.resource.distribute.entity.MobileOrder;
import com.resource.distribute.entity.Record;
import com.resource.distribute.entity.SysConfig;
import com.resource.distribute.entity.User;
import com.resource.distribute.entity.UserOrder;
import com.resource.distribute.service.OrderService;
import com.resource.distribute.utils.AuthCurrentUser;

/**
 * @author huangwenjun
 * @version 2018年5月21日 下午9:53:54
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private RecordDao recordDao;

    @Autowired
    private SysConfigDao sysConfigDao;

    @Autowired
    private UserOrderDao userOrderDao;

    @Override
    @Transactional
    public synchronized ReturnInfo updateOrder(OrderUpdateReq orderReq) {
        UserOrder userOrder = new UserOrder();
        userOrder.setOrderId(orderReq.getOrderId());
        userOrder.setUserId(AuthCurrentUser.getUserId());
        userOrder.setOrderState(orderReq.getState());
        userOrder.setHandSituation(orderReq.getHandSituation().trim());
        userOrder.setRemarks(orderReq.getRemarks());
        userOrder.setMainCourse(orderReq.getMainCourse());
        userOrder.setPairCourse(orderReq.getPairCourse());
        userOrder.setBroadbandInfo(orderReq.getBroadband());
        userOrder.setNewlyOpen(orderReq.getNewlyOpen());
        userOrder.setPriceDifference(orderReq.getPriceDifference());
        userOrder.setUpdateBy(AuthCurrentUser.getUserId());
        userOrder.setDevId(AuthCurrentUser.get().getUserInfo().getDevId());

        Example userOrderExample = new Example(UserOrder.class);
        userOrderExample.createCriteria().andEqualTo("orderId", orderReq.getOrderId())
                .andEqualTo("userId", AuthCurrentUser.getUserId());
        userOrderDao.updateByExampleSelective(userOrder, userOrderExample);
        insertRecord("更新 orderId->", orderReq.getOrderId());

        Example orderExample = new Example(UserOrder.class);
        orderExample.createCriteria().andEqualTo("handSituation", Constant.ORDER.NOT_ACCORD)
                .andEqualTo("orderId", orderReq.getOrderId());
        List<UserOrder> userOrders = userOrderDao.selectByExample(orderExample);
        if (userOrders == null || userOrders.size() == 0) {
            return ReturnInfo.createReturnSuccessOne(null);
        }
        SysConfig configs = sysConfigDao.selectByPrimaryKey(Constant.SYS_CONFIG.MAIN_CHANGE_NUM_ID);
        if (configs == null) {
            return ReturnInfo.createReturnSuccessOne(CodeEnum.DATA_INVALID);
        }
        String[] remarks = new String[userOrders.size()];
        int[] counts = new int[userOrders.size()];
        int tempNum = 0;
        boolean flag = true;
        if (userOrders.size() >= Integer.valueOf(configs.getSysValue())) {
            for (UserOrder tempUserOrder : userOrders) {
                if (tempUserOrder.getHandSituation().equals(Constant.ORDER.NOT_ACCORD)) {
                    for (int i = 0; i < remarks.length; i++) {
                        if (tempUserOrder.getRemarks().equals(remarks[i])) {
                            counts[i]++;
                            flag = false;
                        }
                    }
                    if (flag) {
                        remarks[tempNum] = tempUserOrder.getRemarks();
                        counts[tempNum]++;
                        tempNum++;
                        flag = true;
                    }
                }
            }
            for (int j = 0; j < counts.length; j++) {
                if (counts[j] >= Integer.valueOf(configs.getSysValue())) {
                    String[] needChangeRemark = remarks[j].split("&");
                    if (needChangeRemark.length != 2) {
                        LOG.info("备注信息有误：" + remarks[j]);
                        continue;
                    }
                    MobileOrder mobileOrder = new MobileOrder();
                    mobileOrder.setId(orderReq.getOrderId());
                    mobileOrder.setMainMeal(needChangeRemark[0]);
                    mobileOrder.setSecondMeal(needChangeRemark[1]);
                    orderDao.updateByPrimaryKeySelective(mobileOrder);
                }
            }
        }
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo listOrder(OrderQueryReq queryReq) {
        PageHelper.startPage(queryReq.getPageNo(), queryReq.getPageSize());
        List<UserOrderQueryInfo> orders = new ArrayList<UserOrderQueryInfo>();
        if (!Constant.ORDER.DEFAULT_SISUATION.equals(queryReq.getHandSituation())) {
            if (AuthCurrentUser.get().getUserInfo().getRoleType().equals(Constant.USER.ADMIN)) {
                orders = orderDao.listOtherOrder(queryReq, null);
            } else {
                orders =
                        orderDao.listOtherOrder(queryReq, AuthCurrentUser.get().getUserInfo()
                                .getJobNumber());
            }
        } else {
            if (AuthCurrentUser.get().getUserInfo().getRoleType().equals(Constant.USER.ADMIN)) {
                orders = orderDao.listWaitOrder(queryReq, null);
            } else {
                orders =
                        orderDao.listWaitOrder(queryReq, AuthCurrentUser.get().getUserInfo()
                                .getJobNumber());
            }
        }
        return ReturnInfo.createReturnSucces(orders);
    }

    @Override
    public ReturnInfo importOrder(MultipartFile orderfile, Integer areaId, Integer orderType)
            throws Exception {
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
            order.setIsSensitive(orderType);
            order.setCreateBy(AuthCurrentUser.getUserId());
            order.setCreateTime(new Date());
            // 得到Excel工作表的行
            Row row1 = sheet.getRow(i);
            for (int j = 0; j < tdLength; j++) {
                // 得到Excel工作表指定行的单元格
                Cell cell = row1.getCell(j);
                // 获得每一列中的值
                String value = "";
                if (cell != null && cell.getCellTypeEnum().equals(CellType.STRING)) {
                    value = cell.getStringCellValue();
                } else if (cell != null && cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                    value = String.valueOf(cell.getNumericCellValue());
                } else {
                    value = "非法数据类型";
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
                        order.setBroadband(value);
                        break;
                    }
                    case 4: {
                        order.setBackupFieldOne(value);
                        break;
                    }
                    case 5: {
                        order.setBackupFieldTwo(value);
                        break;
                    }
                    default:
                        break;
                }
            }
            orders.add(order);
        }
        for (MobileOrder order : orders) {
            Example example = new Example(MobileOrder.class);
            example.createCriteria().andEqualTo("mobileNumber", order.getMobileNumber());
            List<MobileOrder> oldOrders = orderDao.selectByExample(example);
            if (CollectionUtils.isEmpty(oldOrders)) {
                orderDao.insertSelective(order);
            } else {
                orderDao.updateByExample(order, example);
            }
        }
        return ReturnInfo.createReturnSuccessOne(null);
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
        String orderIds = "";
        for (MobileOrder order : orders) {
            UserOrder userOrder = new UserOrder();
            userOrder.setUserId(user.getId());
            userOrder.setOrderId(order.getId());
            userOrder.setJobNumber(user.getJobNumber());
            userOrder.setUserName(user.getUserName());
            userOrder.setMobileJobNumber(AuthCurrentUser.getMobileJobNum());
            userOrder.setReceiveTime(new Date());
            userOrder.setHandSituation(Constant.ORDER.DEFAULT_SISUATION);
            userOrderDao.insertSelective(userOrder);
            orderIds += order.getId() + " ";
        }
        insertRecord("领取单子:数量->" + orders.size() + " 单子id->" + orderIds, null);
        return ReturnInfo.createReturnSuccessOne(orders.size());
    }

    private List<MobileOrder> searchOrder(ReceiveOrderReq receiveOrderReq) {
        // if (!StringUtils.isEmpty(receiveOrderReq.getUpValue())) {
        // String upValue = receiveOrderReq.getUpValue().trim();
        // String upNum = "0";
        // int flag = 0;
        // for (int i = 0; i < upValue.length(); i++) {
        // if (upValue.charAt(i) >= 48 && upValue.charAt(i) <= 57) {
        // upNum += upValue.charAt(i);
        // } else {
        // flag = i;
        // break;
        // }
        // }
        // Integer startValue = Integer.valueOf(upNum);
        // if (upValue.indexOf("上") != -1) {
        // receiveOrderReq.setStartValue(startValue);
        // } else if (upValue.indexOf("下") != -1) {
        // receiveOrderReq.setEndValue(startValue);
        // } else {
        // int endValue =
        // Integer.valueOf(upValue.split(String.valueOf(upValue.charAt(flag)))[1]);
        // receiveOrderReq.setStartValue(startValue);
        // receiveOrderReq.setEndValue(endValue);
        // }
        // }
        String recieveIntervalTime = "1900-01-01 00:00:00";
        String notSuccessTime = "1900-01-01 00:00:00";
        String successTime = "1900-01-01 00:00:00";
        List<SysConfig> configs = sysConfigDao.selectAll();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        long nowTime = cal.getTimeInMillis();
        for (SysConfig tempConfig : configs) {
            long newTime =
                    nowTime - Integer.valueOf(tempConfig.getSysValue()) * 24
                            * Constant.TIME.oneHourMillisecond;
            Date date2 = new Date(newTime);
            switch (tempConfig.getId()) {
                case Constant.SYS_CONFIG.RECIEVE_TIME_ID:
                    recieveIntervalTime = simpleDateFormat.format(date2);
                    break;
                case Constant.SYS_CONFIG.NOT_SUCCESS_TIME_ID:
                    notSuccessTime = simpleDateFormat.format(date2);
                    break;
                case Constant.SYS_CONFIG.SUCCESS_TIME_ID:
                    successTime = simpleDateFormat.format(date2);
                    break;
            }
        }
        PageHelper.startPage(receiveOrderReq.getPageNo(), receiveOrderReq.getPageSize());
        List<MobileOrder> orders =
                orderDao.recieveListOrder(receiveOrderReq, recieveIntervalTime, notSuccessTime,
                        successTime);
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

    @Override
    public ReturnInfo mainMeal() {
        List<String> mainMeals = orderDao.getListMainMeal();
        return ReturnInfo.createReturnSuccessOne(mainMeals);
    }

    @Override
    public ReturnInfo secondMeal() {
        List<String> secondMeals = orderDao.getListSecondMeal();
        return ReturnInfo.createReturnSuccessOne(secondMeals);
    }

    @Override
    public ReturnInfo orderCount(CountReq countReq) {
        PageHelper.startPage(countReq.getPageNo(), countReq.getPageSize());
        List<UserOrderQueryInfo> userOrderQueryInfos = orderDao.listOrderByCount(countReq);
        // 领单数
        int recieveNum = userOrderQueryInfos.size();
        // 成功数
        int successNum = 0;
        int totalPriceDiff = 0;
        for (UserOrderQueryInfo userOrder : userOrderQueryInfos) {
            System.out.println(userOrder.toString());
            totalPriceDiff += userOrder.getPriceDifference();
            if (userOrder.getHandSituation().equals(Constant.ORDER.SUCCESS)) {
                successNum++;
            }
        }
        // 成功率
        BigDecimal recieve = new BigDecimal(recieveNum);
        BigDecimal success = new BigDecimal(successNum);
        BigDecimal successRate = new BigDecimal(0);
        if (!success.equals(successRate)) {
            successRate = success.divide(recieve, 4, BigDecimal.ROUND_UP);
        }
        CountRes countRes = new CountRes();
        countRes.setRecieveNum(recieveNum);
        countRes.setSuccessNum(successNum);
        countRes.setSuccessRate(successRate.doubleValue());
        countRes.setTotalPriceDiff(totalPriceDiff);
        countRes.setUserOrderQueryInfos(userOrderQueryInfos);
        return ReturnInfo.createReturnSuccessOne(countRes);
    }
}
