package com.biblioteca.menu.options;

import com.biblioteca.inputValidator.InputValidationException;
import com.biblioteca.io.Printer;
import com.biblioteca.rental.InvalidItemException;
import com.biblioteca.rental.ItemCanNotBeReturned;
import com.biblioteca.rental.ItemIsNotAvailableForCheckOut;
import com.biblioteca.library.Library;
import com.biblioteca.session.UserSession;
import com.biblioteca.user.InvalidLibraryAndPasswordCombination;
import com.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProfileInfoTest {

    private ProfileInfo profileInfo;
    private UserSession mockUserSession;
    private User currentUser;
    private Library mockLibrary;
    private Scanner mockScanner;
    private Printer printer;
    private ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() throws Exception {
        mockLibrary = mock(Library.class);
        mockScanner = new Scanner(System.in);
        currentUser = User.customer("777-4445", "dhanesh", "password", "davcdhanesh1@gmail.com", "9096904102");
        profileInfo = new ProfileInfo();
        mockUserSession = mock(UserSession.class);
        when(mockUserSession.getCurrentUser()).thenReturn(currentUser);

        byteArrayOutputStream = new ByteArrayOutputStream();
        printer = new Printer(byteArrayOutputStream);
    }

    @Test
    public void testPerform() throws Exception, ItemIsNotAvailableForCheckOut, InvalidLibraryAndPasswordCombination, InputValidationException, InvalidItemException, ItemCanNotBeReturned {
        String expectedString = "|777-4445|dhanesh                         |davcdhanesh1@gmail.com          |9096904102\n";
        profileInfo.perform(mockUserSession, mockLibrary, printer, mockScanner);
        assertThat(byteArrayOutputStream.toString(), is(expectedString));
    }

    @Test
    public void testShouldContinueRunning() throws Exception {
        assertThat(profileInfo.shouldContinueRunning(),is(true));
    }

    @Test
    public void testIsSecureLoginRequired() throws Exception {
        assertThat(profileInfo.isSecureLoginRequired(),is(true));
    }

    @Test
    public void testToString() throws Exception {
        assertThat(profileInfo.toString(), is("Profile information"));
    }
}