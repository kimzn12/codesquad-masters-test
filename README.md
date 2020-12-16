# CodeSquad masters test 
## Step 3: 루빅스 큐브 구현하기
### 루빅스 큐브
![Rubik'sCube](./image/rubikscube.png)  
참고 사이트 :  https://rubiks-cube-solver.com/ko/
### 규칙
- [x] 큐브는 W, B, G, Y, O, R의 6가지 색깔을 가지고 있다.
- [x] 입력: 각 조작법을 한 줄로 입력받는다.
- [x] 출력: 큐브의 6면을 펼친 상태로 출력한다.
- [x] Q를 입력받으면 프로그램을 종료하고, 조작 받은 명령의 갯수를 출력시킨다.

### 큐브의 초기 상태
![InitialState](./image/initial_state.png)  

큐브는 6면으로 구성되어 있으며 각 면은 모두 다른 색깔을 가진다.
                    
### 동작
##### 앞면 기준
|U (오른쪽으로 회전)|U' (왼쪽으로 회전)|
|---|---|
|![u](./image/u.png) |![u'](./image/uL.png)|
##### 뒷면 기준
|D (오른쪽으로 회전)|D' (왼쪽으로 회전)|
|---|---|
|![d](./image/d.png) |![d'](./image/dL.png)|

##### 오른쪽면 기준
|R (오른쪽으로 회전)|R' (왼쪽으로 회전)|
|---|---|
|![r](./image/r.png) |![r'](./image/rL.png)|

##### 왼쪽면 기준
|L (오른쪽으로 회전)|L' (왼쪽으로 회전)|
|---|---|
|![l](./image/l.png) |![l'](./image/lL.png)|

##### 윗면 기준
|F (오른쪽으로 회전)|F' (왼쪽으로 회전)|
|---|---|
|![f](./image/f.png) |![f'](./image/fL.png)|

##### 아랫면 기준
|B (오른쪽으로 회전)|B' (왼쪽으로 회전)|
|---|---|
|![b](./image/b.png) |![b](./image/bL.png)|

##### 여러줄 입력받기
|여러줄 입력받기|이상한 값 포함하여 입력받기|
|---|---|
|![MultipleInputs](./image/MultipleInputs.png)|![StrangeInputs](./image/strangeInputs.png)

##### 큐브 무작위로 섞기
|S (오른쪽으로 회전)|
|---|
|![s](./image/s.png) |

##### 끝내기
|Q 명렁어로 끝내기|큐브를 다 맞추고 끝내기|
|---|---|
|![q](./image/q.png) |![finish](./image/finish.png)|




