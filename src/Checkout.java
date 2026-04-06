import java.time.LocalDate;
import java.util.ArrayList;

public class Checkout {
    private User user;
    private Book book;
    private LocalDate loanDate;
    private Integer borrowedDays;
    private Integer renewalCount;

    private double fine;
    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate() {
        this.loanDate = LocalDate.now();
    }

    public Integer getBorrowedDays() {
        return borrowedDays;
    }

    public Integer getRenewalCount() {
        return renewalCount;
    }

    public void setBorrowedDays() {
        this.borrowedDays += 1;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine += 0.5;
    }

    public Checkout(User user, Book book){
        this.user = user;
        this.loanDate = LocalDate.now();
        this.book = book;
        this.fine = 0;
        this.borrowedDays = 0;
        this.book.setBorrowed(true);
        this.renewalCount = 0;
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
