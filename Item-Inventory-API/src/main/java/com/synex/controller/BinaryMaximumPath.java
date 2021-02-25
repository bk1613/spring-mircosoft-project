package com.synex.controller;

public class BinaryMaximumPath {

	Node root;
	
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
	
	public Node binary_insert(Integer[] arr, Node root, int i) {
		
		if(i < arr.length) {
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
	
	public Integer sumMax(Node root, int max) {
		
		int sum = 0;
		
		if(root != null) {
			sum += root.data;
		}
		if(root.left != null) {
			sum += root.left.data;
		}
		if(root.right != null) {
			sum += root.right.data;
		}
		
		if(root.left != null) {
			sum = sumMax(root.left, sum);
		}
		
		if(root.right != null) {
			sum = sumMax(root.right, sum);
		}
		
		
		
		return Math.max(max, sum);
		
	}
	
	public static void main(String[] args) {
		
		BinaryMaximumPath tr = new BinaryMaximumPath();
		
		Integer[] arr = {1, 2, 3};
		
		
		tr.root = tr.binary_insert(arr, tr.root, 0);
		
		tr.preorder(tr.root);
		System.out.println();
		
		System.out.println(tr.sumMax(tr.root, 0));
	}

}
