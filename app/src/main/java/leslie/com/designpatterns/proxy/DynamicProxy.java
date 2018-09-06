package leslie.com.designpatterns.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 优点：可以在不修改原来代码的基础上，就在原来代码的基础上做操作，这就是AOP即面向切面编程
 * 缺点：它只能针对接口生成代理，不能只针对某一个类生成代理
 * Created by Leslie on 2018/9/2.
 */

public class DynamicProxy implements InvocationHandler {
    private static final String TAG = "DynamicProxy";

    // 被代理的对象
    private GiveGiftInterface mGiveGiftInterface = null;

    /**
     * 获取绑定好代理和真实追求者后的追求者接口
     * @param realPursuit 真实追求者
     * @return 绑定好代理和真实追求者后的追求者接口
     */
    public GiveGiftInterface getProxyInterface(RealPursuit realPursuit){
        // 设置被代理的对象，方便invoke里面执行
        this.mGiveGiftInterface = realPursuit;
        // 把真实追求者和动态代理关联起来
        GiveGiftInterface giftInterface = (GiveGiftInterface) Proxy.newProxyInstance(realPursuit.getClass().getClassLoader(),realPursuit.getClass().getInterfaces(),this);
        return giftInterface;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       if(method.getName().equals("giveFlower")){
           Log.i(TAG,"flower is rose");
           return method.invoke(mGiveGiftInterface,args);
       }
       return method.invoke(mGiveGiftInterface,args);
    }

    public static void main(String[] args){
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
}
