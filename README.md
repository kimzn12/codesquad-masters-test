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
##### 1. 윗면 기준
|U (시계방향으로 회전)|U' (반시계방향으로 회전)|
|---|---|
|![u](./image/u.png) |![u'](./image/uL.png)|

- 큐브의 윗 면을 잡고 시계방향 또는 반시계방향으로 돌리는 동작이다.
- "u" 또는 "U"를 입력하면 큐브의 윗면이 시계방향으로 돌아간다. 
오른쪽,앞쪽,왼쪽,뒷쪽면의 줄은 **왼쪽**으로 미뤄진다.   

- "u'" 또는 "U'"를 입력하면 큐브의 윗면이 반시계방향으로 돌아간다. 
오른쪽,앞쪽,왼쪽,뒷쪽면의 줄은 **오른쪽**으로 미뤄진다.  

##### 2. 뒷면 기준
|D (시계방향으로 회전)|D' (반시계방향으로 회전)|
|---|---|
|![d](./image/d.png) |![d'](./image/dL.png)|

- 큐브의 아랫면을 잡고 시계방향 또는 반시계방향으로 돌리는 동작이다.
- "d" 또는 "D"를 입력하면 큐브의 아랫면이 시계방향으로 돌아간다. 
오른쪽,앞쪽,왼쪽,뒷쪽면의 줄은 **오른쪽**으로 미뤄진다.   

- "d'" 또는 "D'"를 입력하면 큐브의 아랫면이 반시계방향으로 돌아간다. 
오른쪽,앞쪽,왼쪽,뒷쪽면의 줄은 **왼쪽**으로 미뤄진다. 

##### 3. 오른쪽면 기준
|R (시계방향으로 회전)|R' (반시계방향으로 회전)|
|---|---|
|![r](./image/r.png) |![r'](./image/rL.png)|

- 큐브의 오른쪽면을 잡고 시계방향 또는 반시계방향으로 돌리는 동작이다.
- "r" 또는 "R'"를 입력하면 큐브의 오른쪽면이 시계방향으로 돌아간다. 
윗쪽,앞쪽,아랫쪽,뒷쪽면의 줄은 **위쪽**으로 미뤄진다.   

- "r'" 또는 "R'"를 입력하면 큐브의 오른쪽면이 반시계방향으로 돌아간다. 
윗쪽,앞쪽,아랫쪽,뒷쪽면의 줄은 **아래쪽**으로 미뤄진다. 

##### 4. 왼쪽면 기준
|L (시계방향으로 회전)|L' (반시계방향으로 회전)|
|---|---|
|![l](./image/l.png) |![l'](./image/lL.png)|

- 큐브의 왼쪽면을 잡고 시계방향 또는 반시계방향으로 돌리는 동작이다.
- "l" 또는 "L'"를 입력하면 큐브의 왼쪽면이 시계방향으로 돌아간다. 
오른쪽,앞쪽,왼쪽,뒷쪽면의 줄은 **아래쪽**으로 미뤄진다.   

- "l'" 또는 "L'"를 입력하면 큐브의 왼쪽면이 반시계방향으로 돌아간다. 
오른쪽,앞쪽,왼쪽,뒷쪽면의 줄은 **윗쪽**으로 미뤄진다. 

##### 5. 앞면 기준
|F (시계방향으로 회전)|F' (반시계방향으로 회전)|
|---|---|
|![f](./image/f.png) |![f'](./image/fL.png)|

- 큐브의 앞면을 잡고 시계방향 또는 반시계방향으로 돌리는 동작이다.
- "f" 또는 "F'"를 입력하면 큐브의 앞면이 시계방향으로 돌아간다. 
오른쪽,윗쪽,왼쪽,아래쪽 면의 줄은 **시계방향**으로 미뤄진다.   

- "f'" 또는 "F'"를 입력하면 큐브의 앞면이 반시계방향으로 돌아간다. 
오른쪽,윗쪽,왼쪽,아래쪽 면의 줄은 **반시계방향**으로 미뤄진다.

##### 6. 아랫면 기준
|B (시계방향으로 회전)|B' (반시계방향으로 회전)|
|---|---|
|![b](./image/b.png) |![b](./image/bL.png)|

- 큐브의 아랫면을 잡고 시계방향 또는 반시계방향으로 돌리는 동작이다.
- "b" 또는 "B'"를 입력하면 큐브의 아랫면이 시계방향으로 돌아간다. 
오른쪽,윗쪽,왼쪽,아래쪽 면의 줄은 **반시계방향**으로 미뤄진다.   

- "b'" 또는 "B'"를 입력하면 큐브의 아랫면이 반시계방향으로 돌아간다. 
오른쪽,윗쪽,왼쪽,아래쪽 면의 줄은 **시계방향**으로 미뤄진다.

##### 7. 여러줄 입력받기
|여러줄 입력받기|이상한 값 포함하여 입력받기|
|---|---|
|![MultipleInputs](./image/MultipleInputs.png)|![StrangeInputs](./image/strangeInputs.png)

- 여러줄을 한 번에 입력받을 수 있다. 만약, 입력값으로 f,r,u,d,b,l,f',r',u',d',b',l' 이외의 값이 들어오면 무시하며 큐브는 동작하지 않는다.

##### 8. 큐브 무작위로 섞기
|S|
|---|
|![s](./image/s.png) |

- "s" 또는 "S" 명령어를 입력하면 큐브가 랜덤으로 섞인다.

##### 9. 끝내기
|Q 명렁어로 끝내기|큐브를 다 맞추고 끝내기|
|---|---|
|![q](./image/q.png) |![finish](./image/finish.png)|

- "q" 또는 "Q"를 입력하면 프로그램을 종료하고, 경과 시관과 조작개수를 출력한다.
조작 개수는 Command에 해당하는 값을 통해 큐브가 움직인 수만 세며, 그 이외의 값들을 입력하였을 경우에는 큐브가 움직이지 않으므로 개수를 세지 않는다.
- Q 명령어를 입력하지 않아도 큐브를 다 완성시켰을 경우에는 축하 메세지를 띄우며 프로그램을 종료한다.




