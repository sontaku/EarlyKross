-- 선수
ALTER TABLE `player`
	DROP FOREIGN KEY `FK_club_TO_player`; -- 클럽 -> 선수

-- 리그
ALTER TABLE `league`
	DROP FOREIGN KEY `FK_club_TO_league`; -- 클럽 -> 리그

-- 선수기록
ALTER TABLE `player_record`
	DROP FOREIGN KEY `FK_player_TO_player_record`; -- 선수 -> 선수기록

-- 클럽 기록
ALTER TABLE `club_results`
	DROP FOREIGN KEY `FK_club_TO_club_results`; -- 클럽 -> 클럽 기록

-- 클럽 기록
ALTER TABLE `club_results`
	DROP FOREIGN KEY `FK_player_TO_club_results`; -- 선수 -> 클럽 기록

-- 클럽 기록
ALTER TABLE `club_results`
	DROP FOREIGN KEY `FK_player_TO_club_results2`; -- 선수 -> 클럽 기록2

-- 클럽 기록
ALTER TABLE `club_results`
	DROP FOREIGN KEY `FK_player_TO_club_results3`; -- 선수 -> 클럽 기록3

-- 클럽 기록
ALTER TABLE `club_results`
	DROP FOREIGN KEY `FK_player_TO_club_results4`; -- 선수 -> 클럽 기록4

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_member_TO_besteleven`; -- 회원 -> 베스트일레븐

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven`; -- 선수 -> 베스트일레븐

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven2`; -- 선수 -> 베스트일레븐2

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven3`; -- 선수 -> 베스트일레븐3

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven4`; -- 선수 -> 베스트일레븐4

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven5`; -- 선수 -> 베스트일레븐5

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven6`; -- 선수 -> 베스트일레븐6

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven7`; -- 선수 -> 베스트일레븐7

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven8`; -- 선수 -> 베스트일레븐8

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven9`; -- 선수 -> 베스트일레븐9

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven10`; -- 선수 -> 베스트일레븐10

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP FOREIGN KEY `FK_player_TO_besteleven11`; -- 선수 -> 베스트일레븐11

-- 팀별게시판
ALTER TABLE `club_board`
	DROP FOREIGN KEY `FK_club_TO_club_board`; -- 클럽 -> 팀별게시판

-- 팀별게시판
ALTER TABLE `club_board`
	DROP FOREIGN KEY `FK_member_TO_club_board`; -- 회원 -> 팀별게시판

-- 팀별게시판_댓글
ALTER TABLE `club_board_reply`
	DROP FOREIGN KEY `FK_club_board_TO_club_board_reply`; -- 팀별게시판 -> 팀별게시판_댓글

-- 팀별게시판_댓글
ALTER TABLE `club_board_reply`
	DROP FOREIGN KEY `FK_member_TO_club_board_reply`; -- 회원 -> 팀별게시판_댓글

-- 중계방
ALTER TABLE `relay`
	DROP FOREIGN KEY `FK_fixture_TO_relay`; -- 경기일정 -> 중계방

-- 경기일정
ALTER TABLE `fixture`
	DROP FOREIGN KEY `FK_league_TO_fixture`; -- 리그 -> 경기일정

-- 경기일정
ALTER TABLE `fixture`
	DROP FOREIGN KEY `FK_league_TO_fixture2`; -- 리그 -> 경기일정2

-- 중계방_채팅
ALTER TABLE `relay_chat`
	DROP FOREIGN KEY `FK_member_TO_relay_chat`; -- 회원 -> 중계방_채팅

-- 클럽 뉴스
ALTER TABLE `club_news`
	DROP FOREIGN KEY `FK_club_TO_club_news`; -- 클럽 -> 클럽 뉴스

-- 같이응원
ALTER TABLE `support_together`
	DROP FOREIGN KEY `FK_member_TO_support_together`; -- 회원 -> 같이응원

-- 같이응원
ALTER TABLE `support_together`
	DROP FOREIGN KEY `FK_member_TO_support_together2`; -- 회원 -> 같이응원2

-- 같이응원
ALTER TABLE `support_together`
	DROP FOREIGN KEY `FK_club_TO_support_together`; -- 클럽 -> 같이응원

-- 선수
ALTER TABLE `player`
	DROP PRIMARY KEY; -- 선수 기본키

-- 리그
ALTER TABLE `league`
	DROP PRIMARY KEY; -- 리그 기본키

-- 클럽
ALTER TABLE `club`
	DROP PRIMARY KEY; -- 클럽 기본키

-- 선수기록
ALTER TABLE `player_record`
	DROP PRIMARY KEY; -- 선수기록 기본키

-- 클럽 기록
ALTER TABLE `club_results`
	DROP PRIMARY KEY; -- 클럽 기록 기본키

-- 베스트일레븐
ALTER TABLE `besteleven`
	DROP PRIMARY KEY; -- 베스트일레븐 기본키

-- 회원
ALTER TABLE `member`
	DROP PRIMARY KEY; -- 회원 기본키

-- 팀별게시판
ALTER TABLE `club_board`
	DROP PRIMARY KEY; -- 팀별게시판 기본키

-- 팀별게시판_댓글
ALTER TABLE `club_board_reply`
	DROP PRIMARY KEY; -- 팀별게시판_댓글 기본키

-- 중계방
ALTER TABLE `relay`
	DROP PRIMARY KEY; -- 중계방 기본키

-- 경기일정
ALTER TABLE `fixture`
	DROP PRIMARY KEY; -- 경기일정 기본키

-- 중계방_채팅
ALTER TABLE `relay_chat`
	DROP PRIMARY KEY; -- 중계방_채팅 기본키

-- 클럽 뉴스
ALTER TABLE `club_news`
	DROP PRIMARY KEY; -- 클럽 뉴스 기본키

-- 같이응원
ALTER TABLE `support_together`
	DROP PRIMARY KEY; -- 같이응원 기본키

-- 선수
DROP TABLE IF EXISTS `player` RESTRICT;

-- 리그
DROP TABLE IF EXISTS `league` RESTRICT;

-- 클럽
DROP TABLE IF EXISTS `club` RESTRICT;

-- 선수기록
DROP TABLE IF EXISTS `player_record` RESTRICT;

-- 클럽 기록
DROP TABLE IF EXISTS `club_results` RESTRICT;

-- 베스트일레븐
DROP TABLE IF EXISTS `besteleven` RESTRICT;

-- 회원
DROP TABLE IF EXISTS `member` RESTRICT;

-- 팀별게시판
DROP TABLE IF EXISTS `club_board` RESTRICT;

-- 팀별게시판_댓글
DROP TABLE IF EXISTS `club_board_reply` RESTRICT;

-- 중계방
DROP TABLE IF EXISTS `relay` RESTRICT;

-- 경기일정
DROP TABLE IF EXISTS `fixture` RESTRICT;

-- 중계방_채팅
DROP TABLE IF EXISTS `relay_chat` RESTRICT;

-- 클럽 뉴스
DROP TABLE IF EXISTS `club_news` RESTRICT;

-- 같이응원
DROP TABLE IF EXISTS `support_together` RESTRICT;

-- 선수
CREATE TABLE `player` (
	`p_id`        INT         NOT NULL, -- 선수번호
	`c_id`        INT         NULL,     -- 클럽번호
	`name`        VARCHAR(30) NULL,     -- 이름
	`ename`       VARCHAR(50) NULL,     -- 영문명
	`position`    VARCHAR(10) NULL,     -- 포지션
	`back_no`     INT         NULL,     -- 등번호
	`nationality` VARCHAR(30) NULL,     -- 국적
	`height`      INT         NULL,     -- 키
	`weight`      INT         NULL,     -- 몸무게
	`birthday`    VARCHAR(30) NULL      -- 생년월일
);

-- 선수
ALTER TABLE `player`
	ADD CONSTRAINT `PK_player` -- 선수 기본키
		PRIMARY KEY (
			`p_id` -- 선수번호
		);

-- 리그
CREATE TABLE `league` (
	`c_id`   INT         NOT NULL, -- 클럽번호
	`season` VARCHAR(10) NOT NULL, -- 시즌
	`played` INT         NULL,     -- 경기수
	`points` INT         NULL,     -- 승점
	`won`    INT         NULL,     -- 승
	`drawn`  INT         NULL,     -- 무
	`lost`   INT         NULL,     -- 패
	`gf`     INT         NULL,     -- 득점
	`ga`     INT         NULL,     -- 실점
	`gd`     INT         NULL,     -- 득실차
	`assist` INT         NULL,     -- 도움
	`fo`     INT         NULL      -- 파울
);

-- 리그
ALTER TABLE `league`
	ADD CONSTRAINT `PK_league` -- 리그 기본키
		PRIMARY KEY (
			`c_id` -- 클럽번호
		);

-- 클럽
CREATE TABLE `club` (
	`c_id`       INT          NOT NULL, -- 클럽번호
	`name`       VARCHAR(30)  NULL,     -- 이름
	`ename`      VARCHAR(30)  NULL,     -- 영문명
	`founded`    VARCHAR(30)  NULL,     -- 창단연도
	`hometown`   VARCHAR(30)  NULL,     -- 연고지
	`stadium`    VARCHAR(50)  NULL,     -- 홈 경기장
	`manager`    VARCHAR(30)  NULL,     -- 감독
	`website`    VARCHAR(100) NULL,     -- 웹사이트
	`team_color` VARCHAR(10)  NULL,     -- 상징색
	`emblem`     VARCHAR(30)  NULL      -- 엠블럼
);

-- 클럽
ALTER TABLE `club`
	ADD CONSTRAINT `PK_club` -- 클럽 기본키
		PRIMARY KEY (
			`c_id` -- 클럽번호
		);

-- 선수기록
CREATE TABLE `player_record` (
	`p_id`        INT         NOT NULL, -- 선수번호
	`season`      VARCHAR(10) NOT NULL, -- 시즌
	`played`      INT         NULL,     -- 출장경기수
	`played_in`   INT         NULL,     -- 교체출장
	`played_out`  INT         NULL,     -- 교체아웃
	`inout_total` INT         NULL,     -- 교체합계
	`fh_goal`     INT         NULL,     -- 전반 골
	`sh_goal`     INT         NULL,     -- 후반 골
	`ot_goal`     INT         NULL,     -- 연장 골
	`total_goal`  INT         NULL,     -- 합계 골
	`assist`      INT         NULL,     -- 도움
	`gk`          INT         NULL,     -- 골킥
	`ck`          INT         NULL,     -- 코너킥
	`fo`          INT         NULL,     -- 파울
	`os`          INT         NULL,     -- 오프사이드
	`st`          INT         NULL,     -- 슈팅
	`yellow`      INT         NULL,     -- 경고
	`red`         INT         NULL      -- 퇴장
);

-- 선수기록
ALTER TABLE `player_record`
	ADD CONSTRAINT `PK_player_record` -- 선수기록 기본키
		PRIMARY KEY (
			`p_id` -- 선수번호
		);

-- 클럽 기록
CREATE TABLE `club_results` (
	`c_id`        INT NOT NULL, -- 클럽번호
	`p_mp`        INT NULL,     -- 최다출장선수
	`p_mg`        INT NULL,     -- 최다득점선수
	`p_ma`        INT NULL,     -- 최다도움선수
	`p_map`       INT NULL,     -- 최다공포선수
	`most_played` INT NULL,     -- 최다출장수
	`most_goal`   INT NULL,     -- 최다득점수
	`most_as`     INT NULL,     -- 최다도움수
	`most_ap`     INT NULL      -- 최다공격포인트수
);

-- 클럽 기록
ALTER TABLE `club_results`
	ADD CONSTRAINT `PK_club_results` -- 클럽 기록 기본키
		PRIMARY KEY (
			`c_id` -- 클럽번호
		);

-- 베스트일레븐
CREATE TABLE `besteleven` (
	`season`    VARCHAR(10) NOT NULL, -- 시즌
	`round`     INT         NOT NULL, -- 라운드
	`m_id`      INT         NULL,     -- 회원번호
	`p1`        INT         NOT NULL, -- 선수1
	`p2`        INT         NOT NULL, -- 선수2
	`p3`        INT         NOT NULL, -- 선수3
	`p4`        INT         NOT NULL, -- 선수4
	`p5`        INT         NOT NULL, -- 선수5
	`p6`        INT         NOT NULL, -- 선수6
	`p7`        INT         NOT NULL, -- 선수7
	`p8`        INT         NOT NULL, -- 선수8
	`p9`        INT         NOT NULL, -- 선수9
	`p10`       INT         NOT NULL, -- 선수10
	`gk`        INT         NOT NULL, -- 골키퍼
	`formation` VARCHAR(10) NULL      -- 포메이션
);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `PK_besteleven` -- 베스트일레븐 기본키
		PRIMARY KEY (
			`season`, -- 시즌
			`round`   -- 라운드
		);

-- 회원
CREATE TABLE `member` (
	`m_id`      INT         NOT NULL, -- 회원번호
	`email`     VARCHAR(30) NULL,     -- 이메일
	`pw`        VARCHAR(30) NULL,     -- 비밀번호
	`nickname`  VARCHAR(30) NULL,     -- 닉네임
	`point`     INT         NULL,     -- 포인트
	`auth`      INT         NOT NULL, -- 회원등급
	`blacklist` INT         NULL      -- 블랙리스트
);

-- 회원
ALTER TABLE `member`
	ADD CONSTRAINT `PK_member` -- 회원 기본키
		PRIMARY KEY (
			`m_id` -- 회원번호
		);

-- 팀별게시판
CREATE TABLE `club_board` (
	`cb_id`   INT         NOT NULL, -- 글번호
	`c_id`    INT         NOT NULL, -- 클럽번호
	`m_id`    INT         NOT NULL, -- 작성자
	`title`   VARCHAR(30) NULL,     -- 제목
	`cb_date` VARCHAR(30) NULL,     -- 작성일
	`view`    INT         NULL      -- 조회수
);

-- 팀별게시판
ALTER TABLE `club_board`
	ADD CONSTRAINT `PK_club_board` -- 팀별게시판 기본키
		PRIMARY KEY (
			`cb_id` -- 글번호
		);

-- 팀별게시판_댓글
CREATE TABLE `club_board_reply` (
	`cbr_id`   INT         NOT NULL, -- 댓글번호
	`cb_id`    INT         NOT NULL, -- 글번호
	`m_id`     INT         NOT NULL, -- 작성자
	`cbr_date` VARCHAR(30) NULL,     -- 작성일
	`cbr_text` TEXT        NULL      -- 내용
);

-- 팀별게시판_댓글
ALTER TABLE `club_board_reply`
	ADD CONSTRAINT `PK_club_board_reply` -- 팀별게시판_댓글 기본키
		PRIMARY KEY (
			`cbr_id` -- 댓글번호
		);

-- 중계방
CREATE TABLE `relay` (
	`f_id`   INT         NOT NULL, -- 경기번호
	`r_date` VARCHAR(30) NULL,     -- 시간
	`r_text` TEXT        NULL      -- 내용
);

-- 중계방
ALTER TABLE `relay`
	ADD CONSTRAINT `PK_relay` -- 중계방 기본키
		PRIMARY KEY (
			`f_id` -- 경기번호
		);

-- 경기일정
CREATE TABLE `fixture` (
	`f_id`    INT         NOT NULL, -- 경기번호
	`home`    INT         NOT NULL, -- 홈
	`away`    INT         NOT NULL, -- 어웨이
	`f_date`  VARCHAR(30) NULL,     -- 일시
	`stadium` VARCHAR(50) NULL      -- 경기장
);

-- 경기일정
ALTER TABLE `fixture`
	ADD CONSTRAINT `PK_fixture` -- 경기일정 기본키
		PRIMARY KEY (
			`f_id` -- 경기번호
		);

-- 중계방_채팅
CREATE TABLE `relay_chat` (
	`rc_id`   INT         NOT NULL, -- 채팅번호
	`m_id`    INT         NOT NULL, -- 회원번호
	`rc_text` TEXT        NULL,     -- 내용
	`rc_date` VARCHAR(30) NULL      -- 일시
);

-- 중계방_채팅
ALTER TABLE `relay_chat`
	ADD CONSTRAINT `PK_relay_chat` -- 중계방_채팅 기본키
		PRIMARY KEY (
			`rc_id` -- 채팅번호
		);

-- 클럽 뉴스
CREATE TABLE `club_news` (
	`n_id`   INT         NOT NULL, -- 뉴스번호
	`c_id`   INT         NOT NULL, -- 클럽번호
	`title`  VARCHAR(30) NULL,     -- 제목
	`source` TEXT        NULL      -- 출처
);

-- 클럽 뉴스
ALTER TABLE `club_news`
	ADD CONSTRAINT `PK_club_news` -- 클럽 뉴스 기본키
		PRIMARY KEY (
			`n_id` -- 뉴스번호
		);

-- 같이응원
CREATE TABLE `support_together` (
	`st_id`    INT         NOT NULL, -- 응원번호
	`c_id`     INT         NOT NULL, -- 응원팀
	`host_id`  INT         NOT NULL, -- 주최자
	`guest_id` INT         NULL,     -- 참가자
	`location` VARCHAR(50) NULL,     -- 장소
	`st_date`  VARCHAR(30) NULL      -- 일시
);

-- 같이응원
ALTER TABLE `support_together`
	ADD CONSTRAINT `PK_support_together` -- 같이응원 기본키
		PRIMARY KEY (
			`st_id` -- 응원번호
		);

-- 선수
ALTER TABLE `player`
	ADD CONSTRAINT `FK_club_TO_player` -- 클럽 -> 선수
		FOREIGN KEY (
			`c_id` -- 클럽번호
		)
		REFERENCES `club` ( -- 클럽
			`c_id` -- 클럽번호
		);

-- 리그
ALTER TABLE `league`
	ADD CONSTRAINT `FK_club_TO_league` -- 클럽 -> 리그
		FOREIGN KEY (
			`c_id` -- 클럽번호
		)
		REFERENCES `club` ( -- 클럽
			`c_id` -- 클럽번호
		);

-- 선수기록
ALTER TABLE `player_record`
	ADD CONSTRAINT `FK_player_TO_player_record` -- 선수 -> 선수기록
		FOREIGN KEY (
			`p_id` -- 선수번호
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 클럽 기록
ALTER TABLE `club_results`
	ADD CONSTRAINT `FK_club_TO_club_results` -- 클럽 -> 클럽 기록
		FOREIGN KEY (
			`c_id` -- 클럽번호
		)
		REFERENCES `club` ( -- 클럽
			`c_id` -- 클럽번호
		);

-- 클럽 기록
ALTER TABLE `club_results`
	ADD CONSTRAINT `FK_player_TO_club_results` -- 선수 -> 클럽 기록
		FOREIGN KEY (
			`p_mp` -- 최다출장선수
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 클럽 기록
ALTER TABLE `club_results`
	ADD CONSTRAINT `FK_player_TO_club_results2` -- 선수 -> 클럽 기록2
		FOREIGN KEY (
			`p_mg` -- 최다득점선수
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 클럽 기록
ALTER TABLE `club_results`
	ADD CONSTRAINT `FK_player_TO_club_results3` -- 선수 -> 클럽 기록3
		FOREIGN KEY (
			`p_ma` -- 최다도움선수
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 클럽 기록
ALTER TABLE `club_results`
	ADD CONSTRAINT `FK_player_TO_club_results4` -- 선수 -> 클럽 기록4
		FOREIGN KEY (
			`p_map` -- 최다공포선수
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_member_TO_besteleven` -- 회원 -> 베스트일레븐
		FOREIGN KEY (
			`m_id` -- 회원번호
		)
		REFERENCES `member` ( -- 회원
			`m_id` -- 회원번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven` -- 선수 -> 베스트일레븐
		FOREIGN KEY (
			`p1` -- 선수1
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven2` -- 선수 -> 베스트일레븐2
		FOREIGN KEY (
			`p2` -- 선수2
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven3` -- 선수 -> 베스트일레븐3
		FOREIGN KEY (
			`p3` -- 선수3
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven4` -- 선수 -> 베스트일레븐4
		FOREIGN KEY (
			`p4` -- 선수4
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven5` -- 선수 -> 베스트일레븐5
		FOREIGN KEY (
			`p5` -- 선수5
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven6` -- 선수 -> 베스트일레븐6
		FOREIGN KEY (
			`p6` -- 선수6
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven7` -- 선수 -> 베스트일레븐7
		FOREIGN KEY (
			`p7` -- 선수7
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven8` -- 선수 -> 베스트일레븐8
		FOREIGN KEY (
			`p8` -- 선수8
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven9` -- 선수 -> 베스트일레븐9
		FOREIGN KEY (
			`p9` -- 선수9
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven10` -- 선수 -> 베스트일레븐10
		FOREIGN KEY (
			`p10` -- 선수10
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 베스트일레븐
ALTER TABLE `besteleven`
	ADD CONSTRAINT `FK_player_TO_besteleven11` -- 선수 -> 베스트일레븐11
		FOREIGN KEY (
			`gk` -- 골키퍼
		)
		REFERENCES `player` ( -- 선수
			`p_id` -- 선수번호
		);

-- 팀별게시판
ALTER TABLE `club_board`
	ADD CONSTRAINT `FK_club_TO_club_board` -- 클럽 -> 팀별게시판
		FOREIGN KEY (
			`c_id` -- 클럽번호
		)
		REFERENCES `club` ( -- 클럽
			`c_id` -- 클럽번호
		);

-- 팀별게시판
ALTER TABLE `club_board`
	ADD CONSTRAINT `FK_member_TO_club_board` -- 회원 -> 팀별게시판
		FOREIGN KEY (
			`m_id` -- 작성자
		)
		REFERENCES `member` ( -- 회원
			`m_id` -- 회원번호
		);

-- 팀별게시판_댓글
ALTER TABLE `club_board_reply`
	ADD CONSTRAINT `FK_club_board_TO_club_board_reply` -- 팀별게시판 -> 팀별게시판_댓글
		FOREIGN KEY (
			`cb_id` -- 글번호
		)
		REFERENCES `club_board` ( -- 팀별게시판
			`cb_id` -- 글번호
		);

-- 팀별게시판_댓글
ALTER TABLE `club_board_reply`
	ADD CONSTRAINT `FK_member_TO_club_board_reply` -- 회원 -> 팀별게시판_댓글
		FOREIGN KEY (
			`m_id` -- 작성자
		)
		REFERENCES `member` ( -- 회원
			`m_id` -- 회원번호
		);

-- 중계방
ALTER TABLE `relay`
	ADD CONSTRAINT `FK_fixture_TO_relay` -- 경기일정 -> 중계방
		FOREIGN KEY (
			`f_id` -- 경기번호
		)
		REFERENCES `fixture` ( -- 경기일정
			`f_id` -- 경기번호
		);

-- 경기일정
ALTER TABLE `fixture`
	ADD CONSTRAINT `FK_league_TO_fixture` -- 리그 -> 경기일정
		FOREIGN KEY (
			`home` -- 홈
		)
		REFERENCES `league` ( -- 리그
			`c_id` -- 클럽번호
		);

-- 경기일정
ALTER TABLE `fixture`
	ADD CONSTRAINT `FK_league_TO_fixture2` -- 리그 -> 경기일정2
		FOREIGN KEY (
			`away` -- 어웨이
		)
		REFERENCES `league` ( -- 리그
			`c_id` -- 클럽번호
		);

-- 중계방_채팅
ALTER TABLE `relay_chat`
	ADD CONSTRAINT `FK_member_TO_relay_chat` -- 회원 -> 중계방_채팅
		FOREIGN KEY (
			`m_id` -- 회원번호
		)
		REFERENCES `member` ( -- 회원
			`m_id` -- 회원번호
		);

-- 클럽 뉴스
ALTER TABLE `club_news`
	ADD CONSTRAINT `FK_club_TO_club_news` -- 클럽 -> 클럽 뉴스
		FOREIGN KEY (
			`c_id` -- 클럽번호
		)
		REFERENCES `club` ( -- 클럽
			`c_id` -- 클럽번호
		);

-- 같이응원
ALTER TABLE `support_together`
	ADD CONSTRAINT `FK_member_TO_support_together` -- 회원 -> 같이응원
		FOREIGN KEY (
			`host_id` -- 주최자
		)
		REFERENCES `member` ( -- 회원
			`m_id` -- 회원번호
		);

-- 같이응원
ALTER TABLE `support_together`
	ADD CONSTRAINT `FK_member_TO_support_together2` -- 회원 -> 같이응원2
		FOREIGN KEY (
			`guest_id` -- 참가자
		)
		REFERENCES `member` ( -- 회원
			`m_id` -- 회원번호
		);

-- 같이응원
ALTER TABLE `support_together`
	ADD CONSTRAINT `FK_club_TO_support_together` -- 클럽 -> 같이응원
		FOREIGN KEY (
			`c_id` -- 응원팀
		)
		REFERENCES `club` ( -- 클럽
			`c_id` -- 클럽번호
		);