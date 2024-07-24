package com.ikun.wms.controller;

/**
 * @Author: yiwang
 * @Date: 2024/7/22
 */

import com.ikun.wms.config.Filter.TokenVerifyFilter;
import com.ikun.wms.pojo.entity.*;
import com.ikun.wms.service.*;
import com.ikun.wms.utils.Page;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/***
 * 商品管理
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private AuthInfoService authInfoService;

    //注入StoreService
    @Resource
    private StoreService storeService;

    //注入BrandService
    @Resource
    private BrandService brandService;

    //注入ProductTypeService
    @Resource
    private ProductTypeService productTypeService;

    //注入SupplyService
    @Resource
    private SupplyService supplyService;

    //注入PlaceService
    @Resource
    private PlaceService placeService;

    //注入UnitService
    @Resource
    private UnitService unitService;

    //注入ProductService
    @Resource
    private ProductService productService;

    //注入TokenUtils
    @Resource
    private TokenVerifyFilter tokenUtils;

    /**
     * 查找所有仓库
     * @return
     */
    @RequestMapping("/store-list")
    public Result storeList(){
        //执行业务
        List<Store> storeList = storeService.queryAllStore();
        //响应
        return Result.success(storeList);
    }

    /**
     * 查找所有品牌
     * @return
     */
    @RequestMapping("/brand-list")
    public Result brandList(){
        //执行业务
        List<Brand> brandList = brandService.queryAllBrand();
        //响应
        return Result.success(brandList);
    }

    /**
     * 查找商品分类
     * @return
     */
    @RequestMapping("/category-tree")
    public Result categoryTree(){
        //执行业务
        List<ProductType> typeTreeList = productTypeService.allProductTypeTree();
        //响应
        return Result.success(typeTreeList);
    }

    /**
     * 查找所有供应商
     * @return
     */
    @RequestMapping("/supply-list")
    public Result supplyList(){
        //执行业务
        List<Supply> supplyList = supplyService.queryAllSupply();
        //响应
        return Result.success(supplyList);
    }

    /**
     * 查找产地
     * @return
     */
    @RequestMapping("/place-list")
    public Result placeList(){
        //执行业务
        List<Place> placeList = placeService.queryAllPlace();
        //响应
        return Result.success(placeList);
    }

    /**
     * 查找单位
     * @return
     */
    @RequestMapping("/unit-list")
    public Result unitList(){
        //执行业务
        List<Unit> unitList = unitService.queryAllUnit();
        //响应
        return Result.success(unitList);
    }

    /**
     * 分页查询
     * @param page
     * @param product
     * @return
     */
    @RequestMapping("/product-page-list")
    public Result productPageList(Page page, Product product){
        //执行业务
        page = productService.queryProductPage(page, product);
        //响应
        return Result.success(page);
    }

    /**
     * 图片上传地址
     */
    @Value("${file.upload-path}")
    private String uploadPath;

    /**
     * 上传图片
     * @param file
     * @return
     */
    @CrossOrigin
    @PostMapping("/img-upload")
    public Result uploadImg(MultipartFile file){

        try {
            //拿到图片上传到的目录(类路径classes下的static/img/upload)的File对象
            File uploadDirFile = ResourceUtils.getFile(uploadPath);
            //拿到图片上传到的目录的磁盘路径
            String uploadDirPath = uploadDirFile.getAbsolutePath();
            //拿到图片保存到的磁盘路径
            String fileUploadPath = uploadDirPath + "\\" + file.getOriginalFilename();
            //保存图片
            file.transferTo(new File(fileUploadPath));
            //成功响应
            return Result.success("图片上传成功！");
        } catch (IOException e) {
            //失败响应
            return Result.error( "图片上传失败！");
        }
    }

    /**
     * 增加商品
     * @param product
     * @return
     */
    @RequestMapping("/product-add")
    public Result addProduct(@RequestBody Product product){

        //获取当前登录的用户
        //CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        //获取当前登录的用户id,即添加商品的用户id
        //int createBy = currentUser.getUserId();
       // product.setCreateBy(createBy);

        //执行业务
        Result result = productService.saveProduct(product);

        //响应
        return result;
    }

    /**
     * 状态更新
     * @param product
     * @return
     */
    @RequestMapping("/state-change")
    public Result changeProductState(@RequestBody Product product){
        //执行业务
        Result result = productService.updateProductState(product);
        //响应
        return result;
    }

    /**
     * 根据id删除商品
     * @param productId
     * @return
     */
    @RequestMapping("/product-delete/{productId}")
    public Result deleteProduct(@PathVariable Integer productId){
        //执行业务
        Result result = productService.deleteProduct(productId);
        //响应
        return result;
    }

    /**
     * 更新商品信息
     * @param product
     * @return
     */
    @RequestMapping("/product-update")
    public Result updateProduct(@RequestBody Product product){

        //获取当前登录的用户
       // CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        //获取当前登录的用户id,即修改商品的用户id
        ////int updateBy = currentUser.getUserId();
      //  product.setUpdateBy(updateBy);

        //执行业务
        Result result = productService.updateProduct(product);

        //响应
        return result;
    }
}

