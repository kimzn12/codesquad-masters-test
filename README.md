# CodeSquad masters test 
## Step 2: 평면큐브 구현하기
####요구사항
- 처음 시작하면 초기 상태를 출력한다.
- 간단한 프롬프트 (CLI에서 키보드 입력받기 전에 표시해주는 간단한 글자들 - 예: CUBE> )를 표시해 준다.
- 한 번에 여러 문자를 입력받은 경우 순서대로 처리해서 매 과정을 화면에 출력한다.

#### 동작 예시
    R R W
    G C W
    G B B
    
    CUBE> UUR
    
    U
    R W R 
    G C W
    G B B
    
    U
    W R R  
    G C W
    G B B
    
    R
    W R W 
    G C B
    G B R
    
    CUBE> Q
    Bye~