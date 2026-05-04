package umc.umc10th.global.apiPayload.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.BaseErrorCode;
import umc.umc10th.global.apiPayload.code.GeneralErrorCode;
import umc.umc10th.global.apiPayload.exception.GeneralException;

@RestControllerAdvice
public class GeneralExceptionAdvice {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiResponse<Void>> handleException(
            GeneralException ex
    ) {

        return ResponseEntity.status(ex.getErrorCode().getStatus())
                .body(ApiResponse.onFailure(
                                ex.getErrorCode(),
                                null
                        )
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(
            Exception ex
    ) {

        BaseErrorCode code = GeneralErrorCode.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(code.getStatus())
                .body(ApiResponse.onFailure(
                                code,
                                ex.getMessage()
                        )
                );
    }
}
