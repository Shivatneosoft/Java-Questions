import java.util.Arrays;

public class Sort2SortedArray {
    public static void main(String[] args) {
//        int[] x = { 0, 2, 0, 3, 0, 5, 6, 0, 0 };
//        int[] y = { 1, 8, 9, 10, 15 };
//        int x[] = {0,6,7,0,0,0,0,8,9};
//        int y[] = {1,2,3,4,5};
        int[] x = {0, 5, 0, 7, 0, 9, 0, 15};
        int[] y = {1, 2, 3, 4};

//        simpleSolution(x,y);
        solutionwith3rdArray(x,y);
    }
    private static void solutionwith3rdArray(int[] x, int[] y) {
        int[] output = new int[x.length];
        int xPointer = 0;
        int yPointer = 0;
        int outputPointer = 0;
        while(!(x.length == xPointer && yPointer == y.length)){
            if(y.length > yPointer){
                if(x.length > xPointer){
                    if(x[xPointer] != 0){
                        if(x[xPointer] < y[yPointer]){
                            output[outputPointer] = x[xPointer];
                            xPointer++;
                            outputPointer++;
                        }
                        else{
                            output[outputPointer] = y[yPointer];
                            yPointer++;
                            outputPointer++;
                        }
                    }
                    else {
                        xPointer++;
                    }
                }
                else {
                    output[outputPointer] = y[yPointer];
                    yPointer++;
                    outputPointer++;
                }
            }
            else {
                if(x[xPointer] != 0){
                    output[outputPointer] = x[xPointer];
                    xPointer++;
                    outputPointer++;
                }
                else {
                    xPointer ++;
                }
            }
        }
        System.out.println(Arrays.toString(output));
    }

    private static void simpleSolution(int[] x, int[] y) {
        int xPointer = 0;
        int yPointer = 0;
        int assignPointer = 0;

        while (true){
            if (yPointer == y.length && xPointer == x.length) {
                break;
            } else if (xPointer == x.length) {
                x[assignPointer] = y[yPointer];
                assignPointer++;
                yPointer++;
            } else if(x[xPointer]!= 0){
                if(x[xPointer] < y[yPointer]){
                    x[assignPointer] = x[xPointer];
                    assignPointer++;
                    xPointer++;
                }
                else {
                    x[assignPointer] = y[yPointer];
                    assignPointer++;
                    yPointer++;
                }
            } else  if(x[xPointer]== 0){
                xPointer++;
            }
        }
        System.out.println(Arrays.toString(x));
    }
}
