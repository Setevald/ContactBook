import java.util.LinkedList;
import java.util.Scanner;

public class ContactBook {
    public static void main(String[] args){
        LinkedList<Contact> contact = new LinkedList<>();
        Scanner scanner =new Scanner(System.in);

        while(true){
            System.out.println("**********");
            System.out.println("(A)dd\n(D)elete\n(E)mail search\n(P)rint list\n(S)earch\n(Q)uit");
            System.out.println("**********");
            System.out.println("Please Enter a command: ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine();

            switch (Character.toUpperCase(choice)){
                case 'A':
                    addContact(contact);
                    break;
                case 'D':
                    deleteContact(contact);
                    break;
                case 'E':
                    searchByEmail(contact);
                    break;
                case 'P':
                    displayContact(contact);
                    break;
                case 'S':
                    searchContact(contact);
                    break;
                case 'Q':
                    System.out.println("Proceed to Exit.....");
                    System.exit(0);
                default:
                    System.out.println("Invalid Command, try again");
            }
        }
    }

    private static void addContact(LinkedList<Contact> contacts){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name= ");
        String name = scanner.nextLine();

        System.out.println("Enter a phone number= ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter email= ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);

        System.out.println("Contact successfully ");
    }
    private static void deleteContact(LinkedList<Contact> contacts){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the contact to delete: ");
        String nameToDelete = scanner.nextLine();

        boolean removed = contacts.removeIf(contact -> contact.name.equals(nameToDelete));

        if (removed) {
            System.out.println("Contact delete successfully.");
        } else {
            System.out.println("Contact not found");
        }
    }
    private static void searchByEmail(LinkedList<Contact> contacts){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the email: ");
        String emailToSearch = scanner.nextLine();

        for (Contact contact : contacts){
            if (contact.email.equals(emailToSearch)){
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Email not found");
    }

    private static void displayContact(LinkedList<Contact> contacts){
        if (contacts.isEmpty()){
            System.out.println("Contact list is empty");
        }else{
            System.out.println("\nContacts:");
            for (Contact contact: contacts){
                System.out.println(contact);
            }
        }


    }
    private static void searchContact(LinkedList<Contact> contacts){
        Scanner scanner = new Scanner(System.in);

        if (contacts.isEmpty()){
            System.out.println("Contact is empty.");
        } else{
            System.out.println("Enter the name to search: ");
            String nameToSearch = scanner.nextLine();

            for (Contact contact : contacts){
                if (contact.name.equals(nameToSearch)) {
                    System.out.println(contact);
                    return;
                } else{
                    System.out.println("Contact not found.");
                    break;
                }
            }
        }
    }
}