SELECT
offices.officeCode,
Count(employees.employeeNumber) as "numEmps"
FROM
employees
INNER JOIN offices ON employees.officeCode = offices.officeCode
GROUP BY
offices.officeCode
