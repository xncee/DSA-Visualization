package DSA;

public class DLL {
    DNode head = null;
    DNode tail = head;

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isOne() {
        return head == tail;
    }

    public void addFirst(int e) {
        DNode n = new DNode(e);
        n.next = head;
        if (!isEmpty())
            head.prev = n;
        head = n;

        if (tail == null)
            tail = n;
    }

    public void addLast(int e) {
        DNode n = new DNode(e);
        if (!isEmpty())
            tail.next = n;
        n.prev = tail;

        tail = n;
    }

    public void addIn(int x, int e) {
        DNode n = new DNode(e);
        DNode current = head;
        while (current != null && current.data != x) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("element "+x+" was not found!");
            return;
        }
        n.next = current.next;
        n.prev = current;
        current.next = n;

        if (current == tail)
            tail = n;
    }

    public void delFirst() {
        if (isEmpty()) {
            System.out.println("DLL is empty!");
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
            head = head.next;
            head.prev = null;
            return;
        }
        if (current == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        DNode prev = current.prev;
        DNode next = current.next;
        prev.next = next;
        next.prev = prev;
    }
}
