# Project: Glovis Coding Test
# 📁 Collection: glovis-number-to-word 


## End-point: get convert number to word
Api that used for convert number to word

#### Parameter

Have 2 request params :

*   **lang** ( defaultValue : en, isNotRequired )  
    lang is parameter that used for translate the word by user preference, using translator engine from whatsmate as third party [whatsmate website](https://www.whatsmate.net/)  
    we can see lang availabe that we can use from this link : [whatsmate - language code support](http://api.whatsmate.net/v1/translation/supported-codes):
*   **num** ( isNotRequired )  
    num is parameter that used for value that we wan to convert to word  
    

### Response

*   It have 4 object within response from this api endpoint :
    *   result (Boolean) : It will give the information that result is **True** or **False**
    *   errorMessage (String) : It will give the information of the root cause of the error
    *   payload ( Object )
        *   language (String) : the language that we set use for convert number to word
        *   extractToWord : value of extracting the number to word
    *   timestamp : a digital record of the time of occurrence when call the api.
### Method: GET
>```
>{{host}}/number-word?lang=id&num=5000
>```
### Query Params

|Param|value|
|---|---|
|lang|id|
|num|5000|


### Response: 200
```json
{
    "result": true,
    "errorMessage": null,
    "payload": {
        "language": "en",
        "extractToWord": " one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine "
    },
    "timestamp": "1646326470494"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
_________________________________________________
Powered By: [postman-to-markdown](https://github.com/bautistaj/postman-to-markdown/)
