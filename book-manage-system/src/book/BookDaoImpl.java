package book;

import util.DbUtil;

import java.util.ArrayList;
import java.util.Map;

public class BookDaoImpl implements BookDao {

    @Override
    public int insert(Book book) throws Exception {
        String sql = "insert into book(bookname,author,press) values(?,?,?)";
        ArrayList<Object> list =  new ArrayList<>();
        list.add(book.getBookname());
        list.add(book.getAuthor());
        list.add(book.getPress());
        return DbUtil.executeUpdate(sql,list);
    }

    @Override
    public int delete(String bookname) throws Exception {
        String sql = "delete from book where bookname = ?";
        ArrayList<Object> list =  new ArrayList<>();
        list.add(bookname);
        return DbUtil.executeUpdate(sql,list);
    }

    @Override
    public int update(Book book,String oldname) throws Exception {
        String sql = "update book set bookname = ?, author = ?, press = ? where bookname = ?";
        ArrayList<Object> list =  new ArrayList<>();
        list.add(book.getBookname());
        list.add(book.getAuthor());
        list.add(book.getPress());
        list.add(oldname);
        return DbUtil.executeUpdate(sql,list);
    }

    @Override
    public Book getOne(String bookname) throws Exception {
        Book book = null;
        String sql = "select * from book where bookname = ?";
        ArrayList<Object> list =  new ArrayList<>();
        list.add(bookname);
        for(Map<String,Object> m:DbUtil.executeQuery(sql,list)){
            book = new Book();
            book.setBookname((String)m.get("bookname"));
            book.setAuthor((String)m.get("author"));
            book.setPress((String)m.get("press"));
        }
        return book;
    }

    @Override
    public ArrayList<Book> getList() throws Exception {
        String sql = "select * from book ";
        ArrayList<Book> bookList = new ArrayList<>();
        for(Map<String,Object> m:DbUtil.executeQuery(sql,null)){
            Book book = new Book();
            book.setBookname((String)m.get("bookname"));
            book.setAuthor((String)m.get("author"));
            book.setPress((String)m.get("press"));
            bookList.add(book);
        }
        return bookList;
    }
}
