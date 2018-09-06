package leslie.com.designpatterns.decorator;

import android.util.Log;

/**
 * Created by Leslie on 2018/9/6.
 */

public class ComponentA extends DecoratorComponent {
    private static final String TAG = "ComponentA";
    public ComponentA(Component component){
        this.mComponent = component;
    }

    @Override
    public void giveFlower() {
        super.giveFlower();
        Log.e(TAG,"装饰A添加的功能");
    }
}
