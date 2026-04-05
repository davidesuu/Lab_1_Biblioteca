import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Checkout> checkouts;

    public Library(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.checkouts = new ArrayList<>();
    }

    public void registerLoan(Book book, User user){
        if(user.IsHasPhoto()){
            if (book.isBorrowed()){
                System.out.println("livro esta emprestado no momento");
            }
            else{
                Checkout e = new Checkout(user, book);
            }
        }
        else{
            System.out.println("Usuario nao possui foto cadastrada no momento");
        }
    }

    public void registerRenew(Checkout checkout){
        if ((checkout.getRenewalCount()) == 2 ){
            System.out.println("Você nao pode renovar mais do que 2 vezes consecutivas");
        } else if (checkout.getBorrowedDays() > 10) {
            System.out.println("Prazo pra renovação acabou");
        }
        else{
            checkout.renewLoan();
        }
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addCheckout(Checkout checkout){
        checkouts.add(checkout);
    }

    public void showBooks(){
        int i = 1;
        for (Book l : books){
            System.out.println(i + " - " + l);
            i++;
        }
    }

    public Book selectBooks(){
        showBooks();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o numero do livro: ");
        int opc = scanner.nextInt() - 1;
        scanner.nextLine();
        return books.get(opc);
    }

    public void showLoans(String registration) {
        int i = 1;
        for (Checkout e : checkouts) {
            if (e.getUser().getRegistration().equals(registration)) {
                System.out.println(e.getUser());
                System.out.println(i + " - " + e.getBook());
                i++;
            }
        }
    }

    public Book selectLoans(String registration){
        showLoans(registration);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o numero do livro: ");
        int opc = scanner.nextInt() - 1;
        scanner.nextLine();
        return checkouts.get(opc).getBook();
    }

    public void devolution(Book book){
        int i = 0;
        for (Checkout c :checkouts ){
            if (book == c.getBook()){
                c.getBook().setBorrowed(false);
                this.checkouts.remove(i);
                break;
            }
            i++;
        }
    }
}