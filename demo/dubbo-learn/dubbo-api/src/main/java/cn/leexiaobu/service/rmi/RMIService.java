package cn.leexiaobu.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Leexiaobu
 * @date 2021-02-23 23:49
 */
public interface RMIService extends Remote {

  public String helloRMI(String name) throws RemoteException;

}