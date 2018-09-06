package leslie.com.designpatterns.decorator;

/**
 * Created by Leslie on 2018/9/6.
 */

public abstract class DecoratorComponent extends Component {
    protected  Component mComponent;

    @Override
    public void giveFlower() {
        mComponent.giveFlower();
    }
}
