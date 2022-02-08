
/* Drop Tables */

DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP TABLE TEST_Member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE BOARD
(
	NUM number NOT NULL,
	-- 회원 아이디
	ID varchar2(20) NOT NULL,
	PRIMARY KEY (NUM)
);


CREATE TABLE TEST_Member
(
	-- 회원 아이디
	ID varchar2(20) NOT NULL,
	-- 회원 이름
	NAME varchar2(20) NOT NULL,
	PRIMARY KEY (ID)
);



/* Create Foreign Keys */

ALTER TABLE BOARD
	ADD FOREIGN KEY (ID)
	REFERENCES TEST_Member (ID)
;



/* Comments */

COMMENT ON COLUMN BOARD.ID IS '회원 아이디';
COMMENT ON COLUMN TEST_Member.ID IS '회원 아이디';
COMMENT ON COLUMN TEST_Member.NAME IS '회원 이름';



