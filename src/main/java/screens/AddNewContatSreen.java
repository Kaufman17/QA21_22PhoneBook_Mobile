package screens;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;
public class AddNewContatSreen extends BaseScreen{
    public AddNewContatSreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    MobileElement nameEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    MobileElement lastNameEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement emailEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    MobileElement phoneEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    MobileElement addressEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    MobileElement descriptionEditText;

    @FindBy(id = "com.sheygam.contactapp:id/createBtn")
    //@FindBy(id = "com.sheygam.contactapp:id/add_contact_btn")
    MobileElement createBtn;


    public AddNewContatSreen fillContactForm(Contact contact){
        should(nameEditText,30);
        type(nameEditText,contact.getName());
        type(lastNameEditText,contact.getLastName());
        type(emailEditText,contact.getEmail());
        type(phoneEditText,contact.getPhone());
        type(addressEditText,contact.getAddress());
        type(descriptionEditText,contact.getDescription());
        return this;
    }
    public ContactListScreen submitContactForm(){
        createBtn.click();
        return new ContactListScreen(driver);
    }

    public AddNewContatSreen submitContactFormNegative(){
        createBtn.click();
        return this;
    }

    public AddNewContatSreen isErrorContainsText(String text){
        checkAlertText(text);
        return this;
    }

//    public ContactListScreen createContact(Contact contact){
//        should(nameEditText,5);
//        type(nameEditText,contact.getName());
//        type(lastNameEditText,contact.getLastName());
//        type(emailEditText,contact.getEmail());
//        type(phoneEditText,contact.getPhone());
//        type(addressEditText,contact.getAddress());
//        type(descriptionEditText,contact.getDescription());
//        createBtn.click();
//        return new ContactListScreen(driver);
//
//    }

}