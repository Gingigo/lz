package cn.lwjzt.designpattern.action.chain;

/**
 * @author Leexiaobu
 * @date 2020-09-08 14:34:01
 */
public interface Handler {
    //    如果返回Boolean.TRUE，表示处理成功，
    //    如果返回Boolean.FALSE，表示处理失败（请求被拒绝），
    //    如果返回null，则交由下一个Handler处理。
    Boolean process(Request request);
}
