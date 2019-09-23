package loginDemo;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public  User checkLogin(User user) {
        try {
            String sql = "select * from user where username=? and password=?";
            User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    user.getUsername(), user.getPassword());
            return user1;
        } catch (Exception e) {
            return null;
        }
    }
}
