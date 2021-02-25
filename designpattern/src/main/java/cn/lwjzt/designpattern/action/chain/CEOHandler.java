package cn.lwjzt.designpattern.action.chain;

/**
 * @author Leexiaobu
 * @date 2020-09-08 14:44:46
 */
public class CEOHandler implements Handler {

    @Override
    public Boolean process(Request request) {
        System.out.println("CEO");
        String name = request.getName();
        if (name == null) {
            return null;
        }
        return name.length() < 5;
    }
}
