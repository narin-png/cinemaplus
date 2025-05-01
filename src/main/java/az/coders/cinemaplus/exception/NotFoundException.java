package az.coders.cinemaplus.exception;

import az.coders.cinemaplus.enums.ErrorCode;
import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
