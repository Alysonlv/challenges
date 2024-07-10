package corp.alv.challenges.domain;

public class MyLinkedListNode<T> {
    // First on the list
    private MyNode<T> head;
    // Last on the list
    private MyNode<T> tail;
    private MyNode<T> next;
    private MyNode<T> prev;
    private long size;

    public MyLinkedListNode() {
        this.size = 0;
    }

    public MyNode<T> addLast(T val) {
        if (tail == null) {
            this.head = new MyNode<>(val);
            this.tail = head;
        } else {
            MyNode prev = this.tail;
            prev.setNext(new MyNode<>(val));
            this.tail = prev.getNext();
            this.tail.setPrev(prev);
        }
        this.size++;
        return tail;
    }

    public MyNode<T> addFirst(T val) {
        if (this.head == null) {
            this.head = new MyNode(val);
            return head;
        }

        MyNode<T> newTail = new MyNode<>(val);
        newTail.setNext(this.head);
        this.head.setPrev(newTail);
        this.head = newTail;
        this.size++;

        return this.head;
    }

    public MyNode<T> removeLast() {
        if (size == 0) {
            return null;
        }

        MyNode<T> last = this.tail;
        this.tail.getPrev().setNext(null);
        this.tail = this.tail.getPrev();
        this.size--;

        return last;
    }

    public MyNode<T> peekLast() {
        return this.tail;
    }

    public MyNode<T> removeFirst() {
        if (size == 0) {
            return null;
        }
        MyNode<T> first = this.head.getNext();
        first.setPrev(null);
        this.head = first;
        this.size--;
        return this.head;
    }

    public MyNode<T> peekFirst() {
        return this.head;
    }

    public boolean contains(T val) {
        MyNode<T> curr = this.tail;
        while (curr != null) {
            if (val.equals(curr.getVal())) {
                return true;
            }
            curr = curr.getNext();
        }

        return false;
    }

    public static void main(String[] args) {
        MyLinkedListNode<Integer> md = new MyLinkedListNode<>();
        md.addLast(0);
        md.addLast(2);
        md.addLast(4);
        md.addLast(6);
        System.out.println("md.contains(6) = " + md.contains(6));
        System.out.println("md.contains(65) = " + md.contains(65));
        md.addFirst(-1);

        MyNode<Integer> last = md.removeLast();
        System.out.println("hi " + last.getVal());

        System.out.println("First = " + md.peekFirst().getVal());
        MyNode<Integer> first = md.removeFirst();
        System.out.println("First Now = " + md.peekFirst().getVal());
    }

}
