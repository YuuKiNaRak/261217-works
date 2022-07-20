package hw3;

public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        this.listName = name; //assign name to the input name
    } 
    
    public void popBack() {
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            if(tail == head){
                tail = null;
                head = null;
                return;
            }
            tail = tail.previous; //point tail to the node previous to tail

        }
    }
    
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            if(tail == head){
                System.out.println("HELLO");
                tail = null;
                head = null;
                return;
            }
            head = head.next; //point head to the node next to head
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return new Node(head.student_id, head.name, head.gpa);
        }
    }
    
    public Node topBack(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return new Node(tail.student_id, tail.name, tail.gpa);
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head = node;
            tail = node;
        }else{
            head.previous = node; //assign previous of head to node
            node.next = head; //assign next of node to head
            head = node; //reassign head to the new node
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node; //assign next of tail to node
            node.previous = tail; //assign previous of node to tail
            tail = node;  // reassign tail to the new node
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
            Node current = head; //Assign new node "current" pointing it to head
            while(current != null){ //loop until current is null
                if(current.student_id == id) //check if 
                    return current;
                current = current.next;
            }

            return new Node("Student Not Found!");
        }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
            Node current = head; //Assign new node "current" pointing it to head
            while(current != null){ //loop until current is null
                if(current.student_id == id){ //check if 
                    if(current != head)
                        current.previous.next = current.next;
                    else{
                        head = head.next;
                        head.previous = null;
                    }
                    if(current != tail)
                        current.next.previous = current.previous;
                    else{
                        tail = tail.previous;
                        tail.next = null;
                    }

                    return current;
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        node2.next = node1.next;
        node2.next.previous = node2;
        node1.next = node2;
        node2.previous = node1;
    }
    
    public void addNodeBefore(Node node1, Node node2){
        node2.previous = node1.previous;
        node2.previous.next = node2;
        node1.previous = node2;
        node2.next = node1;
    }
    
    public boolean isEmpty(){
        return (head == null); // return true if head is null;
    }
    public void merge(DoublyLinkedList list){
        this.tail.next = list.head;
        list.head.previous = this.tail;
        this.tail = list.tail;
    }
    
    public void printStructure(){
        Node current=head;
        System.out.print(listName + ": head <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.next;
        }
        System.out.println("tail");
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node whoGotHighestGPA(){
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node maxGpa = head;
            Node current = head.next;
            while(current != null){
                if(current.gpa >= maxGpa.gpa)
                    maxGpa = current;
                current = current.next;
            }

            return new Node(maxGpa.student_id, maxGpa.name, maxGpa.gpa);
        }
    }
}
