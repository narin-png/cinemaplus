package az.coders.cinemaplus.service;

import az.coders.cinemaplus.dto.MediaDto;
import az.coders.cinemaplus.entity.Media;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {
    MediaDto uploadMedia(Integer mediaTypeId, MultipartFile file);

    void deleteMedia(Integer id);

    Media getMedia(Integer id);

    MediaType getMediaType(String path);

    Resource getResource(String path);
}
