  <h1 align="center">bMart Api </h1>

  <p align="center">
  배달의민족 bMart 를 샘플로하여 Api 구성 연습용
  </p>

## 기술 스택 
1. Spring Boot<br>
2. Jpa<br>
3. MariaDb<br>
## 기능 
1.카테고리 등록 조회(O)<br>
1.1 카테고리는 상품의 외래키로 써 존재하기위해 쓰인다.<br>
1.2 카테고리별 조회를하기 위함<br><br>
2. 회원가입 회원 조회<br>
2.1 회원가입 아이디 비밀번호 는 유효성검사를 실시한다.(O)<br>
2.2 회원아이디 중복시 409에러를 나타낸다.(O)<br>
2.3 비밀번호는 암호화를 통해 디비에 암호상태로 나타내게한다.(X)추후예정<br>
2.4 회원가입시 ROLE은 기본적으로 USER 로설정한다.(O)<br><br>
3.상품 등록 조회(O)<br>
3.1 상품 상세조회를 만든다.(O)<br>
3.2 상품별 할인율 적용하기위해 따로 할인외래키를만든다.(X)추후예정<br>
3.3 상품 등록은 관리자 에디터를 만들어 관리자가 쉽게 상품등록할수있도록한다.(X)추후예정<br>
## 기능 이미지
![getProducts](https://user-images.githubusercontent.com/112354634/223041065-f9175012-187e-4f18-a0cf-287b37846a10.PNG)
![getUser](https://user-images.githubusercontent.com/112354634/223041069-5e51422d-d2e3-496f-a835-1f00329567bd.PNG)
![postProducts](https://user-images.githubusercontent.com/112354634/223041074-84a1c79c-0042-40f7-a2ae-029cce26cc03.PNG)
![signUp](https://user-images.githubusercontent.com/112354634/223041076-b396fbe6-53ef-41b0-a732-3fac8b3eb359.PNG)
![getIdProducts](https://user-images.githubusercontent.com/112354634/223041078-b1f8b528-b37a-4ca8-8ed8-89c613510a00.PNG)

## 보완할점 마침말
하나하나 기능을 더 추가하며 완성도를 높이도록 노력하자

