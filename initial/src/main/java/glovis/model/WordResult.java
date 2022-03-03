package glovis.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class WordResult implements Serializable {
    private static final long serialVersionUID = -3282914508008080205L;
    private String language;
    private String extractToWord;

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExtractToWord() {
        return extractToWord;
    }
    public void setExtractToWord(String extractToWord) {
        this.extractToWord = extractToWord;
    }
}
