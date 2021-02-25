package com.prac;

import com.prac.BinaryTreeMax.Node;

public class BSTtoGreaterTree {

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
	
	public void preorder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	int temp = 0;
	
	public Node convertBST(Node root) {
		
		Node node = root;
		
		traversal(node);
        return root;
    }
	
	public void traversal(Node root) {
		
		if(root != null) {
			traversal(root.right);
			temp=temp+root.data;
			root.data=temp;
			traversal(root.left);		
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTtoGreaterTree bt = new BSTtoGreaterTree();
		int[] roots = {4,1,6,0,2,5,7,0,0,0,3,0,0,0,8};
		
		bt.root = bt.binary_insert(roots, bt.root, 0);
		
		bt.convertBST(bt.root);
		
		bt.preorder(bt.root);
		
	}

}
