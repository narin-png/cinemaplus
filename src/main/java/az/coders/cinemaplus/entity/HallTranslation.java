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
@Table(name="hall_translations")
public class HallTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;  //janr adlari
    @ManyToOne
    private Language language;
    @ManyToOne
    @JsonIgnore
    private Hall hall;
}
