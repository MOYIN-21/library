package com.example.eagle.services;

import com.example.eagle.dtos.BookDto;
import com.example.eagle.dtos.CreateAccountRequest;
import com.example.eagle.dtos.DeleteAccount;
import com.example.eagle.dtos.LogInRequest;
import com.example.eagle.exceptions.NameAlreadyExistException;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
import com.example.eagle.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.login.LoginException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreatorServiceImplTest {
    @Autowired
    private CreatorService creatorService;
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShelfService shelfService;
    private CreateAccountRequest creator;
    private BookDto book;


    @BeforeEach
    void setup() {
        creator = new CreateAccountRequest();
        creator.setUserName("Prof. Lawrence");
        creator.setPassword("0");
    }

    @Test
    public void testThatUserCanCreateAccountInLibrary() throws NameAlreadyExistException {
        creatorService.deleteAll();
        String expected = creatorService.register(creator);
        assertEquals("Account for Creator created successfully", expected);
    }

    @Test
    public void testThatTwoUsersWithTheSameCredentialsCanNotExistInLibrary() throws NameAlreadyExistException {
        creatorService.deleteAll();
        creatorService.register(creator);
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setUserName("Prof. Lawrence");
        createAccountRequest.setPassword("0");
        assertThrows(NameAlreadyExistException.class, () -> creatorService.register(createAccountRequest));

    }

    @Test
    public void testThatCreatorCanLogInAfterCreatingAccount() throws NameAlreadyExistException, LoginException {
        creatorService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Prof. Lawrence");
        user3.setPassword("0");
        String expected = creatorService.register(user3);
        assertEquals("Account for Creator created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Prof. Lawrence");
        dtos.setPassword("0");
        boolean expected2 = creatorService.login(dtos);
        assertTrue(expected2);


    }

    @Test
    public void testThatCreatorCanNotLogInWithWrongAccountDetails() throws LoginException, NameAlreadyExistException {
        creatorService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Prof. Lawrence");
        user3.setPassword("1");
        String expected = creatorService.register(user3);
        assertEquals("Account for Creator created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Prof. Lawren");
        dtos.setPassword("0");
        assertThrows(LoginException.class, () -> creatorService.login(dtos));
    }

    @Test
    public void testThatCreatorCanWriteBookAfterCreatingAndLogInIntoAccount() throws NameAlreadyExistException, LoginException {
        creatorService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Prof. Lawrence");
        user3.setPassword("0");
        String expected = creatorService.register(user3);
        assertEquals("Account for Creator created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Prof. Lawrence");
        dtos.setPassword("0");
        boolean expected2 = creatorService.login(dtos);
        assertTrue(expected2);

        BookDto bookDto = new BookDto();
        bookDto.setTitle("Ablaze");
        bookDto.setCreator("Prof. Lawrence");
        bookDto.setPage(100);
        bookDto.setContent("Once upon a time ");
        bookDto.setDate(LocalDate.ofEpochDay(22/10/2023));
        String expected3 = bookService.writeBook(bookDto);
        assertEquals("Book saved successfully",expected3);
    }

    @Test
    public void testThatCreatorCanFindBookByTitle() throws LoginException, NoBookFoundWIthTitleException, NameAlreadyExistException {
        creatorService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Prof. Law");
        user3.setPassword("1");
        String expected = creatorService.register(user3);
        assertEquals("Account for Creator created successfully", expected);

        LogInRequest dtos1 = new LogInRequest();
        dtos1.setUserName("Prof. Law");
        dtos1.setPassword("1");
        boolean expected2 = creatorService.login(dtos1);
        assertTrue(expected2);

        shelfService.deleteAll();
        BookDto bookDto = new BookDto();
        bookDto.setTitle("Fire");
        bookDto.setCreator("Miss. Law");
        bookDto.setPage(1020);
        bookDto.setContent("Once upon a time ");
        bookDto.setDate(LocalDate.ofEpochDay(22/10/2023));
        String expected3 = bookService.writeBook(bookDto);
        assertEquals("Book saved successfully",expected3);

//        assertEquals("Fire", shelfService.findByBook_Title("Fire").getTitle());
    }
    @Test
    public void testThatCreatorCanFindBookIgnoringTheTitleLettering() throws LoginException, NameAlreadyExistException {

        creatorService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Prof. Lawrence");
        user3.setPassword("0");
        String expected = creatorService.register(user3);
        assertEquals("Account for Creator created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Prof. Lawrence");
        dtos.setPassword("0");
        boolean expected1 = creatorService.login(dtos);
        assertTrue(expected1);

        assertThrows(NoBookFoundWIthTitleException.class,()-> libraryService.findBookByTitle("ablaze"));
    }

    @Test
    public void testThatCreatorCanDeleteAccount() throws UserNotFoundException, NameAlreadyExistException, LoginException {
        creatorService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Prof. Lawrence");
        user3.setPassword("0");
        String expected = creatorService.register(user3);
        assertEquals("Account for Creator created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Prof. Lawrence");
        dtos.setPassword("0");
        boolean expected2 = creatorService.login(dtos);
        assertTrue(expected2);

        DeleteAccount deleteAccount = new DeleteAccount();
        deleteAccount.setUserName("Prof. Lawrence");
        deleteAccount.setPassword("0");
        String expected1 = creatorService.deleteAccount(deleteAccount);
        assertEquals("Account deleted successfully", expected1);
    }

    @Test
    public void testThatCreatorCanGetTheNumberOfBookInALibrary() throws NameAlreadyExistException, LoginException {
        creatorService.deleteAll();
        CreateAccountRequest user3 = new CreateAccountRequest();
        user3.setUserName("Prof. Lawrence");
        user3.setPassword("0");
        String expected = creatorService.register(user3);
        assertEquals("Account for Creator created successfully", expected);

        LogInRequest dtos = new LogInRequest();
        dtos.setUserName("Prof. Lawrence");
        dtos.setPassword("0");
        boolean expected2 = creatorService.login(dtos);
        assertTrue(expected2);

        BookDto bookDto = new BookDto();
        bookDto.setTitle("Love");
        bookDto.setCreator("Miss. Moyinoluwa");
        bookDto.setPage(1020);
        bookDto.setContent("Once upon a time ");
        bookDto.setDate(LocalDate.ofEpochDay(22/10/2023));
        String expected3 = bookService.writeBook(bookDto);
        assertEquals("Book saved successfully",expected3);

        BookDto bookDto2 = new BookDto();
        bookDto2.setTitle("Goat");
        bookDto2.setCreator("Miss. Moyinoluwa");
        bookDto2.setPage(100);
        bookDto2.setContent("Once upon a time ");
        bookDto2.setDate(LocalDate.ofEpochDay(22/10/2023));
        String expected4 = bookService.writeBook(bookDto);
        assertEquals("Book saved successfully",expected4);

        BookDto bookDto3 = new BookDto();
        bookDto3.setTitle("Fire");
        bookDto3.setCreator("Miss. Law");
        bookDto3.setPage(1020);
        bookDto3.setContent("Once upon a time ");
        bookDto3.setDate(LocalDate.ofEpochDay(22/10/2023));
        String expected5 = bookService.writeBook(bookDto);
        assertEquals("Book saved successfully",expected5);

//        bookService.getNumberOfBooks();
//        assertEquals(3, libraryService.getSize());
    }
}