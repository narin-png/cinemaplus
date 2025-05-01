package az.coders.cinemaplus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movie_languages")
public class MovieLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "movieLanguage",cascade = CascadeType.ALL)
    private List<MovieLanguageTranslation> movieLanguageTranslations;
    @OneToOne
    private Media icon;        // az en ru iconlari filmin altindaki
}
