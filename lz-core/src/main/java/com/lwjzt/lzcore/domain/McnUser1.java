package com.lwjzt.lzcore.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "mcn_user1")
public class McnUser1 {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "account_name")
    private String accountName;

    @TableField(value = "password")
    private String password;

    @TableField(value = "crtime")
    private Date crtime;

    @TableField(value = "cruser")
    private String cruser;

    @TableField(value = "opertime")
    private Date opertime;

    @TableField(value = "operuser")
    private String operuser;

    @TableField(value = "account_desc")
    private String accountDesc;

    @TableField(value = "address")
    private String address;

    @TableField(value = "alipay_code")
    private String alipayCode;

    @TableField(value = "audit_status")
    private Integer auditStatus;

    @TableField(value = "bank_card_number")
    private String bankCardNumber;

    @TableField(value = "bank_name")
    private String bankName;

    @TableField(value = "city")
    private String city;

    @TableField(value = "content_component_secret")
    private String contentComponentSecret;

    @TableField(value = "content_component_user_id")
    private String contentComponentUserId;

    @TableField(value = "email")
    private String email;

    @TableField(value = "id_number")
    private String idNumber;

    @TableField(value = "id_number_pic")
    private String idNumberPic;

    @TableField(value = "ip")
    private String ip;

    @TableField(value = "is_administrator")
    private Integer isAdministrator;

    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(value = "istenant_admin")
    private Short istenantAdmin;

    @TableField(value = "last_modify")
    private Date lastModify;

    @TableField(value = "login_err_count")
    private Integer loginErrCount;

    @TableField(value = "login_time")
    private Date loginTime;

    @TableField(value = "logo")
    private String logo;

    @TableField(value = "logout_time")
    private Date logoutTime;

    @TableField(value = "media_type")
    private Integer mediaType;

    @TableField(value = "mobile")
    private String mobile;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "org_code")
    private String orgCode;

    @TableField(value = "org_name")
    private String orgName;

    @TableField(value = "postal_code")
    private String postalCode;

    @TableField(value = "province")
    private String province;

    @TableField(value = "schemaname")
    private String schemaname;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "tenant_id")
    private Long tenantId;

    @TableField(value = "truename")
    private String truename;

    @TableField(value = "unit")
    private String unit;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "user_type")
    private Integer userType;

    @TableField(value = "weak_passwd")
    private Integer weakPasswd;

    @TableField(value = "pen_name")
    private String penName;

    @TableField(value = "wechat")
    private String wechat;

    public static final String COL_ID = "id";

    public static final String COL_ACCOUNT_NAME = "account_name";

    public static final String COL_PASSWORD = "password";

    public static final String COL_CRTIME = "crtime";

    public static final String COL_CRUSER = "cruser";

    public static final String COL_OPERTIME = "opertime";

    public static final String COL_OPERUSER = "operuser";

    public static final String COL_ACCOUNT_DESC = "account_desc";

    public static final String COL_ADDRESS = "address";

    public static final String COL_ALIPAY_CODE = "alipay_code";

    public static final String COL_AUDIT_STATUS = "audit_status";

    public static final String COL_BANK_CARD_NUMBER = "bank_card_number";

    public static final String COL_BANK_NAME = "bank_name";

    public static final String COL_CITY = "city";

    public static final String COL_CONTENT_COMPONENT_SECRET = "content_component_secret";

    public static final String COL_CONTENT_COMPONENT_USER_ID = "content_component_user_id";

    public static final String COL_EMAIL = "email";

    public static final String COL_ID_NUMBER = "id_number";

    public static final String COL_ID_NUMBER_PIC = "id_number_pic";

    public static final String COL_IP = "ip";

    public static final String COL_IS_ADMINISTRATOR = "is_administrator";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_ISTENANT_ADMIN = "istenant_admin";

    public static final String COL_LAST_MODIFY = "last_modify";

    public static final String COL_LOGIN_ERR_COUNT = "login_err_count";

    public static final String COL_LOGIN_TIME = "login_time";

    public static final String COL_LOGO = "logo";

    public static final String COL_LOGOUT_TIME = "logout_time";

    public static final String COL_MEDIA_TYPE = "media_type";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_ORG_CODE = "org_code";

    public static final String COL_ORG_NAME = "org_name";

    public static final String COL_POSTAL_CODE = "postal_code";

    public static final String COL_PROVINCE = "province";

    public static final String COL_SCHEMANAME = "schemaname";

    public static final String COL_SEX = "sex";

    public static final String COL_STATUS = "status";

    public static final String COL_TENANT_ID = "tenant_id";

    public static final String COL_TRUENAME = "truename";

    public static final String COL_UNIT = "unit";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_USER_TYPE = "user_type";

    public static final String COL_WEAK_PASSWD = "weak_passwd";

    public static final String COL_PEN_NAME = "pen_name";

    public static final String COL_WECHAT = "wechat";
}