-- scenario 1: Process Monthly Interest for All Savings Accounts

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;
END ProcessMonthlyInterest;
/


-- Test ProcessMonthlyInterest
EXEC ProcessMonthlyInterest;

