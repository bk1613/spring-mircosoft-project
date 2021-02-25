package com.synex.controller;

public class CheckedBalance {

	int node_count = 0;
	TreeNode root;
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		int height;
		boolean bool;
		TreeNode(int a){
			data = a;
			left = null;
			right = null;
		}
	}
	
	public TreeNode binary_search_insert_tree(int data, TreeNode root) {
		if(data == -1) {
			return root;
		}
		
		if(root == null) {
			root = new TreeNode(data);
			
		}else if(data <= root.data) {
		
			root.left = binary_search_insert_tree(data, root.left);
			
		}else{
			
			root.right = binary_search_insert_tree(data, root.right);
			
		}
		
		return root;
		

	}
	
	public TreeNode checkIfBalanced(TreeNode root) {
		if(root == null) {
			
			return root;
		}
	
		root.left = checkIfBalanced(root.left);
		root.right = checkIfBalanced(root.right);
			
		
		root.height = 1 + max(root);
		//System.out.println(root.height);
		int balFact = getBal(root);
		
		System.out.println(balFact);
		
		if(balFact > 1) {
			root.bool = false;
			return root;
		}else if(balFact < -1) {
			root.bool = false;
			return root;
		}else {
			root.bool = true;
			return root;
		}
		
		
	}
	
	public int getBal(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return height(root.left) - height(root.right);
	}
	
	public int max(TreeNode root) {

    	int maxl = height(root.left);
    	int maxr = height(root.right);
    	
    	if(maxl < maxr) {
    		return maxr;
    		
    	}else {
    		return maxl;
    	}

	}
	
	int height(TreeNode node) {
		if(node == null) {
			return 0;
		}
		
		return node.height;
	}
	
	
	public TreeNode binary_insert(int[] arr, TreeNode root, int i) {
		
		if(i < arr.length) {
			if(arr[i] == -1) {
				return root;
			}
			TreeNode temp = new TreeNode(arr[i]);// temp = 1 temp = 2 temp = 5
			root = temp;
			//node_count++;
			
			root.left = binary_insert(arr, root.left, 2*i +1);
			
			root.right = binary_insert(arr, root.right, 2*i +2);
			
		}
		
		return root;
	}
	
	
	public void postorder(TreeNode root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {24,10,15,18,30,60,37,38,25,26,21};
		
		CheckedBalance tr = new CheckedBalance();
		
		for(int a : arr) {
			tr.root = tr.binary_search_insert_tree(a, tr.root);
		}
		
		
		tr.postorder(tr.root);
		System.out.println("\n");
		
		tr.root = tr.checkIfBalanced(tr.root);
		
		if(tr.root.bool) {
			System.out.println("Is balanced");
		}else {
			System.out.println("Not balanced");
		}

	}

}
