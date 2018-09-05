package leslie.com.designpatterns.proxy;
import java.rmi.*;
/**
 * 作为服务
 * Created by Leslie on 2018/9/5.
 */

public class AddService extends UnicastRemoteObject  implements MyRemote {

    @Override
    public int add(int x,int y){
        return x + y;
    }

    public static void main(String[] args) {
        try {
            // 创建远程服务对象
            MyRemote myRemote = new AddService();
            // 绑定远程服务对象到 rmiregistry
            Naming.rebind("RemoteServer", myRemote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
