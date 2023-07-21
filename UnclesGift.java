import java.util.Arrays;

public class UnclesGift {
    public static void main(String[] args) {
//        int[][] inputs = {{1, 1}, {2, 3}, {3, 4}, {4, 5}, {5, 5},{6,3},{7,3},{8,1},{9,1},{10,4}};
//        int[][] inputs = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 5},{6,3},{7,3},{8,1},{9,1},{10,4}};
//        int[][] inputs = {{1,3},{2,3},{2,2},{4,1},{5,3}};

        int[][] inputs = {{1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,5},
                {6,2},
                {7,3},
                {8,3},
                {9,1},
                {10,4}};

        System.out.println(forLoopSolution(inputs,0));

    }

    private static Integer forLoopSolution(int[][] inputs, int maximumGiftCount) {
        if (inputs.length == 0)
            return 0;
        int unclesCurrentSaving = 0;
        int subArrayMaximumGiftCount = 0;

        // running for loop to fetch each element
        for (int i = 0; i < inputs.length; i++) {
            //incrementing Uncle's Current Salary
            if(i != 0)
                unclesCurrentSaving = unclesCurrentSaving + (inputs[i][0] - inputs[i-1][0]);
            else
                unclesCurrentSaving = inputs[i][0];

            //increase Count if uncle's Current Saving is greater or equal to the current gift price
            if(unclesCurrentSaving >= inputs[i][1]) {
//                System.out.println(unclesCurrentSaving + " unclesCurrentSaving \n" + inputs[i][0] + " inputs[i][0]\n" + inputs[i][1] + " inputs[i][1]\n");
                maximumGiftCount++;
                unclesCurrentSaving = unclesCurrentSaving - inputs[i][1];
                if(maximumGiftCount == 1){
                    subArrayMaximumGiftCount = forLoopSolution(Arrays.copyOfRange(inputs,i+1,inputs.length),0);
                }
            }
        }
//        System.out.println((maximumGiftCount > subArrayMaximumGiftCount) + " " + maximumGiftCount + " " + subArrayMaximumGiftCount);
        return maximumGiftCount > subArrayMaximumGiftCount? maximumGiftCount : subArrayMaximumGiftCount;
    }
}