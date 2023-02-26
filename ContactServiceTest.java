import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService contactService = new ContactService();

    @Test
    public void testAddContact() {
        contactService.addContact(new Contact("c1", "John", "Doe", "1234567890", "123 Main St."));
        assertEquals(1, contactService.getContacts().size());
    }

    @Test
    public void testAddDuplicateContact() {
        contactService.addContact(new Contact("c1", "John", "Doe", "1234567890", "123 Main St."));
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(new Contact("c1", "Jane", "Doe", "0987654321", "456 Park Ave.")));
    }

    @Test
    public void testDeleteContact() {
        contactService.addContact(new Contact("c1", "John", "Doe", "1234567890", "123 Main St."));
        contactService.deleteContact("c1");
        assertEquals(0, contactService.getContacts().size());
    }

    @Test
    public void testUpdateContact() {
        contactService.addContact(new Contact("c1", "John", "Doe", "1234567890", "123 Main St."));
        contactService.updateContact("c1", "firstName", "Jane");
        contactService.updateContact("c1", "lastName", "Smith");
        contactService.updateContact("c1", "phone", "0987654321");
        contactService.updateContact("c1", "address", "456 Park Ave.");
        assertEquals("Jane", contactService.getContacts().get("c1").getFirstName());
        assertEquals("Smihth", contactService.getContacts().get("c1").getLastName());
        assertEquals("0987654321", contactService.getContacts().get("c1").getPhone());
        assertEquals("456 Park Ave.", contactService.getContacts().get("c1").getAddress());
    }

    @Test
    public void testUpdateInvalidContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("c1", "firstName", "Jane"));
    }
    
    @Test
    public void testUpdateInvalidField() {
        contactService.addContact(new Contact("c1", "John", "Doe", "1234567890", "123 Main St."));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("c1", "invalidField", "test"));
    }
}