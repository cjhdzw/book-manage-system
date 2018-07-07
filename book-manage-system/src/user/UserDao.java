package user;

public interface UserDao {
    public int insert(User user) throws Exception;
    public int delete(String username) throws Exception;
    public int update(User user) throws Exception;
    public User getOne(String username) throws Exception;
}
