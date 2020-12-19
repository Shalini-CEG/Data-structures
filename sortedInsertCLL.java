class sortedInsertCLL
{
	public static Node sortedInsert(Node head,int data)
         {
            Node newNode = new Node(data);
            Node current = head;
            
            if(current == null){
                newNode.next = newNode;
                head = newNode;
            }
            
            else if(current.data >= newNode.data){
                while(current.next != head){
                    current = current.next;
                }
                newNode.next = head;
                current.next = newNode;
                head = newNode;
            }
            
            else{
                while(current.next != head && current.next.data < newNode.data){
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            return head;
         }
}
