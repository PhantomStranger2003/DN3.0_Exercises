-- Scenario 1: Automatically Update the Last Modified Date

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END UpdateCustomerLastModified;
/


-- Update a customer's record to test UpdateCustomerLastModified
UPDATE Customers SET Name = 'John Doe Updated' WHERE CustomerID = 1;
