import java.util.*;
class AvlMethods{
    class Node{
        int data;
        Node left;
        Node right;
        int height;

        Node(int val){
            data = val;
            left = null;
            right = null;
            height = 1;
        }
    }

    Node root;

    public int height(Node node){
        if(node == null)
            return 0;
        return node.height;
    }

    public int balFactor(Node node){
        if(node == null)
            return 0;
        return height(node.left) - height(node.right);

    }

    public void insert(int val){
        root = insertNode(root, val);
    }

    public Node insertNode(Node node, int val){
        if(node == null){
            Node newNode = new Node(val);
            return newNode;
        }
        else if(val < node.data){
            node.left = insertNode(node.left, val);
        }
        else{
            node.right = insertNode(node.right, val);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bal = balFactor(node);

        // Left-Left
        if((bal > 1) && (val < node.left.data)){
            System.out.println("Left-Left Rotation");
            return rightRotate(node);
        }

        // Right-Right
        if((bal < -1) && (val > node.right.data)){
            System.out.println("Right-Right Rotation");
            return leftRotate(node);
        }

        // Left-Right
        if((bal > 1) && (val > node.left.data)){
            node.left = leftRotate(node.left);
            System.out.println("Left-Right Rotation");
            return rightRotate(node);
        }

        // Right-Left

        if((bal < -1) && (val < node.right.data)){
            node.right = rightRotate(node.right);
            System.out.println("Right-Left Rotation");
            return leftRotate(node);
        }

        return node;
    }

    public void delete(int data)
    {
        if(search(data))
        {
            root = deleteRec(root, data);
            System.out.println("\n" + data + " deleted\n");
        }
        else
            System.out.println("\n" + data + " not found for deletion.\n");
    }

    private Node deleteRec(Node root, int data)
    {
        if(root == null)
            return root;

        if(root.data > data)
            root.left = deleteRec(root.left, data);

        else if(root.data < data)
            root.right = deleteRec(root.right, data);

        else
        {
            if(root.left == null && root.right == null)
                return null;
            if(root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minNode(root.right);

            root.right = deleteRec(root.right, root.data);
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int bal = balFactor(root);

        //LL
        if(bal > 1 && balFactor(root.left) >= 0) {
            System.out.println("Left-Left Rotation");
            return rightRotate(root);
        }

        //RR
        if(bal < -1 && balFactor(root.right) < 0) {
            System.out.println("Right-Right Rotation");
            return leftRotate(root);
        }

        //LR
        if(bal > 1 && balFactor(root.left) < 0) {
            System.out.println("Left-Right Rotation");
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RL
        if(bal < -1 && balFactor(root.right) > 0) {
            System.out.println("Right-Left Rotation");
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public int minNode(Node root)
    {
        if(root.left == null)
            return root.data;

        return minNode(root.left);
    }

    public Node rightRotate(Node y){
        Node x = y.left;
        Node t2 = x.right;
        //rotation
        x.right = y;
        y.left = t2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    public Node leftRotate(Node y){
        Node x = y.right;
        Node t3 = x.left;

        //rotation
        x.left = y;
        y.right = t3;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    public boolean search(int data)
    {
        Node temp = root;
        while(temp != null)
        {
            if(temp.data > data)
                temp = temp.left;
            else if(temp.data < data)
                temp = temp.right;
            else if(temp.data == data)
                return true;
        }
        return false;
    }


    public void display(Node root, String indent, boolean last){
        if(root != null){
            System.out.print(indent);
            if(last){
                System.out.print("R----");
                indent += "  ";
            }
            else{
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(root.data);
            display(root.left, indent, false);
            display(root.right, indent, true);
        }
    }



}

public class Avl {
    public static void main(String[] args){
        AvlMethods avl = new AvlMethods();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Choose operation: \n 1. Insert \n 2. Delete \n 3. Display \n 4. Exit");
            int val = sc.nextInt();


            switch (val) {
                case 1:
                    System.out.println("Enter a value to be inserted: ");
                    int new_val = sc.nextInt();
                    avl.insert(new_val);
                    break;
                case 2:
                    System.out.println("Enter a value to be deleted: ");
                    int del_val = sc.nextInt();
                    avl.delete(del_val);
                    break;
                case 3:
                    System.out.println("Your tree looks like : ");
                    avl.display(avl.root, "", true);
                    break;
                default:
                    System.out.println("Invalid operation being performed; ");
                    return;

            }

        }

    }


}


/*OUTPUT
Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
1
Enter a value to be inserted:
78
Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
1
Enter a value to be inserted:
90
Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
1
Enter a value to be inserted:
87
Right-Left Rotation
Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
1
Enter a value to be inserted:
45
Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
3
Your tree looks like :
R----87
  L----78
  |  L----45
  R----90
Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
1
Enter a value to be inserted:
66
Left-Right Rotation
Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
3
Your tree looks like :
R----87
  L----66
  |  L----45
  |  R----78
  R----90
Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
2
Enter a value to be deleted:
45

45 deleted

Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
3
Your tree looks like :
R----87
  L----66
  |  R----78
  R----90
Choose operation:
 1. Insert
 2. Delete
 3. Display
 4. Exit
4
Invalid operation being performed;

*/



