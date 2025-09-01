
public class Account extends Data_handling{
    public String login(String password){
        String[] passcode = super.read_File("login");

        if (passcode[0].equals(password)){
           return "successful";
        }
        else{
            return "not_successful";
        }
    }

    public String Change_password(String password){
        String[] datas = new String[1];
        if (password.length() < 3){
            return "Please enter a password longer then 3";
        }
        datas[0] = password;
        return this.write_to_file(datas, "login");

    }

}
