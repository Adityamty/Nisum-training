-- Insert into studentDetails
INSERT INTO studentDetails (StudentID, CourseID, Email, FirstName, LastName)
VALUES 
(1, 101, 'john1@example.com', 'John', 'Doe'),
(2, 101, 'sara2@example.com', 'Sara', 'Lee'),
(3, 102, 'mike3@example.com', 'Mike', 'Smith'),
(4, 102, 'nina4@example.com', 'Nina', 'Brown'),
(5, 103, 'lisa5@example.com', 'Lisa', 'Taylor'),
(6, 103, 'alex6@example.com', 'Alex', 'White'),
(7, 104, 'eric7@example.com', 'Eric', 'Black'),
(8, 104, 'rose8@example.com', 'Rose', 'Green'),
(9, 105, 'dave9@example.com', 'Dave', 'Gray'),
(10, 105, 'emma10@example.com', 'Emma', 'Wood');

-- Insert into employee
INSERT INTO Employee (EmployeeID, Name, Email, Department, Designation)
VALUES
(1, 'Alice', 'alice@example.com', 'HR', 'Manager'),
(2, 'Bob', 'bob@example.com', 'IT', 'Developer'),
(3, 'Charlie', 'charlie@example.com', 'Finance', 'Analyst'),
(4, 'Diana', 'diana@example.com', 'Sales', 'Executive'),
(5, 'Ethan', 'ethan@example.com', 'Marketing', 'Lead'),
(6, 'Fiona', 'fiona@example.com', 'Support', 'Technician'),
(7, 'George', 'george@example.com', 'HR', 'Recruiter'),
(8, 'Hannah', 'hannah@example.com', 'IT', 'DevOps'),
(9, 'Ivan', 'ivan@example.com', 'Finance', 'Clerk'),
(10, 'Jenny', 'jenny@example.com', 'Sales', 'Consultant');

-- Insert into salary
INSERT INTO Salary (SalaryID, EmployeeID, Amount)
VALUES
(1, 1, 70000),
(2, 2, 65000),
(3, 3, 60000),
(4, 4, 55000),
(5, 5, 58000),
(6, 6, 50000),
(7, 7, 52000),
(8, 8, 68000),
(9, 9, 47000),
(10, 10, 53000);

-- Insert into course
INSERT INTO Courses (CourseID, CourseName, Credits)
VALUES
(101, 'Database Systems', 4),
(102, 'Data Structures', 4),
(103, 'Operating Systems', 3),
(104, 'Computer Networks', 3),
(105, 'Software Engineering', 3),
(106, 'Web Development', 2),
(107, 'Mobile App Dev', 2),
(108, 'Cloud Computing', 3),
(109, 'Cybersecurity', 3),
(110, 'AI & Machine Learning', 4);
