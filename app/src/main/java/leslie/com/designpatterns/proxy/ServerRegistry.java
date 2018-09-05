package leslie.com.designpatterns.proxy;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 * Created by Leslie on 2018/9/5.
 */

public class ServerRegistry {
    private static Registry registry;

    private static Registry getRegistry() throws RemoteException {
        try {
            return registry == null ? (registry = LocateRegistry.createRegistry(9001)) : registry;
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        throw new RemoteException("Create registry faild...");
    }

    public static void main(String[] args) {
        try {
            MyRemote server = new AddService();
            getRegistry().bind("RemoteServer", server);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
