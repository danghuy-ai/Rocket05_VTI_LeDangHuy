USE TestingSystem;
INSERT INTO Department(DepartmentName) VALUES (N'Phòng chờ');

/*Question 1*/
DROP PROCEDURE IF EXISTS HUY1;
DELIMITER $$
CREATE PROCEDURE HUY1 (IN depname VARCHAR(30))
BEGIN
	SELECT 
		a.*
	FROM
		`account` a
			JOIN
		department d ON a.DepartmentID = d.DepartmentID
	WHERE
		d.DepartmentName = depname;
END$$
DELIMITER ;

CALL HUY1 ('Marketing');

/*Question 2*/
DROP PROCEDURE IF EXISTS HUY2;
DELIMITER $$
CREATE PROCEDURE HUY2 ()
BEGIN
	SELECT 
		g.GroupID, g.GroupName, COUNT(ga.AccountID) AS count_account
	FROM
		`Group` g
			LEFT JOIN
		groupaccount ga ON g.GroupID = ga.GroupID
	GROUP BY g.GroupID;
END$$
DELIMITER ;

CALL HUY2 ();

/*Question 3*/
DROP PROCEDURE IF EXISTS HUY3;
DELIMITER $$
CREATE PROCEDURE HUY3 ()
BEGIN
	SELECT 
		a.TypeID, a.TypeName, b.number_questions
	FROM
		(SELECT 
			*
		FROM
			typequestion) AS a
			LEFT JOIN
		(SELECT 
			t.TypeID,
				t.TypeName,
				COUNT(q.QuestionID) AS number_questions
		FROM
			typequestion t
		LEFT JOIN question q ON t.TypeID = q.TypeID
		WHERE
			MONTH(q.CreateDate) = MONTH(NOW())
				AND YEAR(q.CreateDate) = YEAR(NOW())
		GROUP BY t.TypeID) AS b ON a.TypeID = b.TypeID;
END$$
DELIMITER ;

CALL HUY3 ();

/*Question 4*/
DROP PROCEDURE IF EXISTS HUY4;
DELIMITER $$
CREATE PROCEDURE HUY4 (OUT ID TINYINT)
BEGIN
	SELECT 
		a.TypeID INTO ID
	FROM
		(SELECT 
			*
		FROM
			typequestion) AS a
			LEFT JOIN
		(SELECT 
			t.TypeID,
				t.TypeName,
				COUNT(q.QuestionID) AS number_questions
		FROM
			typequestion t
		LEFT JOIN question q ON t.TypeID = q.TypeID
		GROUP BY t.TypeID) AS b ON a.TypeID = b.TypeID
	WHERE
		b.number_questions = (SELECT 
				MAX(abc.number_questions) AS max
			FROM
				(SELECT 
					a.TypeID, a.TypeName, b.number_questions
				FROM
					(SELECT 
					*
				FROM
					typequestion) AS a
				LEFT JOIN (SELECT 
					t.TypeID,
						t.TypeName,
						COUNT(q.QuestionID) AS number_questions
				FROM
					typequestion t
				LEFT JOIN question q ON t.TypeID = q.TypeID
				GROUP BY t.TypeID) AS b ON a.TypeID = b.TypeID) AS abc);
END$$
DELIMITER ;

SET @id = 0;
CALL HUY4 (@id);
SELECT @id AS ID;

/*Question 5*/
SET @id = 0;
CALL HUY4 (@id);
select * from typequestion
where TypeID = @id;

/*Question 6*/
DROP PROCEDURE IF EXISTS HUY6;
DELIMITER $$
CREATE PROCEDURE HUY6 (IN keyword VARCHAR (50))
BEGIN
	SELECT 
		*
	FROM
		`group`
	WHERE
		GroupName LIKE keyword;

	SELECT 
		*
	FROM
		`account`
	WHERE
		Username LIKE keyword;
END$$
DELIMITER ;

CALL HUY6 ('quanganh');

/*Question 7*/
DROP PROCEDURE IF EXISTS HUY7;
DELIMITER $$
CREATE PROCEDURE HUY7 (IN fullName VARCHAR (50), IN email VARCHAR (50))
BEGIN
	DECLARE userName VARCHAR (50);
    DECLARE createDate DATETIME;
    DECLARE maxID INT DEFAULT 0;
    SET userName = (SELECT SUBSTRING_INDEX(email, '@', 1));
    SET createDate = (SELECT DATE(NOW()));
    
    INSERT INTO `Account`(Email			, Username		, FullName		, DepartmentID	, PositionID, CreateDate)
	VALUES 				(email			, userName		, fullName		,   '11'		,   '1'		, createDate);
	
    SET maxID = (SELECT MAX(AccountID) FROM `Account`);
    
    SELECT * FROM `Account` WHERE AccountID IN (maxID);
END$$
DELIMITER ;

CALL HUY7 ('danghuy','ledanghuy@gmail.com');


/*Question 8*/
DROP PROCEDURE IF EXISTS HUY8;
DELIMITER $$
CREATE PROCEDURE HUY8 (IN typeNameIN ENUM('Essay','Multiple-Choice'))
BEGIN
	SELECT 
		*, LENGTH(Content) AS length_max
	FROM
		question
	WHERE
		TypeID = (SELECT 
				TypeID
			FROM
				typequestion
			WHERE
				TypeName = typeNameIN)
	HAVING length_max = (SELECT 
			MAX(LENGTH(Content))
		FROM
			question
		WHERE
			TypeID = (SELECT 
					TypeID
				FROM
					typequestion
				WHERE
					TypeName = typeNameIN));
END$$
DELIMITER ;

CALL HUY8 ('Essay');


/*Question 9*/
DROP PROCEDURE IF EXISTS HUY9;
DELIMITER $$
CREATE PROCEDURE HUY9 (IN ID TINYINT UNSIGNED, OUT record INT UNSIGNED)
BEGIN
	DECLARE table1 INT UNSIGNED DEFAULT 0;
    DECLARE table2 INT UNSIGNED DEFAULT 0;
    DECLARE table3 INT UNSIGNED DEFAULT 0;
    
    SELECT 
		COUNT(*) INTO table1
	FROM
		examquestion
	WHERE
		ExamID IN (ID);
        
	SELECT 
		COUNT(*) INTO table2
	FROM
		exam
	WHERE
		ExamID IN (ID);
        
	SET table3 = table1 + table2;
    SET record = table3;

	DELETE FROM examquestion 
	WHERE
		ExamID IN (ID);
        
	DELETE FROM exam 
	WHERE
		ExamID IN (ID);
	
END$$
DELIMITER ;

SET @soLuong = 0;
CALL HUY9 (1,@soLuong);
SELECT @soLuong;


/*Question 10*/
DROP PROCEDURE IF EXISTS HUY10;
DELIMITER $$
CREATE PROCEDURE HUY10 ()
BEGIN
	DECLARE n INT UNSIGNED DEFAULT 0;
    DECLARE ID INT UNSIGNED DEFAULT 0;
    DECLARE record INT UNSIGNED DEFAULT 0;
    
	SELECT 
		COUNT(*)
	INTO n FROM
		exam
	WHERE
		YEAR(NOW()) - YEAR(CreateDate) = 3;
    
    COMMIT;
    WHILE (n > 0) DO
		SET n = n - 1;
        SET ID = (SELECT 
						ExamID
					FROM
						exam
					WHERE
						YEAR(NOW())-YEAR(CreateDate) = 3
					LIMIT n,1);
		SET @soLuong10 = 0;
		CALL HUY9 (ID,@soLuong10);
        
        SET record = record + @soLuong10;
    END WHILE;
    
    SELECT record as record_removed;
    
END$$
DELIMITER ;

CALL HUY10 ();


/*Question 11*/
DROP PROCEDURE IF EXISTS HUY11;
DELIMITER $$
CREATE PROCEDURE HUY11 (IN depName VARCHAR(30))
BEGIN
	UPDATE `account` 
	SET 
		DepartmentID = 11
	WHERE
		DepartmentID = (SELECT 
				DepartmentID
			FROM
				department
			WHERE
				DepartmentName = depName);
                
    DELETE FROM department 
	WHERE
		DepartmentName = depName;
END$$
DELIMITER ;

CALL HUY11 ('Bảo vệ');


/*Question 12*/
DROP PROCEDURE IF EXISTS HUY12;
DELIMITER $$
CREATE PROCEDURE HUY12 ()
BEGIN
	DROP TABLE IF EXISTS MonthOfYear;
    
	CREATE TABLE MonthOfYear(
		monthOfYear  TINYINT UNSIGNED
	);
	INSERT INTO MonthOfYear VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);

	SELECT 
		a.monthOfYear, IFNULL(b.count, 0) AS count
	FROM
		MonthOfYear a
			LEFT JOIN
		(SELECT 
			MONTH(CreateDate) AS createMonth, COUNT(*) AS count
		FROM
			question
		WHERE
			YEAR(CreateDate) = YEAR(NOW())
		GROUP BY MONTH(CreateDate)
		ORDER BY MONTH(CreateDate)) b ON a.monthOfYear = b.createMonth;
        
	DROP TABLE IF EXISTS MonthOfYear;
END$$
DELIMITER ;

CALL HUY12 ();


/*Question 13*/
DROP PROCEDURE IF EXISTS HUY13;
DELIMITER $$
CREATE PROCEDURE HUY13 ()
BEGIN
	DECLARE thang TINYINT DEFAULT 0;
    DECLARE thangphu TINYINT DEFAULT 0;
    SET thang = MONTH(NOW()) - 5;
    
	DROP TABLE IF EXISTS MonthOfYear;
	CREATE TABLE MonthOfYear(
		monthOfYear  TINYINT UNSIGNED
	);
	INSERT INTO MonthOfYear VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);

	IF (thang > 0) THEN
			SELECT 
				a.monthOfYear, IFNULL(b.count, N'Không có câu hỏi nào trong tháng') AS count
			FROM
				MonthOfYear a
					LEFT JOIN
				(SELECT 
					MONTH(CreateDate) AS createMonth, COUNT(*) AS count
				FROM
					question
				WHERE
					YEAR(CreateDate) = YEAR(NOW())
						AND (MONTH(CreateDate) BETWEEN (MONTH(NOW()) - 5) AND MONTH(NOW()))
				GROUP BY MONTH(CreateDate)
				ORDER BY MONTH(CreateDate)) b ON a.monthOfYear = b.createMonth
			WHERE
				a.monthOfYear BETWEEN (MONTH(NOW()) - 5) AND MONTH(NOW());
                
		ELSE
        
			SET thangphu = 12 - thang;
            SELECT 
				a.monthOfYear, IFNULL(b.count, N'Không có câu hỏi nào trong tháng') AS count
			FROM
				MonthOfYear a
					LEFT JOIN
				(SELECT 
				MONTH(CreateDate) AS createMonth, COUNT(*) AS count
			FROM
				question
			WHERE
				(YEAR(CreateDate) = YEAR(NOW())
					AND (MONTH(CreateDate) BETWEEN 1 AND MONTH(NOW())))
					OR (YEAR(CreateDate) = (YEAR(NOW()) - 1)
					AND (MONTH(CreateDate) BETWEEN thangphu AND 12))
			GROUP BY MONTH(CreateDate)
			ORDER BY MONTH(CreateDate)) b ON a.monthOfYear = b.createMonth
			WHERE
				(a.monthOfYear BETWEEN 1 AND MONTH(NOW())) OR (a.monthOfYear BETWEEN thangphu AND 12);
    END IF;
    
	DROP TABLE IF EXISTS MonthOfYear;
END$$
DELIMITER ;

CALL HUY13 ();