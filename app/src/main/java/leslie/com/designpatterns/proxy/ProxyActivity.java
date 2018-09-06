package leslie.com.designpatterns.proxy;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import leslie.com.designpatterns.R;
import leslie.com.designpatterns.adapter.ObjectAdapter.Adaptee;
import leslie.com.designpatterns.adapter.ObjectAdapter.Adapter;
import leslie.com.designpatterns.decorator.ComponentA;
import leslie.com.designpatterns.decorator.ComponentB;
import leslie.com.designpatterns.decorator.DetailComponent;

/**
 * Created by Leslie on 2018/9/6.
 */

public class ProxyActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);
        findViewById(R.id.btn_xu_proxy).setOnClickListener(this);
        findViewById(R.id.btn_dynamic_proxy).setOnClickListener(this);
        findViewById(R.id.btn_adapter).setOnClickListener(this);
        findViewById(R.id.btn_decorator).setOnClickListener(this);
        findViewById(R.id.btn_notify).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_dynamic_proxy){
            //动态代理
            testDynamic();
        }else if(id == R.id.btn_xu_proxy){
            // 虚拟代理
            test1();
        }else if (id == R.id.btn_decorator){
            // 装饰者模式
            testDecorator();
        }else if(id == R.id.btn_adapter){
            // 适配器模式
            testAdapter();
        }else if(id == R.id.btn_notify){
            testNotify();
        }
    }

    private void testNotify(){
        Intent intent= new Intent();
        Notification build = new NotificationCompat.Builder(this)
                .setContentTitle( "测试通知")
                .setContentText( "测试通知内容")
                .setAutoCancel( true)
                .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT))
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(( int) (System.currentTimeMillis()/ 1000L), build);
    }


    public void test1(){
        SchoolGirl girl = new SchoolGirl();
        girl.mName = "leslie";
        GiveGiftInterface giveGift = new ProxyPursuit(girl);
        giveGift.giveChocolate();
        giveGift.giveFlower();
    }

    public void testDynamic(){
        SchoolGirl girl = new SchoolGirl();
        girl.mName = "Dudu";
        RealPursuit realPursuit = new RealPursuit(girl);
        // 创建一个动态代理
        DynamicProxy dynamicProxy = new DynamicProxy();
        // 把真实追求者和动态代理关联起来
        GiveGiftInterface giftInterface = dynamicProxy.getProxyInterface(realPursuit);
        // 调用代理过的接口
        giftInterface.giveFlower();
        giftInterface.giveChocolate();
    }

    private void testDecorator(){
        DetailComponent c = new DetailComponent();
        ComponentA a = new ComponentA(c);
        ComponentB b = new ComponentB(c);
        b.giveFlower();
        c.giveFlower();

    }

    public void testAdapter(){
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.eat();
        adapter.drink();
    }


}
