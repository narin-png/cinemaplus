package az.coders.cinemaplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movie_language_translations")
public class MovieLanguageTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lang;      // languag efilterindeki diller desehofenin dili deyisdikce detsiir
    @ManyToOne
    private Language language;   // filterdeki diller ozleri az rus deysiir deye
    @ManyToOne
    @JsonIgnore
    private MovieLanguage movieLanguage;
}
