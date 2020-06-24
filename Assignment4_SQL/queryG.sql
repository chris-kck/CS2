SELECT
*
FROM
offices
WHERE
offices.addressLine2 IS NOT NULL AND
offices.state IS NULL
