
CREATE PROCEDURE getStudentById(IN p_id INT)
BEGIN
    SELECT id, name, age
    FROM students
    WHERE id = p_id;
END 
