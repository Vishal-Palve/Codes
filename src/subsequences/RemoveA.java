package subsequences;

public class RemoveA {
    public static void main(String[] args) {
        String a = "sbsvaanaajfna";
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != 'a'){
                b.append(a.charAt(i));
            }
        }
        System.out.println(b);

        System.out.println(removeA("Sndkaaanaiaanuviruaa",""));
    }

    public static String removeA(String og, String up){
        if(og.isEmpty()){
            return up;
        }
        if(og.charAt(0) == 'a'){
            return removeA(og.substring(1),up);
        }
        return removeA(og.substring(1), up + og.charAt(0) );
    }
}
