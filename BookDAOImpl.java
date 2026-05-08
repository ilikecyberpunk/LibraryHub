import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    //임시로 저장 지금은 db없음
    private ArrayList<Book> storage = new ArrayList<>();
    
    @Override
    public void addBook(Book book){
        storage.add(book);
        System.out.println("추가됨 : " + book.getTitle());
    }

    @Override
    public Book findById(int bookId){
        for(Book b : storage){
            if(b.getBookId() == bookId){
                return b;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Book> findAll(){
        return storage;
    }

    @Override
    public void updateBook(Book book){
        for(int i = 0; i < storage.size(); i++){
            if(storage.get(i).getBookId() == book.getBookId()){
                storage.set(i, book);
                return;
            }
        }
    }

    @Override
    public void deleteBook(int BookId){
        for(int i = 0; i < storage.size(); i++){
            if(storage.get(i).getBookId() == BookId){
                storage.remove(i);
                return;
            }
        }
    }


}
