public class WeirdAlgorithm {

    public static void main(String[] args) {
        int input = 3;
        System.out.println(solution(input));
    }

    private static String solution(int i) {

        while(i!=1){
            if(i%2 == 0){
                i = i / 2;
            }
            else {
                i = i * 3 + 1;
            }
            System.out.println(i);
        }

        return "Done";
    }

}
