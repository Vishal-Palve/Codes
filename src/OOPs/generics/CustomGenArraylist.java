package OOPs.generics;

public class CustomGenArraylist<T> {

    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

//    public CustomGenArraylist() {
//        this.data = new T[DEFAULT_SIZE];
//    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add( T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        return (int) data[index];
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty list");
        }
        return (T)(data[--size]);
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void set(int index, T num ){
        data[index] =  num;
    }
}
