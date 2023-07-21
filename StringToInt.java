import java.util.ArrayList;
import java.util.List;

public class StringToInt {
    public static int convertStrToInteger(String str) throws Exception {
        int res = 0 , i = 1 , len = str.length();
        while(i < len){
            int dig = str.charAt(i) - '0';
            if(dig > 9)throw new Exception("Only digit are allowed");
            res = res * 10 + dig;
            i++;
        }
        if(str.charAt(0) == '-'){
            res = -1 * res;
        }
        return res;
    }
    public static void main(String[] args) throws Exception {
        String numberString = "10";
        System.out.println(convertStrToInteger(numberString));;
    }
}
