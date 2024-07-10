package corp.alv.challenges.general.stack.medium;

class MinStack {
    int minumum;
    MyNode stack;
    MyNode head;

    public MinStack() {
        this.minumum = Integer.MAX_VALUE;
        stack = new MyNode(0, null, null, minumum);
        head = stack;
    }

    public void push(int val) {
        int min = Math.min(val, head.myMin);
        MyNode node = new MyNode(val, head, null, min);
        head.next = node;
        head = node;
    }

    public void pop() {
        head = head.prev;
        head.next = null;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.myMin;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println("Min = " + ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        //[null,null,null,null,-3,null,0,-2]
        System.out.println("Min = " + ms.getMin());
    }

    class MyNode {
        int val;
        MyNode prev;
        MyNode next;
        int myMin;

        public MyNode(int val, MyNode prev, MyNode next, int myMin) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.myMin = myMin;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
