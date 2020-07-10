/**
	Problem: You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        if(head == null) return null;
        Node current = head;
        
        while(current != null){
            if(current.child != null){
                Node nextNode = current.next;
                Node childNode = flatten(current.child); //get recursive child
                
                current.child = null;
                current.next = childNode;
                childNode.prev = current;
                
                while(current.next != null) current = current.next;
                current.next = nextNode;
                
                if(nextNode != null) nextNode.prev = current;
            }
            current = current.next;
        }
        return head;
    }
}