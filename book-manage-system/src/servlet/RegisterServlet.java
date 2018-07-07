package servlet;

import user.User;
import user.UserDaoImpl;
import util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        UserDaoImpl udi = new UserDaoImpl();
        if(username.equals("") || password1.equals("") || password2.equals("")){
            out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                    "                    alert(\"用户名或密码不能为空！！！\");\n" +
                    "                    window.document.location.href=\"register.jsp\";\n" +
                    "          </script>");
        }
        else {
            try {
                if(udi.getOne(username)!=null){
                    out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                            "                    alert(\"用户名已存在！！！\");\n" +
                            "                    window.document.location.href=\"register.jsp\";\n" +
                            "          </script>");
                }
                else {
                    if(password1.equals(password2)){
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword(DbUtil.md5(password1));
                        udi.insert(user);
                        out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                                "                    alert(\"注册成功！！！\");\n" +
                                "                    window.document.location.href=\"userLogin.jsp\";\n" +
                                "          </script>");
                    }
                    else {
                        out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                                "                    alert(\"两次密码不一致！！！\");\n" +
                                "                    window.document.location.href=\"register.jsp\";\n" +
                                "          </script>");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
