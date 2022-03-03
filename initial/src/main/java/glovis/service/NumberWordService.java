package glovis.service;

import glovis.util.Translator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import glovis.util.NumberWordUtils;

@Component
public class NumberWordService {

    Logger logger = Logger.getLogger(NumberWordService.class.getName());

    public String convert(String langCode, double number) {
        if (number == 0) { return "zero"; }
        String resultTest = "";
        try{
            String snumber = Double.toString(number);
            // pad with "0"
            String mask = "000000000000000000000";
            DecimalFormat df = new DecimalFormat(mask);
            snumber = df.format(number);
            int quintillionDigit = 21;
           for(int i=0; i < snumber.length(); i += 3 ){
               int rangeIndex = i+3;
               int value = Integer.parseInt(snumber.substring( i, rangeIndex));

               String convertWord = this.extractToWord(value, NumberWordUtils.largeNumber.get(quintillionDigit-rangeIndex));

               resultTest += convertWord;
            }
            // remove extra spaces
            resultTest.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
            resultTest = Translator.translate("en", langCode, resultTest);
        } catch (Exception e){
            logger.log(Level.WARNING, e.getMessage());
        }

        return resultTest;
    }

    public String extractToWord(int numValue, String word){
        StringBuilder extractWord = new StringBuilder();
        word = StringUtils.isEmpty(word) ? "" : word;
        if(numValue > 0){
            extractWord.append(NumberWordUtils.getInstance().convertLessThanOneThousand(numValue)+NumberWordUtils.BLANK_SPACE+word);
        }
        return extractWord.toString();
    }
}
