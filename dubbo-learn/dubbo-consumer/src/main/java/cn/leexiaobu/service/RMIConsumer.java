package cn.leexiaobu.service;

import cn.leexiaobu.service.rmi.RMIService;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Leexiaobu
 * @date 2021-02-23 23:35
 */
public class RMIConsumer {

  public static void main(String[] args) {
    RMIConsumer rmiConsumer = new RMIConsumer();
    rmiConsumer.registry("registry");
    rmiConsumer.Naming("Naming");
  }

  void registry(String name) {
    try {
      Registry registry = LocateRegistry.getRegistry(9999);
      RMIService rmiService = (RMIService) registry.lookup("serviceA");
      String leexiaobu = rmiService.helloRMI(name);
      System.out.println(leexiaobu);
    } catch (RemoteException | NotBoundException e) {
      e.printStackTrace();
    }
  }


  void Naming(String name) {
    try {
      String remoteAddr = "rmi://localhost:1100/serviceB";
      RMIService hello = (RMIService) Naming.lookup(remoteAddr);
      String response = hello.helloRMI(name);
      System.out.println("=======> " + response + " <=======");
    } catch (NotBoundException | RemoteException | MalformedURLException e) {
      e.printStackTrace();
    }
  }
}