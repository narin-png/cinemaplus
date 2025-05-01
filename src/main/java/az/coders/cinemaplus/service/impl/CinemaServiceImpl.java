package az.coders.cinemaplus.service.impl;

import az.coders.cinemaplus.config.EnhancedObjectMapper;
import az.coders.cinemaplus.dto.CinemaDto;
import az.coders.cinemaplus.entity.Cinema;
import az.coders.cinemaplus.enums.ErrorCode;
import az.coders.cinemaplus.exception.NotFoundException;
import az.coders.cinemaplus.repository.CinemaRepository;
import az.coders.cinemaplus.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    private final EnhancedObjectMapper objectMapper;
    @Override
    public List<CinemaDto> getCinemas() {
        return objectMapper.convertList(cinemaRepository.findAll(), CinemaDto.class);

    }
    @Override
    public CinemaDto getCinemaById(Integer id) {
        return objectMapper.convertValue(findById(id), CinemaDto.class);
    }

    @Override
    public CinemaDto createCinema(CinemaDto cinemaDto) {
        return objectMapper.convertValue(cinemaRepository.save(objectMapper.convertValue(cinemaDto, Cinema.class)), CinemaDto.class);
    }

    @Override
    public void deleteCinema(Integer id) {
        findById(id);  // BIRINC EMIN OLMALIYIQ KI ID VAR
        cinemaRepository.deleteById(id);
    }


    @Override
    public CinemaDto updateCinema(Integer id, CinemaDto cinemaDto) {
        Cinema findCinema = findById(id);
        Cinema cinema = objectMapper.convertValue(cinemaDto, Cinema.class);
        cinema.setId(findCinema.getId());
        return objectMapper.convertValue(cinemaRepository.save(cinema), CinemaDto.class);
    }
    private Cinema findById(Integer id) {
        return cinemaRepository.findById(id).orElseThrow(()->new NotFoundException(ErrorCode.NOT_FOUND));
    }
}
