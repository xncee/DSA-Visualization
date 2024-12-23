package DSA;

public class DLL {
    DNode head = null;
    DNode tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isOne() {
        return head == tail;
    }

    public void addFirst(int e) {
        DNode n = new DNode(e);
        if (isEmpty()) {
            head = n;
            tail = n;
        }
        else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    public void addLast(int e) {
        DNode n = new DNode(e);
        if (isEmpty()) {
            head = n;
            tail = n;
            return;
        }

        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    public void addIn(int x, int e) {
        DNode current = head;
        while (current != null && current.data != x) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("element "+x+" was not found!");
            return;
        }
        if (current == tail) {
            addLast(e);
            return;
        }

        DNode n = new DNode(e);
        n.next = current.next;
        n.prev = current;
        current.next.prev = n;
        current.next = n;
    }

    public void delFirst() {
        if (isEmpty()) {
            System.out.println("DLL is empty!");
        }
        else if (isOne()) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
    }

    public void delLast() {
        if (isEmpty()) {
            System.out.println("DLL is empty!");
        }
        else if (tail == head) {
            head = null; tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void delIn(int x) {
        DNode current = head;
        while (current != null && current.data != x) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("element "+x+" was not found!");
            return;
        }

        if (current == head) {
            delFirst();
            return;
        }
        if (current == tail) {
            delLast();
            return;
        }

        // Delete in the middle
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
}
