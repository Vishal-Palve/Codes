package OOPs.exceptionHandling;

public class Demo {
    public static void main(String[] args) {

        int i = 0;
        int j = 12;


        int nums[] = new int[5];

   try {
       System.out.println(nums[2]);
       System.out.println(nums[5]);
   } catch (Exception a){
       System.out.println("exception " + a);
   }
        try {
            j = 18/i;

        } catch (ArithmeticException e) {

             System.out.println("Something went wrong " + e);
        }

        System.out.println(j);
        System.out.println("Byeee");
    }
}
