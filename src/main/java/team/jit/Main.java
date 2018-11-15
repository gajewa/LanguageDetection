package team.jit;

import com.detectlanguage.errors.APIError;
import team.jit.Comparator.LanguageDetectorComparator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, APIError {
        LanguageDetectorComparator comparator = new LanguageDetectorComparator("your_api_key");
        comparator.setNewFile("en.txt");
        comparator.detect("en");
        comparator.printResult();

        comparator.setNewFile("pl.txt");
        comparator.detect("pl");
        comparator.printResult();
    }
}
