import nu.pattern.OpenCV;
import org.apache.log4j.helpers.LogLog;
import org.opencv.core.Mat;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class App {
    static {
        load_opencv_library();
    }

    public static void main(String[] args) {

        try {
            String pathSource = "C:\\opencv_assets\\lena.png";
            String pathOut = "C:\\opencv_assets\\outputs\\lena_out.png";

            Mat image = DIP.readImage(pathSource);
            image = DIP.toGaysScale(image);
            DIP.writeImage(pathOut, image);

            BufferedImage bufferedImage = DIP.toBufferedImage(image);
            DIP.showImage(bufferedImage);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void load_opencv_library() {
        try {
            // load OpenCV library
            OpenCV.loadLocally();
        } catch (ExceptionInInitializerError exception) {
            LogLog.error("Error loading OpenCV libraries", exception);
        }
    }
}
