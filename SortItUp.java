public class SortItUp {
    public static void main(String[] args) {
        int[] inputs = {2,0,0,1,2};
        int start = 0, end = inputs.length-1, current = 0;
        int temp = 0;
        while (current <= end){
            if (inputs[current] != 0){
                temp = inputs[end];
                inputs[end] = inputs[current];
                inputs[current] = temp;
                end --;
            }
            if(inputs[current] == 0){
                current++;
            }
        }
        for (int ele: inputs) {
            System.out.print(ele);
        }
        System.out.println();
    }
}
