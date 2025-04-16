public class TwoStacks {
    int size;
    int top1, top2;
    int[] arr;

    TwoStacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = n;
    }

    void push1(int x) {
        if (top1 + 1 < top2) {
            arr[++top1] = x;
        }
    }

    void push2(int x) {
        if (top1 + 1 < top2) {
            arr[--top2] = x;
        }
    }

    int pop1() {
        return top1 >= 0 ? arr[top1--] : -1;
    }

    int pop2() {
        return top2 < size ? arr[top2++] : -1;
    }
}
/*
Time Complexity: O(1)
Space Complexity: O(n)
*/