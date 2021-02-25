package cn.lwjzt.designpattern.action.command;

/**
 * @author Leexiaobu
 * @date 2020-09-07 22:28:03
 */
public abstract class Command {
    public abstract void doit();

    public abstract void undo();
}
