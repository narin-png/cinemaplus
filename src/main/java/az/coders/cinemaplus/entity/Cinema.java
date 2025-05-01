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
@Table(name="cinemas")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "cinema",cascade = CascadeType.ALL)//burdan cinema filterindeki adlar gelir 28 mall, genclik amma dillerde translate deyisir deye elave class yaratdiq
    private List<CinemaTranslation> translations;
    private Integer orderNumber;
    private Boolean allItems=false; //bunu cinema filterde all cinemada yazanda hamisi gelm elidi yene onu filterde truduse fin dall yerinde istofade edicesz
}
