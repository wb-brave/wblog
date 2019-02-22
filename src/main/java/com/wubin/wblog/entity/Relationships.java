package com.wubin.wblog.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wubin
 * @since 2019-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("w_relationships")
public class Relationships extends Model<Relationships> {

    private static final long serialVersionUID = 1L;

    /**
     * 内容主键
     */
    private Integer cid;

    /**
     * 项目主键
     */
    private Integer mid;


    @Override
    protected Serializable pkVal() {
        return this.cid;
    }

}
