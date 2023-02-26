import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;
//Creates new HashMap that will hold the contacts
    public ContactService() {
        contacts = new HashMap<>();
    }
// Method adds contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactID(), contact);
    }
 // Method removes contact
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contacts.remove(contactID);
    }
// Method updates contact
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        Contact contact = contacts.get(contactID);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }
    //Method retrieves contact
    public HashMap<String, Contact> getContacts() {
        return new HashMap<>(contacts);
    }
}