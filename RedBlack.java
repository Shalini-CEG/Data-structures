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

    Node getParent(Node node) {
        return node == null ? null : node.parent;
    }

    Node getGrandParent(Node node) {
        return getParent(getParent(node));
    }

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

    public void inOrder(Node root)
    {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}

public class RedBlack {
    public static void main(String[] args) {
        RBMethods obj1 = new RBMethods();
        System.out.println("RED BLACK TREE - INORDER TRAVERSAL");
        obj1.insert(12);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(5);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(15);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(3);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(10);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(13);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(17);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(4);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(7);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(11);
        obj1.inOrder(obj1.root);
        System.out.println();


        obj1.insert(14);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(6);
        obj1.inOrder(obj1.root);
        System.out.println();

        obj1.insert(8);
        obj1.inOrder(obj1.root);
        System.out.println();

    }
}