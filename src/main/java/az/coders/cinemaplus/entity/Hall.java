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
@Table(name="halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "hall",cascade = CascadeType.ALL)//burdan cinema filterindeki adlar gelir 28 mall, genclik amma dillerde translate deyisir deye elave class yaratdiq
    private List<HallTranslation> translations;
    @ManyToOne
    private Cinema cinema;
}
