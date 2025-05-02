package az.coders.cinemaplus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @ManyToOne
    private MovieLanguage movieLanguage;
    @ManyToOne
    private Format format;
    private double price;
    private Integer rowSeat;
    private Integer colSeat;
}
