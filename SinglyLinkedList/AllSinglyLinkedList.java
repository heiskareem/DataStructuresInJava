class AllSinglyLinkedList{
    public static Node head;

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = next;
        }
    }

    public static void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void insertEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public static void insertInSorted(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        }
        Node current = head;
        Node temp = null;
        while(current != null && current.data < value){
            temp = current;
            current = current.next;
        }
        temp.next = newNode;
        newNode.next = current;
    }

    public static void reverse(){
        Node current = head;
        Node previous = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public static void length(){
        Node current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        System.out.println("The length of the list is = "+count);
    }

    public static void find(int key){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        Node current = head;
        int count = 0;
        while(current != null){
            if(current.data == key){
                System.out.println(key + " is found at index = " + count);
                break;
            }
            current = current.next;
            count++;
        }
        if(current == null){
            System.out.println("The list is empty");
        }
    }

    public static void findMiddle(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("The middle element is = "+slowPtr.data);
    }

    public static void findFromLast(int n){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        if(n <= 0){
            System.out.println("Invalid");
            return;
        }
        int count = 0;
        Node refPtr = head;
        while(count < n){
            if(refPtr == null){
                System.out.println("Invalid");
                return;
            }
            refPtr = refPtr.next;
            count++;
        }
        Node mainPtr = head;
        while(refPtr != null){
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        System.out.println("The Nth node from the last is = "+ mainPtr.data);
    }

    public static void findLoop(){
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                System.out.println("Loop exist in list");
                return;
            }
        }
        System.out.println("List is safe");
    }

    public static void delete(int key){
        Node current = head;
        Node temp = null;
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

    public static void createListForSorted(){
        //creates a example of insertInSorted() method 1--> 3 --> 4
        Node one = new Node(1);
        Node three = new Node(3);
        Node four = new Node(4);

        one.next = three;
        three.next = four;

        head = one;
    }

    public static void createListForFindLoop(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = three;

        head = one;
    }

    public static void display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(current);
    }

    public static void main(String args[]){
        Node first = new Node(1);
        Node secound = new Node(2);
        Node thrid = new Node(3);

        head = first;
        first.next = secound;
        secound.next = thrid;

        insertFirst(4);
        insertFirst(5);

        insertEnd(6);
        insertEnd(7);

        display();

        reverse();
        display();

        length();
        
        find(5);
        find(2);
        find(7);

        findMiddle();

        findFromLast(2);
        findFromLast(7);
        findFromLast(8);

        display();
        delete(7);
        display();
        delete(2);
        display();
        delete(5);
        display();

        //this will create a sample list and display and insert a element in a list then display
        createListForSorted();
        display();
        insertInSorted(2);
        display();

        //this will create a list to test the loop 
        //findLoop() will test the list for loop in the list
        createListForFindLoop();
        findLoop();
        createListForSorted();
        findLoop();
    }
}