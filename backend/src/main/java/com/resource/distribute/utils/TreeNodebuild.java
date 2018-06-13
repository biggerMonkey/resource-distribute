package com.resource.distribute.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNodebuild {

    private String id; // 要显示的子节点的ID
    private String content; // 要显示的子节点的 Text
    private String parentId;
    private List<TreeNodebuild> children; // 孩子节点的List

    public TreeNodebuild() {
        super();
    }

    public TreeNodebuild(String id, String name, List<TreeNodebuild> children) {
        super();
        this.id = id;
        this.content = content;
        this.children = children;
    }

    // / <summary>
    // / 将 组织集合 转成 树节点集合
    // / </summary>
    // / <param name="listPer"></param>
    // / <returns></returns>
    public static List<TreeNodebuild> toTreeNodes(List<TreeNode> listPer, String pid) {
        List<TreeNodebuild> listNodes = new ArrayList<TreeNodebuild>();
        // 生成 树节点时，根据 pid=0的根节点 来生成
        loadTreeNode(listPer, listNodes, pid);
        return listNodes;
    }

    // / <summary>
    // / 递归组织集合 创建 树节点集合
    // / </summary>
    // / <param name="listPer">组织集合</param>
    // / <param name="listNodes">节点集合</param>
    // / <param name="pid">节点父id</param>
    public static void loadTreeNode(List<TreeNode> listPer, List<TreeNodebuild> listNodes,
            String pid) {
        for (TreeNode treeNode : listPer) {
            // 如果组织父id=参数
            if (treeNode.getParentId().equals(pid)) {
                // 将 组织转成 树节点
                TreeNodebuild node = new TreeNodebuild().toNode(treeNode);
                // 将节点 加入到 树节点集合
                listNodes.add(node);

                // 递归 为这个新创建的 树节点找 子节点
                loadTreeNode(listPer, node.children, node.id);
            }
        }
    }

    public TreeNodebuild toNode(TreeNode treeNode) {
        TreeNodebuild node = new TreeNodebuild();
        node.id = treeNode.getId();
        node.content = treeNode.getName();
        node.parentId = treeNode.getParentId();
        node.children = new ArrayList<TreeNodebuild>();
        return node;
    }


    public static List<String> getAllChilderNode(List<TreeNodebuild> treeNodebuilds) {
        List<String> childs = new ArrayList<>();
        getChild(treeNodebuilds, childs);
        return childs;
    }

    private static void getChild(List<TreeNodebuild> treeNodebuilds, List<String> childs) {
        for (TreeNodebuild treeNodebuild : treeNodebuilds) {
            if (treeNodebuild.getChildren().size() > 0) {
                getChild(treeNodebuild.getChildren(), childs);
            } else {
                childs.add(treeNodebuild.getId());
                continue;
            }
        }
        return;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<TreeNodebuild> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNodebuild> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "TreeNodebuild [id=" + id + ", content=" + content + ", children=" + children + "]";
    }
}
