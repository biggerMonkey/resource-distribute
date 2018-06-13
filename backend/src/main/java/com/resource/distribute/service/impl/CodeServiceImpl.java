package com.resource.distribute.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.resource.distribute.common.CodeEnum;
import com.resource.distribute.common.ReturnInfo;
import com.resource.distribute.dao.CodeDao;
import com.resource.distribute.entity.Code;
import com.resource.distribute.service.CodeService;
import com.resource.distribute.utils.AuthCurrentUser;
import com.resource.distribute.utils.TreeNode;
import com.resource.distribute.utils.TreeNodebuild;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeDao codeDao;

    @Override
    public ReturnInfo addCode(Code code) {
        code.setCreateBy(AuthCurrentUser.getUserId());
        codeDao.insertSelective(code);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo updateCode(Code code) {
        code.setUpdateBy(AuthCurrentUser.getUserId());
        codeDao.updateByPrimaryKeySelective(code);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo delCodeById(Integer codeId) {
        Code code = codeDao.selectByPrimaryKey(codeId);
        if (code.getParentId() == 0) {
            return ReturnInfo.create(CodeEnum.REQUEST_PARAM_ERROR);
        }
        codeDao.deleteByPrimaryKey(codeId);
        return ReturnInfo.createReturnSuccessOne(null);
    }

    @Override
    public ReturnInfo listById(Integer parentId) {
        Example example = new Example(Code.class);
        example.createCriteria().andEqualTo("parentId", parentId);
        List<Code> codes = codeDao.selectAll();
        List<TreeNode> treeNodes = new ArrayList<>();
        codes.forEach(code -> {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(String.valueOf(code.getId()));
            treeNode.setName(code.getContent());
            treeNode.setParentId(String.valueOf(code.getParentId()));
            treeNodes.add(treeNode);
        });
        List<TreeNodebuild> treeNodebuildList =
                TreeNodebuild.toTreeNodes(treeNodes, String.valueOf(parentId));
        return ReturnInfo.createReturnSuccessOne(treeNodebuildList);
    }

}
