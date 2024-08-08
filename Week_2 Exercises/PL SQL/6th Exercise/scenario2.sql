-- Scenario 2: Apply Annual Fee to All Accounts

DECLARE
    CURSOR accounts_cursor IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee CONSTANT NUMBER := 50; -- Annual fee amount
BEGIN
    OPEN accounts_cursor;
    LOOP
        FETCH accounts_cursor INTO v_account_id, v_balance;
        EXIT WHEN accounts_cursor%NOTFOUND;
        IF v_balance >= v_annual_fee THEN
            UPDATE Accounts
            SET Balance = Balance - v_annual_fee
            WHERE AccountID = v_account_id;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Insufficient funds for Account ID: ' || v_account_id);
        END IF;
    END LOOP;
    CLOSE accounts_cursor;
    COMMIT;
END;
/


-- Check updated balances for annual fee
SELECT * FROM Accounts;
