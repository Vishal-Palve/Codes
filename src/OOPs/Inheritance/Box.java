package OOPs.Inheritance;

public class Box {
    double l = -1;
    double h = -1;
    double w = -1;

    Box(double l, double h, double w){
        this.l = l  ;
        this.h = h;
        this.w = w;
    }

    Box(Box old){
        this.l  = old.l;
        this.h = old.h;
        this.w = old.w;

    }

    Box() {
        this.l = l;
        this.h = h;
        this.w = w;

    }
}
