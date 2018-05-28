package com.resource.distribute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.AreaDao;
import com.resource.distribute.dto.QueryAreaReq;
import com.resource.distribute.entity.Area;
import com.resource.distribute.service.AreaService;
import com.resource.distribute.utils.AuthCurrentUser;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public ReturnInfo addArea(Area area) {
        area.setCreateBy(AuthCurrentUser.getUserId());
        areaDao.insertSelective(area);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo updateArea(Area area) {
        area.setUpdateBy(AuthCurrentUser.getUserId());
        areaDao.updateByPrimaryKeySelective(area);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo delAreaById(Integer areaId) {
        areaDao.deleteByPrimaryKey(areaId);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo listArea(QueryAreaReq queryAreaReq) {
        PageHelper.startPage(queryAreaReq.getPageNo(), queryAreaReq.getPageSize());
        Example example = new Example(Area.class);
        example.createCriteria().andLike("areaName", "%" + queryAreaReq.getAreaName() + "%");
        List<Area> areas = areaDao.selectByExample(example);
        return ReturnInfo.createReturnSucces(areas);
    }
}
