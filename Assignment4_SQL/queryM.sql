SELECT
products.productCode
FROM
products 
WHERE
products.productCode NOT IN(
SELECT
DISTINCT orderdetails.productCode
FROMorderdetails
)