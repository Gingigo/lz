package cn.leexiaobu.pojo;

import java.io.Serializable;

/**
 * @author Leexiaobu
 * @date 2021-02-24 22:38
 */
public class Result<T> implements Serializable {
  private static final long serialVersionUID=1L;
  private T data;
  private boolean success;
  private String msg;


  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}