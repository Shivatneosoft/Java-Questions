import java.util.*;

public class SumEquals0 {

    private static Set<List<Integer>> outputforCombination = new HashSet<>();
    public static void main(String[] args) {
        String s = "Ankit";
        s.toLowerCase();
        int[] input ={ -2,-2,2,2 };
        twoForloopSolution(input);
        for (int i = 0; i < input.length; i++) {
            sumZero(i,i,0,input);
        }
        recursionCombinationSolution(input);
    }

    private static void recursionCombinationSolution(int[] input) {
        for (int i = 0; i <input.length; i++) {
            sumZeroCombination(i,input,0,new ArrayList<>());
        }
        for (List<Integer> outputs: outputforCombination) {
            System.out.println(outputs);
        }
    }

    private static void sumZeroCombination(int currentIndex, int[] input, int currentSum, List<Integer> output) {
        currentSum = currentSum + input[currentIndex];
        output.add(input[currentIndex]);
        if(currentSum == 0) {
//            System.out.println(output);
            Collections.sort(output);
            outputforCombination.add(output);
        }
        if(currentIndex == input.length-1) {
            return;
        }
        for (int i = currentIndex+1; i < input.length; i++) {
            sumZeroCombination(i,input,currentSum,new ArrayList<>(output));
        }
    }

    private static void twoForloopSolution(int[] input) {
        Integer sum;
        for (int i = 0; i < input.length; i++) {
            sum = 0;
            for (int j = i; j < input.length; j++) {
                sum = sum + input[j];
                if(sum == 0){
                    for (int k = i; k < j+1; k++) {
                        System.out.print(input[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static void sumZero(int start, int pointing,int currentSum, int[] nonZeroList) {
        currentSum = currentSum + nonZeroList[pointing];
        if (currentSum == 0) {
            for (int i = start; i < pointing+1; i++) {
                System.out.print(nonZeroList[i] + " ");
            }
            System.out.println();
            if (pointing == nonZeroList.length-1)
                return ;
            sumZero(start,pointing+1,currentSum,nonZeroList);
        }
        else if (pointing == nonZeroList.length-1)
            return ;
        else
            sumZero(start,pointing+1,currentSum,nonZeroList);
    }
}
