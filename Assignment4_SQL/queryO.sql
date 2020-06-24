SELECT
employees.officeCode,
Count(employees.jobTitle) AS "numReps"
FROM
employees
WHERE
employees.jobTitle = "Sales Rep"
GROUP BY
employees.officeCode
