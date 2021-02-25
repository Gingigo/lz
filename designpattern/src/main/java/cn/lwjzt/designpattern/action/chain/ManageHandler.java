package cn.lwjzt.designpattern.action.chain;

import java.math.BigDecimal;

/**
 * @author Leexiaobu
 * @date 2020-09-08 14:35:06
 */
public class ManageHandler implements Handler {
    @Override
    public Boolean process(Request request) {
        System.out.println("MANAGE");
        if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return null;
        }
        String name = request.getName();
        return name.startsWith("l");

    }
}
