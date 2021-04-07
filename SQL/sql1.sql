-- table 생성
CREATE TABLE book (
    book_id NUMBER(4),
    book_name VARCHAR2(20),
    book_loc VARCHAR2(20)
    );
-- table 검색
SELECT * FROM tab;

-- 테이블 삭제
DROP TABLE book;

-- table 생성 - 제약조건
CREATE TABLE book (
    book_id NUMBER(4) CONSTRAINT book_id_pk PRIMARY KEY,
    book_name VARCHAR2(20),
    book_loc VARCHAR2(20)
    );

--database에 commit
COMMIT;

-- 시퀀스 삭제
DROP SEQUENCE book_seq;

-- 시퀀스 생성 (book_id 자동생성 등과 같은 일을 해주는 객체
CREATE SEQUENCE book_seq;

-- 데이터 추가
INSERT INTO
    book(book_id, book_name, book_loc)
VALUES
(BOOK_SEQ.NEXTVAL, 'book1', '001-00001');