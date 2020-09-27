import java.util.*;

class RBMethods {
    enum Color {RED, BLACK}

    class Node {
        Node left, right;
        int data;
        Node parent;
        Color color;

        Node(int val) {
            data = val;
            left = right = null;
            parent = null;
            color = Color.RED;
        }
    }

    Node root;

    // Fetches Parent
    Node getParent(Node node) {
        return node == null ? null : node.parent;
    }

    // Fetches Grand-Parent
    Node getGrandParent(Node node) {
        return getParent(getParent(node));
    }

    // Fetches Sibling
    Node getSibling(Node node) {
        Node p = getParent(node);

        if (p == null)
            return null;

        if (node == p.left)
            return p.right;
        else
            return p.left;
    }

    //Fetches Uncle
    Node getUncle(Node node) {
        Node p = getParent(node);
        return getSibling(p);
    }

    private void rightRotate(Node y) {
        Node newNode = y.left;
        Node p = getParent(y);

        if(newNode != null) {

            y.left = newNode.right;
            newNode.right = y;
            y.parent = newNode;

            if (y.left != null)
                y.left.parent = y;

            if (p != null) {
                if (y == p.left)
                    p.left = newNode;
                else if (y == p.right)
                    p.right = newNode;
            }
            newNode.parent = p;
        }

    }

    private void leftRotate(Node y) {
        Node newNode = y.right;
        Node p = getParent(y);

        if(newNode != null) {

            y.right = newNode.left;
            newNode.left = y;
            y.parent = newNode;

            if (y.right != null)
                y.right.parent = y;

            if (p != null) {
                if (y == p.left)
                    p.left = newNode;
                else if (y == p.right)
                    p.right = newNode;
            }
            newNode.parent = p;
        }
    }


    Node insert(int data) {
            Node node = new Node(data);

        insertRec(root, node);

        insertRepairTree(node);

        root = node;
        while (getParent(root) != null) {
            root = getParent(root);
        }
        return root;
    }

    void insertRec(Node root, Node node) {
        if (root != null) {
            if (node.data < root.data) {
                if (root.left != null) {
                    insertRec(root.left, node);
                    return;
                } else
                    root.left = node;

            } else {
                if (root.right != null) {
                    insertRec(root.right, node);
                    return;
                } else
                    root.right = node;
            }

        }

        node.parent = root;
        node.left = null;
        node.right = null;
        node.color = Color.RED;
    }

    void insertRepairTree(Node node) {
        if (getParent(node) == null) {
            node.color = Color.BLACK;
        } else if (getParent(node).color == Color.BLACK) {
            return;
        } else if (getUncle(node) != null && getUncle(node).color == null) {
            getParent(node).color = Color.BLACK;
            getUncle(node).color = Color.BLACK;
            getGrandParent(node).color = Color.RED;
            insertRepairTree(getGrandParent(node));
        } else {
            Node p = getParent(node);
            Node g = getGrandParent(node);

            if (node == p.right && p == g.left) {
                leftRotate(p);
                node = node.left;
            } else if (node == p.left && p == g.right) {
                rightRotate(p);
                node = node.right;
            }
            p = getParent(node);
            g = getGrandParent(node);


            if (node == p.left)
                rightRotate(g);
            else
                leftRotate(g);

            p.color = Color.BLACK;
            g.color = Color.RED;
        }

    }
    public void treeStructure(Node root, String indent, boolean last)
    {
        if(root != null)
        {
            System.out.print(indent);
            if(last) {
                System.out.print("R----");
                indent += "  ";
            }
            else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(root.data + "\t" + root.color);
            treeStructure(root.left, indent, false);
            treeStructure(root.right, indent, true);
        }
    }

    public void replaceNode(Node node, Node child){

        child.parent = node.parent;
        if(node == node.parent.left){
            node.parent.left = child;
        }
        else
            node.parent.right = child;
    }


    public void deleteOneChild(int data){
        Node node = new Node(data);
        Node child = (node.right == null) ? node.left : node.right;
        if(child != null){
            replaceNode(node, child);
            if(node.color == Color.BLACK){
                if(child.color == Color.RED)
                    child.color = Color.BLACK;
                else
                    deleteCase1(child);
            }

        }
        //node = null;
       //free(node);
    }

    public void deleteCase1(Node node){
        if(node.parent != null) {
            Node sib = getSibling(node);
            deleteCase2(node);
        }
    }

    public void deleteCase2(Node node){
            Node sib = getSibling(node);
            if(sib.color == Color.RED){
                node.parent.color = Color.RED;
                sib.color = Color.BLACK;
                if(node == node.parent.left)
                    leftRotate(node.parent);
                else
                    rightRotate(node.parent);
            }
            deleteCase3(node);

        }
    public void deleteCase3(Node node){
        Node sib = getSibling(node);
        if((node.parent.color == Color.BLACK) && (sib.color == Color.BLACK)&&(sib.left.color == Color.BLACK) && (sib.right.color == Color.BLACK)){
            sib.color = Color.RED;
            deleteCase1(node.parent);
        }
        else{
            deleteCase4(node);
        }
    }

    public void deleteCase4(Node node){
        Node sib = getSibling(node);

        if((node.parent.color == Color.RED) && (sib.color == Color.BLACK) && (sib.left.color == Color.BLACK) && (sib.right.color == Color.BLACK)){
            sib.color = Color.RED;
            node.parent.color = Color.BLACK;
        }
        else
            deleteCase5(node);
    }

    public void deleteCase5(Node node){
        Node sib = getSibling(node);

        if(sib.color == Color.BLACK){
            if((node == node.parent.left) && (sib.right.color == Color.BLACK) &&(sib.left.color == Color.RED)){
                sib.color = Color.RED;
                sib.left.color = Color.BLACK;
                rightRotate(sib);
            }
            else if((node == node.parent.right) && (sib.left.color == Color.BLACK) &&(sib.right.color == Color.RED)){
                sib.color = Color.RED;
                sib.right.color = Color.BLACK;
                leftRotate(sib);
            }
        }
        deleteCase6(node);
    }

    public void deleteCase6(Node node){
        Node sib = getSibling(node);
        sib.color = node.parent.color;
        node.parent.color = Color.BLACK;

        if(node == node.parent.left){
            sib.right.color = Color.BLACK;
            leftRotate(node.parent);
        }
        else{
            sib.left.color = Color.BLACK;
            rightRotate(node.parent);
        }
    }

}

public class RedBlackTree {
    public static void main(String[] args){
        RBMethods obj1 = new RBMethods();

        Scanner sc = new Scanner(System.in);

        boolean op = true;
        while(op)
        {
            System.out.println("1 - Insert\n2 - Display\n3 - Delete \n5 - Exit");
            System.out.print("Enter your Choice: \n");
            int choice = sc.nextInt();
            int data;

            switch(choice) {
                case 1:
                    System.out.print("Enter a value to be inserted: ");
                    data = sc.nextInt();
                    obj1.insert(data);
                    System.out.println(data + " inserted\n");

                case 2:
                    if (obj1.root == null)
                        System.out.println("Nothing to show!");
                    else
                        obj1.treeStructure(obj1.root, "", true);
                        System.out.println();
                    break;

                case 3:
                    System.out.print("Enter a value to be deleted: ");
                    data = sc.nextInt();
                    obj1.deleteOneChild(data);
                    System.out.println(data + " deleted\n");

                default:
                    System.out.println("\n \nInvalid choice");

            }
        }
        sc.close();
    }
}

/* OUTPUT
1 - Insert
2 - Display
3 - Delete
5 - Exit
Enter your Choice:
1
Enter a value to be inserted: 10
10 inserted

R----10	BLACK

1 - Insert
2 - Display
3 - Delete
5 - Exit
Enter your Choice:
3
Enter a value to be deleted: 10
10 deleted



Invalid choice
 */