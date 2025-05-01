package az.coders.cinemaplus.dto;

import az.coders.cinemaplus.enums.ErrorCode;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ErrorMessageDto {
    private Integer id;
    @Enumerated(EnumType.STRING) // enum sekilinde deyilde string qayitsin deye
    private ErrorCode errorCode;
    private List<ErrorMessageTranslationDto> translations;
}
