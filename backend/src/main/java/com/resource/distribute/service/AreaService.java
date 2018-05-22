package com.resource.distribute.service;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dto.QueryAreaReq;
import com.resource.distribute.entity.Area;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public interface AreaService {

    public ReturnInfo addArea(Area area);

    public ReturnInfo updateArea(Area area);

    public ReturnInfo delAreaById(Integer areaId);

    public ReturnInfo listArea(QueryAreaReq queryAreaReq);
}
