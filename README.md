# Project: Glovis Coding Test

## Installations
Hello welcome to the tech team! Start off by installing the components below.

Java JDK (Java 8. Java version above it will not work yet for our project)
IDE (Eclipse, IntelliJ IDEA)

## Getting the Source Code
Obtain the source code from the yusuf's private in Github repository at https://github.com/yusuf1998/glovis-number-to-word .

## Importing the Project
Import the project into your preferred IDE

## Building the project
Using command line, clean and build the project:

> 1./gradlew clean build -x test --info

The -x test command skips the testing task.

You can run the Project directly by

> 1./gradlew bootRun


## End-point: get convert number to word
> {{host}}/number-word?lang={{langCode}}&num={{numberValue}}}

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
|lang|en|
|num|123456789|


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
