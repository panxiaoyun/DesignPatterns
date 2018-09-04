package leslie.com.designpatterns;

import leslie.com.designpatterns.proxy.DynamicProxy;
import leslie.com.designpatterns.proxy.GiveGiftInterface;
import leslie.com.designpatterns.proxy.OtProxyPursuit;
import leslie.com.designpatterns.proxy.ProxyPursuit;
import leslie.com.designpatterns.proxy.RealPursuit;
import leslie.com.designpatterns.proxy.SchoolGirl;

/**
 * Created by Leslie on 2018/9/4.
 */

public class ProxyTest {

    public void test1(){
        SchoolGirl girl = new SchoolGirl();
        girl.mName = "leslie";
        GiveGiftInterface giveGift = new ProxyPursuit(girl);
        giveGift.giveChocolate();
        giveGift.giveFlower();
    }

    public void test2(){
        SchoolGirl girl = new SchoolGirl();
        girl.mName = "Leo";
        GiveGiftInterface realPursuit = new RealPursuit(girl);
        GiveGiftInterface giveGift = new OtProxyPursuit(realPursuit);
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
}
