import java.util.Arrays;

public class EqualValueForSubArrayElement {
    public static void main(String[] args) {
        int[] inputs = { 0, 0, 1, 0, 1, 0, 0 };
        int[] output = null;
        int oneCount;
        int zeroCount;
        int lenght = 0;

        for (int i = 0; i < inputs.length-1; i++) {
            oneCount = 0;
            zeroCount = 0;
            for (int j = i; j < inputs.length; j++) {
                if(inputs[j] == 1)
                    oneCount++;
                else
                    zeroCount++;
                if (oneCount == zeroCount && lenght < j-i){
                    lenght = j -i ;
                    output = Arrays.copyOfRange(inputs,i,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
