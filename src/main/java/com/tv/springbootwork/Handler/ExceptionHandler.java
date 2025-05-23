package com.tv.springbootwork.Handler;

import com.tv.springbootwork.Exception.APIException;
import com.tv.springbootwork.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

    /**
     * 500 error : 運行時異常(請看log)
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = RuntimeException.class)
    public ResponseBean handler(RuntimeException e) {
        log.error("運行時異常 => {}", e.getMessage());
        return ResponseBean.Builder.error(Action.RUNTIME, Code.FAIL);
    }
    /**
     * API error : API各式問題
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = APIException.class)
    public ResponseBean handler(APIException e) {
        log.error("API錯誤 => {}", e.getMessage());
        return e.getResponseBean();
    }


}
