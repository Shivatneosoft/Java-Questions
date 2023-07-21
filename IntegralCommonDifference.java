import java.util.ArrayList;
import java.util.List;

public class IntegralCommonDifference {
    public static void main(String[] args) {
        List<Integer> input = List.of( 1, 3, 5, 6, 8, 9, 15 );
        solutionUsingTwoForLoop(input);
    }

    private static void solutionUsingTwoForLoop(List<Integer> input) {
        List<List<Integer>> output = new ArrayList<>();
        int subtractValue = 0;
        for (int i = 0; i < input.size()-2; i++) {
            for (int j = i+1; j < input.size()-1; j++) {
                int indexOfThirdElement = input.indexOf((input.get(j) - input.get(i))+ input.get(j));
                if(indexOfThirdElement != -1){
                    output.add(List.of(input.get(i),input.get(j),input.get(indexOfThirdElement)));
                }
            }
        }
        System.out.println(output);
    }
}
