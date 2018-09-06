package leslie.com.designpatterns.proxy;

/**
 * Created by Leslie on 2018/9/2.
 */

public class OtProxyPursuit implements GiveGiftInterface {

    private GiveGiftInterface mGiveGiftInterface;

    public OtProxyPursuit(GiveGiftInterface giveGiftInterface){
        this.mGiveGiftInterface = giveGiftInterface;
    }
    @Override
    public void giveFlower() {
        mGiveGiftInterface.giveFlower();
    }

    @Override
    public void giveChocolate() {
        mGiveGiftInterface.giveChocolate();
    }

    public static void main(String[] args){
        SchoolGirl girl = new SchoolGirl();
        girl.mName = "Leo";
        GiveGiftInterface realPursuit = new RealPursuit(girl);
        GiveGiftInterface giveGift = new OtProxyPursuit(realPursuit);
        giveGift.giveChocolate();
        giveGift.giveFlower();
    }
}
