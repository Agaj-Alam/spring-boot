INSERT INTO student (name) VALUES ('Agaj Alam'),('Rohit Verma'),('Sneha Patel'),('Anjali Gupta'),('Vikas Kumar'),('Neha Singh'),('Saurabh Yadav'),('Priya Nair'),('Ramesh Mehta'),('Pooja Rani');


INSERT INTO professor (title) VALUES
('Dr. Rakesh Mehta'),
('Dr. Anjali Sharma'),
('Dr. Amit Verma'),
('Dr. Priya Nair'),
('Dr. Sunil Gupta');


-- Dr. Rakesh Mehta (id=1) teaches Students 1,2,3
INSERT INTO professor_student (professor_id, student_id) VALUES
(1, 1),
(1, 2),
(1, 3);

-- Dr. Anjali Sharma (id=2) teaches Students 4,5
INSERT INTO professor_student (professor_id, student_id) VALUES
(2, 4),
(2, 5);

-- Dr. Amit Verma (id=3) teaches Students 6,7,8
INSERT INTO professor_student (professor_id, student_id) VALUES
(3, 6),
(3, 7),
(3, 8);

-- Dr. Priya Nair (id=4) teaches Students 9,10
INSERT INTO professor_student (professor_id, student_id) VALUES
(4, 9),
(4, 10);

-- Dr. Sunil Gupta (id=5) teaches Students 1,5,10
INSERT INTO professor_student (professor_id, student_id) VALUES
(5, 1),
(5, 5),
(5, 10);




INSERT INTO subject (title, professor_id) VALUES
('Mathematics', 1),
('Physics', 1),
('Chemistry', 2),
('Biology', 2),
('Computer Science', 3),
('History', 4),
('English', 5);


INSERT INTO student_subject (student_id, subject_id) VALUES
-- Student 1 -> Math, Physics, Chemistry
(1, 1),
(1, 2),
(1, 3),

-- Student 2 -> Physics, English
(2, 2),
(2, 4),

-- Student 3 -> Math, Computer Science
(3, 1),
(3, 5),

-- Student 4 -> Chemistry, Physics, Computer Science
(4, 3),
(4, 2),
(4, 5),

-- Student 5 -> English, Math
(5, 4),
(5, 1),

-- Student 6 -> Computer Science, Chemistry
(6, 5),
(6, 3),

-- Student 7 -> Math, English, Physics
(7, 1),
(7, 4),
(7, 2),

-- Student 8 -> Physics, Chemistry
(8, 2),
(8, 3),

-- Student 9 -> Math, Computer Science, English
(9, 1),
(9, 5),
(9, 4),

-- Student 10 -> All subjects
(10, 1),
(10, 2),
(10, 3),
(10, 4),
(10, 5);



INSERT INTO admission_record (fees, student_id) VALUES
(25000, 1),
(30000, 2),
(28000, 3),
(35000, 4),
(40000, 5),
(26000, 6),
(27000, 7),
(29000, 8),
(31000, 9),
(33000, 10);
