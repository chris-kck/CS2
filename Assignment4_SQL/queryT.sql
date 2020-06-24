SELECT (

IF (

(
SELECT
	COUNT(orderdetails.priceEach+products.buyPrice)
FROM
	orderdetails,
	products
WHERE orderdetails.priceEach=0
OR products.buyPrice=0

)

, "YES",""))

AS "anyProblems"