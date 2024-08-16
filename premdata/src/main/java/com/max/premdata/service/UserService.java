package com.max.premdata.service;

import com.max.premdata.entity.Users;
import com.max.premdata.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public List<Users> getAllUsers(){
        return (List<Users>) userDAO.findAll();
    }
}
