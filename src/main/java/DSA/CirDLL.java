package DSA;

public class CirDLL {
    DNode tail;

    public boolean isEmpty() {
        return tail == null;
    }

    public boolean isOne() {
        return tail != null && tail == tail.next;
    }

    public void addFirst(int e) {
        DNode n = new DNode(e);
        if (isEmpty()) {
            n.next = n;
            n.prev = n;
            tail = n;
        }
        else {
            n.next = tail.next;
            n.prev = tail;
            tail.next.prev = n;
            tail.next = n;
        }
    }

    public void addLast(int e) {
        DNode n = new DNode(e);
        if (isEmpty()) {
            n.next = n;
            n.prev = n;
        }
        else {
            n.next = tail.next;
            n.prev = tail;
            tail.next.prev = n;
            tail.next = n;
        }
        tail = n;
    }

    public void addIn(int x, int e) {
        if (isEmpty()) {
            System.out.println("CirDLL is empty");
            return;
        }

        DNode current = tail.next;
        do {
            if (current.data == x) {
                break;
            }
            current = current.next;
        }
        while (current != tail.next);

        if (current.data != x) {
            System.out.println("element "+x+" was not found!");
            return;
        }

        DNode n = new DNode(e);
        n.next = current.next;
        n.prev = current;
        current.next.prev = n;
        current.next = n;

        if (current == tail) {
            tail = n;
        }
    }

    public void delFirst() {
        if (isEmpty()) {
            System.out.println("DLL is empty!");
            return;
        }
        if (isOne()) {
            tail = null;
            return;
        }

        DNode first = tail.next;
        tail.next = first.next;
        tail.next.prev = tail;
    }

    public void delLast() {
        if (isEmpty()) {
            System.out.println("DLL is empty!");
            return;
        }
        if (isOne()) {
            tail = null;
            return;
        }

        DNode first = tail.next;
        tail = tail.prev;
        tail.next = first;
        first.prev = tail;
    }

    public void delIn(int x) {
        DNode current = tail.next;
        do {
            if (current.data == x) {
                break;
            }
            current = current.next;
        }
        while (current != tail.next);

        if (current.data != x) {
            System.out.println("element "+x+" was not found!");
            return;
        }
        if (current == tail.next) {
            delFirst();
            return;
        }
        if (current == tail) {
            delLast();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
}
