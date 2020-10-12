SELECT class
From courses 
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5
;