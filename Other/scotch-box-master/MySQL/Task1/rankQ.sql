SET @vRank = 0;

SELECT *, (@vRank:=@vRank+1) AS rank
FROM votes
ORDER BY votes DESC;
