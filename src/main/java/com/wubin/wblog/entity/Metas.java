package com.wubin.wblog.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("w_metas")
public class Metas extends Model<Metas> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;
    /**
     * 名称
     */
    private String name;

    /**
     * 项目缩略名
     */
    private String slug;

    /**
     * 项目类型
     */
    private String type;

    /**
     * 选项描述
     */
    private String description;

    /**
     * 项目排序
     */
    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.mid;
    }

}
