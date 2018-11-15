package team.jit.Detector;

import com.google.common.base.Optional;
import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;

import java.io.IOException;
import java.util.List;

public class OptimaizeDetector {
    private LanguageDetector languageDetector;
    private TextObjectFactory textObjectFactory;
    private Integer detected;

    public OptimaizeDetector()throws IOException {
        List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();

        this.languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                .withProfiles(languageProfiles)
                .build();

        this.textObjectFactory = CommonTextObjectFactories.forDetectingOnLargeText();

        this.detected=0;
    }

    public String detect(String textToDetect){
        TextObject text = textObjectFactory.forText(textToDetect);
        Optional<LdLocale> language = languageDetector.detect(text);
        return language.isPresent() ? language.get().getLanguage() : null;
    }

    public void incrementDetectedCount(){
        detected += 1;
    }

    public Integer getDetected(){
        return detected;
    }
}
