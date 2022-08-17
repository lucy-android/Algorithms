package divide.et.conquera.multiply;

public class Main {

    public static void main(String[] args) {
        System.out.println(multiply(121, 123));
        System.out.println(121 * 123);
    }

    public static int multiply(int x, int y) {
        if (x == 2) return y + y;
        if (y == 0) {
            return 0;
        } else if (y == 1) {
            return x;
        } else {
            int z = multiply(x, y / 2);
            if (y % 2 == 0) {
                return multiply(2, z);
            } else {
                return x + multiply(2, z);
            }
        }
    }
}
