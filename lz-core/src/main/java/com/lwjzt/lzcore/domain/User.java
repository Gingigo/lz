package com.lwjzt.lzcore.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * user
 */
@Data
@TableName(value = "`user`")
public class User {
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