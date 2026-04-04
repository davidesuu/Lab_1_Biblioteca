import java.time.LocalDate;
import java.util.ArrayList;

public class Checkout {
    private User user;
    private Book book;
    private String loanDate;
    private Integer borrowedDays;
    private Integer renewalCount;

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public Integer getBorrowedDays() {
        return borrowedDays;
    }

    public Integer getRenewalCount() {
        return renewalCount;
    }

    public Checkout(User user, Book book){
        this.user = user;
        this.loanDate = LocalDate.now().toString();
        this.book = book;
        this.book.setBorrowed(true);
    }

    public void renewLoan(){
        this.renewalCount += 1;
    }

    @Override
    public String toString() {
        return "User: " + this.user.getName() +
               "\nBook name: " + this.book.getName() +
                "\nDate: " + this.loanDate;
    }
}
