import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DIP {

    public static Mat readImage(String pathSource) {
        return Imgcodecs.imread(pathSource);
    }

    public static void saveImage(BufferedImage image, String pathOut) throws IOException {
        File file = new File(pathOut);
        ImageIO.write(image, "jpg", file);
    }

    public static void writeImage(String pathOut, Mat image) {
        Imgcodecs imgcodecs = new Imgcodecs();
        imgcodecs.imwrite(pathOut, image);
    }
}
