


public class writeBinary {

    public static void writeBinary(int n, int count) {
        if (count < 6) {
            writeBinary(n/2, count+1);
            System.out.print(n % 2);
        }
    }

    public static void writeBinary(int n) {
        writeBinary(n, 0);
        System.out.println();
    }

    public static void main(String[] args) {
        writeBinary(0);
        writeBinary(44);
    }
}
