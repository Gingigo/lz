package cn.lwjzt.designpattern.action.chain;

import java.math.BigDecimal;

/**
 * @author Leexiaobu
 * @date 2020-09-08 14:38:13
 */
public class DirectorHandler implements Handler {
    @Override
    public Boolean process(Request request) {
        System.out.println("DIRECTOR");
        if (request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0 || request.getName() == null) {
            return null;
        }
        String name = request.getName();
        return name.endsWith("jun");
    }
}
