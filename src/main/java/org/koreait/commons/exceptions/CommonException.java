package org.koreait.commons.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

public class CommonException extends RuntimeException{


    private HttpStatus status;

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); // 500
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    private HttpStatus getStatus() {
        return  status;
    }
}
