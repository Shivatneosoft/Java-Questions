import java.util.Arrays;
import java.util.List;

public class MaxLenghtOneLargestIndexOfZero {
    public static void main(String[] args) {
        int[] inputs = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };

        solutionOne(inputs);
    }

    private static void solutionOne(int[] inputs) {
        countZerosIndex(inputs,inputs.length-1);
    }

    private static void countZerosIndex(int[] inputs, int endIndex) {
        List previousResultList = List.of(0,0);
        List currentResultList;
        for (int i = endIndex-1; i >= 0; i--) {
            if (inputs[i] == 0) {
                currentResultList = replaceZero(inputs, 0, i);
                if ((Integer) previousResultList.get(0) < (Integer) currentResultList.get(0))
                    previousResultList = currentResultList;
            }
        }
        System.out.println(previousResultList.get(0));
        System.out.println(previousResultList.get(1));
        System.out.println(Arrays.toString((int[]) previousResultList.get(2)));
    }


    private static List replaceZero(int[] inputs, Integer startIndex, int maxIndexOfZero) {
        int[] tempInput = inputs;
        int previousResult = countContinuousOne(inputs);
        int currentResult;
        startIndex = findOne(inputs,startIndex);
        if (startIndex == null)
            return List.of(previousResult,maxIndexOfZero,inputs);
        tempInput[startIndex] = tempInput[startIndex] + tempInput[maxIndexOfZero];
        tempInput[maxIndexOfZero] = tempInput[startIndex] - tempInput[maxIndexOfZero];
        tempInput[startIndex] = tempInput[startIndex] - tempInput[maxIndexOfZero];
        currentResult = countContinuousOne(tempInput);
//        if(maxIndexOfZero == 7){
//            System.out.println("currentResult " + currentResult + " tempInputs" + Arrays.toString(tempInput));
//            System.out.println("previousResult " + previousResult + " Inputs" + Arrays.toString(inputs));
//        }
        if(previousResult > currentResult)
            return List.of(previousResult,maxIndexOfZero,inputs);
        return List.of(currentResult,maxIndexOfZero,tempInput);
    }

    private static Integer findOne(int[] inputs,int startIndex) {
        for (int i = startIndex; i < inputs.length; i++) {
            if(inputs[i] == 1)
                return i;
        }
        return null;
    }

    private static int countContinuousOne(int[] inputs) {
        int continuousCount = 0;
        int previousContinuousCount = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == 1)
                continuousCount ++;
            else if(inputs[i] == 0 & previousContinuousCount < continuousCount){
                previousContinuousCount = continuousCount;
                continuousCount = 0;
            }
        }
        if(previousContinuousCount < continuousCount)
            return continuousCount;
        return previousContinuousCount;
    }
}
