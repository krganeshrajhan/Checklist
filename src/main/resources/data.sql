CREATE TABLE IF NOT EXISTS CHECKLIST(ID IDENTITY PRIMARY KEY, DONE BOOLEAN, TEXT VARCHAR);
DELETE FROM CHECKLIST;
INSERT INTO CHECKLIST VALUES(1, false, 'Timesheet');
INSERT INTO CHECKLIST VALUES(2, false, 'Standup');
INSERT INTO CHECKLIST VALUES(3, false, 'Unit Test');