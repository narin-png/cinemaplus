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
@Table(name="cinema_translations")
public class CinemaTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne        // her dilde sozun bir qarsiligi var ama bir sozu bir nece languagede olur
    private Language language;
    @ManyToOne//yene her dilde bir cinema bir cinema 3 dilde meselem
    @JsonIgnore
    private Cinema cinema;
}
