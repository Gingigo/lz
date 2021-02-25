package cn.leexiaobu.service.impl;

import cn.leexiaobu.service.rmi.RMIService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Leexiaobu
 * @date 2021-02-23 23:27
 */
public class RMIServiceImpl extends UnicastRemoteObject implements RMIService {


  protected RMIServiceImpl() throws RemoteException {
    super();
  }

  @Override
  public String helloRMI(String name) {
    System.out.println("RMI：hello " + name);
    return "RMI: from provider " + name;
  }
}