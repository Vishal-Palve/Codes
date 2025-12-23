package OOPs.Inheritance;

public class BoxPrice extends BoxWeight {
    double cost;


    BoxPrice(double l, double h, double w, double weight , double price) {
        super(l, h, w, weight);
        fun();
        this.cost = price;
    }

    BoxPrice(){
        super();
        this.cost = -1;

    }
    BoxPrice(BoxPrice other){
        super(other);
        this.cost = other.cost;
    }

}

