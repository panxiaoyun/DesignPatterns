package leslie.com.designpatterns.proxy;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Leslie on 2018/9/6.
 */

public class NotifictionProxy implements InvocationHandler {
    private Object mObject;

    public NotifictionProxy(Object mObject) {
        this.mObject = mObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.d("[app]", "方法为:" + method.getName());

        /**
         * 做一些业务上的判断
         * 这里以发送通知为准,发送通知最终的调用了enqueueNotificationWithTag
         */
        if (method.getName().equals("enqueueNotificationWithTag")) {
            //具体的逻辑
            for (int i = 0; i < args.length; i++) {
                if (args[i] != null) {
                    Log.d("[app]", "参数为:" + args[i].toString());
                }
            }
            //做些其他事情，然后替换参数之类
            return method.invoke(mObject, args);
        }
        return null;

    }


}
