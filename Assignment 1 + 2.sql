CREATE DATABASE Qlybaithi;
USE Qlybaithi;

CREATE TABLE department (
    departmentID INT AUTO_INCREMENT,
    departmentName VARCHAR(50),
    PRIMARY KEY (departmentID)
);

CREATE TABLE position (
    positionID INT AUTO_INCREMENT,
    positionName VARCHAR(50),
    PRIMARY KEY (positionID)
);

CREATE TABLE `account` (
    accountID INT AUTO_INCREMENT,
    email VARCHAR(50),
    username VARCHAR(50),
    fullName VARCHAR(50),
    departmentID INT,
    positionID INT,
    createDate DATE,
    PRIMARY KEY (accountID),
    FOREIGN KEY (departmentID)
        REFERENCES department (departmentID)
        ON DELETE CASCADE,
    FOREIGN KEY (positionID)
        REFERENCES position (positionID)
        ON DELETE CASCADE,
    UNIQUE KEY (email)
);

CREATE TABLE `group` (
    groupID INT AUTO_INCREMENT,
    groupName VARCHAR(50),
    creatorID INT,
    createDate DATE,
    PRIMARY KEY (groupID),
    FOREIGN KEY (creatorID)
        REFERENCES `account` (accountID)
        ON DELETE CASCADE
);

CREATE TABLE groupAccount (
    groupID INT,
    accountID INT,
    joinDate DATE,
    PRIMARY KEY (groupID , accountID),
    FOREIGN KEY (groupID)
        REFERENCES `group` (groupID)
        ON DELETE CASCADE,
    FOREIGN KEY (accountID)
        REFERENCES `account` (accountID)
        ON DELETE CASCADE
);

CREATE TABLE typeQuestion (
    typeID INT,
    typeName VARCHAR(30),
    PRIMARY KEY (typeID)
);

CREATE TABLE categoryQuestion (
    categoryID INT AUTO_INCREMENT,
    categoryName VARCHAR(30),
    PRIMARY KEY (categoryID)
);

CREATE TABLE question (
    questionID INT AUTO_INCREMENT,
    content VARCHAR(300),
    categoryID INT,
    typeID INT,
    creatorID INT,
    createDate DATE,
    PRIMARY KEY (questionID),
    FOREIGN KEY (categoryID)
        REFERENCES categoryQuestion (categoryID)
        ON DELETE CASCADE,
    FOREIGN KEY (typeID)
        REFERENCES typeQuestion (typeID)
        ON DELETE CASCADE,
    FOREIGN KEY (creatorID)
        REFERENCES `account` (accountID)
        ON DELETE CASCADE
);

CREATE TABLE answer (
    answerID INT AUTO_INCREMENT,
    content VARCHAR(100),
    questionID INT,
    isCorrect ENUM('Correct', 'Wrong'),
    PRIMARY KEY (answerID),
    FOREIGN KEY (questionID)
        REFERENCES question (questionID)
        ON DELETE CASCADE
);

CREATE TABLE exam (
    examID INT AUTO_INCREMENT,
    codeExam INT,
    title VARCHAR(50),
    categoryID INT,
    duration DATETIME,
    creatorID INT,
    createDate DATE,
    PRIMARY KEY (examID),
    FOREIGN KEY (categoryID)
        REFERENCES categoryQuestion (categoryID)
        ON DELETE CASCADE,
    FOREIGN KEY (creatorID)
        REFERENCES `account` (accountID)
        ON DELETE CASCADE
);

CREATE TABLE examQuestion (
    examID INT,
    questionID INT,
    PRIMARY KEY (examID , questionID),
    FOREIGN KEY (examID)
        REFERENCES exam (examID)
        ON DELETE CASCADE,
    FOREIGN KEY (questionID)
        REFERENCES question (questionID)
        ON DELETE CASCADE
);
