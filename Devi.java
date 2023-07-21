import java.util.*;

public class Devi {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 1, 1, 0, 1, 1 ));
        Map<Integer, Integer> indexCount = new HashMap<Integer, Integer>();

        for(int i=0; i<list.size(); i++) {
            int count =0;
            if(list.get(i) == 0 )
                continue;
            else {
                int j = i;
                while(list.get(j) !=1) {
                    count++;
                    j++;
                }
                indexCount.put(i, count);
                i=j;
            }
        }

        Set<Integer> keys = indexCount.keySet();

        Integer max=0;
        int length1s = 0;
        for(Integer key : keys) {
            Integer newKey = key+indexCount.get(key)+1;
            if(indexCount.containsKey(newKey)) {
                length1s = indexCount.get(key)+indexCount.get(newKey)+1;
                if(max<length1s)
                    max=length1s;
            }
        }

        System.out.println("Max length of 1 = "+ length1s);
    }
}
