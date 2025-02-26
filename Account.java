import java.util.*;

public class Account implements AccountService {
    private int balance = 0;
    private final List<Transaction> transactions = new ArrayList<>();

    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(getDate(), amount, balance));
    }

    public void withdraw(int amount) {
        balance -= amount;
        transactions.add(new Transaction(getDate(), -amount, balance));
    }

    public void printStatement() {
        System.out.println("Date       // Amount  //   Balance");
        Collections.reverse(transactions);
        transactions.forEach(System.out::println);
    }

    private String getDate() {
        return new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    private static class Transaction {
        private final String date;
        private final int amount;
        private final int balance;

        public Transaction(String date, int amount, int balance) {
            this.date = date;
            this.amount = amount;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return String.format("%s // %d    //   %d", date, amount, balance);
        }
    }
}


// deposit() and withdraw() update the balance and store the transaction
// printStatement() prints transactions in reverse order to match the expected output
// getDate() provides the current date 
// Transaction is an inner class storing transaction details