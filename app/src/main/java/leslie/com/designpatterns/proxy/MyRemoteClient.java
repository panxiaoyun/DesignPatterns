package leslie.com.designpatterns.proxy;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Leslie on 2018/9/5.
 */

public class MyRemoteClient {

    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {
        try {
//          MyRemote myRemote = (MyRemote) Naming.lookup("rmi://127.0.0.1:9001/RemoteServer”);//这种方式也可以
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9001);
            MyRemote myRemote = (MyRemote) registry.lookup("RemoteServer");
            int result = myRemote.add(1,2);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
