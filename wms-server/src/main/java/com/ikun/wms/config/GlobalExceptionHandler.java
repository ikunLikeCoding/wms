package com.ikun.wms.config;


import com.ikun.wms.utils.CodeEnum;
import com.ikun.wms.utils.Result;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类，controller发生了异常，统一用该类进行处理
 *
 */
@RestControllerAdvice //aop。拦截标注了@RestController的controller中的所有方法
//@ControllerAdvice //aop。拦截标注了@Controller的controller中的所有方法
public class GlobalExceptionHandler {

    /**
     * 异常处理的方法（controller方法发生了异常，那么就使用该方法来处理）
     *全局异常
     * @return
     */
//    @ExceptionHandler(value = Exception.class)
//    public Result handException(Exception e) {
//        e.printStackTrace(); //在控制台打印异常信息
//        return Result.error(e.getMessage());
//    }

    /**
     * 数据访问异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = DataAccessException.class)
    public Result handDataAccessException(DataAccessException e) {
        e.printStackTrace(); //在控制台打印异常信息
        return Result.error(CodeEnum.DATA_ACCESS_DENY);
    }

    /**
     * 权限不足的异常处理
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(value = AccessDeniedException.class)
//    public Result handException(AccessDeniedException e) {
//        //e.printStackTrace(); //在控制台打印异常信息
//        return Result.error(CodeEnum.NO_AUTH);
//    }

}
