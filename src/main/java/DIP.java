import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

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

    // typeConversionCode = 2 para ler a image em escala de cinza
    public static Mat readImage(String pathSource, int typeConversionCode) {
        return Imgcodecs.imread(pathSource, typeConversionCode);
    }

    public static Mat readToGaysScale(String pathSource) {
        return Imgcodecs.imread(pathSource, Imgcodecs.IMREAD_GRAYSCALE);
    }

    public static Mat toGaysScale(Mat src) {
        Mat dst = new Mat();
        Imgproc.cvtColor(src, dst, Imgproc.COLOR_RGB2GRAY);
        return dst;
    }
}
