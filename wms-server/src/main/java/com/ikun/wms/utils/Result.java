package com.ikun.wms.utils;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/***
 * vo
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T>  implements Serializable {
    private Integer code;
    private String msg;
    private T data;


    public static Result success(){
        return Result.builder()
                .code(CodeEnum.SUCCESS.getCode())
                .msg(CodeEnum.SUCCESS.getMsg())
                .build();
    }

    public static Result success(String msg){
        return Result.builder()
                .code(CodeEnum.SUCCESS.getCode())
                .msg(msg)
                .build();
    }


    public static <T> Result<T> success(T data){

        return new Result<>(
                CodeEnum.SUCCESS.getCode(),
                CodeEnum.SUCCESS.getMsg(),
                data);
    }

    public static<T> Result<T> success(T data, String msg){
        return new Result<>(CodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static Result success(String msg){
        return Result.builder()
                .code(CodeEnum.SUCCESS.getCode())
                .msg(msg)
                .build();
    }
    public static  Result success(CodeEnum codeEnum){
        return Result.builder()
                .code(codeEnum.getCode())
                .msg(codeEnum.getMsg())
                .build();
    }

    public static Result error(){
        return Result.builder()
                .code(CodeEnum.ERROR.getCode())
                .msg(CodeEnum.ERROR.getMsg())
                .build();
    }

    public static Result error(String msg){
        return Result.builder()
                .code(CodeEnum.ERROR.getCode())
                .msg(msg)
                .build();
    }
    public static Result error(CodeEnum codeEnum){
        return Result.builder()
                .code(codeEnum.getCode())
                .msg(codeEnum.getMsg())
                .build();
    }
}
