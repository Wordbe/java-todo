package co.whitetree.javatodo.common.image;

import co.whitetree.javatodo.common.image.dto.ImageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @PostMapping("/presigned-url")
    public String getPresignedUrl(@RequestBody ImageRequest request) {
        return "presignedUrl/" + request.filename();
    }
}
