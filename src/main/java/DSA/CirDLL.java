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
        if (!isEmpty())
            tail.next = n;
        else
            tail = n;

        n.prev = tail;
    }

    public void addLast(int e) {
        DNode n = new DNode(e);
        if (!isEmpty()) {
            n.prev = tail;
            n.next = tail.next;
            tail.next.prev = n;
            tail.next = n;
        }
        else {
            n.next = n;
            n.prev = n;
        }

        tail = n;
    }

    public void addIn(int x, int e) {
        if (isEmpty()) {
            System.out.println("CirDLL is empty");
            return;
        }

        DNode n = new DNode(e);
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
        n.next = current.next;
        n.prev = current;
        if (current == tail) {
            tail.next.prev = n;
            tail = n;
        }
        current.next = n;
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
