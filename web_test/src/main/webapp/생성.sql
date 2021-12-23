--고객Table
create table customer(
    cId varchar2(20) PRIMARY Key, --아이디
    cPw varchar2(20), --비밀번호
    cName varchar2(20), --이름
    adr VARCHAR2(20), --주소
    phone VARCHAR2(20), --전화번호
    email varchar2(20), --이메일
    cDate date DEFAULT sysdate, --가입일
    authority varchar2(20)--권한
);

--상품Table
create table product
(
    pId varchar2(20) PRIMARY KEY, --상품코드
    pName varchar2(20), --상품명
    originPrice number(20), --판매가
    salePrice number(20), --할인가
    pCount NUMBER(20), --재고수량
    pContent varchar2(100), --상세내용
    pImage varchar2(100), --이미지링크
    review number(2,1) --평점 
);

--장바구니 Table
create table ord(
    oId number(8) PRIMARY KEY, --장바구니번호
    pId varchar2(20) references product(pId) on delete CASCADE, --상품번호
    oCount number(8), --구매수량
    cId varchar2(20) references customer(cId) on delete CASCADE,--고객아이디
    oDate date DEFAULT sysdate, --장바구니등록일
    oState varchar2(20) DEFAULT '주문' --상태
);

--게시판Table
create table board(
    bId number(8) PRIMARY KEY, --게시번호
    cID varchar2(20) references customer(cId) on delete CASCADE,--FK --고객아이디
    bDate date DEFAULT sysdate, --게시일
    bPw varchar2(20), --게시글비밀번호
    bTitle varchar2(100), --제목
    bContent varchar2(100) --내용
    );

--댓글Table
create table comm(
    cmId number(8) PRIMARY KEY, --댓글번호
    tId number(8) REFERENCES board(bId), --게시번호
    cmContent varchar2(100),  --댓글내용
    cId varchar2(20) REFERENCES customer(cId) on delete CASCADE, --게시자
    cPw varchar2(20), --댓글비밀번호
    cmDate date default sysdate --댓글단날
);


--게시판 시퀀스
CREATE SEQUENCE board_seq
INCREMENT by 1
START WITH 1
MINVALUE 1
MAXVALUE 1000
NOCYCLE
NOCACHE
NOORDER;

--댓글 시퀀스
CREATE SEQUENCE comm_seq
INCREMENT by 1
START WITH 1
MINVALUE 1
MAXVALUE 1000
NOCYCLE
NOCACHE
NOORDER;

--장바구니 시퀀스
CREATE SEQUENCE ord_oId_seq
                INCREMENT BY 1
                START WITH 10
                NOCACHE
                NOCYCLE; 
                
                
                
DROP SEQUENCE comm_seq;
DROP SEQUENCE board_seq;
DROP SEQUENCE ord_oId_seq;
drop table ord;
drop table comm;
drop table board;
drop table product;
drop table customer;
