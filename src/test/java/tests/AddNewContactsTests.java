package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactsTests extends AppiumConfig {

    @BeforeClass
    public void preCondition() {
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("chara@gmail.com")
                        .password("Chara12345$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
    }

    @Test
    public void createNewContactSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Simon")
                .lastName("Wow" + i)
                .email("wow" + i + "@gmail.com")
                .phone("65987456" + i)
                .address("NY")
                .description("Friend")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(), contact.getLastName());

    }

    @Test
    public void createNewContactSuccessReq() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Simon")
                .lastName("Wow" + i)
                .email("wow" + i + "@gmail.com")
                .phone("65987456" + i)
                .address("NY")
                .description("")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(), contact.getLastName());

    }

    @Test
    public void createContactWithEmptyName() {
        Contact contact = Contact.builder()
                .name("")
                .lastName("Dow")
                .email("dow@gmail.com")
                .phone("65987456123666")
                .address("NY")
                .description("Empty Name")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorContainsText("{name=must not be blank}");
    }

    @Test
    public void createContactWithEmptyLastName() {
        Contact contact = Contact.builder()
                .name("Simon")
                .email("dow@gmail.com")
                .phone("65987456123666")
                .address("NY")
                .description("Empty LastName")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorContainsText("{lastName=must not be blank}");
    }

    @Test
    public void createContactWithEmptyPhone() {
        Contact contact = Contact.builder()
                .name("Simon")
                .lastName("Dow")
                .email("dow@gmail.com")
                .phone("")
                .address("NY")
                .description("EmptyPhone")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorContainsText("{phone=Phone number must contain only digits! And length min 10, max 15!}");
    }

    @AfterClass
    public void postCondition() {
        new ContactListScreen(driver)
                .logout();
    }
}
