package com.zsl.tracecommon;

/**
 * 封装API的错误码
 * Created by binggleW on 2019/4/19.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
