package glovis.controller;

import glovis.model.BaseJson;
import glovis.model.WordResult;
import glovis.service.NumberWordService;
import glovis.util.NumberWordUtils;
import glovis.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GlovisControllerTest {
	@Autowired
	NumberWordService numberWordService;

	@RequestMapping(value = {"/number-word"}, method = RequestMethod.GET)
	public ResponseEntity<BaseJson> convertNumberToWord(
			@RequestParam(value = "lang", defaultValue = "en") String languageCode
			, @RequestParam(value = "num") String number) {
		BaseJson json = new BaseJson();
		try{
			if(!NumberWordUtils.getInstance().isNumeric(number)){
				json.setResult(false);
				json.setErrorMessage("Field num only accept number");
				return new ResponseEntity(json, HttpStatus.NOT_ACCEPTABLE);
			}
			if(number.length() > 21){
				json.setResult(false);
				json.setErrorMessage("Maximum character is 21");
				return new ResponseEntity(json, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
			}
			WordResult convertResult = new WordResult();
			double numValue = Double.parseDouble(number);

			String resultConvert = numberWordService.convert(languageCode, numValue);

			convertResult.setLanguage(languageCode);
			convertResult.setExtractToWord(Translator.translate("en", languageCode, resultConvert));

			json.setResult(true);
			json.setPayload(convertResult);

			return new ResponseEntity(json, HttpStatus.OK);
		} catch (Exception ex){
			json.setResult(false);
			json.setErrorMessage(ex.getMessage());

			return new ResponseEntity(json, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
