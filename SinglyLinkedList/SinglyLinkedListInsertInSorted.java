class SinglyLinkedListInsertInSorted{
    
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

    public ListNode insertInSortedList(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        while(current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public static void main(String args[]){
        SinglyLinkedListInsertInSorted sll = new SinglyLinkedListInsertInSorted();

        sll.insertFirst(16);
        sll.insertFirst(11);
        sll.insertFirst(8);
        sll.insertFirst(1);
        
        sll.display();

        //insert a node in sorted list
        sll.insertInSortedList(11);
        sll.display();
    }
}