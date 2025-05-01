package az.coders.cinemaplus.model.response.exception;

import az.coders.cinemaplus.enums.ErrorCode;
import lombok.Data;

@Data
public class ErrorMessageResponse {
    private ErrorCode errorCode;
    private String message;

    public ErrorMessageResponse(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
