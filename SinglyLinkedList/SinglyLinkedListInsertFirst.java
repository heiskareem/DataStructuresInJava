class SinglyLinkedListInsertFirst{
    
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

    public static void main(String args[]){
        SinglyLinkedListInsertFirst sll = new SinglyLinkedListInsertFirst();

        sll.insertFirst(11);
        sll.insertFirst(8);
        sll.insertFirst(1);
        
        sll.display();
    }
}