--Scenario 2: Promote Customers to VIP Status Based on Balance

DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;
    
    v_customer_id Customers.CustomerID%TYPE;
    v_balance Customers.Balance%TYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer_id, v_balance;
        EXIT WHEN customer_cursor%NOTFOUND;
        
        IF v_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'YES'
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;
    CLOSE customer_cursor;
    
    COMMIT;
END;
/

-- Check updated customer VIP status
SELECT * FROM Customers WHERE IsVIP = 'YES';


