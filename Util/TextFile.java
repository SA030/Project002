import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class TextFile{
    private final String PATH;
    private final File F = new File(PATH);
    private ArrayList<String> F_list = new ArrayList<>();
    private LinkedList<bitcamp.project3.controller.MbtiCommand.Score> scoreList = new LinkedList<>();



    ///////////////////////////////////////////////////////////
    ////////////////////// Constructor ////////////////////////
    ///////////////////////////////////////////////////////////
    public TextFile(String PATH){
		this.PATH = PATH;
        setFlist();
    }




    ///////////////////////////////////////////////////////////
    ///////////////////////// Method //////////////////////////
    ///////////////////////////////////////////////////////////
    private void setFlist() {
		if(isExistsFile()){
			File[] contents = F.listFiles();
			try{
				BufferedReader br = new BufferedReader(new FileReader(F));

				String str = br.readLine();
				while(str != null){
					F_list.add(str);
					str = br.readLine();
				}

				br.close();
			} catch (NullPointerException e){ // null이 있을 경우
				e.getStackTrace();
			} catch (FileNotFoundException e){ // 파일을 찾을 수 없는 경우
				e.getStackTrace();
			} catch (IOException e){ // 파일 읽기 중 에러가 발생한 경우
				e.getStackTrace();
			}
		}
    }


    private boolean isExistsFile(){
        if(!F.exists()){
            System.out.print("해당 경로에 아래 파일을 다운받아주세요.\n" + PATH);
            return false;
        }
        return true;
    }
	
	///////////////////////////////////////////////////////////
	///////////////// public getter, setter ///////////////////
	///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////
	//////////////////////////// -- ///////////////////////////
	//////////////////////////// -- ///////////////////////////
	//////////////////////////// -- ///////////////////////////
	//////////////////////// ---------- ///////////////////////
	////////////////////////// ------ /////////////////////////
	//////////////////////////// -- ///////////////////////////
	///////////////////////////////////////////////////////////
	
	public static ArrayList<String> getFile(){
		return F_list;
	}
  
  
}//Class MbtiCommand END
