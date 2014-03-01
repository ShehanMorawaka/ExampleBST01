package examplebst;

public class BinaryTree 
{
    Node root;

    public void addNode_keyISBN(int isbn, String b_Title) 
    {
        // Create a new Node and initialize it
        Node newNode = new Node(isbn, b_Title);

        // If there is no root this becomes root
        if (root == null) 
        {
            root = newNode;
        } 
        else 
        {
            // Set root as the Node we will start
            // with as we traverse the tree
            Node focusNode = root;

            // Future parent for our new Node
            Node parent;

            while (true) 
            {
                // root is the top parent so we start
                // there
                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node
                if (isbn < focusNode.isbn) 
                {
                    // Switch focus to the left child
                    focusNode = focusNode.leftChild;

                    // If the left child has no children
                    if (focusNode == null) 
                    {
                        // then place the new node on the left of it
                        parent.leftChild = newNode;
                        return; // All Done
                    }
                }
                else 
                { 
                    // If we get here put the node on the right
                    focusNode = focusNode.rightChild;

                    // If the right child has no children
                    if (focusNode == null) 
                    {
                        // then place the new node on the right of it
                        parent.rightChild = newNode;
                        return; // All Done
                    }
                }
            }
        }
    }
    
    public void addNode_keyBookTitle(int isbn, String b_Title) 
    {
        // Create a new Node and initialize it
        Node newNode = new Node(isbn, b_Title);

        // If there is no root this becomes root
        if (root == null) 
        {
            root = newNode;
        } 
        else 
        {
            // Set root as the Node we will start
            // with as we traverse the tree
            Node focusNode = root;

            // Future parent for our new Node
            Node parent;

            while (true) 
            {
                // root is the top parent so we start
                // there
                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node
                if (b_Title.compareTo(focusNode.b_Title)<0) 
                {
                    // Switch focus to the left child
                    focusNode = focusNode.leftChild;

                    // If the left child has no children
                    if (focusNode == null) 
                    {
                        // then place the new node on the left of it
                        parent.leftChild = newNode;
                        return; // All Done
                    }
                }
                else 
                { 
                    // If we get here put the node on the right
                    focusNode = focusNode.rightChild;

                    // If the right child has no children
                    if (focusNode == null) 
                    {
                        // then place the new node on the right of it
                        parent.rightChild = newNode;
                        return; // All Done
                    }
                }
            }
        }
    }


    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth

    public void inOrderTraverseTree(Node focusNode) 
    {
        if (focusNode != null) 
        {
            // Traverse the left node
            inOrderTraverseTree(focusNode.leftChild);

            // Visit the currently focused on node
            System.out.println(focusNode);

            // Traverse the right node
            inOrderTraverseTree(focusNode.rightChild);
        }
    }
    
     public void preorderTraverseTree(Node focusNode) 
    {
        if (focusNode != null) 
        {
            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode) 
    {
        if (focusNode != null) 
        {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    public Node findNode_keyISBN(int isbn) 
    {
        // Start at the top of the tree
        Node focusNode = root;

        // While we haven't found the Node
        // keep looking
        while (focusNode.isbn != isbn) 
        {
            // If we should search to the left
            if (isbn < focusNode.isbn) 
            {
                // Shift the focus Node to the left child
                focusNode = focusNode.leftChild;
            } 
            else 
            {
                // Shift the focus Node to the right child
                focusNode = focusNode.rightChild;
            }

            // The node wasn't found
            if (focusNode == null)
            {
                return null;
            }
        }
        return focusNode;
    }
    
    public Node findNode_keyBookTitle(String b_Title) 
    {
        // Start at the top of the tree
        Node focusNode = root;

        // While we haven't found the Node
        // keep looking
        while (!focusNode.b_Title.equals(b_Title)) 
        {
            // If we should search to the left
            if (b_Title.compareTo(focusNode.b_Title)<0) 
            {
                // Shift the focus Node to the left child
                focusNode = focusNode.leftChild;
            } 
            else 
            {
                // Shift the focus Node to the right child
                focusNode = focusNode.rightChild;
            }
            
            // The node wasn't found
            if (focusNode == null)
            {
                return null;
            }
        }
        return focusNode;
    }

    public static void main(String[] args) 
    {
        BinaryTree theTree = new BinaryTree();

            //Entering some data to the tree which the ISBN is the key
    //        theTree.addNode_keyISBN(2130071606, "Java, A Beginner’s Guide, (5th Edition)");
    //        theTree.addNode_keyISBN(2130321356, "Effective Java (2nd Edition)");
    //        theTree.addNode_keyISBN(2130132761, "What’s New in Java 7?");
    //        theTree.addNode_keyISBN(2130596009, "Head First Java (2nd Edition)");
    //        theTree.addNode_keyISBN(2130132936, "Introduction to Java Programming");
    //        theTree.addNode_keyISBN(2131449343, "Java 7 Pocket Guide");
    //        theTree.addNode_keyISBN(2130070435, "Java The Complete Reference (8th Edition)");
    //        theTree.addNode_keyISBN(2131449319, "Learning Java");
    //        theTree.addNode_keyISBN(2130321927, "Java SE 8 for the Really Impatient");
    //        theTree.addNode_keyISBN(2130071633, "Java Programming (Oracle Press)");

            //Entering some data to the tree which the Book_Title is the key
            theTree.addNode_keyBookTitle(2130071606, "Java, A Beginner’s Guide, (5th Edition)");
            theTree.addNode_keyBookTitle(2130321356, "Effective Java (2nd Edition)");
            theTree.addNode_keyBookTitle(2130132761, "What’s New in Java 7?");
            theTree.addNode_keyBookTitle(2130596009, "Head First Java (2nd Edition)");
            theTree.addNode_keyBookTitle(2130132936, "Introduction to Java Programming");
            theTree.addNode_keyBookTitle(2131449343, "Java 7 Pocket Guide");
            theTree.addNode_keyBookTitle(2130070435, "Java The Complete Reference (8th Edition)");
            theTree.addNode_keyBookTitle(2131449319, "Learning Java");
            theTree.addNode_keyBookTitle(2130321927, "Java SE 8 for the Really Impatient");
            theTree.addNode_keyBookTitle(2130071633, "Java Programming (Oracle Press)");

            System.out.println("Tree in InOrder Traversal:\n");
            theTree.inOrderTraverseTree(theTree.root);

    //         Find the node with ISBN
    //        System.out.println("\n\nNode with the ISBN 2131449343:\n");
    //        System.out.println(theTree.findNode_keyISBN(2131449343));

    //        Find the node with Book Title
            System.out.println("\n\nNode with the Book_Title 'Learning Java':\n");
            System.out.println(theTree.findNode_keyBookTitle("Learning Java"));
        }
    }

class Node 
{
    int isbn;
    String b_Title;

    Node leftChild;
    Node rightChild;

    Node(int isbn, String b_Title) 
    {
        this.isbn = isbn;
        this.b_Title = b_Title;
    }

    public String toString() 
    {
        return isbn+"    "+b_Title;
    }
}