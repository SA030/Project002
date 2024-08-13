package project.Util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;


//printf("%s", String);
public class Kor {

    private static final String WORD = "^[가-힣]*$";
    private static String str = "";
    private static String data = "";
    private static int width = 0;

	public static String printfKOR(String str, String data){
        setKor(str, data);
		return String.format( koreanFormat(), data );
	}

    private static void setKor(String str, String data){
        Kor.str = str;
        Kor.data = data;
        Kor.width = getWidth();
    }

    //format(korean)
    private static String koreanFormat(){
        int cnt = getByteWord();
        String[] splitData = stringSplitHyphen(str);
        String str ="";

        if(splitData[0].equals("%")){
            str = "%-"+ (width-cnt) +"s";
        }else{
            str = "%"+ (width-cnt) +"s";
        }

        return str;

    }

	//get Width
	private static int getWidth(){
		String[] str1 = stringSplitStart(str);
		String[] str2 = stringSplitEnd(str1[1]);
        String[] str3 = stringSplitHyphen(str2[0]);

		return str3[0].isEmpty() ?Integer.parseInt(str3[1]):Integer.parseInt(str3[0]);
	}
	
	
	//Check Char Byte(korean)
    private static int getByteWord(){
        char[] arr = data.toCharArray();
        int cnt = 0;

        for(char w : arr){
            if(Pattern.matches(WORD, String.format("%c", w) ) ){
                cnt++;
            }
        }

        return cnt;
    }

    //Check String Byte
    private static int getByteString(){
        if(getType(data)) {
            try {
                return data.getBytes("euc-kr").length;
            } catch (UnsupportedEncodingException e) {
                return 0;
            }
        }
        return 0;
    }

    //get type(korean?)
    private static boolean getType(String word){
        return Pattern.matches(WORD, word);
    }
	
	//str Split %
	private static String[] stringSplitStart(String str){
        return str.split("%");
    }

	//str Split s
	private static String[] stringSplitEnd(String str){
        return str.split("s");
    }

    //str Split -
    private static String[] stringSplitHyphen(String str) { return str.split("-"); }

}
