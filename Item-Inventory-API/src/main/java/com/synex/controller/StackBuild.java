package com.synex.controller;

import java.util.Arrays;

public class StackBuild<T> {

	Node last;
	Node top;
	class Node{
		T data;
		Node next;
		
		Node(T a){
			data = a;
			next = null;
		}
	}
	
	public void push(T data){
		Node newnode = new Node(data);
		if(top == null) {
			top = newnode;
			last = newnode;
		}else {
			newnode.next = top;
			top = newnode;
		}
	}
	
	public void pop() {
		Node currnode = top;
		if(currnode == null) {
			System.out.println("stack empty");
		}else {
			top = top.next;
		}
	}
	
	public T top() {
		Node currnode = top;
		if(currnode == null) {
			return null;
		}
		return top.data;
	}
	
	public int getMin() {
		Node currnode = top;
		int min =0;
		while(currnode != null) {
			if(min > (int)currnode.data) {
				min = (int)currnode.data;
			}
			currnode = currnode.next;
		}
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cmds = {"MinStack","push","push","push","getMin","pop","top","getMin"};
		int[][] arr = {{},{-2},{0},{-3},{},{},{},{}};
		String[] result = new String[arr.length];
		StackBuild minstack = null;
		int indx = 0;
		for(String cmd: cmds) {
			switch(cmd){
				case "MinStack":
					minstack = new StackBuild();
					break;
				case "push":
					minstack.push(arr[indx][0]);
					break;
				case "getMin":
					result[indx] = ""+minstack.getMin();
					break;
				case "pop":
					minstack.pop();
					break;
				case "top":
					result[indx] = ""+minstack.top();
					break;
				default:
					
					break;	
			}
			indx++;
		}
		
		Arrays.stream(result).forEach(System.out::println);
		
	}

}
