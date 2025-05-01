package az.coders.cinemaplus.controller.user;

import az.coders.cinemaplus.enums.ErrorCode;
import az.coders.cinemaplus.model.response.exception.ErrorMessageResponse;
import az.coders.cinemaplus.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/error-messages")
public class ErrorMessageUserController {
    private final ErrorMessageService errorMessageService;
    private static final String LANGUAGE="Language";

    @GetMapping("/by-error-code")
    public ResponseEntity<ErrorMessageResponse> getErrorMessageByCode( @RequestParam("errorCode") ErrorCode errorCode) {
        return ResponseEntity.ok(errorMessageService.getErrorMessageByCode(errorCode));
    }

}
