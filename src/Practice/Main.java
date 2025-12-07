package Practice;

public class Main {
    public static void main(String[] args) {
            int[] nums = {2,4,88,9,45,96,1};
            int max = 0;
            for(int num : nums){
                if(num > max){
                    max = num;
                }
            }
        System.out.println(max);
    }

    public static void printDiamond(int n) {
        // Upper half (including middle)
        for (int i = 0; i < n; i++) {
            // Print spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int i = n - 2; i >= 0; i--) {
            // Print spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
