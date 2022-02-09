-- GR_Project

-- 회원 가입 테이블
--create table Join (
--    custid      varchar2(50)        not null,
--    password    varchar2(50)        not null,
--    name        varchar2(50)        not null,
--    email       varchar2(50),
--    jnum        number              primary key
--);

-- 회원 가입 번호
--create sequence jnum_seq start with 1 increment by 1;

-- 게시판 본문 글
--create table kkyboard (
--	boardnum		number	        primary key,		--글번호
--	id				varchar2(20)    not null,	        --작성자 ID
--	title			varchar2(100)   not null,		    --글제목
--	content			varchar2(2000)  not null,	        --글내용
--	inputdate		date	        default sysdate,	--작성날짜,시간
--	hits			number 	        default 0,		    --조회수
--	originalfile	varchar2(200),			            --첨부파일명 (원래 이름)
--	savedfile		varchar2(100)			            --첨부파일명 (실제 저장된 이름)
--);

-- 게시판 일련번호에 사용할 시퀀스 
--create sequence kkyboard_seq start with 1 increment by 1;

-- 리플 내용
--create table kkyreply (
--	replynum		number	        primary key,		--리플번호
--	boardnum		number          not null,			--본문 글번호
--	id				varchar2(20)    not null,		    --작성자 ID
--	text			varchar2(200)   not null,		    --리플내용
--	inputdate		date 	        default sysdate,	--작성날짜
--	constraint kkyreply_fk foreign key(boardnum) 
--		references kkyboard(boardnum) on delete cascade
--);

-- 리플에 사용할 시퀀스
--create sequence kkyreply_seq start with 1 increment by 1;

create table web3_member(
    id          varchar2(20)    primary key,
    password    varchar2(20)    not null,
    name        varchar2(20)    not null
);
insert into web3_member(id, password, name) values('aaa', '1234', '홍길동');