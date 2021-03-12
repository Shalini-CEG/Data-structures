class Node(object):
    def __init__(self, val):
        self.val = val
        self.right = None
        self.left = None
        self.height = 1

class AvlMethods(object):
    def insert(self, root, data): 
      
        if not root: 
            return Node(data) 
        elif data < root.val: 
            root.left = self.insert(root.left, data) 
        else: 
            root.right = self.insert(root.right, data) 
  
        # Update the height  
        
        root.height = 1 + max(self.getHeight(root.left), 
                           self.getHeight(root.right)) 
  
        #  Get the balance factor 
        balance = self.getBalance(root) 
  
       
        
        #Left Left 
        if balance > 1 and data < root.left.val:
            print("Left-Left Rotation")
            return self.rightRotate(root) 
  
        #Right Right 
        if balance < -1 and data > root.right.val:
            print("Right-Right Rotation")
            return self.leftRotate(root) 
  
        #Left Right 
        if balance > 1 and data > root.left.val:
            print("Left-Right Rotation")
            root.left = self.leftRotate(root.left) 
            return self.rightRotate(root) 
  
        #Right Left 
        if balance < -1 and data < root.right.val:
            print("Right-Left Rotation")
            root.right = self.rightRotate(root.right) 
            return self.leftRotate(root) 
  
        return root

    def delete(self, root, data): 
  
        if not root: 
            return root 
  
        elif data < root.val: 
            root.left = self.delete(root.left, data) 
  
        elif data > root.val: 
            root.right = self.delete(root.right, data) 
  
        else:
            if root.left is None and root.right is None:
                return None
            if root.left is None: 
                return root.right 
  
            elif root.right is None: 
                return root.left
  
            root.val = minNode(root.right) 
            root.right = self.delete(root.right, root.val)
               
         
        root.height = 1 + max(self.getHeight(root.left), self.getHeight(root.right)) 
  
            #balance factor 
        balance = self.getBalance(root) 
      
            
            # Left Left 
        if balance > 1 and self.getBalance(root.left) >= 0:
            print("Left-Left Rotation")
            return self.rightRotate(root) 
      
            # Right Right 
        if balance < -1 and self.getBalance(root.right) <= 0:
            print("Right-Right Rotation")
            return self.leftRotate(root) 
      
            #  Left Right 
        if balance > 1 and self.getBalance(root.left) < 0:
            print("Left-Right Rotation")
            root.left = self.leftRotate(root.left) 
            return self.rightRotate(root) 
      
            # Right Left 
        if balance < -1 and self.getBalance(root.right) > 0:
                print("Right-Left Rotation")
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

    def minNode(self, root): 
        if root is None or root.left is None: 
            return root 
  
        return self.minNode(root.left)
    
  
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
print("Resultant tree after insertion: ")
avl.display(root, "", True) 
root = avl.delete(root, 30) 

print("Resultant tree after deletion: ") 
avl.display(root, "", True) 
print()
