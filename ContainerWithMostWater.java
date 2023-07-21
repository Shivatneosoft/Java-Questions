import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] inputs = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(inputs));
    }

    private static String solution(int[] height) {
//        List<Integer> sortedHeight = height;
//        Collections.sort(sortedHeight);
//        Integer fixed = sortedHeight.get(height.size()-1);
//        Integer fixedIndex = height.indexOf(fixed)-1;
//        System.out.println(fixed);
//        System.out.println(fixedIndex);

//
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < height.size()-1; i++) {
//            for (int j = i+1; j < height.size(); j++) {
//                int calculate = (j - i) * ((height.get(i) < height.get(j)) ? height.get(i) : height.get(j)) ;
//                if(calculate > 0)
//                result.add(calculate);
//            }
//        }
//        System.out.println(Collections.max(result));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int calculate = (j - i) * (Math.min(height[i], height[j])) ;
                result.add(calculate);
            }
        }
//        System.out.println(result );
        System.out.println(Collections.max(result));



        return "Done";
    }

}
