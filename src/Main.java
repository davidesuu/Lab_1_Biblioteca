import java.util.Scanner;

public class Main {
    public void main(){
        Library l = new Library();
        User user2 = new User("123456789", "perla", 18);
        User user1 = new User("24123414", "David", 19);

        Book book1 = new Book("O Hoobit", "Tolkien", "3rd edition");
        Book book2 = new Book("De Sangue e Cinzas", "Jennifer", "2rd edition");
        Book book3 = new Book("A vida invisivel de addie larue", "Schwab", "1rd edition");
        Book book4 = new Book("O Hoobit", "Tolkien", "3rd edition");

        l.addBook(book1);
        l.addBook(book2);
        l.addBook(book3);

        //System.out.println(user1);
        //System.out.println(user2);
        String s;
        //System.out.println(book1);//System.out.println(book2);
        Scanner scanner = new Scanner(System.in);
        //System.out.println(l.selectBooks());
        Checkout checkout1 = new Checkout(user1, l.selectBooks());
        s = scanner.nextLine();
        Checkout checkout2 = new Checkout(user2, l.selectBooks());
        s = scanner.nextLine();
        Checkout checkout3 = new Checkout(user1, l.selectBooks());
        s = scanner.nextLine();

        l.addCheckout(checkout1);
        l.addCheckout(checkout2);
        l.addCheckout(checkout3);
        System.out.println();
        l.devolution(l.selectLoans("24123414"));
        s = scanner.nextLine();
        System.out.println();
        l.showLoans("24123414");
        System.out.println();
        l.showBooks();
    }
}


//Fazer verificaçao dos if na hora de pegar os livros ja indisponiveis
//Menu
//Fazer verificaçao de dias
//fazer funçao dormir
//Fazer o print da data no checkout