package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length() ; i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            permutations(f + ch + s,up.substring(1));
        }
    }


    static List<String> permutationsArr(String p, String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> hh = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length() ; i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            List<String> recAns = permutationsArr(f + ch + s, up.substring(1));
            hh.addAll(recAns);
        }
        return hh;
    }
    public static void main(String[] args) {

        System.out.println( permutationsArr("", "abdc"));
    }
}
