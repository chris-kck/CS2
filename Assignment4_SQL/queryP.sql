SELECT
customers.salesRepEmployeeNumber,
Count( distinct customers.customerNumber) AS numCustomers
FROM
employees
INNER JOIN customers
WHERE
employees.reportsTo = 1143
GROUP BY
customers.salesRepEmployeeNumber
HAVING
customers.salesRepEmployeeNumber IS NOT NULL
AND
numCustomers>9