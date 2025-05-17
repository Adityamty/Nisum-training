-- COUNT
SELECT COUNT(*) FROM Students;

-- SUM
SELECT SUM(Credits) FROM Courses;

-- AVG
SELECT AVG(Credits) FROM Courses;

-- MAX
SELECT MAX(Credits) FROM Courses;

-- MIN
SELECT MIN(Credits) FROM Courses;

-- GROUP BY
SELECT CourseID, COUNT(*) AS StudentCount
FROM Students
GROUP BY CourseID;

-- HAVING
SELECT CourseID, COUNT(*) AS StudentCount
FROM Students
GROUP BY CourseID
HAVING COUNT(*) > 3;
