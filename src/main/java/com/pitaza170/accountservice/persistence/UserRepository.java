package com.pitaza170.accountservice.persistence;


import com.pitaza170.accountservice.domain.User;
import com.pitaza170.accountservice.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Repository
@AllArgsConstructor
@Slf4j
public class UserRepository {
    private static final String INSERT_INTO =
            "INSERT INTO users(id, name, surname, user_id, login, password, role, registered, status, created) " +
                    "VALUES(:id, :name, :surname, :user_id, :login, :password, :role, :registered, :status, :created) " +
                    "RETURNING * ;";

    private static final String FIND_NEXT_ID =
            "SELECT nextval('users_id_seq');";

    private static final String CHECK_USER  =
            "SELECT user_id FROM users WHERE login AND password IN (:login, :password);";

    private static final String UPDATE_STATUS =
            "UPDATE users SET status = ? WHERE user_id = ?";
    private static final String GET_USER =
            "SELECT * FROM users WHERE user_id = ?";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;
    public int findNextId() {
        return namedParameterJdbcTemplate.queryForObject(FIND_NEXT_ID, Map.of(),
                (rs, rowNum) -> rs.getInt(1));
    }


    @Transactional
    public UserEntity save(UserEntity orderEntity) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", orderEntity.getId())
                .addValue("name", orderEntity.getName())
                .addValue("surname", orderEntity.getSurname())
                .addValue("user_id", orderEntity.getUserId())
                .addValue("login", orderEntity.getLogin())
                .addValue("password", orderEntity.getPassword())
                .addValue("role", orderEntity.getRole())
                .addValue("registered", orderEntity.isRegistered())
                .addValue("status", orderEntity.isStatus())
                .addValue("created", orderEntity.getCreated());

        return namedParameterJdbcTemplate.queryForObject(
                INSERT_INTO, parameterSource, MAPPER);
    }

    public User getUserById(String userId) {
        return jdbcTemplate.queryForObject(
                GET_USER, new Object[] {userId},
                (rs, rowNum) -> {
                    User user = new User();
                    user.setId(Integer.parseInt(rs.getString("user_id")));
                    user.setName(rs.getString("name"));
                    user.setSurname(rs.getString("surname"));
                    user.setLogin(rs.getString("login"));
                    user.setStatus(Boolean.parseBoolean(rs.getString("created")));
                    user.setStatus(Boolean.parseBoolean(rs.getString("status")));
                    return user;
                });
    }
    @Transactional
    public void updateStatus(String userId, Boolean status) {
         jdbcTemplate.update(UPDATE_STATUS, status, userId);
    }

 /*   public Boolean checkUser(String login, String password) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("login", login)
                .addValue("password", password);

        return namedParameterJdbcTemplate.queryForObject(
          CHECK_USER, parameterSource, );
        );
    }
*/
    private static final RowMapper<UserEntity> MAPPER = (rs, rn) -> {
        return new UserEntity(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("user_id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("role"),
                rs.getBoolean("registered"),
                rs.getBoolean("status"),
                rs.getTimestamp("created")
        );
    };





}





