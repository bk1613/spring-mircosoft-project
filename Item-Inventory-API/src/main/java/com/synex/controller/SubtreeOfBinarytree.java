package com.synex.controller;

public class SubtreeOfBinarytree {

	static boolean foundsubtree;
	Node root;
	Node parent;
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
			if(arr[i] == -1) {
				return root;
			}
			Node temp = new Node(arr[i]);// temp = 1 temp = 2 temp = 5
			root = temp;
			//node_count++;
			
			root.left = binary_insert(arr, root.left, 2*i +1);
			
			root.right = binary_insert(arr, root.right, 2*i +2);
			
		}
		
		return root;
	}
	
	public void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	public void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public static boolean checkhelper(Node trroot, Node subroot) {
		
		if(subroot == null) {
			return true;
		}
		
		if(trroot.data != subroot.data) {
			return false;
		}else {
			checkhelper(trroot.left, subroot.left);
			checkhelper(trroot.right, subroot.right);
		}
		
		return true;
	}
	
	public static void checkIsSubtree(Node trroot, Node subroot) {
		
		if(trroot == null) {
			return;
		}
		
		if(checkhelper(trroot, subroot)) {
			foundsubtree = true;
			
		}else {
			checkIsSubtree(trroot.left, subroot);
			checkIsSubtree(trroot.right, subroot);
		}
		
		if(foundsubtree) {
			System.out.println(true);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SubtreeOfBinarytree tree = new SubtreeOfBinarytree();
		SubtreeOfBinarytree subtree = new SubtreeOfBinarytree();
		
		int[] arrtree = {1,  2 ,3,  4,5,6, 7, 8};
		int[] arrsubtree = {3, 6, 7};
		
		for(int a: arrtree) {
			tree.root = tree.binary_insert(arrtree, tree.root, 0);
		}
		
		for(int a: arrsubtree) {
			subtree.root = subtree.binary_insert(arrsubtree, subtree.root, 0);
		}
		System.out.println("inorder: ");
		tree.inorder(tree.root);
		System.out.println();
		subtree.inorder(subtree.root);
		
		System.out.println("\npostorder");
		tree.postorder(tree.root);
		System.out.println();
		subtree.postorder(subtree.root);
		System.out.println();
		
		checkIsSubtree(tree.root, subtree.root);
	}

}
