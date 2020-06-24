SELECT
products.productVendor,
products.productCode,
products.quantityInStock*2 AS newStock
FROM
products
WHERE
products.productVendor LIKE 'Ex%'
