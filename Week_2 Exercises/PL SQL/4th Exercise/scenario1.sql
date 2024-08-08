-- Scenario 1: Calculate the Age of Customers

CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END CalculateAge;
/


-- Test CalculateAge
SELECT CalculateAge(TO_DATE('1985-05-15', 'YYYY-MM-DD')) AS Age FROM DUAL;

