package com.example;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public String key;

    public String value;

    public List<TreeNode> subTreeNodes = new ArrayList<>();

    public TreeNode() {

    }

    public TreeNode(String key) {
        this.key = key;
    }

    public TreeNode(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public TreeNode addSubNodeWithValue(String key, String value) {
        TreeNode node = new TreeNode(key, value);
        subTreeNodes.add(node);
        return node;
    }

    public TreeNode addSubNode(String key) {
        TreeNode node = new TreeNode(key);
        subTreeNodes.add(node);
        return node;
    }

    public TreeNode getSubNode(String key) {
        for (int i = 0; i < subTreeNodes.size(); i ++) {
            if (key.equals(subTreeNodes.get(i).key)) {
                return subTreeNodes.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {

        if (value == null) {
//            StringBuilder result = new StringBuilder();
//            for (TreeNode subTreeNode: subTreeNodes) {
//                result.append(subTreeNode);
//            }
            return "\"" + key + "\":" + "{" + getSubTreeNodes() + "}";
        } else {

            return "\"" + key + "\":" + "\"" + value + "\"";
        }
    }

    public String getSubTreeNodes() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < subTreeNodes.size(); i ++) {
            result.append(subTreeNodes.get(i));
            if (i != subTreeNodes.size() - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }
}
