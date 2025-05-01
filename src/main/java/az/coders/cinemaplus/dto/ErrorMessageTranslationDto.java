package az.coders.cinemaplus.dto;

import az.coders.cinemaplus.entity.Language;
import lombok.Data;

@Data
public class ErrorMessageTranslationDto {
    private int id;
    private Language language;
    private String message;
}
