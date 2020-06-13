class SinglyLinkedListDeleteNode{
    
    private ListNode head;

    private static class ListNode{
        private int data; //Generic Type
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void deleteNode(int key){
        ListNode current = head;
        ListNode temp = null;
        if(current != null && current.data == key){
            head = current.next;
            return;
        }
        while(current != null && current.data != key){
            temp = current;
            current = current.next;
        }
        if(current == null){
            return;
        }
        temp.next = current.next;
    }

    public static void main(String args[]){
        SinglyLinkedListDeleteNode sll = new SinglyLinkedListDeleteNode();

        sll.insertFirst(16);
        sll.insertFirst(11);
        sll.insertFirst(8);
        sll.insertFirst(1);
        
        sll.display();

        //to delete a particular node
        sll.deleteNode(11);
        sll.display();
    }
}