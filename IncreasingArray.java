public class IncreasingArray {
    public static void main(String[] args) {
        int[] inputs = {3,2,5,1,7};
        System.out.println(solution(inputs));
    }

    public static String solution(int[] inputs){
        int temp = 0;
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i]);
        };
        for (int i = 1; i <inputs.length; i++) {
            if (inputs[i] < inputs[i-1]){
                temp = inputs[i];
                inputs[i] = inputs[i+1];
                inputs[i+1] = temp;
            }
        }
        System.out.println();
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i]);
        }
        System.out.println();
        return "Done";
    }
}
