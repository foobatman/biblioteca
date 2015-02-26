package menu;

import IO.Printer;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MenuListTest {

    @Test
    public void testPrintAll() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Printer printer = new Printer(byteArrayOutputStream);
        MenuList menuList = new MenuList();
        menuList.add(new ListAllBook());
        menuList.add(new Quit());
        String expectedMenuList = "1. List Books\n";
        expectedMenuList += "2. Quit\n";
        menuList.printAll(printer);

        assertThat(byteArrayOutputStream.toString(),is(expectedMenuList));
    }

    @Test
    public void testFindMenu() throws Exception {
        MenuList menuList = new MenuList();
        Menu listAllBookOption = new ListAllBook();
        menuList.add(listAllBookOption);
        Menu quitOption = new Quit();
        menuList.add(quitOption);

        assertThat(menuList.find("1"), is(listAllBookOption));
    }

    @Test
    public void testFindMenuWhenInvalidOptionIsGiven() throws Exception {
        MenuList menuList = new MenuList();
        Menu listAllBookOption = new ListAllBook();
        menuList.add(listAllBookOption);
        Menu quitOption = new Quit();
        menuList.add(quitOption);

        assertThat(menuList.find("3").toString(), is("Invalid Option!"));
    }
}