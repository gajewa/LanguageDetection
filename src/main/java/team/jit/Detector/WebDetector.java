package team.jit.Detector;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.util.List;

public class WebDetector {
    private Integer detected;

    public WebDetector(String apiKey){
        DetectLanguage.apiKey = apiKey;
        this.detected = 0;
    }

    public String detect(String textToDetect) throws APIError {
        List<Result> results = DetectLanguage.detect(textToDetect);
        Result result = results.get(0);
        return result.isReliable ? result.language : null;
    }

    public void incrementDetectedCount(){
        detected += 1;
    }

    public Integer getDetected() {
        return detected;
    }
}
