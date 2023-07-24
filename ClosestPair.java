import java.util.ArrayList;
import java.util.List;

public class ClosestPair {
    public static void main(String[] args) {
        int[] first =  { 10, 12, 15, 18, 20 };
        int[] second = { 1, 4, 6, 8 };
        int target = 22;
        System.out.println(solutionUsingThreeLoops(first, second, target));
    }

    private static List<Integer> solutionUsingThreeLoops(int[] first, int[] second, int target) {
        List<Integer> output = new ArrayList<>();

        while (output.isEmpty()){
            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < second.length; j++) {
                    if (first[i] + second[j] == target) {
                        output.addAll(List.of(first[i], second[j]));
                        return output;
                    }
                }
            }
            if(target != 0)
                target --;
        }
        return null;
    }
}
