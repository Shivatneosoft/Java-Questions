import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodMaximumProfit {

    public static List<List<Integer>> combinationRespectToRodLenght = new ArrayList<>();

    public static void main(String[] args) {
        int[] lenght = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> price = List.of(1, 5, 8, 9, 10, 17, 17, 20);
        int rodLenght = 4;
        int previousMaxPrice = 0;
        int maxPrice = 0;

        int indexOfRodLenght = 0;
        for (int i = 0; i < lenght.length; i++) {
            repeatedCombination(lenght,lenght.length,i+1,rodLenght);
            if(lenght[indexOfRodLenght] == rodLenght)
                break;
            indexOfRodLenght++;
        }
        for (List<Integer> combine: combinationRespectToRodLenght) {
            for (Integer lenghtValue: combine) {
                    previousMaxPrice = previousMaxPrice + findPrice(lenght,price,lenghtValue);
            }
            if (previousMaxPrice > maxPrice) {
                maxPrice = previousMaxPrice;
            }
            previousMaxPrice = 0;
        }
        System.out.println(maxPrice);
    }

    private static Integer findPrice(int[] lenght,List<Integer> price, Integer lenghtValue) {
        int i;
        for ( i = 0; i < lenght.length; i++) {
            if(lenght[i] == lenghtValue)
                break;
        }
        return price.get(i);
    }

    private static void repeatedCombination(int[] input, int n, int resultLenght, int rodlenght) {

        int[] result = new int[resultLenght+1];
        combination(result,0,input,resultLenght,0, rodlenght);

    }

    private static void combination(int[] result, int index, int[] input, int resultLenght, int start, int rodLenght) {

        if(index == resultLenght){
            int sum = Arrays.stream(result).sum();
            if(sum == rodLenght) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < resultLenght; i++) {
                    temp.add(result[i]);
                }
               combinationRespectToRodLenght.add(temp);
            }
            return;
        }

        for (int i = start; i < input.length; i++) {
            result[index] = input[i];
            combination(result,index+1,input,resultLenght,i,rodLenght);
        }
    }



}
