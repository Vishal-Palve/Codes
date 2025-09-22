package OOPs.Inheritance;

public class BoxWeight extends Box {
     double weight = -1;

  void fun(){
     System.out.println("yeah i am running");
 }
   BoxWeight(double l, double h, double w, double weight) {

       super(l, h, w);
        this.weight = weight;
    }

     BoxWeight(Box old) {
        super(old);
        this.weight = weight;
    }
    BoxWeight(){
      super();
      this.weight = -1;
    }
}
