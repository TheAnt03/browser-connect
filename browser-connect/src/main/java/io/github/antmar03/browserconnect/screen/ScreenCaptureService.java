package io.github.antmar03.browserconnect.screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ScreenCaptureService {

    private final Lock lock = new ReentrantLock();
    private BufferedImage latestScreenshot;

    @Autowired
    public ScreenCaptureService() {
        // Initialize latestScreenshot with an initial image
        latestScreenshot = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }

    /**
     * Takes screenshot of screen and stores in latest frame
     */
    @Scheduled(fixedRate = 1000/30) // Capture screenshot for 30fps
    public void takeScreenshot() {
        try {
            Robot robot = new Robot();
            Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = robot.createScreenCapture(capture);
            lock.lock();
            latestScreenshot = image;
            lock.unlock();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the latest image to ensure the image is fully loaded before being accessed
     * @return
     */
    public BufferedImage getLatestScreenshot() {
        return latestScreenshot;
    }

}
