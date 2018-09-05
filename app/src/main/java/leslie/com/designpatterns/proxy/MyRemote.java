package leslie.com.designpatterns.proxy;

import android.os.RemoteException;

import java.rmi.*;
/**
 * Created by Leslie on 2018/9/5.
 */

public interface MyRemote extends Remote {

    public int add(int a, int b) throws RemoteException;
}
