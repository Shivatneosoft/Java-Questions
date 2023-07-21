import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class TwoSum {

    static Logger logger = Logger.getLogger("TwoSum");

    public static void main(String[] args) {
        int[] input = {5, 7, 2, 8, 3, 1};
        int target = 10;

//        logger.info(getSolutionwithForLoop(input,target));
//        getSolutionwithPointer(input,target);
        logger.info(getSolutionFromSubstraction(input,target));
    }

    private static void getSolutionwithPointer(int[] input, int target) {
        int start = 0;
        int end = input.length-1;
        while(true){
            if(input[start] + input[end] == target) {
                logger.info(input[start] + "," + input[end]);
//                end --;
                break;
            }
            else if(start == input.length-2){
                logger.info("Pair not found");
                break;
            }
            else if(start+1 == end){
                start++;
                end = input.length-1;
            }
            else {
                end --;
            }
        }
    }

    private static String getSolutionwithForLoop(int[] input, int target) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < input.length-1; i++) {
            for (int j = i+1; j < input.length; j++) {
                if(input[i]+input[j] == target){
                    output.add(input[i]);
                    output.add(input[j]);
                    break;
                }
            }
        }
        return outputprinting(output);
    }
    
    private static String getSolutionFromSubstraction(int[] input, int target){
        ArrayList<Integer> inputList = new ArrayList<>();
        Arrays.stream(input).forEach(data-> inputList.add(data));
        int value = 0;
        for (int i = 0; i < input.length; i++) {
            value = target - input[i];
            if(inputList.contains(value) && value != input[i])
                return ( value + ", " + input[i]);
        }
        return "No Pair found";
    };

    private static String outputprinting(List<Integer> output) {
        if(output.size() == 0)
            return "Pair not found";
        return "Pair found (" + output.get(0) + "," + output.get(1) + ")";
    }
}
