package servlet;

import manage.Manage;
import manage.ManageDaoImpl;
import user.User;
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
import java.util.Date;

@WebServlet(name = "UpdateServlet",value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        UserDaoImpl udi = new UserDaoImpl();
        ManageDaoImpl mdi = new ManageDaoImpl();
        String oldPassword = request.getParameter("oldPassword");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String username = (String)session.getAttribute("username");
        System.out.println(username);
        if(!password1.equals(password2)){
            out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                    "                    alert(\"两次密码不一致！！！\");\n" +
                    "                    window.document.location.href=\"updateU-M.jsp\";\n" +
                    "          </script>");
        }
        else {
            try {
                System.out.println("*************");
                if(udi.getOne(username)!=null){
                    if(!udi.getOne(username).getPassword().equals(DbUtil.md5(oldPassword))){
                        out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                                "                    alert(\"原密码错误！！！\");\n" +
                                "                    window.document.location.href=\"updateU-M.jsp\";\n" +
                                "          </script>");
                    }
                    else {
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword(DbUtil.md5(password1));
                        udi.update(user);
                        out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                                "                    alert(\"密码修改成功！！！\");\n" +
                                "                    window.document.location.href=\"logout.jsp\";\n" +
                                "          </script>");
                    }
                }
                else {
                    if(!mdi.getOne(username).getPassword().equals(DbUtil.md5(oldPassword))){
                        out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                                "                    alert(\"原密码错误！！！\");\n" +
                                "                    window.document.location.href=\"updateU-M.jsp\";\n" +
                                "          </script>");
                    }
                    else {
                        Manage manage = new Manage();
                        manage.setUsername(username);
                        manage.setPassword(DbUtil.md5(password1));
                        mdi.update(manage);
                        out.print("<script type=\"text/javascript\" language=\\\"javascript\\\">\n" +
                                "                    alert(\"密码修改成功！！！\");\n" +
                                "                    window.document.location.href=\"logout.jsp\";\n" +
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
