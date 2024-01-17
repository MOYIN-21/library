package com.example.eagle.services;

import com.example.eagle.dtos.CreateAccountRequest;
import com.example.eagle.dtos.DeleteAccount;
import com.example.eagle.dtos.LogInRequest;
import com.example.eagle.exceptions.NameAlreadyExistException;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
import com.example.eagle.exceptions.UserNotFoundException;
import com.example.eagle.exceptions.ValidateLoginException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.login.LoginException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ShelfService shelfService;
    private CreateAccountRequest user;

    @BeforeEach
    void setup() throws NameAlreadyExistException {
        user = new CreateAccountRequest();
        user.setUserName("Ola");
        user.setPassword("1");
    }


    @Test
    public void testThatUserCanCreateAccountInLibrary() throws NameAlreadyExistException {
        userService.deleteAll();
        String expected = userService.register(user);
        assertEquals("Account created successfully", expected);
    }
    @Test
    public void testThatOneAccountCanBeCreatedInLibrary() throws NameAlreadyExistException {
        userService.deleteAll();
        userService.register(user);
        CreateAccountRequest user2 = new CreateAccountRequest();
        user2.setUserName("Moyin");
        user2.setPassword("2");
        String expected = userService.register(user2);
        assertEquals("Account created successfully", expected);
    }

    @Test
    public void testThatTwoUsersWithTheSameCredentialsCanNotExistInLibrary() throws NameAlreadyExistException {
      userService.deleteAll();
        userService.register(user);
      CreateAccountRequest createAccountRequest = new CreateAccountRequest();
      createAccountRequest.setUserName("Ola");
      createAccountRequest.setPassword("1");
      assertThrows(NameAlreadyExistException.class, ()-> userService.register(createAccountRequest));
    }

    @Test
    public void testThatUserCanLogInAfterCreatingAccount() throws ValidateLoginException, LoginException, NameAlreadyExistException {
        userService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Olawale Mor");
        user3.setPassword("1");
        String expected = userService.register(user3);
        assertEquals("Account created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Olawale Mor");
        dtos.setPassword("1");
        boolean expected2 = userService.login(dtos);
        assertTrue(expected2);

    }

    @Test
    public void testThatUserCanNotLogInWithWrongCredentials() throws ValidateLoginException, LoginException, NameAlreadyExistException {
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Olawale More");
        user3.setPassword("1");
        user3.getUserName();
        user3.getPassword();
        String expected = userService.register(user3);
        assertEquals("Account created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Olawale More");
        dtos.setPassword("2");
        assertThrows(LoginException.class, () -> userService.login(dtos));
    }
        @Test
    public void testThatUserCanLogInToLibrary () throws NameAlreadyExistException, LoginException {
            userService.deleteAll();
            CreateAccountRequest user3 = new CreateAccountRequest();
            user3.setUserName("Olawale Mor");
            user3.setPassword("1");
            String expected = userService.register(user3);
            assertEquals("Account created successfully", expected);

            LogInRequest dtos = new LogInRequest();
            dtos.setUserName("Olawale Mor");
            dtos.setPassword("1");
            boolean expected2 = userService.login(dtos);
            assertTrue(expected2);
    }
@Test
    public void testThatUserCanDeleteAccount() throws NameAlreadyExistException, LoginException, UserNotFoundException {
        userService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Olawale Moy");
        user3.setPassword("2");
        String expected = userService.register(user3);
        assertEquals("Account created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Olawale Moy");
        dtos.setPassword("2");
        boolean expected2 = userService.login(dtos);
        assertTrue(expected2);


        DeleteAccount deleteAccount = new DeleteAccount();
        deleteAccount.setUserName("Olawale Moy");
        deleteAccount.setPassword("2");
        String expected1 = userService.deleteAccount(deleteAccount);
        assertEquals("Account deleted successfully", expected1);
    }

    @Test
    public void testThatUserCanFindBookByTitle() throws LoginException, NoBookFoundWIthTitleException, NameAlreadyExistException {
        userService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Ola");
        user3.setPassword("1");
        String expected = userService.register(user3);
        assertEquals("Account created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Ola");
        dtos.setPassword("1");
        boolean expected2 = userService.login(dtos);
        assertTrue(expected2);

//        Book expectedBook = libraryService.findBookByTitle("Ablaze");
//        assertEquals("Ablaze", expectedBook.getTitle());
    }

    @Test
    public void testThatUserCanFindBookByTitleIgnoringLettering() throws NameAlreadyExistException, LoginException, NoBookFoundWIthTitleException {
        userService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Olawale Moy");
        user3.setPassword("2");
        String expected = userService.register(user3);
        assertEquals("Account created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Olawale Moy");
        dtos.setPassword("2");
        boolean expected2 = userService.login(dtos);
        assertTrue(expected2);

//        assertThrows(NoBookFoundWIthTitleException.class, ()-> shelfService.findByBook_Title("ablaze"));
    }

}

