package TCS.ArrayQues;

public class UniqueElement {

    public static void main(String[] args){
        int[] nums = {5 ,3 ,2 ,3 ,2};
        int un = 0;
        for(int num : nums){
            un = un ^ num;
        }
        System.out.println(un);
    }
}
