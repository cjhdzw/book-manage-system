package book;

import java.util.ArrayList;

public interface BookDao {
    public int insert(Book book) throws Exception;
    public int delete(String bookname) throws Exception;
    public int update(Book book,String oldname) throws Exception;
    public Book getOne(String bookname) throws Exception;
    public ArrayList<Book> getList() throws Exception;
}
