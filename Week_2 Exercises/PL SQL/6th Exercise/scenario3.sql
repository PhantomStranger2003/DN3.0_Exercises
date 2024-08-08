-- Scenario 3: Update the Interest Rate for All Loans Based on a New Policy

DECLARE
    CURSOR loans_cursor IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_new_interest_rate CONSTANT NUMBER := 6; -- New interest rate policy
BEGIN
    OPEN loans_cursor;
    LOOP
        FETCH loans_cursor INTO v_loan_id, v_interest_rate;
        EXIT WHEN loans_cursor%NOTFOUND;
        UPDATE Loans
        SET InterestRate = v_new_interest_rate
        WHERE LoanID = v_loan_id;
    END LOOP;
    CLOSE loans_cursor;
    COMMIT;
END;
/


-- Check updated interest rates for loans
SELECT * FROM Loans;