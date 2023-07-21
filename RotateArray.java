import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class RotateArray{
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int cases = 1;
        while(cases != 0){
            int size = sc.nextInt();
            int shift = sc.nextInt();
            int[] input = new int[size];
            int[] output  = new int[size];
            int lenght = size;
            int count = 0;
            while(count != size){
                input[count] = sc.nextInt();
                count++;
            }
            int index =0;
            int position = lenght - shift < 0 ? lenght - (shift % lenght)  : lenght - shift;
            for(int ele: input){
                System.out.print(ele + " ");
            }
            System.out.println("Position :: " + position);
            for (int i = position; i < lenght-1; i++) {
                output[index] = input[i];
                index ++;
            }
            System.out.println("Done");
            for (int i = 0; i < position; i++) {
                output[index] = input[i];
                index ++;
            }
            System.out.println(index);
            for(int ele: output){
                System.out.print(ele + " ");
            }
            System.out.print("Complete Test Case " + cases );
            cases -- ;
        }

    }
}
