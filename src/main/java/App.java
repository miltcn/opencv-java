import io.github.cdimascio.dotenv.Dotenv;
import nu.pattern.OpenCV;
import org.apache.log4j.helpers.LogLog;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;

import java.awt.image.BufferedImage;

public class App {
    static {
        load_opencv_library();
    }

    public static void main(String[] args) {

        try {

            Dotenv dotenv = Dotenv.load();
            String pathSource = dotenv.get("BASE_PATH") + "\\medidor.jpg";
            String pathOut = dotenv.get("BASE_PATH") + "\\outputs\\medidor_out2.jpg";

            Mat image = DIP.readImage(pathSource);
            image = DIP.toGaysScale(image);
            image = DIP.applyCanny(image, 150.0, 300.0, 3, true);
//            image = DIP.applyThreshold(image, 127,255);
            DIP.writeImage(pathOut, image);

//            DIP.drawRectangle(image, new Point(200,200), new Point(400,400), new Scalar(0,0,255),2);

            BufferedImage bufferedImage = DIP.toBufferedImage(image);
            DIP.showImage(bufferedImage);

        } catch (Exception e) {
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
