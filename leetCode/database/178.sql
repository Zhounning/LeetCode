# 经典排名问题，使用窗口函数
SELECT Score, 
    DENSE_RANK() OVER(ORDER BY Score DESC) AS 'Rank'
FROM Scores