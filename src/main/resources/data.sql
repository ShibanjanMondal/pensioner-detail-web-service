

INSERT INTO BANK_DETAIL
SELECT Aadhaar_No,
ACCOUNT_NO,
BANK_NAME,
BANK_TYPE
 FROM CSVREAD('classpath:pensioner-details-database.csv');


INSERT INTO PENSIONER_DETAIL
SELECT Aadhaar_No,
PAN,
Allowances,
DOB,
Name,
Pension_Type,
Last_Earned_Salary

 FROM CSVREAD('classpath:pensioner-details-database.csv');