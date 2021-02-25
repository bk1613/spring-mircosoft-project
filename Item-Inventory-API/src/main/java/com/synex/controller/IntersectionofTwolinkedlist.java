package com.synex.controller;

public class IntersectionofTwolinkedlist<T> {

	Node start;
	Node last;
	class Node{
		T data;
		Node next;
		
		Node(T a){
			data = a;
			next = null;
		}	
	}
	
	
	public void sort_insert(T data) {
		Node linknode = new Node(data);
		if(this.start == null || (int)start.data > (int)linknode.data) {
			linknode.next = this.start;
			this.start = linknode;
		}else {
			Node curr =this.start;
			Node pre = null;
			while(curr != null && (int)curr.data <= (int)data) {
				if((int)curr.data == (int)data) {
					return;
				}
				pre = curr;
				curr = curr.next;
			}
			linknode.next = curr;
			pre.next = linknode;
		}
		
		
	}
	
	public void insert_at_end(T data) {
		Node newNode = new Node(data);
		if(start == null) {
			start = newNode;
		}else {
			last.next = newNode;
		}
		last = newNode;
	}
	
	public IntersectionofTwolinkedlist copy(IntersectionofTwolinkedlist list) {
		IntersectionofTwolinkedlist copy = new IntersectionofTwolinkedlist();
		Node currnode = list.start;
		
		while(currnode != null) {
			copy.insert_at_end(currnode.data);
			currnode = currnode.next;
		}
		
		return copy;
	}
	
	
	public IntersectionofTwolinkedlist intersec(IntersectionofTwolinkedlist list, IntersectionofTwolinkedlist list2) {
		
		
		IntersectionofTwolinkedlist copylist = copy(list);
		IntersectionofTwolinkedlist copylist2 = copy(list2);
		
		Node currnode1 = copylist.start;
		Node currnode2 = copylist2.start;
		
		while(currnode1 != null && currnode2 != null) {
			
			if((int)currnode1.data > (int)currnode2.data) {
				currnode2 = currnode2.next;
				
			}else if((int)currnode1.data < (int)currnode2.data) {
				currnode1 = currnode1.next;
				
			}else if((int)currnode1.data == (int)currnode2.data) {
				
				this.insert_at_end(currnode2.data);
				currnode1 = currnode1.next;
				currnode2 = currnode2.next;
				
			}
		}
		
		this.insert_at_end(null);
		
		return this;
	}
	
	public void display() {
		Node curr_node = start;
		while(curr_node != null) {
			if(curr_node.data == null) {
				System.out.print(curr_node.data);
			}else {
				System.out.print(curr_node.data+" -> ");
			}
			
			curr_node=curr_node.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 4, 7, 10};
		int[] arr2 = {2,4,6,8,10};
		IntersectionofTwolinkedlist list1 = new IntersectionofTwolinkedlist();
		IntersectionofTwolinkedlist list2 = new IntersectionofTwolinkedlist();
		IntersectionofTwolinkedlist list3 = new IntersectionofTwolinkedlist();
		
		for(int i: arr) {
			list1.sort_insert(i);
		}
		for(int i: arr2) {
			list2.sort_insert(i);
		}
		
		list3 = list3.intersec(list1, list2);
		list3.display();
	}

}
