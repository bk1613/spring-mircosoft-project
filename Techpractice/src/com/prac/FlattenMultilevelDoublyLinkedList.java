package com.prac;

public class FlattenMultilevelDoublyLinkedList {

	Node start;
	Node last;
	Node anchor;
	static class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	    
	    Node(int v){
			val = v;
			next = null;
			prev = null;
		}
	};
	
	public void insert(Integer data) {
		//System.out.println(data);
		if(data == null) {
			//System.out.println("anc");
			
			if(anchor == null) {
				//System.out.println("anc");
				anchor = start;
			}else {
				if(anchor.child != null) {
					anchor = anchor.child;
				}else {
					anchor = anchor.next;
				}
				
			}
			//System.out.println(anchor.val);
			return;
		}
		
		Node newNode = new Node(data);
		if(start == null) {
			start = newNode;
			last = newNode;
				
		}else {
			if(anchor != null && anchor.child == null) {
				anchor.child = newNode;
				
				last = newNode;
				
				//System.out.println(anchor.child.val);
			}else {
				last.next = newNode;
				newNode.prev = last;
				last = newNode;
				//System.out.println(last.val);
			}
			
		}
		
		
		
	}
	
	public void flatten() {
		Node curr = start;
		
		while(curr != null) {
			//System.out.println(curr.val);
			
			if(curr.child != null) {
				Node l = curr.child;
				Node n = curr.next;
				curr.next = l;
				l.prev = curr;
				Node o = null;
				while(l != null) {
					//System.out.println(curr.child.val);
					o = l;
					l = l.next;
				}
				o.next = n;
				n.prev = o;
			}
			last = curr;
			curr = curr.next;
		}
		
	}
	
	public void disply() {
		Node curr = start;
		while(curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
		
	}
	
	public void traverse_at_start() {
		Node curr_node = start;
		while(curr_node != null) {
			System.out.print(curr_node.val+" ");
			curr_node=curr_node.next;
		}
	}
	
	public void traverse_at_last() {
		Node curr_node = last;
		while(curr_node != null) {
			System.out.print(curr_node.val+" ");
			curr_node=curr_node.prev;
		}
	}
	
	public static void main(String[] args) {
		
		Integer[] head = {1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12};
		FlattenMultilevelDoublyLinkedList list = new FlattenMultilevelDoublyLinkedList();
		
		for(Integer i: head) {
			list.insert(i);
		}
		//System.out.println(list.anchor.val);
		list.flatten();
		list.traverse_at_start();
		System.out.println(" ");
		list.traverse_at_last();
	}
	
}
