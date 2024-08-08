--Scenario 3: Send Reminders to Customers with Loans Due in the Next 30 Days

DECLARE
    CURSOR loan_cursor IS
        SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
    
    v_loan_id Loans.LoanID%TYPE;
    v_customer_id Loans.CustomerID%TYPE;
    v_customer_name Customers.Name%TYPE;
    v_end_date Loans.EndDate%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_customer_id, v_customer_name, v_end_date;
        EXIT WHEN loan_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || v_customer_name || ' (ID: ' || v_customer_id || ') has a loan (ID: ' || v_loan_id || ') due on ' || v_end_date || '.');
    END LOOP;
    CLOSE loan_cursor;
END;
/





