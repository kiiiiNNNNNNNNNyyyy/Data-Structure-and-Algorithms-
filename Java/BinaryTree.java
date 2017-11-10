import javax.swing.text.html.FormView;

public class BinaryTree{

    Node root;

    // Adding new node to the BST
    public void addNode(int key, String name){
        Node newNode = new Node(key, name);

        if(root == null){
            root = newNode;
        }else{
            Node focusNode = root;
            Node parent;
            while(true){
                parent = focusNode;
                if(key <  focusNode.key){
                    focusNode = focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    focusNode = focusNode.RightChild;
                    if(focusNode == null){
                        parent.RightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraversalTree(Node focusNode){
        if(focusNode != null){
            inOrderTraversalTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversalTree(focusNode.RightChild);
        }
    }

    public void preOrderTraversalTree(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraversalTree(focusNode.leftChild);
            preOrderTraversalTree(focusNode.RightChild);
        }
    }

    public void postOrderTraversalTree(Node focusNode){
        if(focusNode != null){
            postOrderTraversalTree(focusNode.leftChild);
            postOrderTraversalTree(focusNode.RightChild);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key){
        Node focusNode = root;
        while(focusNode.key != key){
            if(key < focusNode.key){
                focusNode = focusNode.leftChild;
            }else{
                focusNode = focusNode.RightChild;
            }

            if(focusNode == null){
                return null;
            }
        }
        return focusNode;
    }
    
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.addNode(50, "Boss");
        tree.addNode(25, "VP");
        tree.addNode(15, "Manager");
        tree.addNode(30, "Seceratory");
        tree.addNode(75, "Sales Manager");
        tree.addNode(85, "SalesMan");

        tree.postOrderTraversalTree(tree.root);
        System.out.println(tree.findNode(30));
    }
}

class Node{

    int key;
    String name;

    Node leftChild;
    Node RightChild;

    Node(int key, String name){
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return name + " has a key " + key;
    }
}