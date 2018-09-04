package leslie.com.designpatterns.proxy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Leslie on 2018/9/2.
 */

public class ProxyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SchoolGirl girl = new SchoolGirl();
        girl.mName = "LeiLei";
        ProxyPursuit pursuit = new ProxyPursuit(girl);
        pursuit.giveChocolate();
        pursuit.giveFlower();
    }
}
