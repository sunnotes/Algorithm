package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode(char x) { val = x; }
}
 
public class Tree {
    public ArrayList<Character> preorderTraversal(TreeNode root) {
        ArrayList<Character> returnList = new ArrayList<Character>();
 
        if(root == null)
            return returnList;
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
 
        while(!stack.empty()){
            TreeNode n = stack.pop();
            returnList.add(n.val);
 
            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }
 
        }
        return returnList;
    }
    
    public ArrayList<Character> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
         ArrayList<Character> lst = new ArrayList<Character>();
 
        if(root == null)
            return lst; 
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode p = root;
 
        while(!stack.empty() || p != null){
 
            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.left;
 
            // if no left child
            // pop stack, process the node
            // then let p point to the right
            }else{
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }
 
        return lst;
    }
    
    
    public ArrayList<Character> postorderTraversal(TreeNode root) {
    	 
        ArrayList<Character> lst = new ArrayList<Character>();
 
        if(root == null)
            return lst; 
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
 
        TreeNode prev = null;
        while(!stack.empty()){
            TreeNode curr = stack.peek();
 
            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == curr || prev.right == curr){
                //prev == null is the situation for the root node
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }
 
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            }else if(curr.left == prev){
                if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.val);
                }
 
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack. 
            }else if(curr.right == prev){
                stack.pop();
                lst.add(curr.val);
            }
 
            prev = curr;
        }
 
        return lst;
    }
    
    
    public static void main(String[] args) {
    	TreeNode a =  new TreeNode('A');
    	TreeNode b =  new TreeNode('B');
    	TreeNode c =  new TreeNode('C');
    	TreeNode d =  new TreeNode('D');
    	TreeNode e =  new TreeNode('E');
    	TreeNode f =  new TreeNode('F');
    	a.left = b;
    	a.right= c;
    	b.left = d;
    	b.right = e;
    	c.left = f;
    	
    	
    	Tree tree = new Tree();
    	ArrayList<Character> list = new ArrayList<Character>();
    	//list = tree.preorderTraversal(a);
    	//list = tree.inorderTraversal(a);
    	list = tree.postorderTraversal(a);
    	
    	for (Character character : list) {
    		System.out.println(character);
		}
	}
}