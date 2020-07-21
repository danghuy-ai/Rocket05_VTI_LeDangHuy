USE `classicmodels`;

/*Cau 1*/
select sum(quantityOrdered * priceEach) as 'Tong gia tri cac order'
from orders o
join orderdetails od
on o.orderNumber = od.orderNumber
where o.status = 'Shipped' and o.shippedDate > '2004-07-31' and o.shippedDate < '2004-09-01';

/*Cau 2*/
 SELECT 
    c.customerNumber,
    c.customerName,
    SUM(od.quantityOrdered * (od.priceEach - p.buyPrice)) AS profit
FROM
    customers c
        LEFT JOIN
    orders o ON c.customerNumber = o.customerNumber
        LEFT JOIN
    orderdetails od ON o.orderNumber = od.orderNumber
		LEFT JOIN
    products p ON od.productCode = p.productCode
GROUP BY c.customerNumber;

/*Cau 3*/
 SELECT 
    p.productCode,
    p.productName,
    SUM(od.quantityOrdered * od.priceEach) AS revenue
FROM
    products p
        LEFT JOIN
    orderdetails od ON p.productCode = od.productCode
GROUP BY p.productCode;
