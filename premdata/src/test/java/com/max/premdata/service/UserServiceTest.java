package com.max.premdata.service;

import com.max.premdata.repository.UserDAO;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userService;


//    @Test
//    public void testGetAllUsers() {
//
//        // Arrange
//        Users user1 = new Users(1, "User1");
//        Users user2 = new Users(2, "User2");
//
//        List<Users> users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);
//
//        when(userDAO.findAll()).thenReturn(users);
//
//        // Act
//        List<Users> result = userService.getAllUsers();
//
//        // Assert
//        assertEquals(2, result.size());
//
//        System.out.println(result.get(0).toString());
//        assertEquals("User1", result.get(0).getName());
//        assertEquals("User2", result.get(1).getName());
//
//
//    }
}
