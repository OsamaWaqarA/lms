abstract class frame_book extends Data_handling{
    abstract String remove_book(String isbn);
    abstract String return_book(String id);
    abstract boolean can_issue(String isbn);
    abstract String get_book_name(String isbn);
    abstract String Add_books(String name,String isbn,String Authorname,String Qty);
    abstract String issue_book(String isbn,String id);
    
}
