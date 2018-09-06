package leslie.com.designpatterns.decorator;

/**
 * Created by Leslie on 2018/9/6.
 */

public class Test {
    public static void main(String[] args) {
        DetailComponent c = new DetailComponent();
        ComponentA a = new ComponentA(c);
        ComponentB b = new ComponentB(c);
        b.giveFlower();
        c.giveFlower();
    }
}
