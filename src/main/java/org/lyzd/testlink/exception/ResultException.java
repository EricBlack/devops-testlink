package org.lyzd.testlink.exception;

import org.lyzd.testlink.entity.ResultCode;


public class ResultException extends RuntimeException {
    private ResultCode resultCode;

    public ResultException(ResultCode resultCode){
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
