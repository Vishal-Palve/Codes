public class LInearSearch {

    public static void main(String[] args){
        int [] arr = {2  , 4, 9 , 3, 90 , 44 , 98};
        linear(arr , 4);

    }
    static void linear(int[] arr , int target ){
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i] == target){
                System.out.println(i);
            }


        }
        System.out.println(" -1 ");
    }

}
