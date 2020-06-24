SELECT 
payments.customerNumber
FROM
payments
WHERE
payments.amount = (SELECT MAX(payments.amount) FROM payments)