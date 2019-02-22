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
@TableName("w_options")
public class Options extends Model<Options> {

    private static final long serialVersionUID = 1L;

    /**
            * 配置名称
     */
    private String name;

    /**
     * 配置值
     */
    private String value;

    private String description;


    @Override
    protected Serializable pkVal() {
        return this.name;
    }

}
