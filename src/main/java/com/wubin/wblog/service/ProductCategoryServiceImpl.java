package com.wubin.wblog.service;

import com.wubin.wblog.entity.ProductCategory;
import com.wubin.wblog.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project sell
 * @package com.weixin.sell.service
 * @email wubin326@qq.com
 * @date 2018/12/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/21        wubin            0.0.1
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOneById(Integer productId) {
        return productCategoryRepository.findOne(productId);
    }

    @Override
    public List<ProductCategory> findAllInfos() {
        return productCategoryRepository.findAll();
    }

    @Override
    public boolean deleteOneById(Integer productId) {
        try {
            productCategoryRepository.delete(productId);
        } catch (Exception e) {
            return false;
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean deleteAllInfos() {
        try {
            productCategoryRepository.deleteAll();
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public ProductCategory saveProductCategory(ProductCategory productCategory) {

        return productCategoryRepository.save(productCategory);
    }
}
