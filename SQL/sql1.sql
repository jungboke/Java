-- setting 다끝나면 항상 commit해줘야 데이터 변경사항 저장되고,
-- 실행원하는 부분에 드래그해서 ctl+enter해야 실행됨.

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
(BOOK_SEQ.NEXTVAL, 'book5', '001-00023');

-- 데이터 수정
UPDATE book SET book_loc = '005-00055'
WHERE BOOK_NAME = 'book2';

-- 데이터 삭제
DELETE FROM book
WHERE book_id = 2;

-- 데이터 검색
SELECT * FROM book;

SELECT book_name AS 책이름, book_loc AS 책위치 FROM book;

-- 데이터 검색 + 조건
SELECT * FROM book WHERE book_id LIKE '1%';
-- 데이터 검색 + 정렬
SELECT * FROM book ORDER BY book_loc ASC;
SELECT * FROM book ORDER BY book_loc DESC;
