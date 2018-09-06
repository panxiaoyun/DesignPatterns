package leslie.com.designpatterns;

import org.junit.Test;

import leslie.com.designpatterns.adapter.ObjectAdapter.Adaptee;
import leslie.com.designpatterns.adapter.ObjectAdapter.Adapter;

/**
 * Created by Leslie on 2018/9/4.
 */

public class AdapterTest {

    @Test
    public void test1(){
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.eat();
        adapter.drink();
    }
}
