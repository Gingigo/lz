package cn.lwjzt.designpattern.action.chain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leexiaobu
 * @date 2020-09-08 14:30:15
 */
public class Chain {

    List<Handler> list = new ArrayList<>();

    public void addHandler(Handler handler) {
        list.add(handler);
    }

    public boolean handleRequest(Request request) {
        for (int i = 0; i < list.size(); i++) {
            Handler handler = list.get(i);
            Boolean r = handler.process(request);
            if (null != r) {
                System.out.println(request + " " + (r ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
                return r;
            }
        }
        throw new RuntimeException("Could not handle request: " + request);
    }

    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.addHandler(new ManageHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());
        Request leexiaobu = new Request("leexiaobu", BigDecimal.valueOf(1000));
        boolean b = chain.handleRequest(leexiaobu);
        System.out.println(b);
        leexiaobu = new Request("lWJ", BigDecimal.valueOf(100000));
        b = chain.handleRequest(leexiaobu);
        leexiaobu = new Request(null, BigDecimal.valueOf(10000));
        b = chain.handleRequest(leexiaobu);
    }
}
