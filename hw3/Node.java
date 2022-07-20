package hw3;

public class Node {
    public int student_id;
    public String name;
    public double gpa;
    
    Node next;
    Node previous;
    
    // Constructor 1
    public Node(int id, String name, double gpa){
        this.student_id = id; //assign student_id to the input name
        this.name = name; //assign name to the input name
        this.gpa = gpa; //assign gpa to the input gpa
    }
    // Constructor 2
    public Node(String name){
        this.name = name; //assign game to the input name
    }
    // Constructor 3 (dummy)
    public Node(){
        // You can leave this function blank
    }
    
    public void printIDName(){
        System.out.println("StudentID: " + student_id + " , Name: " + name);
    }

}
