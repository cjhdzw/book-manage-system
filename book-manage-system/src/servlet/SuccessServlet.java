package servlet;

import book.Book;
import book.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SuccessServlet",value = "/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String method = request.getParameter("method");
        if(method.equals("insert")){
            response.sendRedirect("updateBook.jsp");
        }else if(method.equals("update")){
            String bookname = request.getParameter("post");
            BookDaoImpl bdi = new BookDaoImpl();
            try {
                request.setAttribute("book",bdi.getOne(bookname));
                request.getRequestDispatcher("updateBook.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            String bookname = request.getParameter("post");
            BookDaoImpl bdi = new BookDaoImpl();
            try {
                bdi.delete(bookname);
                response.sendRedirect("LoginServlet");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
