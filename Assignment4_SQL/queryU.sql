/*My Query Shows the Total Sales and Total Orders of products in the order of
Products with the most revenue then products with the most order - per Product vendor.
It also shows associated product line.
The best part is that it also shows these results for a particular year (which can be changed),
which is good for business intelligence to know which are your top-selling products per Vendor.

In a nutshell, it shows all ordered products' perfomance in sales and orders with respect to various vendors.
*/

/* I will comment on each step I took to show how I ensured the query is correct */
SELECT
YEAR(o.orderDate) AS "Year",
products.productVendor AS "Product Vendor", 
products.productLine AS "Product Line",
products.productName AS "Product Name", -- select all the productNames in the DB
sum(od.quantityOrdered) AS "Total Orders", -- sum all the orders for a particular product.
ROUND(sum(od.quantityOrdered * od.priceEach),2) AS "Total Order Sales" -- rounded sum of total sales per product


FROM
products
RIGHT JOIN
orderdetails AS od
ON od.productCode = products.productCode -- right join in order to get product name ONLY if it is in order details i.e. if it was ordered. match on productcode key.

INNER JOIN
orders AS o
ON o.orderNumber = od.orderNumber  -- join in order to find referenced order year for orders to be analysed

WHERE YEAR(o.orderDate)=2005 -- filter aggregation by order year

group by 4 -- product name is a unique field that has a 1:1 relationship with productVendor or productLine.

ORDER BY 2, 6 DESC,5 DESC; -- descending total sales, descending total orders (to see correlation between orders and sales). Done for each vendor.



'''

#####QUERY RESULT BELOW FOR VULA-GIVEN SCHEMA####

+------+---------------------------+------------------+---------------------------------------------+--------------+-------------------+
| Year | Product Vendor            | Product Line     | Product Name                                | Total Orders | Total Order Sales |
+------+---------------------------+------------------+---------------------------------------------+--------------+-------------------+
| 2005 | Autoart Studio Design     | Classic Cars     | 1968 Ford Mustang                           |          180 |          31699.51 |
| 2005 | Autoart Studio Design     | Motorcycles      | 1997 BMW R 1100 S                           |          271 |          28747.69 |
| 2005 | Autoart Studio Design     | Trucks and Buses | 1962 Volkswagen Microbus                    |          192 |          22598.49 |
| 2005 | Autoart Studio Design     | Vintage Cars     | 1932 Model A Ford J-Coupe                   |          149 |          17225.01 |
| 2005 | Autoart Studio Design     | Motorcycles      | 2002 Yamaha YZR M1                          |          186 |          13099.91 |
| 2005 | Autoart Studio Design     | Vintage Cars     | 1937 Horch 930V Limousine                   |          171 |           9795.15 |
| 2005 | Autoart Studio Design     | Ships            | The Schooner Bluenose                       |          145 |           8814.00 |
| 2005 | Autoart Studio Design     | Planes           | 1900s Vintage Bi-Plane                      |          150 |           8756.75 |
| 2005 | Carousel DieCast Legends  | Vintage Cars     | 1913 Ford Model T Speedster                 |          172 |          16774.23 |
| 2005 | Carousel DieCast Legends  | Ships            | 18th century schooner                       |          157 |          16561.87 |
| 2005 | Carousel DieCast Legends  | Classic Cars     | 1982 Camaro Z28                             |          169 |          15037.77 |
| 2005 | Carousel DieCast Legends  | Vintage Cars     | 1940 Ford Delivery Sedan                    |          190 |          14586.96 |
| 2005 | Carousel DieCast Legends  | Ships            | The Titanic                                 |          155 |          13433.86 |
| 2005 | Carousel DieCast Legends  | Trains           | Collectable Wooden Train                    |          123 |          10786.52 |
| 2005 | Carousel DieCast Legends  | Trucks and Buses | 1926 Ford Fire Engine                       |          167 |           9256.38 |
| 2005 | Carousel DieCast Legends  | Classic Cars     | 1966 Shelby Cobra 427 S/C                   |          171 |           8208.90 |
| 2005 | Carousel DieCast Legends  | Classic Cars     | 1958 Chevy Corvette Limited Edition         |          192 |           6504.43 |
| 2005 | Classic Metal Creations   | Classic Cars     | 1952 Alpine Renault 1300                    |          174 |          34037.20 |
| 2005 | Classic Metal Creations   | Classic Cars     | 1956 Porsche 356A Coupe                     |          255 |          31432.14 |
| 2005 | Classic Metal Creations   | Classic Cars     | 1957 Corvette Convertible                   |          202 |          24790.32 |
| 2005 | Classic Metal Creations   | Planes           | 1928 British Royal Navy Airplane            |          207 |          20214.53 |
| 2005 | Classic Metal Creations   | Classic Cars     | 1965 Aston Martin DB5                       |          179 |          19812.95 |
| 2005 | Classic Metal Creations   | Classic Cars     | 1949 Jaguar XK 120                          |          191 |          14916.79 |
| 2005 | Classic Metal Creations   | Classic Cars     | 1961 Chevrolet Impala                       |          172 |          12376.65 |
| 2005 | Classic Metal Creations   | Trains           | 1962 City of Detroit Streetcar              |          158 |           8539.60 |
| 2005 | Classic Metal Creations   | Vintage Cars     | 1938 Cadillac V-16 Presidential Limousine   |          150 |           6202.61 |
| 2005 | Classic Metal Creations   | Trucks and Buses | 1954 Greyhound Scenicruiser                 |          118 |           5816.38 |
| 2005 | Exoto Designs             | Motorcycles      | 1997 BMW F650 ST                            |          257 |          22469.91 |
| 2005 | Exoto Designs             | Vintage Cars     | 1941 Chevrolet Special Deluxe Cabriolet     |          226 |          20918.96 |
| 2005 | Exoto Designs             | Classic Cars     | 1952 Citroen-15CV                           |          189 |          20627.17 |
| 2005 | Exoto Designs             | Trucks and Buses | 1957 Chevy Pickup                           |          200 |          20201.29 |
| 2005 | Exoto Designs             | Vintage Cars     | 1917 Maxwell Touring Car                    |          196 |          16635.58 |
| 2005 | Exoto Designs             | Vintage Cars     | 1904 Buick Runabout                         |          170 |          13822.69 |
| 2005 | Exoto Designs             | Classic Cars     | 1992 Porsche Cayenne Turbo Silver           |          117 |          12366.53 |
| 2005 | Exoto Designs             | Vintage Cars     | 1932 Alfa Romeo 8C2300 Spider Sport         |          147 |          11233.27 |
| 2005 | Exoto Designs             | Classic Cars     | 1969 Chevrolet Camaro Z28                   |          138 |          10908.44 |
| 2005 | Gearbox Collectibles      | Vintage Cars     | 1928 Mercedes-Benz SSK                      |          170 |          25964.04 |
| 2005 | Gearbox Collectibles      | Classic Cars     | 1976 Ford Gran Torino                       |          172 |          23431.55 |
| 2005 | Gearbox Collectibles      | Classic Cars     | 1948 Porsche Type 356 Roadster              |          186 |          22881.80 |
| 2005 | Gearbox Collectibles      | Classic Cars     | 1998 Chrysler Plymouth Prowler              |          139 |          21075.51 |
| 2005 | Gearbox Collectibles      | Classic Cars     | 1948 Porsche 356-A Roadster                 |          202 |          13454.21 |
| 2005 | Gearbox Collectibles      | Classic Cars     | 2002 Chevy Corvette                         |          123 |          12060.71 |
| 2005 | Gearbox Collectibles      | Planes           | P-51-D Mustang                              |          154 |          11720.87 |
| 2005 | Gearbox Collectibles      | Motorcycles      | 1982 Ducati 996 R                           |          202 |           7514.61 |
| 2005 | Gearbox Collectibles      | Trains           | 1950s Chicago Surface Lines Streetcar      |          128 |           7099.22 |
| 2005 | Highway 66 Mini Classics  | Motorcycles      | 1996 Moto Guzzi 1100i                       |          230 |          26139.34 |
| 2005 | Highway 66 Mini Classics  | Classic Cars     | 1993 Mazda RX-7                             |          200 |          24133.08 |
| 2005 | Highway 66 Mini Classics  | Planes           | ATA: B757-300                               |          160 |          16441.41 |
| 2005 | Highway 66 Mini Classics  | Trucks and Buses | Diamond T620 Semi-Skirted Tanker            |          167 |          16392.80 |
| 2005 | Highway 66 Mini Classics  | Motorcycles      | 1960 BSA Gold Star DBD34                    |          242 |          16049.47 |
| 2005 | Highway 66 Mini Classics  | Vintage Cars     | 1928 Ford Phaeton Deluxe                    |          189 |          11663.53 |
| 2005 | Highway 66 Mini Classics  | Motorcycles      | 1982 Ducati 900 Monster                     |          177 |          10894.50 |
| 2005 | Highway 66 Mini Classics  | Classic Cars     | 1970 Dodge Coronet                          |          154 |           8101.18 |
| 2005 | Min Lin Diecast           | Classic Cars     | 1995 Honda Civic                            |          186 |          23935.48 |
| 2005 | Min Lin Diecast           | Classic Cars     | 1970 Triumph Spitfire                       |          172 |          22129.12 |
| 2005 | Min Lin Diecast           | Motorcycles      | 1969 Harley Davidson Ultimate Chopper       |          193 |          15371.40 |
| 2005 | Min Lin Diecast           | Classic Cars     | 1969 Dodge Super Bee                        |          214 |          14883.54 |
| 2005 | Min Lin Diecast           | Planes           | American Airlines: B767-300                 |          164 |          13239.58 |
| 2005 | Min Lin Diecast           | Vintage Cars     | 1912 Ford Model T Delivery Wagon            |          163 |          12232.70 |
| 2005 | Min Lin Diecast           | Ships            | 1999 Yamaha Speed Boat                      |          161 |          11997.64 |
| 2005 | Min Lin Diecast           | Vintage Cars     | 1934 Ford V8 Coupe                          |          189 |          10156.01 |
| 2005 | Motor City Art Classics   | Classic Cars     | 1972 Alfa Romeo GTA                         |          218 |          27225.84 |
| 2005 | Motor City Art Classics   | Vintage Cars     | 1937 Lincoln Berline                        |          222 |          21055.68 |
| 2005 | Motor City Art Classics   | Trucks and Buses | 1940s Ford truck                            |          182 |          19733.71 |
| 2005 | Motor City Art Classics   | Planes           | America West Airlines B757-200              |          199 |          18911.60 |
| 2005 | Motor City Art Classics   | Planes           | F/A 18 Hornet 1/72                          |          221 |          15691.20 |
| 2005 | Motor City Art Classics   | Trucks and Buses | 1980?s GM Manhattan Express                 |          157 |          13066.45 |
| 2005 | Motor City Art Classics   | Vintage Cars     | 1911 Ford Town Car                          |          150 |           7949.40 |
| 2005 | Motor City Art Classics   | Planes           | Boeing X-32A JSF                            |          171 |           7538.58 |
| 2005 | Motor City Art Classics   | Vintage Cars     | 1939 Chevrolet Deluxe Coupe                 |          194 |           5660.64 |
| 2005 | Red Start Diecast         | Motorcycles      | 2003 Harley-Davidson Eagle Drag Bike        |          209 |          34856.12 |
| 2005 | Red Start Diecast         | Classic Cars     | 1999 Indy 500 Monte Carlo SS                |          174 |          20267.28 |
| 2005 | Red Start Diecast         | Planes           | 1980s Black Hawk Helicopter                 |          144 |          19109.02 |
| 2005 | Red Start Diecast         | Vintage Cars     | 18th Century Vintage Horse Carriage         |          140 |          13110.81 |
| 2005 | Red Start Diecast         | Trucks and Buses | 1996 Peterbilt 379 Stake Bed with Outrigger |          175 |          10382.92 |
| 2005 | Red Start Diecast         | Ships            | The USS Constitution Ship                   |          131 |           8620.13 |
| 2005 | Red Start Diecast         | Vintage Cars     | 1936 Mercedes Benz 500k Roadster            |          119 |           4235.98 |
| 2005 | Second Gear Diecast       | Classic Cars     | 2001 Ferrari Enzo                           |          135 |          25416.16 |
| 2005 | Second Gear Diecast       | Classic Cars     | 1962 LanciaA Delta 16V                      |          174 |          23025.61 |
| 2005 | Second Gear Diecast       | Motorcycles      | 1974 Ducati 350 Mk3 Desmo                   |          203 |          19335.42 |
| 2005 | Second Gear Diecast       | Classic Cars     | 1969 Ford Falcon                            |          123 |          18593.04 |
| 2005 | Second Gear Diecast       | Vintage Cars     | 1936 Chrysler Airflow                       |          184 |          16858.85 |
| 2005 | Second Gear Diecast       | Planes           | American Airlines: MD-11S                   |          208 |          13312.48 |
| 2005 | Second Gear Diecast       | Planes           | Corsair F4U ( Bird Cage)                    |          203 |          12005.12 |
| 2005 | Second Gear Diecast       | Classic Cars     | 1982 Lamborghini Diablo                     |          176 |           6124.74 |
| 2005 | Studio M Art Models       | Trucks and Buses | 1940 Ford Pickup Truck                      |          185 |          20333.45 |
| 2005 | Studio M Art Models       | Classic Cars     | 1970 Plymouth Hemi Cuda                     |          205 |          14021.01 |
| 2005 | Studio M Art Models       | Ships            | The Mayflower                               |          159 |          11506.70 |
| 2005 | Studio M Art Models       | Classic Cars     | 1957 Ford Thunderbird                       |          170 |          11251.68 |
| 2005 | Studio M Art Models       | Motorcycles      | 1957 Vespa GS150                            |          165 |           9165.37 |
| 2005 | Studio M Art Models       | Vintage Cars     | 1930 Buick Marquette Phaeton                |          218 |           8576.51 |
| 2005 | Studio M Art Models       | Vintage Cars     | 1936 Mercedes-Benz 500K Special Roadster    |          168 |           8155.24 |
| 2005 | Studio M Art Models       | Vintage Cars     | 1939 Cadillac Limousine                     |          164 |           6968.20 |
| 2005 | Unimax Art Galleries      | Classic Cars     | 1992 Ferrari 360 Spider red                 |          347 |          52978.28 |
| 2005 | Unimax Art Galleries      | Motorcycles      | 2002 Suzuki XREO                            |          231 |          30434.09 |
| 2005 | Unimax Art Galleries      | Trucks and Buses | 1964 Mercedes Tour Bus                      |          181 |          20632.49 |
| 2005 | Unimax Art Galleries      | Vintage Cars     | 1903 Ford Model A                           |          126 |          16233.55 |
| 2005 | Unimax Art Galleries      | Planes           | 1900s Vintage Tri-Plane                     |          238 |          15940.74 |
| 2005 | Unimax Art Galleries      | Ships            | HMS Bounty                                  |          175 |          13769.63 |
| 2005 | Unimax Art Galleries      | Classic Cars     | 1970 Chevy Chevelle SS 454                  |          141 |           9194.58 |
| 2005 | Unimax Art Galleries      | Ships            | Pont Yacht                                  |          153 |           8014.35 |
| 2005 | Welly Diecast Productions | Classic Cars     | 1969 Dodge Charger                          |          272 |          29567.27 |
| 2005 | Welly Diecast Productions | Vintage Cars     | 1917 Grand Touring Sedan                    |          189 |          27830.70 |
| 2005 | Welly Diecast Productions | Trucks and Buses | 1958 Setra Bus                              |          197 |          23652.09 |
| 2005 | Welly Diecast Productions | Classic Cars     | 1969 Corvair Monza                          |          159 |          23121.76 |
| 2005 | Welly Diecast Productions | Classic Cars     | 1968 Dodge Charger                          |          147 |          14973.59 |
| 2005 | Welly Diecast Productions | Ships            | The Queen Mary                              |          143 |          11771.98 |
| 2005 | Welly Diecast Productions | Classic Cars     | 1971 Alpine Renault 1600s                   |          217 |          11387.72 |
| 2005 | Welly Diecast Productions | Motorcycles      | 1936 Harley Davidson El Knucklehead         |          205 |          11195.21 |
+------+---------------------------+------------------+---------------------------------------------+--------------+-------------------+


'''