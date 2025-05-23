CREATE TABLE DEPARTMENT (
    DEPARTMENT_ID VARCHAR(36) PRIMARY KEY,   -- 部門ID
    DEPARTMENT_NAME VARCHAR(100)             -- 部門名稱
);

CREATE TABLE EMPLOYEE (
   EMPLOYEE_ID VARCHAR(36) PRIMARY KEY,-- 員工ID
   EMPLOYEE_NAME VARCHAR(100),         -- 員工姓名
   GENDER VARCHAR(1),                  -- 性別
   BIRTH DATE,                         -- 生日
   EMAIL VARCHAR(100),                 -- 信箱
   PHONE VARCHAR(10),                  -- 手機號碼
   STATUS VARCHAR(10),                 -- 狀態
   START_DATE DATE,                    -- 建立日期
   DEPARTMENT_ID VARCHAR(36),          -- 所屬部門ID
   MODIFY_BY VARCHAR(36),              -- 修改人
   MODIFY_DATE DATE,                   -- 修改時間
   CONSTRAINT FK_EMPLOYEE_DEPT
   FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID)
);


