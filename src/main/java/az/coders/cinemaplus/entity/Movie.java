package az.coders.cinemaplus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<MovieTranslation> translations;
    private Date startDate;
    private Date endDate;
    @OneToMany
    private List<Country> countries;  // translationda yazmadiq cunli country ozunun ayri cedvelde saxladiq v icinde translate etdik
    private Integer duration;
    @OneToMany
    private List<Genre> genres;
    @OneToOne
    private Media image; // sekil videolari saxlamaq
    @OneToOne
    private Media video;
    @ManyToMany
    private List<MovieLanguage> movieLanguages;
    @ManyToMany
    private List<Format> formats;
    private Integer limitAge;
    private Integer orderNumber;
}
