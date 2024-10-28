## 목표
주어진 요구 사항을 바탕으로 객체를 디자인하고 서로 간의 협력 관계를 통해 문제를 해결하고자 한다.

## 객체 디자인
### InputView 및 OutputView

- 현 시점 View는 콘솔이 담당한다.
- 사용자에게 게임 진행을 위한 멘트를 전달한다.
- 문자열을 입력받고 결과를 출력한다.

### InputValidator

- 사용자의 입력을 검증한다. 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨다.
- 잘못된 입력
    - 공백 (진행할 자동차가 없는 경우)
    - 자동차 이름이 5자를 초과한 경우
    - 쉼표(,)를 제외한 특수문자를 사용한 경우 (자동차 이름에 특수문자가 포함된 경우)
    - 쉼표가 연달아 사용된 상황(ex. woody,,,fobi)

### InputExtractor

- 검증이 끝난 입력에 대해 자동차 이름을 추출한다.

### Car

- 이름과 전진 진행도를 갖는다.
- 외부에서 진행 요청 시, 제공된 Random 함수를 바탕으로 전진 할 지 스스로 결정한다.

### Game

- 자동차 경주의 시작부터 끝을 통제하는 역할이다.
- 자동차들의 리스트, 우승자를 판단하는 심판, 라운드 정보를 갖는다.
- 외부에서 진행 요청 시, 게임 전체를 진행하고 우승자를 반환한다.

### OutputMaker

- 정해진 포맷의 문자열을 생성하는 역할이다.
    - 차수별 실행 결과
    - 우승자 안내 문구

### GameController

- 위에서 디자인한 객체들의 협력으로 결과를 도출해낸다.

## 객체 별 상세 요구사항 정리
### Feat1: InputView 및 OutputView

- [ ]  게임을 시작할 때 정해진 문자열을 출력하고 입력값을 반환한다.
- [ ]  차수별 실행 결과를 출력한다.
- [ ]  라운드가 모두 종료되면 우승자를 출력한다.

### Feat2: InputValidator

- [ ]  InputView로부터 반환받은 문자열을 검증하고 만족하지 못할 시 예외를 발생시킨다.
    - [ ]  입력값은 공백일 수 없다.
    - [ ]  쉼표(,)를 제외한 특수문자는 사용될 수 없다.
    - [ ]  자동차 이름은 5자 이하만 가능하다.
    - [ ]  쉼표는 연속적으로 사용될 수 없다.

### Feat3: InputExtractor

- [ ]  유효성 검증에 통과한 문자열에 대하여 쉼표(,)를 기준으로 자동차 이름을 추출해 반환한다.

### Feat4 : Car

- [ ]  랜덤 숫자가 4 이상인 경우 전진해 진행도(Progress)가 올라간다.
- [ ]  랜덤 숫자가 3 이하인 경우 이전 진행도를 유지한다.

### Feat5 : Game

- [ ]  각 자동차는 명령에 따라 모두 전진을 시도한다.
- [ ]  심판(Referee)는 모든 라운드가 종료되면 우승자를 선별해 반환한다.
    - [ ]  Referee는 주어진 자동차 리스트에 대하여 가장 진행도가 높은 우승자를 선별한다.

### Feat6: OutputMaker

- [ ]  매 차수가 끝날 때 모든 Car 객체를 통해 차수별 실행 결과 문구를 생성한다.
- [ ]  모든 차수가 끝나면 최종 우승자 안내 문구를 생성한다.

### Feat7: GameController

- [ ]  InputView를 통해 문자열을 입력받는다.
- [ ]  InputValidator를 통해 문자열을 검증한다. 잘못된 입력의 경우 예외를 발생시키고 종료한다.
- [ ]  InputExtractor를 통해 자동차 이름을 추출해 Game 객체를 생성, 자동차 경주를 시작한다.
- [ ]  모든 라운드를 거친 뒤 심판을 통해 우승자를 반환한다.
- [ ]  OutputView를 통해 결과를 출력한다.