import java.util.Arrays;
import java.util.List;

public class MaxLenghtOne {
    public static void main(String[] args) {
//        int[] inputs = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
        int[] inputs = { 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1,1,0 };

        solutionOne(inputs);
//        countZerosIndex(inputs);
    }

    private static void solutionOne(int[] inputs) {
        countZerosIndex(inputs);
    }

    private static void countZerosIndex(int[] inputs) {
        int indexOfZero = inputs.length-1;
        List currentOutput = null;
        List previousOutput = List.of(0,0);
        while (indexOfZero != 0){
            if(inputs[indexOfZero] == 0) {
                currentOutput = replaceZero(inputs, 0, indexOfZero);
                if((Integer)previousOutput.get(0) < (Integer)currentOutput.get(0)){
                    previousOutput = currentOutput;
                } else if (previousOutput.get(0) == currentOutput.get(0) && (Integer)previousOutput.get(1) < (Integer)currentOutput.get(1)) {
                    previousOutput = currentOutput;
                }
            }
            indexOfZero--;
        }
        System.out.println(previousOutput.get(1));
    }


    private static List replaceZero(int[] inputs, Integer startIndex, int maxIndexOfZero) {
        int[] tempInput = inputs;
        int previousResult = countContinuousOne(inputs);
        int currentResult;
        startIndex = findOne(inputs,startIndex);
        if (startIndex == null)
            return List.of(previousResult,maxIndexOfZero, inputs);
        tempInput[startIndex] = tempInput[startIndex] + tempInput[maxIndexOfZero];
        tempInput[maxIndexOfZero] = tempInput[startIndex] - tempInput[maxIndexOfZero];
        tempInput[startIndex] = tempInput[startIndex] - tempInput[maxIndexOfZero];
        currentResult = countContinuousOne(tempInput);
        if(previousResult > currentResult)
            return List.of(previousResult,maxIndexOfZero, inputs);
        return List.of(currentResult,maxIndexOfZero, tempInput);
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
