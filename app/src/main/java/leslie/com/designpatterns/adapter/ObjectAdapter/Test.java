package leslie.com.designpatterns.adapter.ObjectAdapter;

import leslie.com.designpatterns.decorator.ComponentA;
import leslie.com.designpatterns.decorator.ComponentB;
import leslie.com.designpatterns.decorator.DetailComponent;

/**
 * Created by Leslie on 2018/9/6.
 */

public class Test {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.eat();
        adapter.drink();
    }
}
