-- scenario 2: Implement a Bonus Scheme for Employees

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE Department = p_department;

    COMMIT;
END UpdateEmployeeBonus;
/


-- Test UpdateEmployeeBonus
EXEC UpdateEmployeeBonus('IT', 5);
