# 집약과 정렬
## 집약함수
- 집약 : 복수의 행을 하나의 행으로 모음
- [입력데이터] I-> 집약함수 ->O [단일행]

### 1. count
- 테이블 열을 입력하면 행 수를 출력함
- 함수 인자로 *를 넘기면 NULL이 포함되어 계산. 필드를 넘기면 NULL이 제외 됨
- select에 기술 가능한 값
  1. 상수
  2. 집약 함수
  3. group by가 있는 경우 집약키만 기술 가능.
  <pre><code>
  select goods_name, buy_price, count(*)
  from goods
  group by buy_price;
  => goods_name은 집약 함수에 없는 필드명이므로 에러가 남(집약시 1:!로 대응하지 않기 때문에 어떤 값을 가져와야하는 지 모름)
  </code></pre>

### 2. sum
- 필드의 합계를 구함. 숫자타입 자료형만 가능.
- 인자로 *를 넘길 수 없다.
- 필드명을 반드시 넘겨야하기 때문에 Null값은 제외해서 계산이 됨. (하지만 0은 아님)

### 3. avg
- 복수 행의 값으로부터 평균값을 구함. 숫자타입 자료형만 가능.
- 인자로 * 못넘김.
- Null값은 제외된 후 계산이 됨. 하지만 0은 아니기에, Null을 0으로 취급해서 계산하라면 다른 방법을 써야 함.

### 4. max, min
- 필드 중 최대값(max), 최소값(min)을 구함.
- 거의 모든 데이터에 대해 사용할 수 있음.

## 5. distinc의 이용
- 계산 시 중복값을 제외하고 집약하려면 인자로 넘길 때 DISTINCT 키워드를 삽입.
  <pre><code>
  select count(distinct goods_classify) from goods;
  </code></pre>

## 그룹핑
- 집약함수 : 전체 테이블을 집약 범위로 계산
- group by : 테이블을 몇 개의 그룹으로 나누어서 집약
  <pre><code>
  select 필드명1, 필드명2, ...
  from 테이블명
  group by 필드명1, 필드명2 ...;
  </code></pre>
- 집약키/그룹화열 : group by 구에 지정한 필드
- 전체 실행 순서
  1. from에서 가져올 대상 확정
  2. where 구에서 지정한 조건으로 from에서 가져온 레코드를 걸러냄
  3. group by로 테이블을 나눔
  4. select에서 명시한 각각 필드명 뽑아냄
- 집약키의 레코드로 null값이 있다면 나중에 NULL이라는 별도의 그룹으로 분류된다.
- group by 구에 select 필드에 쓴 별명을 쓰면 안됨(select 구에서 별명을 부여하는 것은 제일 마지막이므로!)
- groupb by로 집약된 결과는 무작위 순서
- where 구에는 집약 함수를 쓸 수 없다. (*대신 Having을 쓰도록 한다.) 집약 함수를 쓸 수 있는 곳은 select, having, order by에만 가능하다.
  <pre><code>
  select goods_classify, count(*)
  from goods
  where count(*) = 2 << 에러!
  group by goods_classify;
  </code></pre>

## 집약 결과에 조건 지정하기
- 집약 함수의 결과에 어떤 조건을 지정하고 싶다면 having을 group by 뒤에 서술.
- 전체 실행 순서
  1. select에서 명시한 각각 필드명 뽑아냄
  2. from에서 가져올 대상 확정
  3. where 구에서 지정한 조건으로 from에서 가져온 레코드를 걸러냄
  4. group by로 테이블을 나눔
  5. having
- having구에 쓸 수 있는 요소
  1) 상수
  2) 집약 함수
  3) group by 구에 지정한 열명(집약 키)

## 정렬
- 검색 결과를 재정렬 하기위해 사용.
- asc : 오름차순, desc : 내림차순,
- ,로 구분해서 여러개의 소트키를 지정 할 수 있음.
- 소트키로 지정한 열에 null값이 있다면... null을 포함하는 열을 모아서 맨 앞 또는 뒤에 표시됨
- 키로는 select에서 지정한 별명을 쓸 수 있음. 왜냐면 order by가 가장 마지막에 실행되기 때문.
- select에 포함되지 않은 필드나 집약키도 소트키로 지정할 수 있음. (열번호는 사용 안됨)
