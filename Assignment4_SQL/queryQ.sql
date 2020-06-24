SELECT
	a.country,
	a.officeCode AS "oneOffice",
	b.officeCode AS "otherOffice" 
FROM
	offices AS a
	INNER JOIN offices AS b ON a.officeCode != b.officeCode 
	AND a.country = b.country
WHERE a.officeCode<b.officeCode