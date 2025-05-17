CREATE TABLE Students (
  StudentID INT PRIMARY KEY,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  DateOfBirth DATE,
  Email VARCHAR(100)
);


CREATE TABLE Courses (
  CourseID INT PRIMARY KEY,
  CourseName VARCHAR(100),
  Credits INT
);


CREATE TABLE Enrollments (
  EnrollmentID INT PRIMARY KEY,
  StudentID INT,
  CourseID INT,
  EnrollmentDate DATE,
  FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
  FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);


INSERT INTO Students (StudentID, FirstName, LastName, DateOfBirth, Email) VALUES
(1, 'Alice', 'Smith', '2001-04-10', 'alice@example.com'),
(2, 'Bob', 'Johnson', '2000-08-22', 'bob@example.com'),
(3, 'Charlie', 'Brown', '1999-12-05', 'charlie@example.com'),
(4, 'Daisy', 'White', '2002-07-15', 'daisy@example.com'),
(5, 'Ethan', 'Black', '2003-01-20', 'ethan@example.com'),
(6, 'Fiona', 'Green', '2001-11-12', 'fiona@example.com'),
(7, 'George', 'Hill', '2000-02-18', 'george@example.com'),
(8, 'Hannah', 'Baker', '1998-03-30', 'hannah@example.com'),
(9, 'Ishaan', 'Kumar', '2002-10-10', 'ishaan@example.com'),
(10, 'Jenny', 'Liu', '2001-05-22', 'jenny@example.com'),
(11, 'Kevin', 'Lee', '2000-09-09', 'kevin@example.com'),
(12, 'Liam', 'Jones', '1999-06-25', 'liam@example.com'),
(13, 'Mia', 'Rodriguez', '2002-12-01', 'mia@example.com'),
(14, 'Noah', 'Kim', '2003-03-11', 'noah@example.com'),
(15, 'Olivia', 'Nguyen', '2001-01-05', 'olivia@example.com'),
(16, 'Paul', 'Singh', '2000-04-14', 'paul@example.com'),
(17, 'Queenie', 'Wang', '2003-05-19', 'queenie@example.com'),
(18, 'Raj', 'Patel', '2002-08-08', 'raj@example.com'),
(19, 'Samantha', 'Clark', '1999-10-02', 'samantha@example.com'),
(20, 'Tom', 'Adams', '2001-06-13', 'tom@example.com');


INSERT INTO Courses (CourseID, CourseName, Credits) VALUES
(101, 'Database Systems', 4),
(102, 'Data Structures', 4),
(103, 'Web Development', 3),
(104, 'Operating Systems', 4),
(105, 'Networking', 3),
(106, 'Machine Learning', 5);


INSERT INTO Enrollments (EnrollmentID, StudentID, CourseID, EnrollmentDate) VALUES
(1, 1, 101, '2024-01-10'),
(2, 2, 102, '2024-01-12'),
(3, 3, 101, '2024-01-15'),
(4, 4, 103, '2024-01-18'),
(5, 5, 104, '2024-01-20'),
(6, 6, 105, '2024-01-22'),
(7, 7, 106, '2024-01-25'),
(8, 8, 101, '2024-01-28'),
(9, 9, 102, '2024-02-01'),
(10, 10, 103, '2024-02-03'),
(11, 11, 104, '2024-02-06'),
(12, 12, 105, '2024-02-08'),
(13, 13, 106, '2024-02-10'),
(14, 14, 101, '2024-02-12'),
(15, 15, 102, '2024-02-15'),
(16, 16, 103, '2024-02-17'),
(17, 17, 104, '2024-02-19'),
(18, 18, 105, '2024-02-22'),
(19, 19, 106, '2024-02-24'),
(20, 20, 101, '2024-02-26'),
(21, 1, 102, '2024-03-01'),
(22, 2, 103, '2024-03-02'),
(23, 3, 104, '2024-03-03'),
(24, 4, 105, '2024-03-04'),
(25, 5, 106, '2024-03-05');
