package com.alalili.datastruct;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    private String id;
    private List<TreeNode> children;

    public TreeNode(String id) {
        this.id = id;
        this.children = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }
}