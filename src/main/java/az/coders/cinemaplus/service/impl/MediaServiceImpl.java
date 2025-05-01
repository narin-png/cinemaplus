package az.coders.cinemaplus.service.impl;

import az.coders.cinemaplus.config.EnhancedObjectMapper;
import az.coders.cinemaplus.dto.MediaDto;
import az.coders.cinemaplus.entity.Media;
import az.coders.cinemaplus.enums.ErrorCode;
import az.coders.cinemaplus.exception.NotFoundException;
import az.coders.cinemaplus.repository.MediaRepository;
import az.coders.cinemaplus.repository.MediaTypeRepository;
import az.coders.cinemaplus.service.MediaService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    private final MediaRepository mediaRepository;
    private final MediaTypeRepository mediaTypeRepository;
    private final EnhancedObjectMapper mapper;
    @Value("${file.path}")
    private String folder;

    @Override
    @SneakyThrows
    public MediaDto uploadMedia(Integer mediaTypeId, MultipartFile file) {
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        Path path = Paths.get(folder, fileName);
        //bele path yoxdusa yaratsin deye
        Files.createDirectories(path.getParent());
        Files.copy(file.getInputStream(), path);
        Media media = new Media();
        media.setPath(path.toString());
        az.coders.cinemaplus.entity.MediaType mediaType = mediaTypeRepository.findById(mediaTypeId).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
        media.setMediaType(mediaType);
        return mapper.convertValue(mediaRepository.save(media), MediaDto.class);
    }

    @Override
    public void deleteMedia(Integer id) {
        Media media = mediaRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
        Path path = Paths.get(media.getPath());
        if (path.toFile().exists()) {
            path.toFile().delete();
        }
        mediaRepository.deleteById(id);
    }

    @Override
    public Media getMedia(Integer id) {
        return mediaRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }

    @Override
    public MediaType getMediaType(String path) {
        String extension = path.substring(path.lastIndexOf(".") + 1);
        switch (extension) {
            case "mp4":
                return MediaType.parseMediaType("video/mp4");
            case "jpeg":
            case "png":
            case "jpg":
            case "avi":
                return MediaType.parseMediaType("image/jpeg");
            case "svg":   //icon
                return MediaType.parseMediaType("image/svg+xml");
        }
        return MediaType.parseMediaType("application/octet-stream");
    }

    @Override
    @SneakyThrows
    public Resource getResource(String path) {
        Path filePath=Paths.get( path);
        if(filePath.toFile().exists()) {
            return new InputStreamResource(new FileInputStream(filePath.toFile()));
        }
        throw new NotFoundException(ErrorCode.NOT_FOUND);
    }
}
