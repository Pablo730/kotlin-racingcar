# kotlin-racingcar
## TDD 연습
- 여기서는 실제 프로젝트가 아닌, TDD를 몸에 익히기 위한 과정이다
  - 구현하려는 도메인에 대한 이해가 안되어있다면 먼저 기능 구현 후 기본 코드를 버린다
  - 다시 리팩토링을 거치면서 TDD를 이해하고 몸에 익힌다

## 프로그래밍 요구 사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## 기능 요구 사항
1. 각 자동차에 이름을 부여할 수 있다.
2. 경주에서 자동를 출력할 때 자동차 이름을 같이 출력한다.
3. 입력 받을 때 자동차 이름은 쉼표(,)로 구분한다.
4. 경주가 끝나면 어떤 자동차가 우승했는지 자동차 이름으로 알려준다.
5. 우승자는 1명 이상일 수 있다.

## 기능 목록
- [x] 자동차는 이름과 위치를 가진다
- [x] 자동차의 초기 위치는 0이다
- [x] 자동차의 이름이 빈 값이거나, 5글자를 넘으면 예외가 발생한다
- [x] 자동차마다 무작위로 전진할 수 있다. 기준 값은 4이상이면 전진한다
- [x] 주어진 무작위 값이 4미만이면 정지한다
- [x] 경주에 참가하는 자동차가 1대도 없으면 예외가 발생한다
- [x] 경주에서 자동차 전진을 시도하는 횟수가 1 미만이면 예외가 발생한다
- [x] 레이싱에서 전진을 시도하면 모든 자동차들이 주어진 무작위 값이 4 이상이면 전진을 시행한다
- [x] 레이싱에서 전진을 시도하면 모든 자동차들이 주어진 무작위 값이 4 미만이면 정지한다
- [x] 경주가 시작되면 모든 자동차들이 주어진 시도 횟수에 맞춰 전진을 시행한다
- [x] 경주가 끝난 이후 경주 재시작을 할 경우 예외가 발생한다
- [x] 경주가 끝난 이후 가장 멀리간 자동차가 우승한다
- [x] 우승자는 1명 이상일 수 있다

## Commit 단위
- 자동차는 이름과 위치를 가진다 기능 구현 및 테스트, Car 클래스 및 CarTest 클래스 구현
- 자동차의 초기 위치는 0이다 기능 구현 및 테스트
- 자동차의 이름이 빈 값이거나, 5글자를 넘으면 예외 발생 기능 구현 및 테스트
- 자동차 전진의 기준 값은 4이상이면 전진한다에 대한 기능 구현 및 테스트
- 자동차 전진의 기준 값이 4미만이면 정지한다에 대한 테스트
- 경주에 참가하는 자동차가 1대도 없으면 예외 발생 기능 구현 및 테스트, Racing 클래스 및 RacingTest 클래스 구현
- 경주에서 자동차 전진을 시도하는 횟수가 1 미만이면 예외 발생에 대한 기능 구현 및 테스트
- 레이싱에서 전진을 시도하면 모든 자동차들이 주어진 무작위 값이 4 이상이면 전진 기능 구현 및 테스트
- 레이싱에서 전진을 시도하면 모든 자동차들이 주어진 무작위 값이 4 미만이면 정지 기능 구현 및 테스트
- 레이싱에서 전진을 시도하면 모든 자동차들이 주어진 condition 기준 값에 맞춰 전진 시행 기능 구현 및 테스트
- 경주가 시작되면 모든 자동차들이 주어진 시도 횟수에 맞춰 전진 시행 기능 구현 및 테스트
- 경주가 끝난 이후 경주 재시작을 할 경우 예외 발생에 대한 기능 구현 및 테스트
- 경주가 끝난 이후 가장 멀리간 자동차인 우승자 찾기 기능 구현 테스트
- 우승자가 1명 이상인 조건에 대한 기능 구현 및 테스트
- View 관련 클래스 및 Main 클래스 구현

## 리팩톨링
- 하나의 개체에 너무 많은 책임을 갖게 하지 않기
  Racing 클래스 분리 -> RacingResult 클래스, CarForwardAttempt 클래스 추가
- 여러 가변 상태를 관리하는 코드를 지양하자