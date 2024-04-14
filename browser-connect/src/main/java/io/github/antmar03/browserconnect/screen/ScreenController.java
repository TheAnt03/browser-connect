package io.github.antmar03.browserconnect.screen;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@RestController
@RequestMapping("/screen")
public class ScreenController {
    private final ScreenCaptureService screenCaptureService;

    @Autowired
    public ScreenController(ScreenCaptureService screenCaptureService) {
        this.screenCaptureService = screenCaptureService;
    }
    @GetMapping(
            value = "/getimage",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @CrossOrigin
    public @ResponseBody byte[] getImage(HttpServletResponse response) throws IOException {
        BufferedImage image = screenCaptureService.getLatestScreenshot();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", out);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(out.toByteArray()).getBody();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }
}

