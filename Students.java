public class Students extends Data_handling{

    public String remove_student(String id){
        if(this.can_issue(id)){
            return this.del_file(id);
        }else{
            return "Return the book first";
        }
    }

    public void history(String id){
        String[] hold;
        hold = this.read_File(id);
        for (int i = 1;i<= 500;i++){
            if (hold[i] == null){
                break;
            }
            else{
                System.out.println(hold[i]);
                this.delay(100);
            }
        }
        System.out.println("End of the list");
    }

    public String add_student(String name, String rollnum){
        String ans =  this.create_file(rollnum);
        if (ans == "successful"){
            String[] datas = new String[1];
            datas[0] = name;
            return this.write_to_file(datas,rollnum);
        }
        else{
            return ans;
        }
    }

    public String get_name(String id){
        String head[];
        head = this.read_File(id);
        return head[0];
    }

    public Boolean can_issue(String id){
        String hold[];
        hold = this.read_File(id);
        int num = 0;
        while (true){
            if (hold[num] == null){
                break;
            }
            num++;
        }
        if (hold[num-1].contains("Issued")){
            return false;
        }else{
            return true;
        }
    }
    
}
