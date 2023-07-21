import java.util.Arrays;

public class Combination {
    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int n= input.length;
        int rodlenght = 4;
        for (int i = 0; i < 4; i++) {
            repeatedCombination(input,n,i+1, rodlenght);
        }
    }

    private static void repeatedCombination(int[] input, int n, int resultLenght, int rodlenght) {

        int[] result = new int[resultLenght+1];
        combination(result,0,input,resultLenght,0, rodlenght);

    }

    private static void combination(int[] result, int index, int[] input, int resultLenght, int start, int rodLenght) {

        if(index == resultLenght){
            int sum = Arrays.stream(result).sum();
            if(sum == rodLenght) {
                System.out.print("{ ");
                for (int i = 0; i < resultLenght; i++) {
                    System.out.print(result[i] + " ");
                }
                System.out.println("}");
            }
            return;
        }

        for (int i = start; i < input.length; i++) {
            result[index] = input[i];
            combination(result,index+1,input,resultLenght,i,rodLenght);
        }
    }
}
