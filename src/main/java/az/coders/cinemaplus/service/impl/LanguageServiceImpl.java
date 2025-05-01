package az.coders.cinemaplus.service.impl;

import az.coders.cinemaplus.config.EnhancedObjectMapper;
import az.coders.cinemaplus.dto.LanguageDto;
import az.coders.cinemaplus.entity.Language;
import az.coders.cinemaplus.enums.ErrorCode;
import az.coders.cinemaplus.exception.NotFoundException;
import az.coders.cinemaplus.repository.LanguageRepository;
import az.coders.cinemaplus.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    private final EnhancedObjectMapper objectMapper;

    @Override
    public List<LanguageDto> getLanguages() {
        return objectMapper.convertList(languageRepository.findAll(), LanguageDto.class);

    }

    @Override
    public LanguageDto getLanguageById(Integer id) {
        return objectMapper.convertValue(findById(id), LanguageDto.class);
    }

    @Override
    public LanguageDto createLanguage(LanguageDto languageDto) {
        return objectMapper.convertValue(languageRepository.save(objectMapper.convertValue(languageDto, Language.class)), LanguageDto.class);
    }

    @Override
    public void deleteLanguage(Integer id) {
        findById(id);
        languageRepository.deleteById(id);
    }

    @Override
    public LanguageDto updateLanguage(Integer id, LanguageDto languageDto) {
        Language findLanguage = findById(id);
        Language language = objectMapper.convertValue(languageDto, Language.class);
        language.setId(findLanguage.getId());
        return objectMapper.convertValue(languageRepository.save(language), LanguageDto.class);
    }

    private Language findById(Integer id) {
        return languageRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }
}