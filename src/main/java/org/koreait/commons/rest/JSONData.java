package org.koreait.commons.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class JSONData<T> {
    private boolean success = true;
    private HttpStatus status = HttpStatus.OK;

    @NonNull
    private T data;
    private String message;
}
