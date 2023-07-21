import java.util.Collections;
import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        int input = 5;
        List<Integer> inputs = List.of(2, 3, 1, 5);
        System.out.println(solution(input,inputs));
    }

    private static String solution(int input, List<Integer> inputs) {

        Integer number = Collections.min(inputs);
        for (Integer element: inputs) {
            if(inputs.contains(number)){
                number = number + 1;
            }
            else {
                System.out.println(number + " is missing");
            }
        }

        return "Done";
    }
}
