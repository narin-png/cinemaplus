package az.coders.cinemaplus.exception;

import az.coders.cinemaplus.model.response.exception.ErrorMessageResponse;
import az.coders.cinemaplus.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ErrorMessageService errorMessageService;
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> handlerNotFoundException(NotFoundException ex) {
        return ResponseEntity.ok(errorMessageService.getErrorMessageByCode(ex.getErrorCode()));
    }
}
