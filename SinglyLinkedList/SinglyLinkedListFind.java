class SinglyLinkedListFind{
    
    //private static ListNode head;

    private static class ListNode{
        private int data; //Generic Type
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void display(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static boolean find(ListNode head, int searchKey){
        if(head == null){
            return false;
        }
        ListNode current = head;
        while(current != null){
            if(current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String args[]){
        
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        //Now we will connect them together to form a chain
        head.next = second; // 10 --> 1
        second.next = third; // 10 --> 1 --> 8
        third.next = fourth; //10 --> 1 --> 8 --> 11 --> null

        display(head);
       
        SinglyLinkedListFind sll = new SinglyLinkedListFind();

        if(sll.find(head, 111)){
            System.out.println("Search Key found !!!");
        }else{
            System.out.println("Search Key not found !!!");
        }
    }
}