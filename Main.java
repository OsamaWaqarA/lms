import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Account acc = new Account();
        book Book = new book();
        Students student = new Students();
        String ans;
        int op;
        Scanner Getdata = new Scanner(System.in);
        System.out.print("Enter password: ");
        ans = acc.login(Getdata.nextLine());
        if (ans.equals("successful")){
            while (true){
                acc.delay(1000);
                System.out.println("\nPress 1: To add a book");
                acc.delay(100);
                System.out.println("Press 2: To add a student");
                acc.delay(100);
                System.out.println("Press 3: To issue a book");
                acc.delay(100);
                System.out.println("Press 4: To return a book");
                acc.delay(100);
                System.out.println("Press 5: To check student history");
                acc.delay(100);
                System.out.println("Press 6: To remove student");
                acc.delay(100);
                System.out.println("Press 7: To remove book");
                acc.delay(100);
                System.out.println("Press 10: To change password");
                op = Getdata.nextInt();
                Getdata.nextLine();
                if (op == 10){
                    System.out.println("Enter the new password ");
                    System.out.println(acc.Change_password(Getdata.nextLine()));
                }else if (op == 1) {
                    String ISBN;
                    while (true){
                        System.out.print("Enter the ISBN number: ");
                        ISBN = Getdata.nextLine();
                        if (ISBN.length() == 13){
                            break;
                        }else{
                            System.out.println("Please Enter a 13 digit ISBN number");
                        }

                    }
                    System.out.print("Enter the Author's name: ");
                    String aname = Getdata.nextLine();
                    System.out.print("Enter the amount of books you have: ");
                    String Qty = Getdata.nextLine();
                    System.out.print("Enter name of the book: ");
                    System.out.println(Book.Add_books(Getdata.nextLine(),ISBN ,aname, Qty));

                }else if (op == 2){
                    System.out.print("Enter the name of the student: ");
                    String name = Getdata.nextLine();
                    String roll;
                    while (true){
                        System.out.print("Enter the roll number of the student: ");
                        roll =Getdata.nextLine();
                        if (roll.length() == 7){
                            break;
                        }else{
                            System.out.println("Please enter a 7 digit number");
                        }
                    }
                    System.out.println(student.add_student(name,roll));
                }else if(op == 3){
                    String[] hold;
                    System.out.println("Please select a student :");
                    acc.delay(250);
                    hold = acc.read_File("dir");
                    int st;
                    while (true){
                        for (int i = 0;i<= 500;i++){
                            if (hold[i] == null){
                                break;
                            }
                            if (hold[i].length() == 7){
                                System.out.println("Press "+i+": For '"+student.get_name(hold[i])+"'");
                                acc.delay(100);
                            }
                        }

                        st = Getdata.nextInt();
                        Getdata.nextLine();
                        if (student.can_issue(hold[st])){
                            break;
                        }else{
                            System.out.println("This Student cannot isuue a book he/she has already issued a book");
                        }
                    }

                    System.out.println("Please select a book :");
                    acc.delay(250);

                    for (int i=0;i<=500;i++){
                        if (hold[i] == null){
                            break;
                        }

                        if (hold[i].length() == 13){
                            if (Book.can_issue(hold[i])){
                                System.out.println("Press "+i+": For '"+Book.get_book_name(hold[i])+"'");
                            }
                        }
                    }
                    int b = Getdata.nextInt();
                    Getdata.nextLine();

                    System.out.println(Book.issue_book(hold[b], hold[st]));
                }else if(op == 4){
                    String[] hold;
                    System.out.println("Please select a student :");
                    acc.delay(250);
                    hold = acc.read_File("dir");
                    int st;
                    while (true){
                        for (int i = 0;i<= 500;i++){
                            if (hold[i] == null){
                                break;
                            }
                            if (hold[i].length() == 7){
                                System.out.println("Press "+i+": For '"+student.get_name(hold[i])+"'");
                                acc.delay(100);
                            }
                        }

                        st = Getdata.nextInt();
                        Getdata.nextLine();
                        if (student.can_issue(hold[st]) != true){
                            break;
                        }else{
                            System.out.println("This Student cannot Return a book he/she has not issued a book");
                        }
                    }

                    System.out.println(Book.return_book(hold[st]));

                }else if (op == 5){
                    String[] hold;
                    System.out.println("Please select a student :");
                    acc.delay(250);
                    hold = acc.read_File("dir");
                    int st;
                    for (int i = 0;i<= 500;i++){
                        if (hold[i] == null){
                            break;
                        }
                        if (hold[i].length() == 7){
                            System.out.println("Press "+i+": For '"+student.get_name(hold[i])+"'");
                            acc.delay(100);
                        }
                    }

                    st = Getdata.nextInt();
                    Getdata.nextLine();
                    student.history(hold[st]);

                }else if(op == 6){

                    String[] hold;
                    System.out.println("Please select a student :");
                    acc.delay(250);
                    hold = acc.read_File("dir");
                    int st;
                    for (int i = 0;i<= 500;i++){
                        if (hold[i] == null){
                            break;
                        }
                        if (hold[i].length() == 7){
                            System.out.println("Press "+i+": For '"+student.get_name(hold[i])+"'");
                            acc.delay(100);
                        }
                    }

                    st = Getdata.nextInt();
                    Getdata.nextLine();
                    System.out.println(student.remove_student(hold[st]));

                }else if(op == 7){

                    String[] hold;
                    System.out.println("Please select a student :");
                    acc.delay(250);
                    hold = acc.read_File("dir");
                    int st;
                    for (int i = 0;i<= 500;i++){
                        if (hold[i] == null){
                            break;
                        }
                        if (hold[i].length() == 13){
                            if (Book.can_issue(hold[i])){
                                System.out.println("Press "+i+": For '"+Book.get_book_name(hold[i])+"'");
                            }
                        }
                    }

                    st = Getdata.nextInt();
                    Getdata.nextLine();
                    System.out.println(Book.remove_book(hold[st]));

                }
            }
        }else{
            System.out.println("You have enter the wrong password");
        }
        Getdata.close();
    }
}
