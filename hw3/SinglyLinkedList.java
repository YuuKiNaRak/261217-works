package hw3;

public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){
        listName = name;
    }
    
    public void popBack() {
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            if(head.next == null){ //check if the list has a single node
                head = null;
                return;
            }
            Node current = head;
            while(current.next.next != null) current = current.next; //iterate each node until second last node
            current.next = null; //point next of that node to null
        }
    }
    
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            head = head.next;
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head;
        }
    }
    
    public Node topBack(){ 
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            while(current.next != null) current = current.next; //iterate each node until last node
            return current; //return that node
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head = node;
        }else{
            node.next = head;   //node -> HEAD
            head = node;        //HEAD -> previous_head
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()){
            head = node;
        } else {
            Node current = head;
            while(current.next != null) current = current.next; //iterate each node until last node
            current.next = node; // last_node -> node
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
            Node current = head;
            while(current != null){ //iterate each node in the list
                if(current.student_id == id) //check if a node's student_id is equal to id
                    return current; //if yes, return the node and exit the function
                current = current.next;
            }
            //in case there are no any node that satisfies the condition 
            return new Node("Student Not Found!");
        }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
            
        } else {
            if(head.student_id == id){ //check if erasing node is the head
                Node temp = head;
                head = head.next;
                return temp; //if it is, return head right away
            }

            Node current = head;
            while(current.next != null){ //iterate each node in the list until the node before the erasing node or right before tail
                if(current.next.student_id == id){ //if the checking node is before the erasing node
                    Node temp = current.next;
                    current.next = current.next.next;
                    return temp;
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        node2.next = node1.next; //insert node2 between current and node1
        node1.next = node2;
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(head == node1){
            node2.next = node1;
            head = node2;
            return;
        }
        Node current = head;
        while(current != null){ //iterate each node until find the node before referencing node
            if(current.next == node1){
                node2.next = node1; //insert node2 between current and node1
                current.next = node2;
                return;
            }            
            current = current.next;
        }
    }
    
    public boolean isEmpty(){
        return (head == null); //return true if head is null;
    }
    public void merge(SinglyLinkedList list){
        Node tail = head;
        while(tail.next != null) tail = tail.next;
        tail.next = list.head;        
    }
    
    public void printStructure(){
        Node current=head;
        System.out.print(listName + ": head -> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public Node whoGotHighestGPA(){
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node maxgpaNode = head;
            Node current = head.next;
            while(current != null){ //iterate each nodes in the list
                if(current.gpa >= maxgpaNode.gpa)   //if considering max-gpa is greater than or equal to saved max-gpa
                    maxgpaNode = current;           //reassign max-gpa to the pointing node
                current = current.next;
            }
            return maxgpaNode; //return max-gpa
        }
    }
}
