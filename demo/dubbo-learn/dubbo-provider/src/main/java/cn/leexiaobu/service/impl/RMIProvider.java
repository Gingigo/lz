package cn.leexiaobu.service.impl;

import cn.leexiaobu.service.rmi.RMIService;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Leexiaobu
 * @date 2021-02-23 23:30
 */
public class RMIProvider {

  public static void main(String[] args) {
    RMIProvider rmiProvider = new RMIProvider();
    rmiProvider.registry();
    rmiProvider.Naming();
  }
  //registry的调用方式
  void registry() {
    try {
      Registry registry = LocateRegistry.createRegistry(9999);
      RMIService rmiService = new RMIServiceImpl();
      registry.rebind("serviceA", rmiService);
      System.out.println("======= 启动RMI服务成功!  registry=======");
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }


  void Naming() {
    try {
      LocateRegistry.createRegistry(1100);
      RMIService rmiService = new RMIServiceImpl();
      Naming.bind("rmi://localhost:1100/serviceB", rmiService);
      System.out.println("======= 启动RMI服务成功!  Naming=======");
    } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
      e.printStackTrace();
    }
  }

}