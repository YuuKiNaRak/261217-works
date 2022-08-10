package hw5;

public class Queue {
    Node[] arr; // circular Queue
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){
        this.capacity = cap; //ให้รับค่าcapเข้ามาไว้ที่calssของQueue
         arr = new Node[capacity];//แล้วสร้างอาเรย์ที่มีขนาดcapacity
        
    }
    
    public void enqueue(Node node){
        if (!isFull()){
        arr[back] = node;//ถ้าQไม่เต็มให้เเบ็คเป็นโหนดที่รับเข้ามาใหม่ หลังจากนั้น
         back = (back+1)%capacity;//ให้ย้ายเเบ็คไปที่ตัวถัดไปแล้วให้sizeเพิ่มขึ้น1
         size +=1;

            
        }else{
            System.out.println("Queue Overflow!!!");
        }
    }
    
    public Node dequeue(){
        
        if (!isEmpty()){
            Node x = arr[front];//ให้สร้างโหนดxชี้ไปที่ ฟ้อนเพราะเราจะรีเทินตัวที่ลบออกไป
            front = (front+1)%capacity;//ให้ฟ้อนย้ายไปที่ตัวถัดไปเเล้วลบsizeลง1
            size -=1;
            return x;
        }else{
            System.out.println("Queue Underflow!!!");
            return null;
        }
         
    }
    
    public boolean isEmpty(){
        
        return size==0; // ให้รีเทินบูลีนออกมาว่าว่างหรือไม่
    }
    
    public boolean isFull(){
        return size == capacity; // เช็คด้วยsizeว่ามีขนาดเท่ากับcapแล้วหรือยัง
    }
    
    public void printCircularIndices(){
        System.out.println("Front index = " + front + " Back index = " + back);
    }
    
    public void printQueue(){
        if (!isEmpty()){
            System.out.print("[Front] ");
            int i = front;
            do{ //ให้i=frontก่อนเเล้วให้iปริ้นค่าที่อยู่ในฟ้อนหลังจากนั้นให้iย้ายไปเรื่อยๆจนกว่าจะเจอback
                System.out.print(arr[i].data+" ");
                i = (i+1)%capacity;
            }
            while(i!=back);
                
            System.out.println("[Back]");
        }else{
            System.out.println("Empty Queue!!!");
        }
    }
}
