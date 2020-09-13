CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT BEGIN
SET n = N -1;
RETURN (
    # Write your MySQL query statement below.
    Select DISTINCT Salary
    from Employee
    Order By Salary DESC
    limit n, 1
);
END