package com.alalili.datastruct;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TreeSearch {

    public static List<TreeNode> findAssociatedNodes(TreeNode root, String leafId) {
        List<TreeNode> associatedNodes = new ArrayList<>();
        findAssociatedNodesRecursive(root, leafId, associatedNodes);
        return associatedNodes;
    }

    private static void findAssociatedNodesRecursive(TreeNode node, String leafId, List<TreeNode> associatedNodes) {
        if (node == null) {
            return;
        }

        if (node.getId().equals(leafId)) {
            associatedNodes.add(node);
            return;
        }

        for (TreeNode child : node.getChildren()) {
            findAssociatedNodesRecursive(child, leafId, associatedNodes);
            if (!associatedNodes.isEmpty()) {
                associatedNodes.add(node);
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 构建树结构数据
        TreeNode root = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");

        root.addChild(nodeB);
        root.addChild(nodeC);
        nodeB.addChild(nodeD);
        nodeB.addChild(nodeE);

        // 示例查询叶子节点 E 关联的所有树节点
        String leafId = "E";
        List<TreeNode> associatedNodes = findAssociatedNodes(root, leafId);

        // 输出查询结果
        System.out.println("查询叶子节点 " + leafId + " 关联的所有树节点：");
        for (TreeNode node : associatedNodes) {
            System.out.println(node.getId());
        }


        String str = "Hello\nWorld\nThis is a\ntest string\n1";
        int lastIndex = str.lastIndexOf("\n");
        String newStr = str.substring(0, lastIndex).replaceAll("\n", "") + str.substring(lastIndex);
        System.out.println(newStr);


        BigDecimal originalNumber = new BigDecimal("33333.126000");
        BigDecimal roundedNumber = originalNumber.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(roundedNumber.toString());
    }
}
