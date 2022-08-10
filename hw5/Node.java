package hw5;

public class Node extends BTreePrinter {

    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data; //assign data
    }

    public void printTree() {
        super.printTree(this);
    }

    public void printBFT() {
        Queue q = new Queue(50);
        System.out.print("BFT node sequence [ ");
        q.enqueue( this ); //enqueue itself into the Queue
        Node node; //declare a Node
        while ( !q.isEmpty() ){
            node = q.dequeue();
            System.out.print(node.data + " "); //print
            if (node.left != null) //enqueue its children
                q.enqueue(node.left);
            if (node.right != null)
                q.enqueue( node.right);
        }
        System.out.println("]");
    }

    public void printDFT() { // PreOrder
        Stack s = new Stack(50);
        System.out.print("DFT node sequence [ ");
        s.push( this ); //push itself into the Stack
        Node node; //declare a Node
        while ( !s.isEmpty() ){
            node= s.pop();
            System.out.print(node.data + " "); //print
            if (node.right != null) //push its children
                s.push(node.right);
            if (node.left != null)
                s.push( node.left);
        }
        System.out.println("]");
    }
}
