package hw4;

public class Stack implements List{
    // Implement Stack using Linked List without tail
    Node head;
    
    public void push(Node node){
        if (head == null){
            head = node; //add node to stack(empty stack)
        }else{
            node.next = head;
            head = node; //add node to the top of stack (not empty stack)
        }
    }
    
    public void pop(){
        // Fix this function
        if (head != null){
            head = head.next; // pop out the node at the top of stack
        }else{
            System.out.println("Error: Stack Underflow");
        }
    }
    
    public Node top(){
        
        return head; //return node at the top of stack to caller
    }
    
}
