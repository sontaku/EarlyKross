# EarlyKross
> K리그 활성화를 위한 커뮤니티 사이트



## 개요

K리그 데이터 기반 리그, 클럽, 선수 정보를 제공하며 팀별 게시판 등 커뮤니티 게시판 제공

주요 서비스 : 라운드별 베스트 일레븐 맞추기, 실시간 중계 채팅방, 같이 응원, 데이터 센터



## 소개

<table class="tg">
    <tr align="left">
      <th>프로젝트명</th>
      <th>얼리크로스(EarlyKross)</th>
    </tr>
    <tr align="left">
      <th>개발기간</th>
      <th>2021.05.26 ~ 2021.06.18</th>
    </tr>
    <tr align="left">
      <th>인원</th>
      <th>5</th>
    </tr>
    <tr>
      <th colspan="2">사용 기술</th>
    </tr>
    <tr align="left">
      <th>백엔드</th>
      <th>Java, Spring boot, MariaDB, JPA</th>
    </tr>
    <tr align="left">
      <th>프론트엔드</th>
      <th>HTML5, CSS3, JavaScript, jQuery, Ajax</th>
    </tr>
    <tr align="left">
      <th>형상관리</th>
      <th>Git, Github</th>
    </tr>
    <tr align="left">
      <th>툴</th>
      <th>IntelliJ, PyCharm, Git Bash, Typora</th>
    </tr>
    <tr align="left">
      <th>운영체제</th>
      <th>Windows 10</th>
    </tr>
  </table>



## 개발 환경

- OS : Windows 10

- jdk : AdoptOpenJDK 11 hotSpot Windows 64bit

  https://adoptopenjdk.net/releases.html

- spring boot : 2.4.6

- mariaDB : 10.5.8

  https://mariadb.org/download/

- redis 3.0.504

  https://github.com/microsoftarchive/redis/releases/download/win-3.0.504/Redis-x64-3.0.504.msi



## 서비스

1. **베스트 일레븐 맞추기** - 적중 선수 한 선수당 포인트 획득(포인트는 계정 경험치 Lv++)

2. 리그별, **팀별 게시판**(커뮤니티)

3. **데이터 센터**

   - 선수조회
   - 팀 조회
   - 감독 조회
   - 리그 순위 ( 팀 순위, 선수 개인 순위 )

4. **실시간 중계 채팅방**

5. 같이 응원

8. K리그 뉴스

9. 관리자 페이지

   - 회원관리

     - 블랙리스트
     - 회원조회

   - 시각화 데이터(회원, 게시판 등등)

     

## 구성원

- 김광운 : https://github.com/kklck
  - 베스트 일레븐
  - 회원가입 및 로그인 페이지
  - Spring Security 적용 및 구글 API 로그인
  - 카카오 맵 API로 동적 마커 생성하여 매칭 서비스
- 박태영 : https://github.com/tanguri
  - AWS 서버 관리
  - DB 데이터 크롤링
  - 같이 응원 중계 서비스
- 손진영 : https://github.com/sontaku
  - DB modeling
  - 데이터 센터 (리그, 클럽, 선수)
    - ELK 스택 적용
  - git 형상관리
- 최현웅 : https://github.com/rphonica
  - 뉴스 페이지
- 탁우근 : https://github.com/GitWoogeun
  - 관리자 페이지
  - 회원가입 및 로그인 페이지(kakao api)
