package com.prac;

public class DetectACycle {

	static Node head;
	static Node last;
	static Node anchor;
	static class Node{
		int data;
		Node next;
		
		Node(int a){
			data = a;
			next = null;
		}
	}
	
	
	public void link_insert_at_end(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}else {
			last.next = newNode;
		}
		last = newNode;
		
	}
	
	public void circ_insert_at_end(int data, Node anchor) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			last = newNode;
			head.next = head;
		}else {
			if(anchor == null) {
				head.next = newNode;
				anchor = head.next;
				last = last.next;
			}else {
				last.next = newNode;
				last = last.next;
			}
			last.next = anchor;
		}
		
	}
	
	public void circ_insert_at_end(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			head.next = head;
		}else {
			if(last == null) {
				last = newNode;
				last.next = last;
				head.next = newNode;
			}else {
				newNode.next = head.next;
				last.next = newNode;
				last = newNode;
			}
		}
		
	}
	
	public int detectCyclic(int count) {
		Node currnode = head;
		
		for(int i = 0; i < count; i++) {
			//System.out.println(currnode.data);
			if(currnode.next == null) {
				return 0;
			}
			
			currnode = currnode.next;
		}
		
		
		return 1;
	}
	
	public static boolean cycle(Node starting) {
        Node current = starting;
        Node anchor = starting;
        while(anchor.next != null) {
            while(current.next != null) {
                if(current.equals(anchor)) {
                    return true;
                }
                current = current.next;

            }
            anchor = anchor.next;
            current = anchor.next;
        }
        
        
        return false;
    }
	
	public static void main(String[] args) {
		
		DetectACycle list = new DetectACycle();
		int[] arr = {1, 2};
		int count = 0;
		for(int i: arr) {
			list.link_insert_at_end(i);
			count++;
		}
		
		System.out.println(list.detectCyclic(count));
		System.out.println(" ");
		int count2 = 0;
		 head = null;
	        last = null;
	        anchor = null;
		DetectACycle list2 = new DetectACycle();
		int[] arr2 = {1, 2, 3, 4};
		
		for(int i: arr2) {
//			list2.circ_insert_at_end(i, list2.anchor);
			list2.circ_insert_at_end(i);
			count2++;
		}
	
		System.out.println(list2.detectCyclic(count2));
		
		
		Node anchor = null;
        
        Node newNode = new Node(1);
        Node current = newNode;
        head = newNode;
        head.next = new Node(2);
        anchor = head.next; //anchor points to node 2
        current = current.next; //current now on node2
        
        current.next = new Node(3);
        current = current.next; //current now on node 3
        
        current.next = anchor; //the next of node 3 is now at node 2. thus creating a cycle
            
        System.out.println(cycle(head));
	}

}
