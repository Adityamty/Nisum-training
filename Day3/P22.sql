-- INNER JOIN
SELECT Students.FirstName, Courses.CourseName
FROM Students
INNER JOIN Courses ON Students.CourseID = Courses.CourseID;

-- LEFT JOIN
SELECT Courses.CourseName, Students.FirstName
FROM Courses
LEFT JOIN Students ON Students.CourseID = Courses.CourseID;

-- RIGHT JOIN 
SELECT Students.FirstName, Courses.CourseName
FROM Students
RIGHT JOIN Courses ON Students.CourseID = Courses.CourseID;

-- FULL OUTER JOIN
SELECT Students.FirstName, Courses.CourseName
FROM Students
FULL OUTER JOIN Courses ON Students.CourseID = Courses.CourseID;
