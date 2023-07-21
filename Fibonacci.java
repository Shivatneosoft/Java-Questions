import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Fibonacci {
    public static Long fibonacci(int n){
        List<Long> dp = new ArrayList<>();
        dp.add(0L);
        dp.add(1L);

        for(int i = 2; i<n+1;i++){
            dp.add(dp.get(i-1)+dp.get(i-2));
        }

        return dp.get(n);

    }
    public static void main(String[] args) {
        System.out.println(fibonacci(100));
    }
}
