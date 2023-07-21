import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<Integer> input = List.of(1,3,5,7);
        int sumOf = 8;
        usingRecursion(input,sumOf);
    }

    private static void usingRecursion(List<Integer> input, int sumOf) {
        for (int i = 0; i < 2; i++) {
            List<Integer> output = new ArrayList<>();
            List<List<Integer>> combination = combination(input, output, 0, i + 1, sumOf);
            System.out.println(combination);
        }
    }

    private static List<List<Integer>> combination(List<Integer> input, List<Integer> output,int insertIndexOfOutput, int length,int sumOf) {
//        System.out.println(length == insertIndexOfOutput);
        if(length == insertIndexOfOutput){
            int sum = sumCount(output);
            if(sum == sumOf){
                System.out.println(output);
                Collections.sort(output);
                return List.of(output);
            }
            return null;
        }

        List<List<Integer>> combinationList = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            try {
                output.set(insertIndexOfOutput,input.get(i));
            }
            catch (IndexOutOfBoundsException exception){
                output.add(input.get(i));
            }
            System.out.println("replace " + insertIndexOfOutput +" " +output);
            List<List<Integer>> tempCombination = combination(input, output, insertIndexOfOutput + 1, length, sumOf);
            if(tempCombination != null)
                if(!tempCombination.isEmpty())
                    for (List<Integer> element: tempCombination)
                        if(!combinationList.contains(element))
                            combinationList.add(element);
        }
        System.out.println(combinationList);
        return combinationList;
    }

    private static int sumCount(List<Integer> output) {
        int sum = 0;
        for (Integer element:output) {
            sum = sum + element;
        }
        return sum;
    }
}
