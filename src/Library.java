import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Checkout> checkouts;
    private LocalDate date;

    public Library(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.checkouts = new ArrayList<>();
        this.date = LocalDate.now();
    }

    public void registerLoan(User user, Book book){  //isso aqui da pra substituir as duas funçoes de la em baixo
        if(user.IsHasPhoto()){
            if (book.isBorrowed()){
                System.out.println("livro esta emprestado no momento");
            }
            else{
                Checkout e = new Checkout(user, book);
                addCheckout(e);
                for(int i = 0; i < books.size() ; i++){
                    if(books.get(i) == book){
                        books.remove(i);
                    }
                }
                IO.println("Livro coisado com sucesso!");
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void checkFine(User user) {
        if (checkouts.isEmpty()) {
            return;
        }
        double fine = 0;
        for (Checkout c : checkouts) {
            fine = 0;
            if (c.getUser() == user) {
                int today = this.getDate().getDayOfMonth();
                int borrowed = c.getLoanDate().getDayOfMonth();
                int date = today - borrowed;
                if (date > 10) {
                    fine += 0.5;
                }
            }
        }
        if (fine > 0) {
            user.setFine(fine);
            IO.println("VOCE ESTA DEVENDO + " + user.getFine());
        }
        return;
    }


    public ArrayList<Checkout> getCheckout(){
        return this.checkouts;
    }

    public boolean showBooks() { //As dois metodos show sao boolean agora no caso do usuario
        int i = 1;               //querer ver a lista vazia.
        if(books.isEmpty()){
            return false;
        }
        for (Book b : books) {
            if (b.isBorrowed()) {
                continue;
            } else {
                System.out.println(i + " - " + b);
                i++;
            }
        }
        return true;
    }

    public Book selectBooks(){
        if(showBooks()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Selecione o numero do livro: ");
            int opc = scanner.nextInt() - 1;
            scanner.nextLine();
            Book book = books.get(opc);
            return book;
        }
        else{
            return null;
        }
    }

    public boolean showLoans(String registration) {
        int i = 1;
        if(checkouts.isEmpty()){
            return false;
        }
        for(Checkout e : checkouts) {
            if (e == null) {
                return false;
            } else {
                if (e.getUser().getRegistration().equals(registration)) {
                    System.out.println(e.getUser());
                    System.out.println(i + " - " + e.getBook());
                    IO.println("Borrowed days " + e.getBorrowedDays());
                    i++;
                }
            }
        }
        return true;//ISSO PODE SER SIMPLIFICADO SO COM O toString do Checkout
    }

    public Book selectLoans(String registration) {
        if (showLoans(registration)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Selecione o numero do livro: ");
            int opc = scanner.nextInt() - 1;
            scanner.nextLine();
            addBook(checkouts.get(opc).getBook());
            return checkouts.get(opc).getBook();
        }
        else {
            return null;
        }
    }

    public boolean devolution(Book book){
        int i = 0;
        for (Checkout c :checkouts ){
            if (book == c.getBook()){
                c.getBook().setBorrowed(false);
                this.checkouts.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}