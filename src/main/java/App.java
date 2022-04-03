import nu.pattern.OpenCV;
import org.apache.log4j.helpers.LogLog;

public class App {
    static {
        load_opencv_library();
    }

    public static void main(String[] args) {


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
