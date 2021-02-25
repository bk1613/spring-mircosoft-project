package com.prac;

public class HouseRobberIII {
	
	static Node root;
	static class Node{
		int data;
		Node left;
		Node right;
		int height;
		
		Node(int a){
			data = a;
			left = null;
			right = null;
		}
	}
	int elements;
	public Node binaryInsert(Integer[] arr, Node root, int i) {
		if(i < arr.length) {
			if(arr[i] == null) {
				return root;
			}
			if(arr[i] != null) {
			Node temp = new Node(arr[i]);// temp = 1 temp = 2 temp = 5
			root = temp;
			}
			
			root.left = binaryInsert(arr, root.left, 2*i +1);
			
			root.right = binaryInsert(arr, root.right, 2*i +2);
			elements += 1;
		}
		
		return root;
	}
	
	public static void preorder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	
	int count = 0;
	public int rob(Node root) {
	    
		if (root == null) {
            return 0;
        }
		int max = 0;
		root.height = height(root);
		
			
		max = root.data;
			
		
		

		count++;
		int a = rob(root.left)+max;
		int b = rob(root.right)+max;

		
		if(count == elements) {
			if(a > b) {
				return a;
			}else {
				return b;
			}
		}
		return max;
	}
	
	public int height(Node root) {

		if (root == null) 
            return 0; 
		
    	int maxl = height(root.left);
    	int maxr = height(root.right);
    	
    	if(maxl < maxr) {
    		return maxr + 1;
    		
    	}else {
    		return maxl + 1;
    	}

	}
	
//	public int rob(TreeNode root) {
//	    if(root == null)
//	        return 0;
//	 
//	    int[] result = helper(root);
//	    return Math.max(result[0], result[1]);
//	}
//	 
//	public int[] helper(TreeNode root){
//	    if(root == null){
//	        int[] result = {0, 0};
//	        return result;
//	    }
//	 
//	    int[] result = new int[2];
//	    int[] left = helper(root.left);
//	    int[] right = helper (root.right);
//	 
//	    // result[0] is when root is selected, result[1] is when not. 
//	    result[0] = root.val + left[1] + right[1];
//	    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
//	 
//	    return result;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {3,2,3,null,3,null,1};
		HouseRobberIII tr = new HouseRobberIII();
		
		tr.root = tr.binaryInsert(arr, tr.root, 0);
		System.out.println(tr.elements);
		preorder(tr.root);
		
		System.out.println();
		;
		System.out.println(tr.rob(tr.root));
	}

}
