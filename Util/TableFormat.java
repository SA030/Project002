import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class TableFormat {
	
	
	public static void printTable(int[] width, String[] data){
		
	}
	
    //가로선 출력
    //너비 배열 입력 시 가로선 출력
    //  +----+---------------+---------------+---------------+
    //width: 가로 너비
    private static String printTableLine(int[] width){
        StringBuilder str;

        //start "+"
        str = new StringBuilder("+");
        // str += "----+"
        for(int i=0 ; i<width.length ; i++) {
            str.append("-".repeat(width[i]));
            str.append("+");
        }
        //end "\n"
        str.append("\n");

        return str.toString();
    }//Method printLine END



	//표 내용 1줄 출력
	private static String printTableData(int[] width, String[] data){
		String str = "";
		int cnt = 0;
		
		for(String data : data){
			str += printTableDataFormat(width[cnt++], data);
		}
		
		return str;
	}


    //표 내용 출력
    //너비 배열과 데이터 입력 시 표에 맞게 출력
    //for(printUserFormat)사용하여 한줄 출력 가능
    //  "|root           "
    //width: 가로길이
    //data(String): 정보
    private static String printTableDataFormat(int width, String data){
        String str = "";
        //start "|"
        str = "|" +
                String.format(koreanFormat(width, data), data);

        return str;
    }//Method printUserFormat END








	//printf(kor)
	private static String printf(String str, String data){
		int width = getWidth(str);
		return koreanFormat(data, width);
	}


    //format(koean)
    private static String koreanFormat(String data, int width){
        int cnt = getByteWord(data);
        String str ="";

        str = "%-"+ (width-cnt) +"s";
        return str;

    }

	//get Width
	private static int getWidth(String str){
		String[] str1 = stringSplitStart(str);
		String[] str2 = stringSplitEnd(str1[1]);
		return Integer.parseInt(str2[0]);
	}
	
	
	//Check Char Byte(korean)
    private static int getByteWord(String word){
        char[] arr = word.toCharArray();
        int cnt = 0;

        for(char w : arr){
            if(Pattern.matches("^[가-힣]*$", String.format("%c", w) ) ){
                cnt++;
            }
        }

        return cnt;
    }

    //Check String Byte
    private static int getByteString(String word){
        if(getType(word)) {
            try {
                return word.getBytes("euc-kr").length;
            } catch (UnsupportedEncodingException e) {
                return 0;
            }
        }
        return 0;
    }

    //get type(korean?)
    private static boolean getType(String word){
        return Pattern.matches("^[가-힣]*$", word);
    }
	
	//str Split %
	private static String[] stringSplitStart(String str){
        return str.split("%");
    }

	//str Split s
	private static String[] stringSplitEnd(String str){
        return str.split("s");
    }

}
