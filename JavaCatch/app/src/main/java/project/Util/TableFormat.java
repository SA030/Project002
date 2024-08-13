package project.Command.Util;

public class TableFormat extends Kor{
	
	//Table Title 출력
	public static void printTableTitle(int[] width, String[] title){
        printTableLine(width);
        printTableData(width, title);
        printTableLine(width);
    }
	
    //가로선 출력
    //너비 배열 입력 시 가로선 출력
    //  +----+---------------+---------------+---------------+
    //width: 가로 너비
    public static void printTableLine(int[] width){
        StringBuilder str;

        //start "+"
        str = new StringBuilder("+");
        // str += "----+"
        for (int j : width) {
            str.append("-".repeat(j));
            str.append("+");
        }
        //end "\n"
        str.append("\n");

        System.out.print(str.toString());
    }//Method printLine END



	//표 내용 1줄 출력
    public static void printTableData(int[] width, String[] data){
		StringBuilder str = new StringBuilder();
		int cnt = 0;
		
		for(String d : data){
			str.append(printTableDataFormat(width[cnt++], d));
		}
        str.append(":\n");

        System.out.print(str.toString());
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
        str = "|" + printfKOR("%-"+width+"s", data);

        return str;
    }//Method printUserFormat END

}
