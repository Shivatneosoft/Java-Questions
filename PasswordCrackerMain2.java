import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class PasswordCrackerMain2

{

    public static void main(String[] args)
    {
        ForkJoinPool fjp = ForkJoinPool.commonPool();
        List<GFG> gfgs = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            GFG gfg = new GFG("",i);
            gfgs.add(gfg);
        }
        fjp.invokeAll(gfgs);
    }

}
