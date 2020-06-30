
/* Drop Tables */

DROP TABLE test_ticket CASCADE CONSTRAINTS;
DROP TABLE test_card CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_ticket
(
	user_id varchar2(20) NOT NULL,
	ticket_count number NOT NULL,
	CONSTRAINT ticket_buy_limit
	CHECK(ticket_count BETWEEN 1 AND 5)
);


CREATE TABLE test_card
(
	user_id varchar2(20) NOT NULL,
	buy_amount number DEFAULT 1
);


SELECT * FROM test_card;
SELECT * FROM test_ticket;
-- ticket 2장을 카드로 결제하는 경우

INSERT INTO test_card VALUES('aaa',2);
INSERT INTO test_ticket VALUES('aaa',2);


--ticket 5장을 카드로 결제하는 경우

INSERT INTO test_card VALUES('aaa',5);
INSERT INTO test_ticket VALUES('aaa',5);


--ticket 6장을 크라드로 결제하는 경우

INSERT INTO test_card VALUES('aaa',6);
INSERT INTO test_ticket VALUES('aaa',6);




