package user;

import util.DbUtil;

import java.util.ArrayList;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public int insert(User user) throws Exception {
        String sql = "insert into user(username,password) values(?,?)";
        ArrayList<Object> list =  new ArrayList<>();
        list.add(user.getUsername());
        list.add(user.getPassword());
        return DbUtil.executeUpdate(sql,list);
    }

    @Override
    public int delete(String username) throws Exception {
        String sql = "delete from user where username = ?";
        ArrayList<Object> list =  new ArrayList<>();
        list.add(username);
        return DbUtil.executeUpdate(sql,list);
    }

    @Override
    public int update(User user) throws Exception {
        String sql = "update user set password = ? where username = ?";
        ArrayList<Object> list =  new ArrayList<>();
        list.add(user.getPassword());
        list.add(user.getUsername());
        return DbUtil.executeUpdate(sql,list);
    }

    @Override
    public User getOne(String username) throws Exception {
        User user = null;
        String sql = "select * from user where username = ?";
        ArrayList<Object> list =  new ArrayList<>();
        list.add(username);
        for(Map<String,Object> m:DbUtil.executeQuery(sql,list)){
            user = new User();
            user.setPassword((String)m.get("password"));
            user.setUsername((String)m.get("username"));
        }
        return user;
    }
}
