package com.example.demo.Pr1.Service;

import com.example.demo.Pr1.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final String user = "user";
    private static final String password = "password";
    private static final String url = "jdbc:postgresql://postgresqldb:5432/appdb";

    public List<UserEntity> findAll(){

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from public.users");

            List<UserEntity> people = new ArrayList<>();
            while(resultSet.next()){
                UserEntity current = new UserEntity();
                current.setId(resultSet.getLong("id"));
                current.setName(resultSet.getString("name"));
                current.setSurname(resultSet.getString("surname"));

                people.add(current);
            }
            connection.close();
            return people;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}



