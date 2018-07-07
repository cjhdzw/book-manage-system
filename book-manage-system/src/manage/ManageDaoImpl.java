package manage;

import util.DbUtil;

import java.util.ArrayList;
import java.util.Map;

public class ManageDaoImpl implements ManageDao{
    @Override
    public Manage getOne(String username) throws Exception {
        Manage manage = null;
        String sql = "select * from manage where username = ?";
        ArrayList<Object> list = new ArrayList<>();
        list.add(username);
        for(Map<String,Object> m:DbUtil.executeQuery(sql,list)){
            manage = new Manage();
            manage.setUsername(username);
            manage.setPassword((String)m.get("password"));
        }
        return manage;
    }

    @Override
    public int update(Manage manage) throws Exception {
        String sql = "update manage set password = ? where username = ?";
        ArrayList<Object> list =  new ArrayList<>();
        list.add(manage.getPassword());
        list.add(manage.getUsername());
        return DbUtil.executeUpdate(sql,list);
    }
}
