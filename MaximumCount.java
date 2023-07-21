import java.util.*;

public class MaximumCount {
    public static void main(String[] args) {
        int[] input = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
        simpleSolution(input);
    }
    private static void simpleSolution(int[] input) {
        int[] output;
        Map<Integer, Integer> countElement = new HashMap<>();
        int maxCount = 0;
        int value = 0;
        for (Integer element : input)
            countElement.put(element, countElement.containsKey(element) ? countElement.get(element) + 1 : 1);
        for (Map.Entry<Integer, Integer> entry : countElement.entrySet())
            if (maxCount < entry.getValue()){
                maxCount = entry.getValue();
                value = entry.getKey();
            }
        output= new int[maxCount];
        Arrays.fill(output,value);
        System.out.println(Arrays.toString(output));
    }
}
