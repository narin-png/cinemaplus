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
@Table(name="countries")
public class Country {    // country elavee cedvelde saxlanmlai cunki konkret olke adlari var sehv kimse olke daxil etmesin deye ordan alnmali
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private List<CountryTranslation> countries;
}
