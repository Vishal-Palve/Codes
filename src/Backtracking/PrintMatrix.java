package Backtracking;

import java.util.Arrays;

public class PrintMatrix {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] arr = new int[maze.length][maze[0].length];
        pathstep("", maze,arr,0, 0, 1);
    }
    static void pathstep(String p,boolean[][] maze, int[][] arr, int r, int c, int step){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            arr[r][c]= step;
            for(int[] n : arr){
                System.out. println(Arrays.toString(n));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {

            return;
        }
        maze[r][c] = false;
            arr[r][c] = step;
        if(r > 0){
            pathstep(p + 'U', maze, arr , r-1, c, step +1);
        }
        if(c > 0){
            pathstep(p + 'L', maze, arr, r, c-1, step+1);
        }
        if(c < arr[0].length-1){
            pathstep(p + 'R', maze, arr, r, c+1, step+1);
        }
        if(r < arr.length-1){
            pathstep(p + 'D', maze, arr, r+1, c, step+1);
        }
        maze[r][c] = true;
        arr[r][c] =0;
    }
}
