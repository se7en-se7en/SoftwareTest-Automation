public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
       contactID = validateID(contactID);
       firstName = validatefirstName(firstName);
       lastName = validatelastName(lastName);
       phone = validatePhone(phone);
       address = validateAddress(address);
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
    	firstName = validatefirstName(firstName);
    	this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
       lastName = validatelastName(lastName);
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = validatePhone(phone);
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
       address = validateAddress(address);
        this.address = address;
    }
    
    public String validateID(String contactID) {
    	  if (contactID == null || contactID.length() > 10) {
              throw new IllegalArgumentException("Invalid contact ID.");
          }
        return contactID;
    }
    
    public String validatefirstName(String firstName) {
    	if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name.");
        }
        return lastName;
    }
    
    public String validatelastName(String lastName) {
    	if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name.");
        }
        return lastName;
    }
    
    public String validatePhone(String phone) {
    	 if (phone == null || !phone.matches("\\d{10}")) {
             throw new IllegalArgumentException("Invalid phone number.");
         }
        return phone;
    }
    
    public String validateAddress(String address) {
    	 if (address == null || address.length() > 30) {
             throw new IllegalArgumentException("Invalid address.");
         }
       return address;
   }
}