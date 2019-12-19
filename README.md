>
><h1>Naver Crawler <sup><sup></sup></sup><sub><sub><sup><i>in cafe, use login, specified category</i></sup></sub></sub></h1>
>&nbsp&nbsp네이버 카페의 부동산 매물 관련 게시글 내용을 담아 .csv 파일 형태로 저장하기 위해 만든 프로그램<br>
<br>

&nbsp;&nbsp;![][Java]
&nbsp;&nbsp;![][Build]
&nbsp;&nbsp;![][Spring]
&nbsp;&nbsp;![][Mybatis]
&nbsp;&nbsp;![][HtmlUnit]
&nbsp;&nbsp;![][OpenCsv]
<br>

&nbsp;&nbsp;**특정 카페**에 **지정한 카테고리**의 **부동산 매물 게시글**을 크롤링 하는 프로그램임.
스프링에서 제공하는 스케줄러를 사용해 일정 주기로 게시글을 긁어오도록 개발한 프로젝트.
<br><br>

>#### 크롤링 과정 <sup><sup></sup></sup><sub><sub><sup><i>Flow</i></sup></sub></sub></h1>
1. HtmlUnit 로그인 & 쿠키 획득
2. URL 및 쿠키를 사용한 Jsoup 컨넥션
3. 페이지 수 만큼의 모든 Elements 를 게시글 객체형의 List 로 변형
4. csv 파일 생성 및 게시글 validation
5. 게시글 파싱 및 데이터 획득
6. DB insert (트랜잭션)

&nbsp;&nbsp;**특정 카페**에 **지정한 카테고리**의 **부동산 매물 게시글**을 크롤링 하는 프로그램임.
스프링에서 제공하는 스케줄러를 사용해 일정 주기로 게시글을 긁어오도록 개발한 프로젝트.
----------------------------------------------------

>_Maven dependency:_

```xml
<!-- Mybatis -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.0.0</version>
    </dependency>
    
<!-- HtmlUnit -->
    <dependency>
        <groupId>net.sourceforge.htmlunit</groupId>
        <artifactId>htmlunit</artifactId>
        <version>2.36.0</version>
    </dependency>
    <dependency>
        <groupId>org.jsoup</groupId>
        <artifactId>jsoup</artifactId>
        <version>1.10.3</version>
    </dependency>
    
<!-- OpenCsv -->
    <dependency>
        <groupId>net.sf.opencsv</groupId>
        <artifactId>opencsv</artifactId>
        <version>2.3</version>
    </dependency>
```

----------------------------------------------------
>#### 요구사항 <sup><sup></sup></sup><sub><sub><sup><i>Request</i></sup></sub></sub></h1>
>
- 부동산 직거래 매물이 올라오는 네이버카페의 매물정보글을 가져와야 한다.
- 아래와 같은 조건을 만족하는 게시글 이어야 한다<br><br>
&nbsp; #. 연락처가 포함 될 것<br>
&nbsp; #. 매물 관련된 게시글 일 것<br>
&nbsp; #. 중개사가 올린 글은 제외할 것<br>
&nbsp; #. __'방 내놓는'__ 게시글 일 것<br><br>
- 일정 주기로 자동으로 긁어와야 한다
- 파일은 __*.csv__ 형태로 저장해야 한다

----------------------------------------------------
>#### 기능 <sup><sup></sup></sup><sub><sub><sup><i>Issue</i></sup></sub></sub></h1>
>
- 아래와 같은 패턴의 연락처 패턴을 인식해서 연락처 정보를 가져온다<br><br>
&nbsp; #. 영1영.xxxx.xxxx<br>
&nbsp; #. 0일공.xxxx.xxxx<br>
&nbsp; #. 010.xxxx.xxxx<br>
&nbsp; #. 영일영.xxxx.xxxx<br>

- 카페의 권한이 없는 경우, 로그인 정보를 가져와 크롤링 할 수 있다
- 일정 주기로 스케줄링 실행
- Validation 할 수 있다
- 크롤러 종류

```xml
 - Single (하나 카테고리 크롤링)
 - Multi (다중 카테고리 크롤링)
 - Search (카페 내 키워드 검색 결과)
```

[Build]:https://img.shields.io/badge/Build-maven-green?style=flat-square
[Java]:https://img.shields.io/badge/java-1.8-blue?style=flat-square&logo=Java&logoColor=Red
[Spring]:https://img.shields.io/badge/springboot-2.1.8.RELEASE-blue?style=flat-square&logo=Spring
[Mybatis]:https://img.shields.io/badge/mybatis-2.0-blue?style=flat-square&logo=MySQL&logoColor=white
[HtmlUnit]:https://img.shields.io/badge/jsoup-1.10.3-blue?style=flat-square&logo=LibraryThing&logoColor=white
[OpenCsv]:https://img.shields.io/badge/openCSV-2.3-blue?style=flat-square&logo=LibraryThing&logoColor=white