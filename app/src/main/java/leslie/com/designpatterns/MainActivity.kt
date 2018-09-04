package leslie.com.designpatterns

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import leslie.com.designpatterns.proxy.ProxyPursuit
import leslie.com.designpatterns.proxy.SchoolGirl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val schoolGirl : SchoolGirl
        val pursuit : ProxyPursuit
    }
}
