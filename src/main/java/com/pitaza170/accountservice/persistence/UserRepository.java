package com.pitaza170.accountservice.persistence;


import com.pitaza170.accountservice.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public int findNextId() {
        return namedParameterJdbcTemplate.queryForObject(FIND_NEXT_ID, Map.of(),
                (rs, rowNum) -> rs.getInt(1));
    }


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

 /*   public Boolean checkUser(String login, String password) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("login", login)
                .addValue("password", password);

        return namedParameterJdbcTemplate.queryForObject(
          CHECK_USER, parameterSource, );
        );
    }
*/

    private static final RowMapper<UserEntity> MAPPER = (rs, rn) -> new UserEntity(
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


}





