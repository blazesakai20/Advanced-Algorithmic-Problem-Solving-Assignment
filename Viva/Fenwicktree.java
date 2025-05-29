public class Fenwicktree {
    private int[] tree;
    private int size;
    public Fenwicktree(int n) {
        size = n;
        tree = new int[n + 1];
    }

    public void update(int i, int delta) {
        i++; 
        while (i <= size) {
            tree[i] += delta;
            i += (i & -i);
        }
    }

    public int query(int i) {
        i++; 
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int rangeQuery(int l, int r) {
        return query(r) - query(l - 1);
    }

    public void printTree() {
        for (int i = 1; i <= size; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; 
        Fenwicktree ft = new Fenwicktree(arr.length);

        for (int i = 0; i < arr.length; i++) {
            ft.update(i, arr[i]);
        }

        System.out.println("Prefix sum up to index 3: " + ft.query(3));
        System.out.println("Sum from index 1 to 4: " + ft.rangeQuery(1, 4)); 

        ft.update(2, 5);

        System.out.println("After update, prefix sum up to index 3: " + ft.query(3)); 
        System.out.println("After update, sum from index 2 to 4: " + ft.rangeQuery(2, 4));
    }
}
