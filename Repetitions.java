import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Repetitions {
    public static void main(String[] args) {
        String input = "ATTCGGGA";

        System.out.println(solution(input));

    }

    private static String solution(String input) {

        ArrayList<String> element = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            String s = String.valueOf(input.charAt(i));

            if(!element.contains(s)){
                element.add(s);
                count.add(1);
            }

            else{
                int index = element.indexOf(s);
                Integer value = count.get(index);
                count.remove(index);
                count.add(index,value+1);
            }

        }
        System.out.println(Collections.max(count));



        return "Done";
    }
}
