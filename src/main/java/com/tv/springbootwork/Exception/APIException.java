package com.tv.springbootwork.Exception;

import com.tv.springbootwork.util.ResponseBean;
import lombok.Data;

@Data
public final class APIException extends Exception{

    ResponseBean<?> responseBean;

    public APIException(ResponseBean<?> responseBean) {
        super(responseBean.getMessage());
        this.responseBean = responseBean;
    }
}
