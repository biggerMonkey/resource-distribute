package com.resource.distribute.service;

import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.entity.Code;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public interface CodeService {

    public ReturnInfo addCode(Code code);

    public ReturnInfo updateCode(Code code);

    public ReturnInfo delCodeById(Integer codeId);

    public ReturnInfo listById(Integer parentId);
}
