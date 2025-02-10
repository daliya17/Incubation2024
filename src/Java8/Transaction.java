package Java8;

import lombok.Data;

@Data
public class Transaction {
    public int id;
    public int amount;
    public TransactionType transactionType;
    public String status;

    public Transaction(int id, int amount, TransactionType transactionType, String status) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.status = status;
    }
}
