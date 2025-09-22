package subsequences;

public class Apple {
    public static void main(String[] args) {
        System.out.println(removeIfExists("ajbjsapplefrff"));
    }
    public static String remove(String str){
        if(str.isEmpty()){
            return "";
        }
        if(str.startsWith("apple")){
            return remove(str.substring(5));
        }
        return str.charAt(0) + remove(str.substring(1) );
    }
    public static String removeIfExists(String str){
        if(str.isEmpty()){
            return "";
        }
        if(str.startsWith("app") && !str.startsWith("apple")){
            return remove(str.substring(3));
        }
        return str.charAt(0) + remove(str.substring(1) );
    }
}
