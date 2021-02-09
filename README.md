# ✔ ani more 

지금 바로 시작하는 환경 보호 첫 걸음을 돕는 앱 서비스, ani more입니다.

> 데모 개발 기간 : 2020.11~2020.12

<br>
<br>

## ✔ 서비스 소개 영상

<p align="center">
<img src="https://user-images.githubusercontent.com/55133871/105039588-15189100-5aa4-11eb-9c3d-69af71db075f.gif" width="380"> <img src="https://user-images.githubusercontent.com/55133871/105039606-1b0e7200-5aa4-11eb-921c-8391ec54059e.gif" width="380">
</p>
<p align="center">
<img src="https://user-images.githubusercontent.com/55133871/105041227-12b73680-5aa6-11eb-8e4e-9cacffe0c49a.gif" width="380"> <img src="https://user-images.githubusercontent.com/55133871/105041252-18ad1780-5aa6-11eb-8228-8f57748d3f6c.gif" width="380">
</p>

<br>
<br>

## ✔ 포스터
![poster](https://user-images.githubusercontent.com/55133871/105042001-11d2d480-5aa7-11eb-8c61-cc76cc6ab121.png)

<br>
<br>

## ✔ 메인 뷰 & 기능소개

### ✨ 스플래시
<p align="center">
<img src="https://user-images.githubusercontent.com/55133871/105037921-09c46600-5aa2-11eb-9953-5419ff32d407.gif" width="300">
</p>

1. 스플래시
   <br> 앱 아이콘 클릭 시 스플래시가 재생되며, 스플래시 종료 후 로그인 화면으로 넘어갑니다.

<br>
<br>

### ✨ 메인 뷰
<p align="center">
<img src="https://user-images.githubusercontent.com/55133871/105037949-11840a80-5aa2-11eb-9cc4-c66ab5503120.gif" width="300"> <img src="https://user-images.githubusercontent.com/55133871/105037983-1c3e9f80-5aa2-11eb-9c32-75ba85b9435d.gif" width="300">
</p>

1. 메인 뷰의 환경 보호 미션 카드(recycler view 사용)
   <br> 현재 유저가 진행하고 있는 환경 보호 미션 카드를 넘겨볼 수 있습니다.
2. 미션별 카드 모아보기
   <br> 버튼을 통해 애니(일반), 모어(연속) 별로 카드를 모아볼 수 있습니다.
3. 한줄 환경 보호 상식
   <br> 메인 뷰에 들어올 때마다 랜덤으로 환경 보호 상식이 화면 상단에 출력됩니다.

<br>
<br>

### ✨ 카드 추가
<p align="center">
<img src="https://user-images.githubusercontent.com/55133871/105037925-0b8e2980-5aa2-11eb-84c6-8c329b8d7d5b.gif" width="300"> <img src="https://user-images.githubusercontent.com/55133871/105037932-0df08380-5aa2-11eb-989e-e986eaf1ab15.gif" width="300">
</p>

1. 환경 보호 테마 선택
   <br> 애니모어의 테마에 맞게 멸종 위기 동물 버튼을 클릭하면 해당 동물에 대한 소개와 함께 환경 보호 카테고리에 대한 설명이 보입니다.
2. 미션 선택
   <br> 멸종 위기 동물(환경 보호 테마)를 선택하면 해당 카테고리의 미션이 랜덤으로 부여됩니다. 미션 다시 받기를 선택하면 또 다른 미션이 랜덤으로 부여됩니다.
3. 미션 유형 선택
   <br> 미션 선택 후 미션의 애니/모어 유형을 선택할 수 있습니다. 애니 유형을 선택 시 미션 마감 일자를, 모어 유형을 선택시 연속 수행 목표 날짜를 선택합니다.

<br>
<br>

### ✨ 카드 상세 정보 확인
<p align="center">
<img src="https://user-images.githubusercontent.com/55133871/105037960-13e66480-5aa2-11eb-82a5-7cb67f14b0f2.gif" width="300"> <img src="https://user-images.githubusercontent.com/55133871/105037969-1648be80-5aa2-11eb-9f63-47645e6ccb07.gif" width="300">
</p>

1. 카드 상세 정보 확인
   <br> 메인 뷰에서 카드를 클릭할 경우 해당 카드의 현재 미션 수행 정보가 나타나며, 한 번 더 클릭 시 카드가 뒤집어지며 추가 정보를 확인할 수 있습니다.
2. 카드 삭제
   <br> 포기하기 버튼을 누를 경우 미션 정보가 사라집니다.

<br>
<br>

### ✨ 오늘의 미션 수행
<p align="center">
<img src="https://user-images.githubusercontent.com/55133871/105037942-0fba4700-5aa2-11eb-9ec0-82f284d8883e.gif" width="300"> <img src="https://user-images.githubusercontent.com/55133871/105037943-1052dd80-5aa2-11eb-8beb-b12df8d0fb5c.gif" width="300">
</p>

1. 미션 수행 버튼 클릭
   <br> 오늘 미션 완료 스탬프가 찍히며 미션 수행 카운트가 하나 올라갑니다.
2. 미션 수행 완료
   <br> 목표 횟수 / 목표 기간을 달성할 경우 완료 스플래시가 보이며, 해당 카드는 과거 카드 뷰로 이동합니다.

<br>
<br>

### ✨ 과거 카드 뷰
<p align="center">
<img src="https://user-images.githubusercontent.com/55133871/105037973-18ab1880-5aa2-11eb-917f-05afa4fbfa48.gif" width="300">
</p>

1. 과거 미션 카드 모아보기
   <br> 본인이 성공한 미션의 개수와, 지난 카드들을 모아볼 수 있습니다. 카드 클릭 시 해당 미션에 대한 정보와 성공/실패 여부가 보입니다.

<br>
<br>

## ✔ 한 줄 회고

#### * 뿌듯한 부분

안드로이드를 처음 배워봤음에도 불구하고 다양한 뷰와 기능들을 모두 완성했습니다. 데모데이 전까지 모든 경우의 QA를 꼼꼼하게 완료했습니다.

#### * 아쉬운 부분

Android studio로 제작하여 iOS 버전이 없습니다. 짧은 기간 안에 서버 연결까지 하다보니 효율적인 DB 구성 및 API를 제작하지 못했다는 것이 아쉽습니다.
