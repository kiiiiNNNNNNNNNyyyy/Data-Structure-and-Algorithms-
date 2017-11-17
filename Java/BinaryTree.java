import javax.net.ssl.ExtendedSSLSession;
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

    public boolean remove(int key){
        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while(focusNode.key != key){
            parent = focusNode;
            if(key < focusNode.key){
                isItALeftChild = true;
                focusNode = focusNode.leftChild;
            }else{
                isItALeftChild = false;
                focusNode = focusNode.RightChild;
            }

            if(focusNode == null){
                return false;
            }
        }

        if(focusNode.leftChild == null && focusNode.RightChild == null){
            if(focusNode == root){
                root = null;
            }else if(isItALeftChild){
                parent.leftChild = null;
            }else{
                parent.RightChild = null;
            }
        }

        else if(focusNode.RightChild == null){
            if(focusNode == root){
                root = focusNode.leftChild;
            }else if(isItALeftChild){
                parent.leftChild = focusNode.leftChild;
            }else{
                parent.RightChild = focusNode.leftChild;
            }
        }

        else if(focusNode.leftChild == null){
            if(focusNode == root){
                root = focusNode.RightChild;
            }else if(isItALeftChild){
                parent.leftChild = focusNode.RightChild;
            }else{
                parent.RightChild = focusNode.leftChild;
            }
        }

        else{
            Node replacement = getReplacementNode(focusNode);
            if(focusNode == root){
                root = replacement;
            }else if(isItALeftChild){
                parent.leftChild = replacement;
            }else{
                parent.RightChild = replacement;
            }

            replacement.leftChild = focusNode.leftChild;
        }

        return true;
    }

    public Node getReplacementNode(Node replacedNode){
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.RightChild;

        while(focusNode != null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if(replacement != replacedNode.RightChild){
            replacementParent.leftChild = replacement.RightChild;
            replacementParent.RightChild = replacedNode.RightChild;
        }

        return replacement;
    }
    
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.addNode(50, "Boss");
        tree.addNode(25, "VP");
        tree.addNode(15, "Manager");
        tree.addNode(30, "Seceratory");
        tree.addNode(75, "Sales Manager");
        tree.addNode(85, "SalesMan");

        System.out.println("REMOVE KEY 25");
        tree.remove(25);

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