import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(ThreeSumSolution(nums));
        ThreeSumSolution1(nums);
    }

    private static void ThreeSumSolution1(int[] nums) {
        int i=0;
        List<List<Integer>> output = new ArrayList<>();
        while (i != nums.length-2){
            int j=i+1;
            while (j != nums.length-1){
                int k=j+1;
                while (k != nums.length){
                    List<Integer> tempOutput = new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k] == 0){
                        if(nums[i] < nums[j] && nums[i] < nums[k]){
                            tempOutput.add(nums[i]);
                            if(nums[k] > nums[j])
                                tempOutput.add(nums[j]);
                            else
                                tempOutput.add(nums[k]);
                        }
                        else if(nums[j] < nums[k] && nums[j] < nums[i]){
                            tempOutput.add(nums[j]);
                            if(nums[k] > nums[i])
                                tempOutput.add(nums[i]);
                            else
                                tempOutput.add(nums[k]);
                        }
                        else if(nums[k] < nums[j] && nums[k] < nums[i]){
                            tempOutput.add(nums[k]);
                            if(nums[i] > nums[j])
                                tempOutput.add(nums[j]);
                            else
                                tempOutput.add(nums[i]);
                        }
                        output.add(tempOutput);
                    }
                    k++;
                }
                j++;
            }
            i++;
        }
        System.out.println(output);
    }

    private static String ThreeSumSolution(int[] nums) {
        System.out.println("Starting ThreeSumSolution");
        List<List<Integer>> output = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    List<Integer> tempOutput = new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k] == 0){
                        tempOutput.addAll(List.of(nums[i],nums[j],nums[k]));
                        Collections.sort(tempOutput);
                        if(!output.contains(tempOutput)){
                            output.add(tempOutput);
                        }
                        System.out.println(tempOutput);
                    }
                }
            }
        }
        System.out.println(output);
        return "Done";
    }
}
