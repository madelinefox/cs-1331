


public class ArrayUtils {

    public static int reverseProduct(int[] a, int[] b) {
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * b[n - (i + 1)];
        }
        return sum;
    }

    public static void main(String [] args) {
        int[] c = {3, 7, 10, 2};
        int[] d = {1, 4, 9, 5};
        System.out.println(reverseProduct(c, d));
    }
}