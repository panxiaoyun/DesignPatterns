package leslie.com.designpatterns.decorator;

import android.util.Log;

/**
 * Created by Leslie on 2018/9/6.
 */

public class DetailComponent extends Component {

    private static final String TAG = "DetailComponent";
    @Override
    public void giveFlower() {
        Log.i(TAG,"detail give flower");
    }
}
