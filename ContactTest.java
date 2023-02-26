import org.junit.Assert;
import org.junit.Test;

public class ContactTest {
    @Test
    public void testContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Assert.assertEquals("1234567890", contact.getContactID());
        Assert.assertEquals("John", contact.getFirstName());
        Assert.assertEquals("Doe", contact.getLastName());
        Assert.assertEquals("1234567890", contact.getPhone());
        Assert.assertEquals("123 Main St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIDTooLong() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameTooLong() {
        new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameTooLong() {
        new Contact("1234567890", "John", "DoeDoeDoe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooShort() {
        new Contact("1234567890", "John", "Doe", "123456789", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooLong() {
        new Contact("1234567890", "John", "Doe", "12345678901", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressTooLong() {
        new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St 123 Main St 123 Main St");
    }
}