package SearchEngine.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IndexRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveIndex(String url, String title, String description, String keywords) {
        String sql = "INSERT INTO indexes (url, title, description, keywords) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, url, title, description, keywords);
    }

    public boolean doesUrlExist(String url) {
        String sql = "SELECT COUNT(*) FROM indexes WHERE url = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, url);
        return count > 0;
    }
}
