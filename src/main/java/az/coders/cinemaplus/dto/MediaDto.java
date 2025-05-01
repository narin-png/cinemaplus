package az.coders.cinemaplus.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDto {
    private Integer id;
    private String path;
    private MediaTypeDto mediaTypeDto;
}
