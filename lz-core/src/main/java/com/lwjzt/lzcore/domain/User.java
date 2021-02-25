package com.lwjzt.lzcore.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * user
 */
@Data
@TableName(value = "`user`")
public class User implements Serializable {
    private static final long serialVersionUID = -12345L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getColId() {
        return COL_ID;
    }

    public static String getColUserName() {
        return COL_USER_NAME;
    }

    public static String getColAge() {
        return COL_AGE;
    }

    public static String getColPhone() {
        return COL_PHONE;
    }

    public static String getColDescription() {
        return COL_DESCRIPTION;
    }

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * userName
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * age
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * phone
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    public static final String COL_ID = "id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_AGE = "age";

    public static final String COL_PHONE = "phone";

    public static final String COL_DESCRIPTION = "description";
}