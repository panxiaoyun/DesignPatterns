package leslie.com.designpatterns.adapter.ObjectAdapter;

import android.util.Log;

/**
 * Created by Leslie on 2018/9/4.
 */

public class Adapter implements Target {
    private static final String TAG = "Adapter";
    Adaptee mAdaptee;

    public Adapter(Adaptee adaptee){
        this.mAdaptee = adaptee;
    }
    @Override
    public void eat() {
        mAdaptee.eat();
    }

    @Override
    public void drink() {
        Log.i(TAG,"drink beer");
    }
}
