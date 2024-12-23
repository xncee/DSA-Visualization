package DSA;

public class SLL {
    SLLNode head;

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int e) {
        // create new node.
        // connect the new node (n) to the head.
        SLLNode n = new SLLNode(e);
        n.next = head; // [n] -> head -> [node1] -> ... -> null
        head = n; // head -> [n]

        // result: head -> [n] -> [node1] -> ... -> null
    }

    public void delFirst() {
        // ensure the list isn't empty.
        // move the head pointer to the next node.
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return; // terminate code
        }
        head = head.next;
        /*
         [node1] -> [node2] -> null
                       ^
                       |
                      head
        */
        // result: head -> [node2] -> null
    }

    public void addLast(int e) {
        // create new node.
        SLLNode n = new SLLNode(e);
        // if the list is empty, assign head to new node.
        if (isEmpty()) {
            head = n; // head -> n -> null
        }
        // if not, iterate through the list until you find the node that points to null (last node).
        else {
            SLLNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            // connect last node (current) with the new node.
            current.next = n; // [current] -> n
        }
    }

    public void delLast() {
        // ensure the list isn't empty.
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return; // terminate code
        }
        // if the list contains only one node, assign head to null.
        if (head.next == null) {
            head = null;
            return; // terminate code
        }

        // if the list contains more than one element:
        // iterate through the list until current.next.next == null.
        // ex: head -> [A] -> [B] -> null
        SLLNode current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        // assign current.next to null to delete the next node.
        current.next = null; // [A] - > null

        // result: head -> [A] -> null
    }

    public void addIn(int i, int e) {
        SLLNode n = new SLLNode(e);

        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return; // terminate code.
        }

        // iterate through the list until current.data==i or current==null (element was not found).
        SLLNode current = head;

        while (current != null) {
            if (current.data == i) {
                break;
            }
            current = current.next;
        }

        // if 'i' is found:
        if (current != null) {
            // link n to current.next.
            // connect current to n.
            n.next = current.next; // [n] -> [current.next]
            current.next = n; // [current] -> [n]

            // result: [current] -> [n] -> [current.next]
        }
        else {
            System.out.println("element "+i+" was not found!");
        }
    }

    public void delIn(int e) {
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return; // terminate code
        }

        // iterate through the list until current.data==e or current==null (element was bot found).
        SLLNode prev = null; // pointer1
        SLLNode current = head; // pointer2

        while (current != null) {
            if (current.data == e) {
                break;
            }

            prev = current; // move pointer1 one step to right.
            current = current.next; // move pointer2 one step to right.
        }

        // if element is found:
        if (current != null) {
            // [prev] -> [current] -> [current.next]
            // connect 'prev' to current.next to remove 'current'.
            if (prev != null) {
                prev.next = current.next; // [prev] -> [current.next]
            }
            else {
                // element was found at the beginning, therefore prev==null
                // delFirst.
                delFirst();
            }
        }
        else {
            System.out.println("element "+e+" was not found!");
        }
    }

    public void sort() {
        // selection sort algorithm (google it)
        // the smallest element is brought to left in each iteration of the outer loop.
        SLLNode n1 = head;
        while (n1 != null) {
            SLLNode n2 = n1.next;
            while (n2 != null) {
                if (n2.data < n1.data) {
                    int temp = n1.data;
                    n1.data = n2.data;
                    n2.data = temp;
                }
                n2 = n2.next;
            }
            n1 = n1.next;
        }
    }

    public void insert(int e) {
        SLLNode n = new SLLNode(e);
        if (isEmpty()) {
            head = n;
            return;
        }

        // search:
        SLLNode prev = null;
        SLLNode current = head;

        while (current != null) {
            if (current.data > e) {
                break;
            }
            prev = current;
            current = current.next;
        }
        // insert:
        // if a greater element is found:
        // connect prev to n.
        // connect n to current.
        // [n] -> null
        // [prev] -> [current]
        if (current != null) {
            if (prev != null) {
                prev.next = n; // [prev] -> [n]
                n.next = current; // [n] -> [current]

                // result: [prev] -> [n] -> [current]
            }
            // if prev is null, then the greater element was found at the beginning.s
            else {
                n.next = head;
                head = n;
                //addFirst(e);
            }
        }
        else {
            addLast(e);
        }
    }

    public void display() {
        SLLNode n = head;
        System.out.print("head -> ");

        while (n != null) {
            System.out.print("["+n.data+"] -> ");
            n = n.next;
        }
        System.out.println("null");
    }
}

