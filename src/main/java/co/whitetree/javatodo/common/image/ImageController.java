package co.whitetree.javatodo.common.image;

import co.whitetree.javatodo.common.image.dto.ImageRequest;
import co.whitetree.javatodo.support.aws.S3Client;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final S3Client s3Client;

    @PostMapping("/presigned-url")
    public String getPresignedUrl(@RequestBody ImageRequest request) {
        return s3Client.getImageUrl(request.filename(), LocalDateTime.now());
    }
}
