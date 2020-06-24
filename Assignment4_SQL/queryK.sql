SELECT
orders.orderNumber,
orders.`status`,
orderdetails.priceEach,
orderdetails.quantityOrdered,
products.productName
FROM
orders ,
orderdetails,
products
WHERE
orderdetails.orderNumber=orders.orderNumber
AND
orderdetails.productCode = products.productCode
AND
products.productVendor = "Exoto Designs"
