SELECT customers.Name as 'Customers'
FROM customers
WHERE customers.id
not in
(
select customerid
from orders
);