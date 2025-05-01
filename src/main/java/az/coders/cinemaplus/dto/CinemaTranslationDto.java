package az.coders.cinemaplus.dto;

import az.coders.cinemaplus.entity.Cinema;
import lombok.Data;

@Data
public class CinemaTranslationDto {
    private Integer id;
    private String name;
    private LanguageDto language;
    private Cinema cinema;
}
