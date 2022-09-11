
// This Tree needs to inherit BTreePrinter
public class Tree extends BTreePrinter{ //inherit from BTreePrinter
    Node root;
      
    public Tree(Node root){
        this.root = root;
    }
    
    public Tree(){} // Dummy constructor (No need to edit)
    
    public void printTree(){
        //super.printTree(root);
        //System.out.println("Empty tree!!!");
    }

    public static void printNode(Node node){
        //System.out.println("Node not found!!!");
    }
        
    public Node find(int search_key){
        return null; // Call the recursive version
    }
    
    public static Node find(Node node, int search_key){
        // this function should be recursive
        // You should check null in this function
        
        return null;
    }
    
    
    public Node findMin(){
        return null; // Call the recursive version
    }
    
    public static Node findMin(Node node){
        // this function should be recursive
        return null;
    }
    
    public Node findMax(){
        return null; // Call the recursive version
    }
    
    public static Node findMax(Node node){
        // this function should be recursive
        return null;
    }
    
    public Node findClosestLeaf(int search_key){
        return null; // Call the recursive version
    }
    
    public static Node findClosestLeaf(Node node, int search_key){
        // this function should be recursive
        return null;
    }
    
    public Node findClosest(int search_key){
        
        Node current, closest;
        closest = current = root;
        int min_diff = Integer.MAX_VALUE;
        
        
        
        while (current != null) { //วนจนกว่า จะเจอ null 
            if(search_key == current.key ){ //เมื่อ node ที่ใช้อยุ่ เท่ากับ search_key
                return current; // นำ node ตรงจุดนั้นแแกมาแล้วจบเลย
            }

            if( Math.abs(search_key - current.key) < min_diff){ //เมื่อค่าABS ของ search_key - current.key น้อยกว่า min_diff 
                min_diff = Math.abs(search_key - current.key); //min_diff จะเป็นค่านั้น
                closest =  current; // ให้closestเป็นnodeที่ใกล้ที่สุด
            }

            if( search_key < current.key){ //เมื่อ search_key < current.key
                current = current.left; // ให้cuurent ไปทางซ้าย
            }
            else{
                current = current.right;// ให้cuurent ไปทางขวา
            }
            
        }
        
        return closest;//ส่งค่าclosest
    
    
    // Implement this function using the findClosestLeaf technique
    // Do not implement the recursive function
    public void insert(int key) {
        // Implement insert() using the non-recursive version
        // This function should call findClosestLeaf()
    }
    
    public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        
        if(root != null){   //If the the tree is empty, there is nothing to print.
            //left -> center -> right
            printPreOrderDFT(root.left);
            System.out.print(root.key + " ");
            printPreOrderDFT(root.right);
        }
        
        System.out.println("]");
    }
    
    public static void printPreOrderDFT(Node node){
        if(node == null) return;    //If the node is null, there is nothing to print.
        
        //left -> center -> right
        printPreOrderDFT(node.left);
        System.out.print(node.key + " ");
        printPreOrderDFT(node.right); 
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        
        if(root != null){   //If the the tree is empty, there is nothing to print.
            //center -> left -> right
            System.out.print(root.key + " ");
            printInOrderDFT(root.left);
            printInOrderDFT(root.right);
        }
        
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        if(node == null) return;    //If the node is null, there is nothing to print.
        
        //center -> left -> right
        System.out.print(node.key + " ");
        printInOrderDFT(node.left);
        printInOrderDFT(node.right);
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");

        if(root != null){   //If the the tree is empty, there is nothing to print.
            //left -> right -> center
            printPostOrderDFT(root.left);
            printPostOrderDFT(root.right);
            System.out.print(root.key + " ");
        }
        
        System.out.println("]");
    }
    
    public static void printPostOrderDFT(Node node){
        if(node == null) return;    //If the node is null, there is nothing to print.
        
        //left -> right -> center
        printPostOrderDFT(node.left);
        printPostOrderDFT(node.right);
        System.out.print(node.key + " ");
    }
    
    public static int height(Node node){
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        return -2;
    }
    
    public static int size(Node node){
        if(node == null) 
            return 0; //Node is null, therefore its size is 0.
        
        // size of it self + size of left-subtree + size of right-subtree
        return 1 + size(node.left) + size(node.right);
    }
    
    public static int depth(Node root, Node node){
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root
        // depth = length(path{node->root})
        return -2;

    }
    
    public int height(){ // Tree height
        // Hint: call the static function
        return -2;
    }
    
    public int size(){ // Tree size
        return size(root);
    }
    
    public int depth(){ // Tree depth
        // Hint: call the static function
        return -2;
    }
    
    public Node findKthSmallest(int k){
        return null; // Call the recursive version
    }
    
    public static Node findKthSmallest(Node node, int k){
        // this function should be recursive
        return null;
    }
    
    public static Node findNext(Node node){
        //this function should call other functions
        return null;
    }
    
    public static Node leftDescendant(Node node){// Case 1 (findMin)
        // this function should be recursive
        return null;
    }
    
    public static Node rightAncestor(Node node) {// Case 1 (first right parent)
        // this function should be recursive
        return null;
    }
    
    public List rangeSearch(int x, int y){
        // This function utilizes findCloest() and findNext()
        // Use List list append(node) to add node to the list
        // List is the static Array
        return new List(100);
    }
    
         
    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void delete(int key) {
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function
    }

    // Use this function to delete non-root nodes
    public static void delete(Node node){
        // There should be 7 cases here
    }
}
