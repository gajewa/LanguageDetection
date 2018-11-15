# LanguageDetection
This is a project for testing three language detection libraries for Java.

To try it out insert your text into the language files in the resources folder (you can also leave the existing files or add new ones with different langauges), and then run the Main class with this code:

```
LanguageDetectorComparator comparator = new LanguageDetectorComparator("your_api_key");
comparator.setNewFile(filename);
comparator.detect(languageShort);
comparator.printResult();
```

For example for the English language:
```
LanguageDetectorComparator comparator = new LanguageDetectorComparator("your_api_key");
comparator.setNewFile("en.txt");
comparator.detect("en");
comparator.printResult();
```
