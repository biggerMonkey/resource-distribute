package com.resource.distribute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.MobileJobNumberDao;
import com.resource.distribute.dto.QueryMobileReq;
import com.resource.distribute.entity.MobileJobNumber;
import com.resource.distribute.service.MobileJobNumberService;
import com.resource.distribute.utils.AuthCurrentUser;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
@Service
public class MobileJobNumberServiceImpl implements MobileJobNumberService {

    @Autowired
    private MobileJobNumberDao mobileJobNumberDao;

    @Override
    public ReturnInfo addMobile(MobileJobNumber mobileJobNumber) {
        mobileJobNumber.setCreateBy(AuthCurrentUser.getUserId());
        mobileJobNumberDao.insertSelective(mobileJobNumber);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo updateMobile(MobileJobNumber mobileJobNumber) {
        mobileJobNumber.setUpdateBy(AuthCurrentUser.getUserId());
        mobileJobNumberDao.updateByPrimaryKeySelective(mobileJobNumber);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo delMobileById(Integer mobileJobNumberId) {
        mobileJobNumberDao.deleteByPrimaryKey(mobileJobNumberId);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo listMobile(QueryMobileReq queryMobileReq) {
        PageHelper.startPage(queryMobileReq.getPageNo(), queryMobileReq.getPageSize());
        Example example = new Example(MobileJobNumber.class);
        example.createCriteria().andLike("mobileJobNumber",
                "%" + queryMobileReq.getMobileJobNumber() + "%");
        List<MobileJobNumber> numbers = mobileJobNumberDao.selectByExample(example);
        return ReturnInfo.createReturnSucces(numbers);
    }
}
