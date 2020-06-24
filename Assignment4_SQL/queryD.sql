SELECT
orderdetails.orderNumber,
orderdetails.productCode,
orderdetails.quantityOrdered,
orderdetails.priceEach,
orderdetails.orderLineNumber
FROM
orderdetails
WHERE
orderdetails.quantityOrdered * orderdetails.priceEach > 10000
