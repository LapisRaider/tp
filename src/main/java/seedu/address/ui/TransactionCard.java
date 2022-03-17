package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.transaction.DueDate;
import seedu.address.model.transaction.Transaction;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class TransactionCard extends UiPart<Region> {

    private static final String FXML = "TransactionListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Transaction transaction;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label amount;
    @FXML
    private Label transactionDate;
    @FXML
    private Label dueDate;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public TransactionCard(Transaction transaction, int displayedIndex) {
        super(FXML);
        this.transaction = transaction;
        id.setText(displayedIndex + ". ");

        // Required fields.
        amount.setText(transaction.getAmount().getValue());
        transactionDate.setText(transaction.getTransactionDate().getValue());

        // Optional fields.
        dueDate.setText(transaction.getDueDate().map(DueDate::getValue).orElse(DueDate.EMPTY_DUE_DATE));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TransactionCard)) {
            return false;
        }

        // state check
        TransactionCard card = (TransactionCard) other;
        return id.getText().equals(card.id.getText())
                && transaction.equals(card.transaction);
    }
}
