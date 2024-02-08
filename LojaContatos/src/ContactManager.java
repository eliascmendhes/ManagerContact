import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private ArrayList<Customer> contacts;
    private Scanner input;

    public ContactManager() {
        contacts = new ArrayList<>();
        input = new Scanner(System.in);
    }

    

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        manager.start();
    }
    
 
    public void addContact() {
        System.out.print("Digite o Nome: ");
        String name = input.nextLine();

        System.out.print("Digite o Telefone:");
        String phone = input.nextLine();

        System.out.print("Digite o Email: ");
        String email = input.nextLine();

        Customer newCustomer = new Customer(name, phone, email);
        contacts.add(newCustomer);
        System.out.println("Contato adicionado!");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Lista de contatos vazia.");
            return;
        }

        System.out.println("Contatos:");
        for (Customer customer : contacts) {
            System.out.println(customer.toString());
        }
    }

    public void searchContact(String name) { 
        boolean found = false;
        for (Customer customer : contacts) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(customer.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nenhum contato encontrado com o nome: " + name);
        }
    }

    public void start() {
        int choice;
        do {
            System.out.println("\nMenu Gerenciador de Contatos:");
            System.out.println("1. Adicionar conato");
            System.out.println("2. Mostrar contatos");
            System.out.println("3. Pesquisar contato");
            System.out.println("4. Sair");
            System.out.print("Digite sua escolha: ");

            choice = input.nextInt();
            input.nextLine(); // Consume newline 

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    System.out.print("Digite o nome da sua pesquisa: ");
                    searchContact(input.nextLine());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }
        } while (choice != 4);
    }
}
