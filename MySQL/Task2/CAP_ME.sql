/*
*Enable profiling
*/
SET profiling = 1;
/*
* Drop any previous implementation of the function
*/
DROP FUNCTION IF EXISTS CAP_ME;
/*\
*Change the delimitter
*/
DELIMITER !
/*
* Actual implementation of the function
*/
CREATE FUNCTION CAP_ME(str VARCHAR(300)) RETURNS VARCHAR(300)
BEGIN
  #Declare the variables
  DECLARE capStr VARCHAR(300);
  #Change all the charcters to lower case and intialize others
  SET str = CONCAT(LOWER(str),' ');
  SET capStr = '';
  #Loop to capitalize
  WHILE(LOCATE(' ',str) > 0) DO
    SET capStr = CONCAT(capStr, ' ', CONCAT(UCASE(LEFT(LEFT(str, LOCATE(' ',str) - 1), 1)), SUBSTRING(LEFT(str, LOCATE(' ',str) - 1), 2)) );
    SET str = SUBSTRING(str, LOCATE(' ',str) + 1);
  END WHILE;
  RETURN TRIM(capStr);
END!
/*
*Change the delimitter back
*/
DELIMITER ;
/*
*Simple test
*/
SELECT CAP_ME('UNITED states Of AmERIca');
/*
*Show th executing time
*/
SHOW PROFILES;
