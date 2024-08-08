-- Scenario 2: Manage Errors When Updating Employee Salaries

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) IS
    v_current_salary Employees.Salary%TYPE;
    employee_not_found EXCEPTION;
BEGIN
    -- Fetch the current salary of the employee
    SELECT Salary INTO v_current_salary 
    FROM Employees 
    WHERE EmployeeID = p_employee_id;

    -- Update the salary
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' not found.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: An unexpected error occurred during the salary update.');
        ROLLBACK;
END UpdateSalary;
/

-- Test UpdateSalary
EXEC UpdateSalary(1, 10);
