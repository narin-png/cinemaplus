package az.coders.cinemaplus.service;

import az.coders.cinemaplus.dto.ErrorMessageDto;
import az.coders.cinemaplus.enums.ErrorCode;
import az.coders.cinemaplus.model.response.exception.ErrorMessageResponse;

import java.util.List;

public interface ErrorMessageService {
    ErrorMessageResponse getErrorMessageByCode(ErrorCode errorCode);
    List<ErrorMessageDto> getErrorMessages();
    ErrorMessageDto getErrorMessageById(Integer id);
    ErrorMessageDto createErrorMessage(ErrorMessageDto errorMessageDto);
    void deleteErrorMessage(Integer id);
    ErrorMessageDto updateErrorMessage(Integer id, ErrorMessageDto errorMessageDto);
}
