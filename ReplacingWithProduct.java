import java.util.Scanner;

public class ReplacingWithProduct {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] output = new int[size];
        int[] arr = new int[size];
        for (int i = 0; i <size; i++) {
            arr[i] = sc.nextInt();
        }
        int product = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i!=j) {
                    product = product * arr[j];
                }
            }
            output[i] = product;
            product = 1;
            System.out.println(output[i] + " ");
        }
    }
}
