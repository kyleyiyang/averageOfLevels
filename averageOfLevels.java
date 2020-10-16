import java.util.*; 
public class Main
{
    public static List<Double> arr = new ArrayList<Double>();
    public static int levels=1;
	public static void main(String[] args) {
		System.out.println("Hello World");
		//TreeNode left_right = new TreeNode(11);
		TreeNode left_right = null;
		TreeNode left_left = new TreeNode(10);
		TreeNode right_left = new TreeNode(15);
		TreeNode right_right = new TreeNode(7);
		TreeNode left = new TreeNode(9, left_left, left_right);
		TreeNode right = new TreeNode(20, right_left, right_right);
		TreeNode root = new TreeNode(3, left, right);
		arr.add((double)root.val);
		recur(root);
		System.out.println(arr);
	}
	public static void recur(TreeNode root) {
	    
        if (root!=null) {
            if (root.left!=null && root.right!=null) {
                System.out.println("levels="+levels);
                System.out.println("size="+arr.size());
                System.out.println(arr.size()>=levels+1);
                if (arr.size()>=levels+1) {
                    arr.add(((double)(root.left.val+root.right.val)/2+arr.get(levels))/2);
                } else {
                    arr.add((double)(root.left.val+root.right.val)/2);
                }
            } else if (root.left!=null && root.right==null) {
                arr.add((double)(root.left.val));
            } else if (root.left==null && root.right!=null) {
                arr.add((double)(root.right.val));
            }
            levels++;
            recur(root.left);
            recur(root.right);
        }
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
