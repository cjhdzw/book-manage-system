package servlet;

import book.BookDaoImpl;
import manage.ManageDaoImpl;
import user.UserDaoImpl;
import util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        UserDaoImpl udi = new UserDaoImpl();
        ManageDaoImpl mdi = new ManageDaoImpl();
        BookDaoImpl bdi = new BookDaoImpl();
        if (session.getAttribute("username") == null) {
            PrintWriter out = response.getWriter();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            try {
                if (udi.getOne(username) == null && mdi.getOne(username) == null) {
                    out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                            "                    alert(\"该用户不存在！！！\");\n" +
                            "                    window.document.location.href=\"index.jsp\";\n" +
                            "          </script>");
                } else {
                    if (mdi.getOne(username) != null) {
                        if (mdi.getOne(username).getPassword().equals(DbUtil.md5(password))) {
                            session.setAttribute("username", username);
                            request.setAttribute("bookList", bdi.getList());
                            request.getRequestDispatcher("manageSuccess.jsp").forward(request, response);
                        } else {
                            out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                                    "                    alert(\"密码错误！！！\");\n" +
                                    "                    window.document.location.href=\"manageLogin.jsp\";\n" +
                                    "          </script>");
                        }
                    }
                    if (udi.getOne(username) != null) {
                        if (udi.getOne(username).getPassword().equals(DbUtil.md5(password))) {
                            session.setAttribute("username", username);
                            request.setAttribute("bookList", bdi.getList());
                            request.getRequestDispatcher("userSuccess.jsp").forward(request, response);
                        } else {
                            out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                                    "                    alert(\"密码错误！！！\");\n" +
                                    "                    window.document.location.href=\"userLogin.jsp\";\n" +
                                    "          </script>");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                request.setAttribute("bookList", bdi.getList());
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("manageSuccess.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
