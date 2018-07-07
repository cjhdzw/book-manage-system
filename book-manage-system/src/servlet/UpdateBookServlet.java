package servlet;

import book.Book;
import book.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateBookServlet",value = "/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bookname = request.getParameter("bookname");
        String author = request.getParameter("author");
        String press = request.getParameter("press");
        BookDaoImpl bdi = new BookDaoImpl();
        Book book = new Book();
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setPress(press);
        System.out.println(bookname);
        try {
            if(bdi.getOne(bookname)==null){
                bdi.insert(book);
                System.out.println("insert");
            }else {
                bdi.update(book,bookname);
                System.out.println("update");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("LoginServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
