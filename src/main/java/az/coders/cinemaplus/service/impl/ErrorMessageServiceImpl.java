package az.coders.cinemaplus.service.impl;

import az.coders.cinemaplus.config.EnhancedObjectMapper;
import az.coders.cinemaplus.dto.ErrorMessageDto;
import az.coders.cinemaplus.entity.ErrorMessage;
import az.coders.cinemaplus.entity.ErrorMessageTranslation;
import az.coders.cinemaplus.enums.ErrorCode;
import az.coders.cinemaplus.exception.NotFoundException;
import az.coders.cinemaplus.model.response.exception.ErrorMessageResponse;
import az.coders.cinemaplus.repository.ErrorMessageRepository;
import az.coders.cinemaplus.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static az.coders.cinemaplus.interceptor.HeaderInterceptor.LANGUAGE;

@Service
@RequiredArgsConstructor
public class ErrorMessageServiceImpl implements ErrorMessageService {
    private final ErrorMessageRepository errorMessageRepository;
    private final EnhancedObjectMapper objectMapper;

    @Override
    public ErrorMessageResponse getErrorMessageByCode(ErrorCode errorCode) {
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(errorCode);
        Optional<ErrorMessage> errorMessage = errorMessageRepository.findByErrorCode(errorCode);
        if (errorMessage.isPresent()) {
            Optional<ErrorMessageTranslation> translation = errorMessage.get().getTranslations().stream().filter(t -> t.getLanguage().getLanguage().equals(LANGUAGE)).findFirst();
            translation.ifPresent(errorMessageTranslation -> errorMessageResponse.setMessage(errorMessageTranslation.getMessage()));
        }
        return errorMessageResponse;
    }
    @Override
    public List<ErrorMessageDto> getErrorMessages() {
        return objectMapper.convertList(errorMessageRepository.findAll(), ErrorMessageDto.class);
    }

    @Override
    public ErrorMessageDto getErrorMessageById(Integer id) {
        return objectMapper.convertValue(findById(id), ErrorMessageDto.class);
    }

    @Override
        public ErrorMessageDto createErrorMessage(ErrorMessageDto errorMessageDto) {
        //ErrorMessage save = errorMessageRepository.save(mapper.convertValue(errorMessageDto, ErrorMessage.class));
        //save.getTranslations().forEach(translation -> translation.setErrorMessage(save));
        return objectMapper.convertValue(errorMessageRepository.save(objectMapper.convertValue(errorMessageDto, ErrorMessage.class)), ErrorMessageDto.class);
    }

    @Override
    public void deleteErrorMessage(Integer id) {
        findById(id);
        errorMessageRepository.deleteById(id);
    }

    @Override
    public ErrorMessageDto updateErrorMessage(Integer id, ErrorMessageDto errorMessageDto) {
        ErrorMessage findErrorMessage = findById(id);
        ErrorMessage errorMessage = objectMapper.convertValue(errorMessageDto, ErrorMessage.class);
        errorMessage.setId(findErrorMessage.getId());
        return objectMapper.convertValue(errorMessageRepository.save(errorMessage), ErrorMessageDto.class);
    }

    private ErrorMessage findById(Integer id) {
        return errorMessageRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }
}



