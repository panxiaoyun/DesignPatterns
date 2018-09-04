package leslie.com.designpatterns.proxy;

import android.util.Log;

/**
 * 真实对象，追求者
 * Created by Leslie on 2018/9/2.
 */

public class RealPursuit implements GiveGiftInterface {
    private final static String TAG = "RealPursuit";

    private SchoolGirl mGirl;

    public RealPursuit(SchoolGirl girl){
        this.mGirl = girl;
    }
    @Override
    public void giveFlower() {
        Log.i(TAG,"real pursuit give flower to " + mGirl.mName);
    }

    @Override
    public void giveChocolate() {
        Log.i(TAG,"real pursuit give chocolate to " + mGirl.mName);
    }
}
