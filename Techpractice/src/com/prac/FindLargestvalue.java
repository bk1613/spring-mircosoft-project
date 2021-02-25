package com.prac;

import java.util.ArrayList;
import java.util.List;

import com.prac.BinaryTreeMax.Node;

public class FindLargestvalue {

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
	
	
	
	public void helper(Node root, List<Integer> largenums, int height) {
		
		if(root == null) {
			return;
		}
		
		if(height == largenums.size()) {
			largenums.add(root.data);
		}else {
			largenums.set(height, Math.max(largenums.get(height), root.data));
		}
		
		
		helper(root.left, largenums, height+1);
		helper(root.right, largenums, height+1);
		
		
		
	}
	
	public List<Integer> largestValues(Node root) {

		List<Integer> levelnums = new ArrayList<>();
		
		List<Integer> largenums = new ArrayList<>();
		
		
		helper(root, largenums, 0);
			
		System.out.println(largenums);
		
		return largenums;
	}
	
	
	
	public static void main(String[] args) {
		
		FindLargestvalue tr = new FindLargestvalue();
		int[] nodes = {1,3,2,5,3,0,9};
		tr.root = tr.binary_insert(nodes, tr.root, 0);
		tr.largestValues(tr.root);
	}
	
}
