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
            if(tail == head){ //check if the list has a single node
                tail = null;
                head = null;
                return;
            }
            tail = tail.previous; 
            tail.next = null; //set next of the last node to null since it was pointing to previous tail
        }
    }
    
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            if(tail == head){ //check if the list has a single node
                tail = null; 
                head = null;
                return;
            }
            head = head.next;
            head.previous = null; //set previous of the first node to null since it was pointing to previous head
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head; //return the first node
        }
    }
    
    public Node topBack(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return tail; //return the last node
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head = node; //If the list was empty, both head and tail will point toward the input node.
            tail = node;
        }else{
            head.previous = node; //assign previous of head to node     node <-  HEAD <->...
            node.next = head; //assign next of node to head             node <-> HEAD <->...
            head = node; //reassign head to the new node                HEAD <-> previous_head <->...
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()) {
            head = node; //If the list was empty, both head and tail will point toward the input node.
            tail = node;
        } else {
            tail.next = node; //assign next of tail to node             ... <-> TAIL  -> node
            node.previous = tail; //assign previous of node to tail     ... <-> TAIL <-> node
            tail = node;  //reassign tail to the new node              ... <-> previous_tail <-> TAIL
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
            Node current = head;
            while(current != null){ //iterate each node in the list
                if(current.student_id == id){ //if found the node which its student_id is equal to id
                    if(current != head) //if the node isn't head
                        current.previous.next = current.next;
                    else{
                        head = head.next;
                        head.previous = null; //set previous of the new_head to null since it was pointing to previous_head
                    }
                    if(current != tail) //if the node isn't tail
                        current.next.previous = current.previous;
                    else{
                        tail = tail.previous;
                        tail.next = null; //set next of the new_tail to null since it was pointing to previous_tail
                    }

                    return current; //return the erased node
                }
                current = current.next;
            }
            //in case there are no any node that satisfies the condition       
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        if(node1 == tail)   //check if node1 is the tail
            tail = node2;
        else{//if not                           <----------------->
            node2.next = node1.next;        //node1   node2  -> node3  
            node2.next.previous = node2;    //node1   node2 <-> node3
        }
        node2.previous = node1; //node1 <-  node2
        node1.next = node2;     //node1 <-> node2
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(node1 == head)   //check if node1 is the head
            head = node2;
        else{//if not                               <----------------->
            node2.previous = node1.previous;    //node3 <-  node2   node1
            node2.previous.next = node2;        //node3 <-> node2   node1
        }
        node2.next = node1;     //node2  -> node1
        node1.previous = node2; //node2 <-> node1
    }
    
    public boolean isEmpty(){
        return (head == null); //return true if head is null;
    }
    public void merge(DoublyLinkedList list){
        this.tail.next = list.head;         //connects 2 lists together
        list.head.previous = this.tail;
        this.tail = list.tail;  //reassign main-tail to point toward the inputlist-tail
    }
    
    public void printStructure(){
        Node current=head;
        System.out.print(listName + ": head <-> ");
        while(current!=null){ //iterate each node in the list
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.next;
        }
        System.out.println("tail");
    }
    
    //This may be useful for you for implementing printStructure()
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
