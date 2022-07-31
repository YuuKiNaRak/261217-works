package hw4;
public class Queue implements List{
    // Implement Queue using Linked List with tail
    Node head;
    Node tail;
    
    public void push(Node node){ 
        if (head == null){//ให้เช็คก่อนว่าในQueueว่างไหมถ้าว่างให้ head tail = node
            head = node;
            tail = node;
        }else{ //ถ้าไม่ว่างให้ tail.nextชี้ไปที่โหนดใหม่
           tail.next = node ;//แล้วค่อยย้ายtailไปที่โหนดใหม่
          tail = node;
        }
    }
    
    public void pop(){
        if (head != null){//ให้เช็คก่อนว่าในQueueว่างไหมถ้าไม่ว่างให้ เฮดชี้ไปที่ตัวถัดไปเลย
            if (head != tail){
                head = head.next;
            }else{//ถ้าว่างให้เฮดกับเทลเท่ากับนัล
                head = null;
                tail = null;
            
            }
        }else System.out.println("Error: Queue Underflow");//แล้วรีเทินErrorออกมา
    }
    
    public Node top(){
        return head;//รีเทินตัวหน้าสุดออกมา
    }
    
}

