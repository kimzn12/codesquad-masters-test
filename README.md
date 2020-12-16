# CodeSquad masters test 
## Step 3: 루빅스 큐브 구현하기
### 루빅스 큐브
! [Rubik'sCube](./image/rubikscube.png)  
참고 사이트 :  https://rubiks-cube-solver.com/ko/
### 규칙
- [x] 큐브는 W, B, G, Y, O, R의 6가지 색깔을 가지고 있다.
- [x] 입력: 각 조작법을 한 줄로 입력받는다.
- [x] 출력: 큐브의 6면을 펼친 상태로 출력한다.
- [x] Q를 입력받으면 프로그램을 종료하고, 조작 받은 명령의 갯수를 출력시킨다.

### 큐브의 초기 상태
                    B B B  
                    B B B
                    B B B
    
     W W W     O O O     G G G     Y Y Y 
     W W W     O O O     G G G     Y Y Y 
     W W W     O O O     G G G     Y Y Y 
     
                    R R R 
                    R R R 
                    R R R 
                    
### 예시
    (초기 상태 출력)
    
    CUBE> FRR'U2R
    
    F
    (큐브상태)
    
    R
    (큐브상태)
    
    ...
    
    R
    (큐브상태)
    
    CUBE> Q
    경과시간: 00:31 //추가 구현 항목
    조작갯수: 6
    이용해주셔서 감사합니다. 뚜뚜뚜.

### 요구사항
    function main() {
          for() { // 들여쓰기 1단계
              if() { // 들여쓰기 2단계
                  return; // 들여쓰기 3단계
              }
          }
      }

-  커밋 자주하기, 구현의 의미가 명확하게 전달되도록 커밋 메시지를 작성할 것
-  함수나 메소드는 한 번에 한 가지 일을 하고 가능하면 20줄이 넘지 않도록 구현한다.
-  함수나 메소드의 들여쓰기를 가능하면 적게(3단계까지만) 할 수 있도록 노력해 본다.



