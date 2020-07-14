USE testingsystem;

/*Question 1*/
CREATE OR REPLACE VIEW v_huy1 AS
    SELECT 
        a.*
    FROM
        `account` a
            JOIN
        department d ON a.DepartmentID = d.DepartmentID
    WHERE
        d.DepartmentName = 'Sale';
        
SELECT 
    *
FROM
    v_huy1;


/*Question 2*/
CREATE OR REPLACE VIEW v_huy2 AS(
	WITH countGroup AS(
		SELECT 
			a.*, COUNT(g.AccountID) AS count_max_group
		FROM
			`account` a
				JOIN
			groupaccount g ON a.AccountID = g.AccountID
		GROUP BY a.AccountID)
	SELECT 
		*
	FROM
		countGroup
	WHERE
		count_max_group = (SELECT 
				MAX(count_max_group)
			FROM
				countGroup));

SELECT 
    *
FROM
    v_huy2;


/*Question 3*/
CREATE OR REPLACE VIEW v_huy3 AS(
	WITH length AS(
		SELECT 
			QuestionID, Content, LENGTH(Content) AS length_content
		FROM
			question
		HAVING length_content > 300)
	SELECT 
		*
	FROM
		length);
        
SELECT 
    *
FROM
    v_huy3;
    
DELETE FROM examquestion 
WHERE
    QuestionID IN (SELECT 
        QuestionID
    FROM
        v_huy3);
        
DELETE FROM answer 
WHERE
    QuestionID IN (SELECT 
        QuestionID
    FROM
        v_huy3);
        
DELETE FROM question 
WHERE
    QuestionID IN (SELECT 
        QuestionID
    FROM
        v_huy3);


/*Question 4*/
CREATE OR REPLACE VIEW v_huy4 AS(
	WITH dep AS(
		SELECT 
			d.*, COUNT(a.DepartmentID) AS max_employee
		FROM
			department d
				LEFT JOIN
			`account` a ON d.DepartmentID = a.DepartmentID
		GROUP BY d.DepartmentID
		ORDER BY d.DepartmentID)
        
	SELECT 
		*
	FROM
		dep
	WHERE
		max_employee = (SELECT 
				MAX(max_employee)
			FROM
				dep));
                
SELECT 
    *
FROM
    v_huy4;


/*Question 5*/
CREATE OR REPLACE VIEW v_huy5 AS
	SELECT 
		q.*, a.AccountID, a.FullName
	FROM
		question q
			JOIN
		`account` a ON a.AccountID = q.CreatorID
	WHERE
		a.FullName LIKE N'Nguyễn%';
        
SELECT 
    *
FROM
    v_huy5;
    
    