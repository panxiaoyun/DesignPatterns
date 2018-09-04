package leslie.com.designpatterns.adapter.ObjectAdapter;

import android.util.Log;

/**
 * 被适配
 * Created by Leslie on 2018/9/4.
 */

public class Adaptee {
    private static final String TAG = "Adaptee";
    public void eat() {
        Log.i(TAG,"eat 山珍海味");
    }
}
