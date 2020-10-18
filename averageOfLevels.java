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
import java.util.*; 
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> arr = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        recur(root,0.0,0,arr,counts);
        for (int i=0;i<arr.size();i++) {
            arr.set(i,(arr.get(i)/counts.get(i)));
        }
        return arr;
    }
    public static void recur(TreeNode root, double ave, int levels, List<Double> arr, List<Integer> counts) {
        if (levels==0) {
            arr.add((double)root.val);
            counts.add(1);
            levels++;
        }
        if (root!=null) {
            ave =0.0;
            int n=0;
            if (root.left!=null && root.right!=null) {
                ave = (1.0*root.left.val+1.0*root.right.val);
                n=2;
            } else if (root.left!=null && root.right==null) {
                ave = (1.0*root.left.val);
                n=1;
            } else if (root.left==null && root.right!=null) {
                ave = (1.0*root.right.val);
                n=1;
            }
            if (root.left!=null || root.right!=null) {
                if (arr.size()>=levels+1) {
                    arr.set(levels,(ave+arr.get(levels)));
                    counts.set(levels, counts.get(levels) +n);
                } else {
                    arr.add(ave);
                    counts.add(n);
                }
            }
            
            levels++;
            recur(root.left, ave, levels, arr, counts);
            recur(root.right, ave, levels, arr,counts);
        }
    }
}
