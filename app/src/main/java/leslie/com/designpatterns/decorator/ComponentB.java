package leslie.com.designpatterns.decorator;

import android.util.Log;

/**
 * Created by Leslie on 2018/9/6.
 */

public class ComponentB extends DecoratorComponent {
    private static final String TAG = "ComponentB";
    public ComponentB(Component component){
        this.mComponent = component;
    }

    @Override
    public void giveFlower() {
        super.giveFlower();
        Log.e(TAG,"装饰B添加的功能");
    }
}
