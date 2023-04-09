/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            // 좌측, 우측 노드의 길이가 다르면 false
            return false;
        }
        
        // 좌측, 우측 검증
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}