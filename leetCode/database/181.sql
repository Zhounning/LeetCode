Select a.Name AS 'Employee'
from Employee AS a,
    Employee AS b
where a.ManagerId = b.Id
    and a.salary > b.salary