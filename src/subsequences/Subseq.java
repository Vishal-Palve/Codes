package subsequences;

import javax.security.auth.login.AccountExpiredException;
import java.util.ArrayList;

public class Subseq {
    public static void main(String[] args) {
        suseq("", "abc");

        String str = "abcdefghijklmn";
        System.out.println(str.substring(6).startsWith("ghi"));
    }

    static void suseq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        suseq(p + ch, up.substring(1));
        suseq(p , up.substring(1));
    }

    static ArrayList<String> suseq2(String p, String up){
        if(up.isEmpty()){
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
           return list;
        }
        char ch = up.charAt(0);
       ArrayList<String> left = suseq2(p + ch, up.substring(1));
        ArrayList<String> right = suseq2(p , up.substring(1));
        left.addAll(right);
        return left;
    }
}
