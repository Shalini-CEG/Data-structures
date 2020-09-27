import java.util.Scanner;
class SplayMethods{
    class Node
    {
        int data;
        Node left,right;

        Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public void add(int data)
    {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data)
    {
        Node newNode = new Node(data);

        if(root == null)
            return newNode;

        root = splay(root, data);

        if(root.data == data)
            return root;

        if(data < root.data)
        {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        }
        else
        {
            newNode.left = root;
            newNode.right = root.right;
            root.right= null;
        }

        return newNode;
    }

    public boolean search(int data)
    {
        if(root == null)
            return false;

        root = splay(root, data);
        return root.data == data;
    }

    public void delete(int data)
    {
        root = deleteRec(root, data);
    }

    public Node deleteRec(Node root, int data)
    {
        Node temp;

        if(root == null)
            return null;

        root = splay(root, data);

        if(root.data != data) {
            System.out.println(data + " not found for deletion\n");
            return root;
        }
        else
            System.out.println(data + " deleted\n");

        if(root.left == null) {
            temp = root;
            root = root.right;
        }
        else
        {
            temp = root;

            root = splay(root.left, data);

            root.right = temp.right;
        }

        return root;
    }

    private Node splay(Node root, int data)
    {
        if(root == null || root.data == data)
            return root;

        // Left Subtree
        if(data < root.data)
        {
            if(root.left == null)
                return root;

            if(data < root.left.data) //Zig - Zig
            {
                root.left.left = splay(root.left.left, data);

                root = rightRotate(root);
            }
            else if(data > root.left.data) //Zig - Zag
            {
                root.left.right = splay(root.left.right, data);

                if(root.left.right != null)
                    root.left = leftRotate(root.left);
            }

            if(root.left == null)
                return root;
            else
                return rightRotate(root);
        }

        // Right Subtree
        else
        {
            if(root.right == null)
                return root;

            if(data > root.right.data)
                //Zag - Zag
            {
                root.right.right = splay(root.right.right, data);

                root = leftRotate(root);
            }
            else if(data < root.right.data)
                //Zag - Zig
            {
                root.right.left = splay(root.right.left, data);

                if(root.right.left != null)
                    root.right = rightRotate(root.right);
            }

            if(root.right == null)
                return root;
            else
                return leftRotate(root);
        }
    }

    private Node rightRotate(Node y)
    {
        Node x = y.left;
        Node t3 = x.right;

        //Rotate
        x.right = y;
        y.left = t3;

        return x;
    }

    private Node leftRotate(Node x)
    {
        Node y = x.right;
        Node t1 = x.left;

        //Rotate
        y.left = x;
        x.right = t1;

        return y;
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
            System.out.println(root.data);
            treeStructure(root.left, indent, false);
            treeStructure(root.right, indent, true);
        }
    }
}

public class SplayTree
{
    public static void main(String[] args)
    {
        SplayMethods obj1 = new SplayMethods();

        Scanner input = new Scanner(System.in);

        boolean op = true;
        while(op)
        {
            System.out.println("1 - Insert\n2 - Display\n3 - Search\n4  -Delete\n5 - Exit");
            System.out.print("Enter your Choice: \n");
            int choice = input.nextInt();
            int data;

            switch(choice)
            {
                case 1:
                    System.out.print("Enter a value to be inserted: ");
                    data = input.nextInt();
                    obj1.add(data);
                    System.out.println(data + " inserted\n");

                case 2:
                    if(obj1.root == null)
                        System.out.println("Nothing to show!");
                    else
                        obj1.treeStructure(obj1.root, "", true);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter the data to find: ");
                    data = input.nextInt();
                    if(obj1.search(data))
                        System.out.println("Element found\n");
                    else
                        System.out.println("Not Found!");
                    break;

                case 4:
                    System.out.print("Enter the data to be deleted: ");
                    data = input.nextInt();
                    obj1.delete(data);
                    break;

                default:
                    System.out.println("\nInvalid Choice");
                    break;
            }
        }
        input.close();
    }
}


/* OUTPUT
1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice:
1
Enter the data to be inserted: 20
20 inserted

R----20

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice:
1
Enter the data to be inserted: 90
90 inserted

R----90
  L----20

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice:
1
Enter the data to be inserted: 5
5 inserted

R----5
  R----20
    R----90

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice:
4
Enter the data to be deleted: 5
5 deleted

1 - Insert
2 - Display
3 - Search
4  -Delete
5 - Exit
Enter your Choice:
2
R----20
  R----90

 */
