import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public void main() {
        Library library = new Library();
//        User user2 = new User("123456789", "perla", 18);
//        User user1 = new User("24123414", "David", 19);
//
        Book book1 = new Book("O Hoobit", "Tolkien", "3rd edition");
        Book book2 = new Book("De Sangue e Cinzas", "Jennifer", "2rd edition");
        Book book3 = new Book("A vida invisivel de addie larue", "Schwab", "1rd edition");
        Book book4 = new Book("O Hoobit", "Tolkien", "3rd edition");
//
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
//        //System.out.println(user1);
//        //System.out.println(user2);
//        String s;
//        //System.out.println(book1);//System.out.println(book2);
//        Scanner scanner = new Scanner(System.in);
//        //System.out.println(l.selectBooks());
//        Checkout checkout1 = new Checkout(user1, l.selectBooks());
//        s = scanner.nextLine();
//        Checkout checkout2 = new Checkout(user2, l.selectBooks());
//        s = scanner.nextLine();
//        Checkout checkout3 = new Checkout(user1, l.selectBooks());
//        s = scanner.nextLine();
//
//        l.addCheckout(checkout1);
//        l.addCheckout(checkout2);
//        l.addCheckout(checkout3);
//        System.out.println();
//        l.devolution(l.selectLoans("24123414"));
//        s = scanner.nextLine();
//        System.out.println();
//        l.showLoans("24123414");
//        System.out.println();
//        l.showBooks();
        Scanner scanner = new Scanner(System.in);
        User user = loginMenu(scanner);
        mainMenu(user, scanner, library);

    }

    static User loginMenu(Scanner scanner) {
        String name, registration;
        Integer age;
        IO.println("Login:");
        IO.print("Nome: ");
        name = scanner.nextLine();
        IO.print("Matricula: ");
        registration = scanner.nextLine();
        IO.print("Idade: ");
        age = scanner.nextInt();
        scanner.nextLine();

        try {
            User user = new User(name, registration, age);
            IO.println("Bem vindo " + user.getName());
            return user;
        } catch (RuntimeException e) {
            IO.println("Erro: " + e.getMessage());
            return (loginMenu(scanner));
        }
    }

    static void mainMenu(User user, Scanner scanner, Library library){
        LocalDate date = LocalDate.now();
        IO.println("Selecione alguma opção:");
        int opc;
        do {
            IO.println("1 - Pegar livro");
            IO.println("2 - Devolver livro");
            IO.println("3 - Dormir");
            IO.println("4 - Sair");
            opc = scanner.nextInt();
            scanner.nextLine();  // pra pegar o \n do buffer
            switch (opc){
                case 1 -> loanMenu(user, library);
                case 2 -> retrieveMenu(user, library);
                case 3 -> sleep(date);
                default -> IO.println("Opção Invalida!");
            }
        }while (opc != 4);
    }
//IDEIA? Integrar o register com o select, no momento o register faz o registro e o select retorna o livro. tudo em uma funçao so?
    static void loanMenu(User user, Library library){
        IO.println("Digite o numero do livro para escolher: ");
        Book book = library.selectBooks();  //PROBLEM GRAVe aqui, isso nao vai mais funcionar quando implementar so mostrar quando loaned for false.
        Checkout checkout = new Checkout(user, book);
        library.addCheckout(checkout);
        IO.println("Livro coisado com sucesso!");
    }
//Melhorar o print daqui, e o de cima tbm
    static void retrieveMenu(User user, Library library){
        library.devolution(library.selectLoans(user.getRegistration()));
        IO.println("Livro devolvido com suucesso");   //PROBLEMA GRAVE Com index aqui quando eu pego os 3 e devolvo tudo
        //corrigido :) Tava iterando em books, era pra ser em checkouts
    }

    static void sleep(LocalDate date){
        IO.println("Dia atual: " + date);
        date = date.plusDays(1);  //Nao funciona ainda, mas é uma ideia
        IO.println("Agora: " + date);
    }


}


//Fazer verificaçao dos if na hora de pegar os livros ja indisponiveis
//Menu
//Fazer verificaçao de dias
//fazer funçao dormir
//Fazer o print da data no checkout