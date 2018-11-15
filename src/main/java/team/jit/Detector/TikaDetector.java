package team.jit.Detector;

import org.apache.tika.langdetect.OptimaizeLangDetector;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.language.detect.LanguageResult;

public class TikaDetector {
    private LanguageDetector languageDetector;
    private Integer detected;

    public TikaDetector() {
        this.languageDetector = new OptimaizeLangDetector().loadModels();
        this.detected = 0;
    }

    public String detect(String textToDetect) {
        LanguageResult result = languageDetector.detect(textToDetect);
        return result.isReasonablyCertain() ? result.getLanguage() : null;
    }

    public void incrementDetectedCount(){
        detected += 1;
    }

    public Integer getDetected() {
        return detected;
    }
}
