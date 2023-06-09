CREATE TABLE EMP AS SELECT * FROM EMPLOYEES e ;
CREATE TABLE DEPT AS SELECT * FROM DEPARTMENTS;
CREATE TABLE JOB2 AS SELECT * FROM JOBS;
ALTER TABLE HR.EMP MODIFY EMAIL VARCHAR2(25) NULL;

CREATE TABLE ADMINS(
	ADMIN_ID VARCHAR2(20),
	ADMIN_PW VARCHAR2(256)
);


SELECT RANDOM()
	FROM DUAL;

INSERT INTO ADMINS VALUES('hamoon', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4');
INSERT INTO ADMINS VALUES('hyeon','f6f2ea8f45d8a057c9566a33f99474da2e5c6a6604d736121650e2730c6fb0a3');

ALTER TABLE ADMINS ADD CONSTRAINT ADMINS_PK PRIMARY KEY(ADMIN_ID);

DROP TABLE job2;
SELECT job_id FROM job2;
-- 전체조회
SELECT *
	FROM EMP e ;
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, MANAGER_ID, JOB_ID, DEPARTMENT_ID
	FROM EMP;

-- 사원등록, employee_id 중복제거
INSERT INTO EMP (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, MANAGER_ID, JOB_ID, DEPARTMENT_ID)
	VALUES((SELECT MAX(EMPLOYEE_ID)+1
				FROM EMP)
			,'MOON','HAMOON',SYSDATE,'IT_PROG','10');

-- employee_id 중복제거
SELECT MAX(EMPLOYEE_ID)+1
	FROM EMP;

-- 사원 삭제
DELETE FROM EMP e 
	WHERE EMPLOYEE_ID = '207';

SELECT *
	FROM EMP e 
	WHERE EMPLOYEE_ID = '204';

-- 직원 급여 갱신
UPDATE EMP SET SALARY = '5000'
	WHERE EMPLOYEE_ID = '204';


SELECT JOB_ID, MIN_SALARY, MAX_SALARY
	FROM JOBS;

--직업별 급여 조회
SELECT EMPLOYEE_ID, JOB_ID, SALARY, 평균급여, "부서내 급여 등수"
FROM (SELECT EMPLOYEE_ID, e.JOB_ID, SALARY, 평균급여,
		 	DENSE_RANK() OVER(PARTITION BY e.JOB_ID ORDER BY SALARY DESC) "부서내 급여 등수"
 		FROM EMP e INNER JOIN (SELECT JOB_ID, ROUND(AVG(SALARY)) 평균급여
				 	FROM EMP e 
				 	GROUP BY JOB_ID) e2
	ON e.JOB_ID = e2.JOB_ID)
	WHERE EMPLOYEE_ID = '100';
	
-- SALARY를 업데이트할 때 JOBS의 최소급여 최대급여 안에서만 갱신되도록 처리하는 트리거
CREATE OR REPLACE TRIGGER TRG_UPDATE_JOB2_EMP_ID
BEFORE UPDATE OF JOB_ID ON JOB2
FOR EACH ROW
DECLARE
    V_OLD_JOB_ID EMP.JOB_ID%TYPE;
    V_NEW_JOB_ID EMP.JOB_ID%TYPE;
BEGIN
    -- 이전 JOB_ID와 새로운 JOB_ID를 저장
    V_OLD_JOB_ID := :OLD.JOB_ID;
    V_NEW_JOB_ID := :NEW.JOB_ID;

    -- EMP 테이블의 JOB_ID 갱신
    UPDATE EMP
    SET JOB_ID = V_NEW_JOB_ID
    WHERE JOB_ID = V_OLD_JOB_ID;
END;

DROP TRIGGER TRG_EMP_SALARY;

-- 사원의 매니저 조회
SELECT e.EMPLOYEE_ID , e.FIRST_NAME , e2.EMPLOYEE_ID AS MANAGER_ID, e2.LAST_NAME AS MANAGER
	FROM EMP e , EMP e2 
	WHERE e.MANAGER_ID = e2.EMPLOYEE_ID
	AND e.EMPLOYEE_ID = '204';

-- 사원의 부서 이름 조회
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, DEPARTMENT_NAME
	FROM DEPT  JOIN EMP 
	USING(DEPARTMENT_ID)
	WHERE EMPLOYEE_ID = '103';

-- 부서 이름 갱신
UPDATE DEPT SET DEPARTMENT_NAME = 'Admin'
	WHERE DEPARTMENT_NAME = 'Administration';

-- 사원의 직업 이름 조회
SELECT EMPLOYEE_ID, JOB_ID, JOB_TITLE
	FROM JOB2 JOIN EMP
	USING(JOB_ID)
	WHERE EMPLOYEE_ID = '200';

-- 직업 이름 갱신
UPDATE JOB2 SET JOB_ID = 'IT_PROG'
		WHERE JOB_ID = 'IT_FROG';

SELECT *
	FROM EMP e 
	WHERE JOB_ID = 'IT_PROG';