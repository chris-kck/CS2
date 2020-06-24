SELECT ((SELECT
count(offices.country)
FROM
offices
WHERE
country="USA")
/count(offices.country))*100 AS "percentUSA"
FROM
offices
