--Автор: Александр Гилимович

USE students;
-- 1
-- Имена и фамилии успешно сдавших экзамен, упорядочить по результату (отличники первые)
SELECT 
    e.id, e_r.result, st.first_name, st.last_name
FROM
    student AS st
        INNER JOIN
    (exam_result AS e_r
    INNER JOIN exam AS e ON e.id = e_r.exam_id) ON st.id = e_r.student_id
WHERE
    e.id = 1
ORDER BY e_r.result DESC;

-- 2
-- Количество студентов успешно сдавших экзамен на 4, 5
SELECT 
    COUNT(*)
FROM
    student AS st
        INNER JOIN
    exam_result AS e_r ON st.id = e_r.student_id
WHERE
    e_r.result > 3;


-- 3
-- Количество сдавших автоматом (в exam_result нет, в student_result положительный результат)
SELECT 
    count(*)
FROM
    student_result AS s_r
        INNER JOIN
    (training_course AS t_c
    INNER JOIN exam AS e ON t_c.id = e.training_course_id) ON s_r.training_course_id = t_c.id
        LEFT OUTER JOIN
    exam_result AS e_r ON s_r.student_id = e_r.student_id
        AND e.id = e_r.exam_id
WHERE
    e_r.exam_id IS NULL;


-- 4
-- Средний балл студентов по предмету СУБД
SELECT 
    AVG(s_r.result)
FROM
    student_result AS s_r
        INNER JOIN
    training_course AS t_r ON s_r.training_course_id = t_r.id
WHERE
    t_r.name = 'RDBMS';

-- 5
-- Имена и фамилии студентов, не сдававших теорию графов
-- 5.1
SELECT 
     st.id, st.first_name, st.last_name
FROM
    student AS st
        INNER JOIN
    (student_result AS s_r
    INNER JOIN (training_course AS t_c
    INNER JOIN exam AS e ON t_c.id = e.training_course_id) ON t_c.id = s_r.training_course_id) ON st.id = s_r.student_id
    LEFT OUTER JOIN exam_result AS e_r ON s_r.student_id = e_r.student_id AND e_r.exam_id = e.id
WHERE t_c.name = 'Literature' AND e_r.exam_id is NULL;


-- 5.2
SELECT 
    st.id, st.first_name, st.last_name
FROM
    student AS st
        INNER JOIN
    (student_result AS s_r
    INNER JOIN (training_course AS t_c
    INNER JOIN exam AS e ON t_c.id = e.training_course_id) ON t_c.id = s_r.training_course_id) ON st.id = s_r.student_id
WHERE
    NOT EXISTS( SELECT 
            *
        FROM
            exam_result AS e_r
        WHERE
            e_r.student_id = st.id
                AND e_r.exam_id = e.id)
        AND t_c.name = 'Literature';

-- 5.3

SELECT 
    st.id, st.first_name, st.last_name
FROM
    student AS st
        INNER JOIN
    (student_result AS s_r
    INNER JOIN training_course AS t_c ON s_r.training_course_id = t_c.id) ON st.id = s_r.student_id
WHERE
    t_c.name = 'Literature'
        AND s_r.student_id NOT IN (SELECT 
            e_r.student_id
        FROM
            exam_result AS e_r
        WHERE
            exam_id = 2);

-- 6
-- Идентификатор преподавателей, читающих лекции по более, чем 2 предметам
SELECT 
     t_c.teacher_id
FROM
    training_course AS t_c
 GROUP BY teacher_id
 HAVING COUNT(teacher_id) >1
;
    

-- 7
-- id, фамилии студентов, пересдавших хотя бы 1 предмет
SELECT 
    st.id, st.last_name, t_c.id, e.id, e_r.result, s_r.result
FROM
    student AS st
        INNER JOIN
    (student_result AS s_r
    INNER JOIN (training_course AS t_c
    INNER JOIN (exam AS e
    INNER JOIN exam_result AS e_r ON e.id = e_r.exam_id) ON t_c.id = e.training_course_id) ON t_c.id = s_r.training_course_id) ON st.id = s_r.student_id
WHERE
    s_r.result > e_r.result
        AND st.id = e_r.student_id;


-- 8
-- Имена и фамилии 5 студентов с макс оценками
SELECT 
    st.last_name, st.first_name, AVG(s_r.result) AS result
FROM
    student AS st
        INNER JOIN
    student_result AS s_r ON st.id = s_r.student_id
GROUP BY st.last_name
ORDER BY result DESC
LIMIT 5;

-- 9
-- Фамилия преподавателя с наилучшими результатами по его предметам
SELECT 
    t.last_name, AVG(s_r.result) AS res
FROM
    techer AS t
        INNER JOIN
    (training_course AS t_c
    INNER JOIN student_result AS s_r ON t_c.id = s_r.training_course_id) ON t.id = t_c.teacher_id
GROUP BY t.last_name
ORDER BY res DESC
LIMIT 1;

-- 10
-- Успеваемость студентов по годам по предмету мат статистика по годам

SELECT 
    YEAR(s_r.date) AS year, AVG(s_r.result) AS res
FROM
    student_result AS s_r
        INNER JOIN
    training_course AS t_c ON s_r.training_course_id = t_c.id
WHERE
    t_c.name = 'Literature'
GROUP BY year
ORDER BY year;








