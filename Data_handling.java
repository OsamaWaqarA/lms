import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Data_handling {

    public String del_file(String name){
        File fileObj = new File(name+".txt");
        String[] hold;
        int num = 0,loc = 0;
        hold = this.read_File("dir");
        while (true){
            if (hold[num] == null){
                break;
            }else if(hold[num].equals(name)){
                loc = num;
            }
            num += 1;
        }
        if (loc == num-1){
            hold[num-1] = null;
        }else{
            hold[loc] = hold[num-1];
            hold[num-1] = null;
        }
        String[] datas = new String[num-1];
        System.arraycopy(hold, 0, datas, 0, num-1);
        String ans = this.write_to_file(datas, "dir");
        if (ans.equals("un_successful")){
            return ans;
        }else{
            if (fileObj.delete()){
                return "sucessful";
            }else{
                return "un_successful";
            }
        }
        
    }

    public void delay(int time){
        while (true){
            try {
                Thread.sleep(time);
                break;
            } catch (InterruptedException e) {
                
            }
        }
    }

    public String create_file(String name){
        try{
            File fileObj = new File(name+".txt");
            if (fileObj.createNewFile()){
                String ans = this.Add_a_line_to_file(name, "dir");
                if (ans.equals("not_successful")){
                    return "not_successful";
                }
                return "successful";
            }else{
                return "File already exists";
            }
        }catch(IOException e){
            return "not_successful";
        }

    }

    public String write_to_file(String[] datas,String name ){
        try{
            FileWriter fileObj = new FileWriter(name+".txt");
            for(int i = 0;i < datas.length;i++){
                fileObj.write(datas[i]);
                fileObj.write("\n");
            }
            fileObj.close();
            return "successfull";
        }catch(IOException e){
            return "Not_successfull";

        }

    }

    public String Add_a_line_to_file(String line,String name ){
        String[] hold;
        hold = this.read_File(name);
        int num = 0;
        while (true){
            if (hold[num] == null){
                break;
            }else{
                num += 1;
            }
        }
        String[] hold2 = new String[num+1];
        System.arraycopy(hold, 0, hold2, 0, num);
        hold2[num] = line;
        String ans = this.write_to_file(hold2, name);
        if (ans.equals("not_successful")){
            return "not_successful";
        }
        return "successful";

    }

    public String[] read_File(String name){
        String[] datas = new String[500];
        int count = 0;
        try {
            File fileObj = new File(name+".txt");
            Scanner myReader = new Scanner(fileObj);
            while (myReader.hasNextLine()) {
                datas[count] = myReader.nextLine();
                count += 1;
            }
            myReader.close();
            return datas;
            } catch (FileNotFoundException e) {
                datas[0] = "un_successful";
                return datas;
            }
    }
    
}
