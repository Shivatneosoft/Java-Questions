public class SymmetricPair {
    public static void main(String[] args) {
        int[][] inputs = {{3, 4}, {1, 2}, {5, 2}, {7, 10}, {4, 3}, {2, 5}};
        solutionUsingTwoForLoop(inputs);
    }

    private static void solutionUsingTwoForLoop(int[][] inputs) {
        for (int i = 0; i < inputs.length; i++)
            for (int j = i; j < inputs.length; j++)
                if(inputs[i][1] == inputs[j][0] && inputs[j][1] == inputs[i][0])
                    printOutput(inputs[i][1],inputs[i][0]);
    }

    private static void printOutput(int valueOne, int valueTwo) {
        System.out.println("{ " + valueTwo + "," + valueOne + " } | { " + valueOne + "," + valueTwo + " }");
    }
}
