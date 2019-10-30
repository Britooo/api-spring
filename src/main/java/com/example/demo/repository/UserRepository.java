package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate template;
    StringBuilder sql;

    public List<User> list() {

        this.sql = new StringBuilder();

        sql.append(" SELECT");
        sql.append("  id,");
        sql.append("  name,");
        sql.append("  email,");
        sql.append("  passwd ");
        sql.append(" FROM users");

        System.out.println(sql.toString());

        List<User> usersList = template.query(this.sql.toString(), new BeanPropertyRowMapper<User>(User.class));

        return usersList;
    }

    public User get(int id) {

        this.sql = new StringBuilder();

        sql.append(" SELECT");
        sql.append("  id,");
        sql.append("  name,");
        sql.append("  email,");
        sql.append("  passwd ");
        sql.append(" FROM users");
        sql.append(" WHERE id =  ?");

        User user = template.queryForObject(sql.toString(), new Object[] { id },
                BeanPropertyRowMapper.newInstance(User.class));

        return user;
    }
}