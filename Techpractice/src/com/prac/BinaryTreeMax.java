package com.prac;

public class BinaryTreeMax {

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
	
	public int findmax(Node root, int max) {
		
		int sum = 0;
		if(root == null) {
			return 0;
		}
		
		if(root != null) {
			sum += root.data;
		}
		
		if(root.left != null) {
			sum += root.left.data;
			sum = findmax(root.left, sum);
		}
		if(root.right != null) {
			sum += root.right.data;
			sum = findmax(root.right, sum);
		}
		
		return Math.max(sum, max);
	}
	
	public static void main(String[] args) {
		BinaryTreeMax tr = new BinaryTreeMax();
		//int[] arr = {1, 2, 3};
		int[] arr = {-10, 9, 20, 0, 0, 15, 7};
		
		tr.root = tr.binary_insert(arr, tr.root, 0);
		//tr.preorder(tr.root);
		int max = tr.findmax(tr.root, 0);
		System.out.println(max);
	}
	
}
