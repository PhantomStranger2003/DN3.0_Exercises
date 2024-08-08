-- Scenario 3: Check if a Customer Has Sufficient Balance

CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id NUMBER,
    p_amount NUMBER
) RETURN BOOLEAN IS
    v_balance Accounts.Balance%TYPE;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END HasSufficientBalance;
/



-- Test HasSufficientBalance
SELECT HasSufficientBalance(1, 500) AS SufficientBalance FROM DUAL;
