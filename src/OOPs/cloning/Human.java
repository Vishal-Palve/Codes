package OOPs.cloning;

public class Human implements Cloneable {
    private int age ;
    private String name;
    private int[] arr;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
