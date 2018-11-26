# 도구 다루기
## jasmine
- 행위 주도 개발 방식으로 자바스크립트 단위 테스트를 작성하는 라이브러리
- https://github.com/jasmine

### 기본문법
- describe : 재스민 테스트 꾸러미를 만들고 두개의 인자를 받음.
  - 문자열 : 무엇을 테스트할 지 서술한다.
  - 함수 : 테스트 꾸러미의 구현부
- it : 개별 테스트. 2개의 인자를 받음
  - 문자열 : 무엇을 테스트할 지 서술한다.
  - 함수 : 한개의 기대식을 가진 함수. 코드 상태의 true/false를 단언하게 됨
- beforeEach/afterEach
  - 각 꾸러미 테스트가 실행되기 이전, 이후에 각각 실행할 함수.
  - 공통적으로 해야할 설정 및 정리 코드를 담아두면 좋다.
- expect
  - 테스트마다 존재
  - 형식 : expect(실제 값을 가진 변수).toBe(기대값)
  - matcher : 실제값과 기대값을 비교함. 내장 matcher도 있고, 없으면 커스텀으로 쓰면 됨

### 스파이
####  test double
1. Dummy : 보통 인자 리스트를 채우기 위해 사용되는 값으로 전달은 하지만 실제 사용되지는 않는다.
2. Stub : 더미를 조금 더 구현하여 아직 개발되지 않은 클래스나 메서드가 실제 작동하는 것처럼 보이게 함. 리턴 값을 하드코딩 해 둠.
3. Spy : stub과 비슷하지만, 내부적으로 기록을 남긴다. 특정 객체가 사용되거나 예상되는 메서드가 특정한 인자로 호출되었는 지 등 상황을 감시하고 이러한 정보를 제공한다.
4. Fake : stub에서 조금 더 발전해 실제로 간단히 구현된 코드를 갖고있으나, 운영 환경에서는 사용할 수 없는 객체.
5. Mock : Dummy, Stub, Spy를 혼합한 형태와 비슷하나 행위를 검증하는 용도로 사용한다.

#### 스파이 설정
- spyOn : 특정 함수를 몰래 들여다 볼 수 있다.
  - 첫번째 인자는 객체 인스턴스
  - 두번째 인자는 감시할 함수명
- toHavebeencalled()
  - expect 구문에서 호출이 되었는지 확인 가능


## 의존성 주입
- 빈자의 의존성 주입(poor man's dependency injection)
  <pre><code>Attendee = function(attendeeId){
  	if(!(attendeeId instanceof Attendee)) return new Attendee(attendeeId);
  	this.attendeeId = attendeeId;
  	this.service = new ConferenceWebSvc();//직접 생성하지 않고 외부에서 주입하도록 한다.
  	this.messenger = new Messenger();//직접 생성하지 않고 외부에서 주입하도록 한다.
  };</code></pre>
  <pre><code>Attendee = function(service, messenger, attendeeId){
  	if(!(attendeeId instanceof Attendee)) return new Attendee(service, messenger, attendeeId);
  	this.attendeeId = attendeeId;
  	this.service = service;
  	this.messenger = messenger;
  };</code></pre>
- 다음 질문에 1가지라도 해당된다면 직접 인스턴스화하지 않고 주입하도록 함.
  1) 외부 자원에 의존하는가?(ex. DB, 설정파일, HTTP, 기타 인프라 등)
  2) 객체 내부에서 발생할 지 모를 에러를 테스트에서 고려해야하는가?
  3) 특정한 방향으로 객체를 작동시켜야 할 테스트가 있는가?
  4) 온전히 내가 소유한 객체인가?

  ## AOP(Aspect Oriented Programming)
  - AOP : (단일한 책임 범위 내에 있지 않은)하나 이상의 객체에 유용한 코드를 한데 묶어 눈에 띄지 않게 객체에 배포하는 기법
- 핵심은 함수 실행(타깃)을 가로채어 다른 함수(어드바이스)를 실행하기 직전이나 직후, 또는 전후에 실행하는 것.
  ### 구성원
  - Advice : 배포할 코드 조각
  - Aspect/Cross-cutting concern(횡단 관심사) : 어드바이스가 처리할 문제

  ### AOP로 믿음직한 코드 만들기
  1. 함수를 단순하게 유지. 함수가 각자 단일 책임을 수행할 뿐이다.
  2. 코드를 DRY하게 유지.
  3. 애플리케이션 설정을 한 곳에 집중.
