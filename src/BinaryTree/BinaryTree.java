package BinaryTree;

class BinaryTree {
    
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    
    Node root;

    
    BinaryTree() {
        root = null;
    }

    
    void insert(int key) {
        root = insertRec(root, key);
    }

    
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

   
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    
    Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            
            root.key = minValue(root.right);

            
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    
    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    
    void printPreOrder() {
        printPreOrderRec(root);
    }

    void printPreOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            printPreOrderRec(root.left);
            printPreOrderRec(root.right);
        }
    }

    
    void printInOrder() {
        printInOrderRec(root);
    }

    void printInOrderRec(Node root) {
        if (root != null) {
            printInOrderRec(root.left);
            System.out.print(root.key + " ");
            printInOrderRec(root.right);
        }
    }

    
    void printPostOrder() {
        printPostOrderRec(root);
    }

    void printPostOrderRec(Node root) {
        if (root != null) {
            printPostOrderRec(root.left);
            printPostOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print traversals
        System.out.println("Pre-order traversal:");
        tree.printPreOrder();

        System.out.println("\nIn-order traversal:");
        tree.printInOrder();

        System.out.println("\nPost-order traversal:");
        tree.printPostOrder();

        // Delete a node
        System.out.println("\n\nDelete 20");
        tree.deleteKey(20);
        System.out.println("In-order traversal after deletion:");
        tree.printInOrder();

        System.out.println("\n\nDelete 30");
        tree.deleteKey(30);
        System.out.println("In-order traversal after deletion:");
        tree.printInOrder();

        System.out.println("\n\nDelete 50");
        tree.deleteKey(50);
        System.out.println("In-order traversal after deletion:");
        tree.printInOrder();
    }
}
