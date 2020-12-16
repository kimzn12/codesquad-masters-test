# CodeSquad masters test 
## Step 1 단어 밀어내기
### 💡 요구사항
1. 입력: 사용자로부터 단어 하나, 정수 숫자 하나( -100 <= N < 100) , L 또는 R을 입력받는다. L 또는 R은 대소문자 모두 입력 가능하다.
2. 주어진 단어를 L이면 주어진 숫자 갯수만큼 왼쪽으로, R이면 오른쪽으로 밀어낸다.
3. 밀려나간 단어는 반대쪽으로 채워진다.

### 🏃 동작
- 입력: apple 3 L


        apple 3 L
        leapp
    
- 입력: banana 6 R


        banana 6 R
        banana

- 입력: carrot -1 r    


        carrot -1 r
        arrotc
        ## Step 2: 평면큐브 구현하기
        
## Step 2 평면큐브 구현하기
#### 요구사항
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
