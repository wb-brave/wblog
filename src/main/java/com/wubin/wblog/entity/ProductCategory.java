package com.wubin.wblog.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wubin
 * @Description 产品目录表
 * @project sell
 * @package com.weixin.sell.entity
 * @email wubin326@qq.com
 * @date 2018/12/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/21        wubin            0.0.1
 */
@Entity
//动态跟新信息
@DynamicUpdate
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer catagoryId;

    @NonNull
    private String catagoryName;

    @NonNull
    private Integer catagoryType;

    private Date createTime;

    private Date updateTime;
}
