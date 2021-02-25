package com.prac;

public class LinkedListCycle {

	Node start;
	Node last;
	class Node {
		int data;
		Node next;
		Node(int v){
			data = v;
		}
	}
	
	public void insertend(int data) {
		Node newnode = new Node(data);
		if(start == null) {
			start = newnode;
			last = newnode;
		}else {
			last.next = newnode;
			last = last.next;
		}
	}
	
	public void travse() {
		Node curr = start;
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
	public boolean checkcycle(int[] head, int pos) {
		if(pos < 0 || pos > head.length) {
			return false;
		}
		
		Node anchor = start;
		Node curr = start;
		int count = 0;
		while(anchor != null) {
			if(count == pos) {
				break;
			}
			count++;
			anchor = anchor.next;
			
		}
		last.next = anchor;
		System.out.println(last.next.data);
		
		if(last.next.data == anchor.data) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCycle li = new LinkedListCycle();
		int[] head = {1,2};
		int pos = 0;
		for(int a: head) {
			li.insertend(a);
		}
		li.travse();
		
		System.out.println(li.checkcycle(head, pos));
	}

}
