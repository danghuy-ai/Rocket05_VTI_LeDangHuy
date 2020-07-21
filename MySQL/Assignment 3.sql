USE Qlybaithi;

/*Question 1*/
INSERT INTO department (departmentName) VALUES ('Ke toan'),
('Nhan su'),
('Giam sat va Quan ly'),
('Marketing'),
('Creating content'),
('Ky thuat'),
('Sale'),
('Cong doan'),
('Kiem toan'),
('Security');

INSERT INTO position (positionName) VALUES ('Chu tich hoi dong quan tri'),
('Giam doc'),
('Pho giam doc'),
('Truong phong'),
('Pho phong'),
('Quan ly'),
('Nhan vien chinh thuc'),
('Nhan vien hop dong'),
('Nhan vien thu viec'),
('Thuc tap sinh');

INSERT INTO `account` (email,username,fullName,departmentID,positionID,createDate) VALUES ('demo@gmail.com', 'Tran Trang','Tran Thao Trang','1','2','2020-01-01'),
('demo1@gmail.com', 'Pham Manh','Pham Duc Manh','1','6','2020-01-01'),
('demo2@gmail.com', 'Tran Nam','Tran Van Nam','1','7','2020-01-01'),
('demo3@gmail.com', 'Nguyen Tung','Nguyen Van Tung','4','2','2020-01-05'),
('demo4@gmail.com', 'Nguyen Thao','Nguyen Minh Thao','4','7','2020-01-01'),
('demo5@gmail.com', 'Tran An','Tran Van An','5','2','2020-01-10'),
('demo6@gmail.com', 'Tran Cung','Tran Manh Cung','5','6','2020-01-01'),
('demo7@gmail.com', 'Phan Thang','Phan Huy Thang','5','7','2020-01-05'),
('demo8@gmail.com', 'Le Nhung','Le Hong Nhung','5','10','2020-05-01'),
('demo9@gmail.com', 'Le Huy','Le Dang Huy','3','1','2020-01-01');

INSERT INTO `group` (groupName,creatorID,createDate) VALUES ('Group phong ban Ke toan',1,'2020-01-05'),
('Group phong ban Nhan su',10,'2020-07-04'),
('Group phong ban Giam sat va Quan ly',10,'2020-01-25'),
('Group phong ban Marketing',4,'2020-01-15'),
('Group phong ban Creating Content',5,'2020-06-01'),
('Group phong ban Ky thuat',10,'2020-01-05'),
('Group phong ban Sale',10,'2020-01-22'),
('Group phong ban Cong doan',10,'2020-06-05'),
('Group phong ban Kiem toan',10,'2020-01-05'),
('Group phong ban Security',10,'2020-07-05');

INSERT INTO groupAccount VALUES (1,1,'2020-01-05'),
(1,2,'2020-01-06'),
(1,3,'2020-01-20'),
(4,4,'2020-01-05'),
(4,5,'2020-01-07'),
(5,6,'2020-01-05'),
(5,7,'2020-01-05'),
(5,8,'2020-01-08'),
(5,9,'2020-01-28'),
(3,10,'2020-01-05');

INSERT INTO typeQuestion VALUES (1,'Trac nghiem IQ'),
(2,'Trac nghiem nang luc'),
(3,'Trac nghiem dau vao'),
(4,'Tu luan chung'),
(5,'Danh gia sang tao'),
(6,'Danh gia dinh ky nhan vien');

INSERT INTO categoryQuestion (categoryName) VALUES ('Ve cong ty'),
('Ve ban than'),
('Kien thuc chung'),
('Kien thuc chuyen mon'),
('Su hieu biet ve nganh'),
('Danh gia tuong lai cua nganh'),
('Dinh huong ve nganh'),
('Cau hoi them'),
('Hieu biet xa hoi'),
('Nhung van de lien quan khac');

INSERT INTO question (content,categoryID,typeID,creatorID,createDate) VALUES ('demo',1,3,10,'2020-05-01'),
('demo 1',2,3,10,'2020-05-01'),
('demo mot chut',4,3,10,'2020-05-05'),
('demo 2',8,1,10,'2020-05-06'),
('demo 3',10,6,10,'2020-05-01'),
('demo',2,6,10,'2020-05-01'),
('demo 1',2,6,10,'2020-05-10'),
('demo 2',10,6,10,'2020-05-01'),
('demo 2',10,5,10,'2020-06-01'),
('demo 2',1,1,10,'2020-05-03');

INSERT INTO answer (content,questionID,isCorrect) VALUES ('Demo',1,'Correct'),
('Demo',2,'Wrong'),
('Demo34',2,'Correct'),
('Demo34',2,'Wrong'),
('Demo24',2,'Correct'),
('Demo3423',2,'Correct'),
('Demo1',3,'Correct'),
('Demo chut',4,'Wrong'),
('Demo',5,'Correct'),
('Demo',6,'Wrong'),
('Demo 2',7,'Correct'),
('Demo1',8,'Correct'),
('Demo',9,'Wrong'),
('Demo',10,'Correct');

INSERT INTO exam (codeExam,title,categoryID,duration,creatorID,createDate) VALUES (1,'Demo 1 chut',1,'2019-01-01 01:00:00',10,'2019-05-20'),
(1,'Demo',2,'2019-01-01 01:30:00',10,'2019-05-19'),
(1,'Demo',4,'2019-01-01 01:00:00',10,'2019-05-20'),
(2,'Demo',7,'2019-01-01 01:00:00',10,'2019-05-25'),
(2,'Demo',3,'2019-01-01 01:30:00',10,'2019-05-25'),
(1,'Demo',3,'2019-01-01 01:00:00',10,'2020-05-20'),
(3,'Demo',4,'2019-01-01 00:45:00',10,'2019-06-20'),
(3,'Demo',8,'2019-01-01 00:30:00',10,'2019-06-20'),
(1,'Demo',6,'2019-01-01 01:00:00',10,'2019-12-10'),
(2,'Demo',1,'2019-01-01 01:00:00',10,'2019-05-27');

INSERT INTO examQuestion VALUES (1,1),
(1,4),
(2,3),
(2,7),
(1,7),
(3,7),
(5,5),
(6,8),
(8,9),
(10,4);

/*Question 2*/
SELECT 
    *
FROM
    department;

/*Question 3*/
SELECT 
    departmentID
FROM
    department
WHERE
    departmentName = 'Sale';

/*Question 4*/
SELECT 
    MAX(fullName)
FROM
    `account`;
    
SELECT 
    *
FROM
    `account`
ORDER BY fullName DESC;

/*Question 5*/
SELECT 
    *
FROM
    `account`
WHERE
    departmentID = 3
ORDER BY fullName DESC
LIMIT 1;

/*Question 6*/
SELECT 
    groupName
FROM
    `group`
WHERE
    createDate < '2019-12-20';

/*Question 7*/
SELECT 
    questionID
FROM
    answer
GROUP BY questionID
HAVING COUNT(questionID) >= 4;

/*Question 8*/
SELECT 
    examID
FROM
    exam
WHERE
    duration >= '2019-01-01 01:00:00'
        AND createDate < '2019-12-20';

/*Question 9*/
SELECT 
    *
FROM
    `group`
ORDER BY createDate DESC
LIMIT 5;

/*Question 10*/
SELECT 
    COUNT(accountID) AS count_employee
FROM
    `account`
WHERE
    departmentID = 3;

/*Question 11*/
SELECT 
    *
FROM
    `account`
WHERE
    fullName LIKE ('D%')
        AND fullName LIKE ('%o');

