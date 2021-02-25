package com.prac;

import com.prac.BinaryTreeMax.Node;

public class AddOneRowtoTree {

	
	Node root;
	class Node{
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
	
	public Node binary_insert(int[] arr, Node root, int i) {
		
		
		
		if(i < arr.length) {
			if(arr[i] == 0) {
				return root;
			}
			
			if(arr[i] == -1) {
				return root;
			}
			Node temp = new Node(arr[i]);// temp = 1 temp = 2 temp = 5
			root = temp;
			
			
			root.left = binary_insert(arr, root.left, 2*i +1);
			
			root.right = binary_insert(arr, root.right, 2*i +2);
			
		}
		
		return root;
	}
	
	
	int maxDepth(Node node) 
    {
        if (node == null)
            return -1;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
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
	
	boolean connect;
	int hi;
	
	public Node helper(Node root, int v, int d, int h) {
		if(root == null){
            return null;
        }
        
        
        if(d == h){
            System.out.println(root.data);
            Node node = new Node(v);
            //node.left = root;
            connect = true;
            return node;
        }
        
        Node nodel = helper(root.left, v, d, h+1);
        //System.out.println(connect);
        if(connect){
            nodel.left = root.left;
            root.left = nodel;
            connect = false;
        }
        
        Node noder =  helper(root.right, v, d, h+1);
        //System.out.println(connect);
        if(connect){
            noder.right = root.right;
            root.right = noder;
            connect = false;
        }
        
        return root;
	}
	
	
    public Node addOneRow(Node root, int v, int d) {
    	if(d == 1) {
    		Node node = new Node(v);
    		node.left = root.left;
    		node.right = root.right;
    		root = node;
    		return root;
    	}
    	
    	helper(root, v, d, 1);
    	return root;
        
    }
	
	public void travrse(Node root) {
		
		if(root != null) {
			System.out.print(root.data + " ");
			travrse(root.left);
			travrse(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOneRowtoTree node = new AddOneRowtoTree();
		System.out.println("ss");
		
		int[] nums = {4, 2, 0, 3, 1};
//		int[] nums = {4, 2, 6, 3, 1, 5};
		node.root = node.binary_insert(nums, node.root, 0);
		node.hi = node.maxDepth(node.root);
		node.root = node.addOneRow(node.root, 1, 3);
		
		node.travrse(node.root);
	}

}
