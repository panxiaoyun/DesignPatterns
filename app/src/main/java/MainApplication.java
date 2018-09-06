import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import leslie.com.designpatterns.proxy.NotifictionProxy;
import leslie.com.designpatterns.proxy.ProxyActivity;

/**
 * Created by Leslie on 2018/9/6.
 */

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        hookNotificationManager(this);
        Intent intent = new Intent();
        intent.setClass(this, ProxyActivity.class);
        startActivity(intent);
    }

    public static void hookNotificationManager(Context context) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            // 获取隐藏的方法
            Method method = notificationManager.getClass().getDeclaredMethod("getService");
            method.setAccessible(true);
            //获取代理对象
            final Object sService = method.invoke(notificationManager);
            Log.d("[app]", "sService=" + sService);
            Class<?> INotificationManagerClazz = Class.forName("android.app.INotificationManager");
            Object proxy = Proxy.newProxyInstance(INotificationManagerClazz.getClassLoader(), new Class[]{INotificationManagerClazz}, new NotifictionProxy(sService));
            //获取原来的对象
            Field mServiceField = notificationManager.getClass().getDeclaredField("sService");
            mServiceField.setAccessible(true);
            //替换
            mServiceField.set(notificationManager, proxy);
            Log.d("[app]", "Hook NoticeManager成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
