class Node(object):
    def __init__(self, val):
        self.val = val
        self.right = None
        self.left = None
        self.height = 1

class AvlMethods(object):
    def insert(self, root, key): 
      
        #  BST 
        if not root: 
            return Node(key) 
        elif key < root.val: 
            root.left = self.insert(root.left, key) 
        else: 
            root.right = self.insert(root.right, key) 
  
        # Update the height  
        
        root.height = 1 + max(self.getHeight(root.left), 
                           self.getHeight(root.right)) 
  
        #  Get the balance factor 
        balance = self.getBalance(root) 
  
       
        
        #Left Left 
        if balance > 1 and key < root.left.val: 
            return self.rightRotate(root) 
  
        #Right Right 
        if balance < -1 and key > root.right.val: 
            return self.leftRotate(root) 
  
        #Left Right 
        if balance > 1 and key > root.left.val: 
            root.left = self.leftRotate(root.left) 
            return self.rightRotate(root) 
  
        #Right Left 
        if balance < -1 and key < root.right.val: 
            root.right = self.rightRotate(root.right) 
            return self.leftRotate(root) 
  
        return root 
  
    def leftRotate(self, z): 
  
        y = z.right 
        T2 = y.left 
  
        # Perform rotation 
        y.left = z 
        z.right = T2 
  
        # Update heights 
        z.height = 1 + max(self.getHeight(z.left), 
                         self.getHeight(z.right)) 
        y.height = 1 + max(self.getHeight(y.left), 
                         self.getHeight(y.right)) 
  
        
        return y 
  
    def rightRotate(self, z): 
  
        y = z.left 
        T3 = y.right 
  
        # Perform rotation 
        y.right = z 
        z.left = T3 
  
        # Update heights 
        z.height = 1 + max(self.getHeight(z.left), 
                        self.getHeight(z.right)) 
        y.height = 1 + max(self.getHeight(y.left), 
                        self.getHeight(y.right)) 
  
        # Return the new root 
        return y 
  
    def getHeight(self, root): 
        if not root: 
            return 0
  
        return root.height 
  
    def getBalance(self, root): 
        if not root: 
            return 0
  
        return self.getHeight(root.left) - self.getHeight(root.right) 
  
    def display(self, root, indent, last): 
  
       if root:
            print(indent)
            if(last):
                print("R-----")
                indent += "  "
            else:
                print("L-----")
                indent += "|  "

            print(root.val)
            avl.display(root.left, indent, False)
            avl.display(root.right, indent, True)
  

avl = AvlMethods() 
root = None
  
root = avl.insert(root, 10) 
root = avl.insert(root, 20) 
root = avl.insert(root, 30) 


  
 
print("Resultant tree: ") 
avl.display(root, "", True) 
print()
