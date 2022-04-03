import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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

    public static BufferedImage toBufferedImage(Mat image) throws IOException {
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", image, matOfByte);
        byte[] byteArray = matOfByte.toArray();
        InputStream in = new ByteArrayInputStream(byteArray);

        return ImageIO.read(in);
    }

    public static void showImage(BufferedImage bufImage){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
        frame.pack();
        frame.setVisible(true);
    }

    public static Mat applyThreshold(Mat src, double thresh, double maxval) {
        Mat dst = new Mat();
        Imgproc.threshold(src, dst, thresh, maxval, Imgproc.THRESH_BINARY);
        return dst;
    }
}
