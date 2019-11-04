/* CopyRight UMF */
package com.umfintech.activitimiddleware.test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author wangyu
 * @date 2019/11/4 10:20
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new int[]{1,2,3,4,5,6,7});
        System.out.println(root);
    }
}

/**
 * @description Sequence binary tree structure
 * @author wangyu
 * @date 2019/11/4 10:20
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    /**
     * @description Build a sequence binary tree through an array
     * @param nums
     */
    TreeNode(int[] nums) {
        this.val = nums[0];
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(this);
        for (int i = 1; i < nums.length - 1; i += 2) {
            TreeNode node = list.poll();
            node.left = new TreeNode(nums[i]);
            node.right = new TreeNode(nums[i+1]);
            list.offer(node.left);
            list.offer(node.right);
        }
    }

    @Override
    public String toString() {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(this);
        ArrayList<Integer> res = new ArrayList<>();
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            res.add(node.val);
            if (node.left != null) {
                list.offer(node.left);
            }
            if (node.right != null) {
                list.offer(node.right);
            }
        }
        return res.toString();
    }
}




















