import java.util.Arrays;

public class DifferenceBetweenTwoNumber {
    public static void main(String[] args) {
        int[] input =  { 9, 2, 7, 9, 5, 1, 3, 5 };
        using2For(input);
        findThroughRecurssion(input);
    }

    private static void findThroughRecurssion(int[] input) {
        System.out.println(findmax(input));
    }

    private static Integer findmax(int[] input) {
        if(input.length < 2)
            return null;
        int indexOfMax = indexOfMaxInArray(input);
        if(indexOfMax == 0)
            return findmax(Arrays.copyOfRange(input, 1,input.length));
        Integer diff = diff(Arrays.copyOfRange(input, 0, indexOfMax+1));
        Integer findmax = findmax(Arrays.copyOfRange(input, indexOfMax+1,input.length));
        if (findmax == null)
            return diff;
        if(findmax > diff)
            return findmax;
        return diff;
    }

    private static int indexOfMaxInArray(int[] input){
        int max = 0;
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] > max)  {
                max = input[i];
                index = i;
            }
        }
        return index;
    }

    private static Integer diff(int[] input) {
        int min = input[0];
        for (int i = 0; i < input.length; i++) {
            if(input[i] < min)  {
                min = input[i];
            }
        }
        return input[input.length-1] - min;
    }

    private static void using2For(int[] input) {
        int maxDifference = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i+1; j < input.length; j++) {
                if(input[i] < input[j]){
                    int diff = input[j] - input[i];
                    if(diff > maxDifference)
                        maxDifference = diff;
                }
            }
        }
        System.out.println(maxDifference);
    }
}
