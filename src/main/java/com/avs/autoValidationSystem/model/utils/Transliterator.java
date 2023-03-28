package com.avs.autoValidationSystem.model.utils;

import org.springframework.stereotype.Component;

public class Transliterator {
    private static char[] abcCyr = {' ','а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п', 'р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я', 'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П', 'Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'
    };
    private static String[] abcLat = {"_","a","b","v","g","d","e","io","zh","z","i","y","k","l","m","n","o","p", "r","s","t","u","f","h","ts","ch","sh","sht","a","i","y","e","yu","ya", "A","B","V","G","D","E","Io","Zh","Z","I","Y","K","L","M","N","O","P", "R","S","T","U","F","H","Ts","Ch","Sh","Sht","A","I","Y","e","Yu","Ya"};


    public static String convertCyrToLat(String s){
        StringBuilder english = new StringBuilder();
        boolean temp = true;
        for (int i = 0; i < s.length(); i++) {
            temp = true;
            for(int j = 0; j < abcCyr.length; j++ ) {
                if (s.charAt(i) == abcCyr[j]) {
                    temp = false;
                    english.append(abcLat[j]);
                    break;
                }
            }
            if(temp){
                english.append(s.charAt(i));
            }
        }
        return english.toString();
    }
}
