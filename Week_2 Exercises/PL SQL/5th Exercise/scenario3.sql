-- Scenario 3: Enforce Business Rules on Deposits and Withdrawals

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance Accounts.Balance%TYPE;
BEGIN
    -- Check if the transaction is a withdrawal
    IF :NEW.TransactionType = 'Withdrawal' THEN
        -- Get the current balance of the account
        SELECT Balance INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID
        FOR UPDATE;

        -- Check if the withdrawal amount exceeds the balance
        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Error: Withdrawal amount exceeds account balance.');
        END IF;
    END IF;

    -- Check if the transaction is a deposit and if the amount is positive
    IF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Error: Deposit amount must be positive.');
        END IF;
    END IF;
END CheckTransactionRules;
/

-- Insert a withdrawal transaction to test CheckTransactionRules
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 1, SYSDATE, 2000, 'Withdrawal'); -- Assuming balance is less than 2000
