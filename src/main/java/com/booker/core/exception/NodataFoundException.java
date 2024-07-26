package com.booker.core.exception;

import com.booker.core.exception.code.ErrorCode;
import org.springframework.http.HttpStatus;


public class NodataFoundException extends BookerException {

    public NodataFoundException() {
        super(HttpStatus.NOT_FOUND, ErrorCode.NOT_FOUND);
    }

    public NodataFoundException(ErrorCode errorCode) {
        super(HttpStatus.NOT_FOUND, errorCode);
    }

    public NodataFoundException(HttpStatus httpStatus, ErrorCode errorCode) {
        super(httpStatus, errorCode);
    }
}
