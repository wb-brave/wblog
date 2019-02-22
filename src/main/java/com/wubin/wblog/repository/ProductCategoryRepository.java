package com.wubin.wblog.repository;

import com.wubin.wblog.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wubin
 * @Description
 * @project sell
 * @package com.weixin.sell.repository
 * @email wubin326@qq.com
 * @date 2018/12/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/21        wubin            0.0.1
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
}
