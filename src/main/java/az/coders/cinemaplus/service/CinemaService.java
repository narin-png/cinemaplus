package az.coders.cinemaplus.service;

import az.coders.cinemaplus.dto.CinemaDto;

import java.util.List;

public interface CinemaService {

    List<CinemaDto> getCinemas();

    CinemaDto getCinemaById(Integer id);

    CinemaDto createCinema(CinemaDto cinemaDto);

    void deleteCinema(Integer id);

    CinemaDto updateCinema(Integer id, CinemaDto cinemaDto);
}
