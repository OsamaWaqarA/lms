import java.time.LocalDateTime;

public class book extends frame_book {

    public String remove_book(String isbn){
        String ans =  this.del_file(isbn);
        return ans;
    }

    public String return_book(String id){
        String[] hold;
        long fine;
        hold = this.read_File(id);
        int num = 0;
        while (true){
            if (hold[num] == null){
                break;
            }
            num++;
        }
        String[] parts = hold[num-1].split(",");//0issued  1 dt 2 isbn
        LocalDateTime rt = LocalDateTime.parse(parts[1]);
        LocalDateTime currentTime = LocalDateTime.now();
        long daysDifference = currentTime.toLocalDate().toEpochDay() - rt.toLocalDate().toEpochDay();
        if (daysDifference > 5){
            fine = (daysDifference - 5) * 1000;
            System.out.println("You have to pay a fine of "+fine);
        }    

        String line = "Returned,"+currentTime+parts[2];
        String ans = this.Add_a_line_to_file(line,id);
        if (ans.equals("un_successful")){
            return ans;
        }

        hold = this.read_File(parts[2]);
        num = 0;
        while (true){
            if (hold[num] == null){
                break;
            }else{
                num += 1;
            }
        }
        String[] hold2 = new String[num];
        int number;
        System.arraycopy(hold, 0, hold2, 0, num);
        try {
            number = Integer.parseInt(hold2[2].trim());
            number += 1;
            hold2[2] = "" +number;

            number = Integer.parseInt(hold2[3].trim());
            number -= 1;
            hold2[3] = "" +number;

        } catch (NumberFormatException e) {
            return "not_successful";
        }
        ans = this.write_to_file(hold2,parts[2]);
        return ans;
    }

    public boolean can_issue(String isbn){
        String[] hold;
        hold = this.read_File(isbn);
        int number;
        try {
        
            number = Integer.parseInt(hold[2].trim());
            if (number >0){
                return true;
            }else{
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }
        
    }

    public String get_book_name(String isbn){
        String[] hold;
        hold = this.read_File(isbn);
        return hold[0];
    }

    public String Add_books(String name,String isbn,String Authorname,String Qty){
        String ans;
        ans = super.create_file(isbn);
        if (ans.equals("successful")){
            String[] datas = new String[4];
            datas[0] = name;
            datas[1] = Authorname;
            datas[2] = Qty;
            datas[3] = "0";
            return super.write_to_file(datas, isbn);
        }else{
            return "The book is already registered";
        }
    }

    public String issue_book(String isbn,String id){
        LocalDateTime currentTime = LocalDateTime.now();
        String line = "Issued,"+currentTime+","+isbn;
        String ans = this.Add_a_line_to_file(line,id);
        if (ans.equals("not_successful")){
            return "not_successful";
        }
        String[] hold;
        hold = this.read_File(isbn);
        int num = 0;
        while (true){
            if (hold[num] == null){
                break;
            }else{
                num += 1;
            }
        }
        String[] hold2 = new String[num];
        int number;
        System.arraycopy(hold, 0, hold2, 0, num);
        try {
            number = Integer.parseInt(hold2[2].trim());
            number -= 1;
            hold2[2] = "" +number;

            number = Integer.parseInt(hold2[3].trim());
            number += 1;
            hold2[3] = "" +number;

        } catch (NumberFormatException e) {
            return "not_successful";
        }
        ans = this.write_to_file(hold2,isbn);
        return ans;
    }
}
