package manage;

public interface ManageDao {
    public Manage getOne(String username) throws Exception;
    public int update(Manage manage) throws Exception;
}
