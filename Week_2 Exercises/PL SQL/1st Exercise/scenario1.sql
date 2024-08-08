--Scenario 1: Apply Discount to Loan Interest Rates for Customers Above 60 Years Old

DECLARE
    CURSOR customer_cursor IS
        SELECT c.CustomerID, TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
    
    v_customer_id Customers.CustomerID%TYPE;
    v_age NUMBER;
    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer_id, v_age, v_loan_id, v_interest_rate;
        EXIT WHEN customer_cursor%NOTFOUND;
        
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = v_interest_rate * 0.99
            WHERE LoanID = v_loan_id;
        END IF;
    END LOOP;
    CLOSE customer_cursor;
    
    COMMIT;
END;
/

-- Check updated loan interest rates
SELECT * FROM Loans;


