package com.resource.distribute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.RecordDao;
import com.resource.distribute.dto.RecordQueryReq;
import com.resource.distribute.entity.Record;
import com.resource.distribute.service.RecordService;

/**
 * @author huangwenjun
 * @Date 2018年6月27日
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDao;

    @Override
    public ReturnInfo logList(RecordQueryReq logQueryReq) {
        PageHelper.startPage(logQueryReq.getPageNo(), logQueryReq.getPageSize());
        List<Record> records = recordDao.selectAllRecord();
        return ReturnInfo.createReturnSucces(records);
    }

}
