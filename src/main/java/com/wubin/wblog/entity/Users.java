package com.wubin.wblog.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author wubin
 * @since 2019-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("w_users")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    /**
     * user表主键
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;
    /**
     * 用户名称
     */
    @NonNull
    private String username;
    /**
     * 用户的密码
     */
    @NonNull
    private String password;
    /**
     * 用户的邮箱
     */
    @NonNull
    private String email;
    /**
     * 用户的主页
     */
    @NonNull
    @TableField("home_url")
    private String homeUrl;
    /**
     * 用户的显示名称
     */
    @NonNull
    @TableField("screen_name")
    private String screenName;
    /**
     * 用户注册时的GMT unix时间戳
     */
    private Integer created;
    /**
     * 最后活跃时间
     */
    private Integer activated;
    /**
     * 上次登录最后活跃时间
     */
    private Integer logged;
    /**
     * 用户组
     */
    @NonNull
    @TableField("group_name")
    private String groupName;

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

}
