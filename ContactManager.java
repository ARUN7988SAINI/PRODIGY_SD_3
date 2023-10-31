import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}

public class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting the Contact Manager.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("Contact List:");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println("Contact " + (i + 1) + ":");
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email: " + contact.getEmail());
            System.out.println();
        }
    }

    private static void editContact() {
        viewContacts();
        if (contacts.isEmpty()) {
            return;
        }

        System.out.print("Enter the contact number you want to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume the newline character

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number. Please try again.");
        } else {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            Contact contact = contacts.get(index);
            contact = new Contact(name, phoneNumber, email);
            contacts.set(index, contact);
            System.out.println("Contact updated successfully!");
        }
    }

    private static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) {
            return;
        }

        System.out.print("Enter the contact number you want to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume the newline character

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number. Please try again.");
        } else {
            Contact deletedContact = contacts.remove(index);
            System.out.println("Contact deleted: " + deletedContact.getName());
        }
    }
}
