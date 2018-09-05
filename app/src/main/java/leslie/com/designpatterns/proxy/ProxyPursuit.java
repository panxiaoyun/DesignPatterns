package leslie.com.designpatterns.proxy;

import android.util.Log;

/**
 * 静态代理对象
 * Created by Leslie on 2018/9/2.
 */

public class ProxyPursuit implements GiveGiftInterface {

    private final static String TAG = "ProxyPursuit";
    private RealPursuit mRealPursuit;

    public ProxyPursuit(SchoolGirl girl){
        if(mRealPursuit == null){
            mRealPursuit = new RealPursuit(girl);
        }
    }
    @Override
    public void giveFlower() {
        Log.i(TAG,"ProxyPursuit say you are so beautiful");
        mRealPursuit.giveFlower();
        Log.i(TAG,"ProxyPursuit say you are so cute");
    }

    @Override
    public void giveChocolate() {
        mRealPursuit.giveChocolate();
    }
}
