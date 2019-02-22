package com.wubin.wblog.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
@TableName("w_contents")
public class Contents extends Model<Contents> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 内容缩略名
     */
    private String slug;

    /**
     * 内容生成时的GMT unix时间戳
     */
    private Integer created;

    /**
     * 内容更改时的GMT unix时间戳
     */
    private Integer modified;

    /**
     * 内容所属用户id
     */
    @TableField("author_id")
    private Integer authorId;

    /**
     * 内容类别
     */
    private String type;

    /**
     * 内容状态
     */
    private String status;

    /**
     * 标签列表
     */
    private String tags;

    /**
     * 分类列表
     */
    private String categories;

    /**
     * 点击次数
     */
    private Integer hits;

    /**
     * 内容所属评论数
     */
    @TableField("comments_num")
    private Integer commentsNum;

    /**
     * 是否允许评论
     */
    @TableField("allow_comment")
    private Boolean allowComment;

    /**
     * 是否允许ping
     */
    @TableField("allow_ping")
    private Boolean allowPing;

    /**
     * 允许出现在聚合中
     */
    @TableField("allow_feed")
    private Boolean allowFeed;

    /**
     * 内容文字
     */
    private String content;


    @Override
    protected Serializable pkVal() {
        return this.cid;
    }

}
