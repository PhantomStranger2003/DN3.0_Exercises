-- scenario 3: Transfer Funds Between Accounts

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_from_balance Accounts.Balance%TYPE;
    insufficient_funds EXCEPTION;
BEGIN
    -- Fetch the balance of the source account
    SELECT Balance INTO v_from_balance 
    FROM Accounts 
    WHERE AccountID = p_from_account_id
    FOR UPDATE;

    -- Check if the source account has sufficient funds
    IF v_from_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Transfer funds
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    COMMIT;

EXCEPTION
    WHEN insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the source account.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: An unexpected error occurred during the fund transfer.');
        ROLLBACK;
END TransferFunds;
/



-- Test TransferFunds
EXEC TransferFunds(1, 2, 100);
