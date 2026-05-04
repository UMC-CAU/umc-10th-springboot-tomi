package umc.umc10th.global.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.umc10th.global.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private final BaseErrorCode errorCode;
}
