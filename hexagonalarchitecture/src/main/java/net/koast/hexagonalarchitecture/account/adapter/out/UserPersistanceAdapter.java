package net.koast.hexagonalarchitecture.account.adapter.out;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import net.koast.hexagonalarchitecture.account.application.out.AddUserPort;
import net.koast.hexagonalarchitecture.account.domain.UserEntity;

@Component
public class UserPersistanceAdapter implements AddUserPort {

  private final JdbcTemplate template;
  
  public UserPersistanceAdapter(DataSource dataSource) {
    this.template = new JdbcTemplate(dataSource);
  }

  public boolean checkUserId(UserEntity entity) throws Exception {
    System.out.println("=== checkUserId ===");
    String sql = "SELECT COUNT(*) FROM HEX_USER WHERE USER_ID = ?";
    Integer count = template.queryForObject(sql, Integer.class, entity.getUserId());
    if(count == 0) return true;
    else return false;
  }
  
  public boolean addUser(UserEntity entity) throws Exception {
    System.out.println("=== addUser ===");
    String sql = "INSERT INTO HEX_USER (USER_ID, NAME, PASSWORD) VALUES (?, ?, ?)";
    template.update(sql, entity.getUserId(), entity.getName(), entity.getPassword());
    return true;
  }
}
