package com.wubin.wblog.service;

import com.wubin.wblog.entity.ProductCategory;

import java.util.List;

/**
 * @author wubin
 * @Description 产品目录表的业务类
 * @project sell
 * @package com.weixin.sell.service
 * @email wubin326@qq.com
 * @date 2018/12/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/21        wubin            0.0.1
 */
public interface ProductCategoryService {

    ProductCategory findOneById(Integer productId);

    List<ProductCategory> findAllInfos();

    /**
     * 如果删除过程中出现异常
     * 则返回false
     *
     * @param productId
     * @return
     */
    boolean deleteOneById(Integer productId);

    boolean deleteAllInfos();

    ProductCategory saveProductCategory(ProductCategory productCategory);

}
