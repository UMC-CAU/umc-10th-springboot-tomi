package umc.umc10th.global.apiPayload.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.BaseErrorCode;
import umc.umc10th.global.apiPayload.code.GeneralErrorCode;
import umc.umc10th.global.apiPayload.exception.GeneralException;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ){
        // 검증 실패한 변수명과 실패 이유를 담을 Map
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        BaseErrorCode code = GeneralErrorCode.BAD_REQUEST;
        return ResponseEntity.status(code.getStatus())
                .body(ApiResponse.onFailure(code, errors));
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
