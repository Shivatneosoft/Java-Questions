import java.util.Arrays;

public class Sorting012 {

    public static int[] input = { 0, 1, 2, 1 };

    public static void main(String[] args) throws InterruptedException {

        int start = 0;
        int end = input.length-1;
        int frontPointer = 0;
        int rearPointer = input.length-1;

        while (true) {
            if (input[frontPointer] == 0)
                frontPointer++;
            else if (input[end] == 0){
                swap(frontPointer, end);
                frontPointer++;
                end--;
            }
            else {
                end --;
            }
            if(input[rearPointer] == 2)
                rearPointer--;
            else if (input[start] == 2){
                swap(rearPointer, start);
                rearPointer--;
                start++;
            }
            else {
                start++;
            }
            if (start >= rearPointer && end <= frontPointer ) {
                System.out.println(Arrays.toString(input));
                break;
            }
        }
    }

    public static void swap(int first, int second){
        input[first] = input[second] + input[first];
        input[second] = input[first] - input[second];
        input[first] = input[first] - input[second];
    };
}
