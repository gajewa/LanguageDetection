package team.jit.Comparator;

import com.detectlanguage.errors.APIError;
import team.jit.Detector.OptimaizeDetector;
import team.jit.Detector.TikaDetector;
import team.jit.Detector.WebDetector;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LanguageDetectorComparator {
    private WebDetector webDetector;
    private TikaDetector tikaDetector;
    private OptimaizeDetector optimaizeDetector;
    private BufferedReader bufferedReader;
    private Double lines;

    public LanguageDetectorComparator(String apiKey) throws IOException {
        webDetector = new WebDetector(apiKey);
        tikaDetector = new TikaDetector();
        optimaizeDetector = new OptimaizeDetector();
        this.lines = 0.0;
    }

    public void setNewFile(String filename){
        InputStream fileStream = ClassLoader.getSystemResourceAsStream(filename);
        bufferedReader = new BufferedReader(new InputStreamReader(fileStream));
    }

    public void detect(String language) throws IOException, APIError {
        String buffer;
        while((buffer = bufferedReader.readLine()) != null) {
            String webResult = webDetector.detect(buffer);
            String tikaReuslt = tikaDetector.detect(buffer);
            String optimaizeResult = optimaizeDetector.detect(buffer);

            if(webResult!= null && webResult.equals(language)){
                webDetector.incrementDetectedCount();
            }

            if(tikaReuslt != null && tikaReuslt.equals(language)){
                tikaDetector.incrementDetectedCount();
            }

            if(optimaizeResult != null && optimaizeResult.equals(language)){
                optimaizeDetector.incrementDetectedCount();
            }

            lines += 1;
        }

    }

    public void printResult(){
        System.out.println("WebAPI detection: " + webDetector.getDetected()*100/lines + "%");
        System.out.println("Tika detection: " + tikaDetector.getDetected()*100/lines + "%");
        System.out.println("Optimaize detection: " + optimaizeDetector.getDetected()*100/lines + "%");
    }
}
