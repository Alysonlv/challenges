package corp.alv.challenges.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyNode<T> {

    private T val;
    private MyNode<T> next;
    private MyNode<T> prev;

    public MyNode(T val) {
        this.val = val;
    }

    public MyNode(T val, MyNode<T> next, MyNode<T> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
