CREATE TABLE STUDENT_INFO
(
    ROLL_NO    INT,
    NAME       VARCHAR(25),
    ADDRESS    VARCHAR(20),
    CONTACT_NO BIGINT NOT NULL,
    AGE        INT
);

INSERT INTO STUDENT_INFO
VALUES (7, 'ROHIT', 'GAZIABAD', 9193458625, 18),
       (4, 'DEEP', 'RAMNAGAR', 9193458546, 18),
       (1, 'HARSH', 'DELHI', 9193342625, 18),
       (8, 'NIRAJ', 'ALIPUR', 9193678625, 19),
       (5, 'SAPTARHI', 'KOLKATA', 9193789625, 19),
       (2, 'PRATIK', 'BIHAR', 9193457825, 19),
       (6, 'DHANRAJ', 'BARABAJAR', 9193358625, 20),
       (3, 'RIYANKA', 'SILIGURI', 9193218625, 20);

-- order by 1st column
SELECT ROLL_NO, Name, Address
FROM STUDENT_INFO
ORDER BY 1;



SELECT GREATEST(10, 20, 30, 40, 50) AS Greatest_Value;

SELECT GREATEST('MySQL', 'MS ACCESS', 'SQL') AS GreatestValue_String;

SELECT LEAST(10, 20, 30, 40) AS Least_Value;

SELECT LEAST('MySQL', 'MS ACCESS', 'SQL') AS LeastValue_String;

SELECT NULLIF('Geeksforgeeks', 'Geeksforgeeks');

SELECT NULLIF('123', 'Geeksforgeeks') as "NULL_IF FUNCTION";

SELECT COALESCE(NULL, 'A', 'B', NULL);

CREATE TABLE float01001
(
    user_id   int NOT NULL AUTO_INCREMENT,
    float_val float,
    PRIMARY KEY (user_id)
);

INSERT float01001(float_val)
VALUES (1.9);

INSERT float01001(float_val)
VALUES (1.1);

INSERT float01001(float_val)
VALUES (3.9);

INSERT float01001(float_val)
VALUES (5.0);

INSERT float01001(float_val)
VALUES (10.9);

SELECT float_val,
       CASE
           WHEN float_val > 5 THEN 'The value is greater than 5'
           WHEN float_val = 5 THEN 'The value is 5'
           ELSE 'The value is under 5' END as float_txt
FROM float01001;
