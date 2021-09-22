package com.exercise.algorithm.tree;

/**
 * @ClassName SortedArrayToBST
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/10 上午8:31
 * @Version 1.0
 **/
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return getMinHighTree(nums, 0, nums.length -1);
    }

    public TreeNode getMinHighTree(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        int mid = (start + end)>>1;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = getMinHighTree(nums, start, mid-1);
        treeNode.right = getMinHighTree(nums, mid+1, end);
        return treeNode;
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        sortedArrayToBST.print(treeNode);
    }

    public void print(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        System.out.println(treeNode.val);
        print(treeNode.getLeft());
        print(treeNode.getRight());
    }
}
