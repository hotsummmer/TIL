# 복잡한 질의
## 뷰(view)
### 뷰 vs 테이블
- 뷰 : 저장 안된다
- 테이블 : 실제 DB에 저장된다

### 뷰의 이점(그럼 왜 뷰를 쓸까?)
- 기억 장치 용량을 절약. (매번 저장하지 않으니까!)
- select 문을 매번 작성하지 않고 뷰로 저장해 반복해서 사용할 수 있다는 것-> 뷰로 저장이 되니까 거기서 또 꺼내쓸 수 있음
  => 자주 사용하는 select 문은 뷰로 만들어서 반복해서 사용하자!
- 원 테이블과 연동되기 때문에 최신 상태의 데이터를 선택할 수 있음.

### 뷰 관련 쿼리
#### 생성하기
<pre><code>CREATE VIEW 뷰명
(열1,열2, 열3 ...)as
select(열1, 열2, 열3 ...)</code></pre>
#### 삭제하기
<pre><code>Drop view 뷰명</code></pre>
- 다단 뷰의 작성 기반이 되는 뷰를 삭제하는 경우 삭제하면 에러가 남.

### 뷰를 from절에 지정했을 때
1. 먼저 뷰에 정의된 select 문이 실행되고,
2. 그 결과에 대해 뷰를 from 구에 지정한 select문이 실행된다.
--> 다단계 뷰도 지정 가능하다는 뜻!

### 뷰 제약사항
1. 뷰 정의에 order by 구를 사용할 수 없다.
  - 뷰에서는 행에 순서가 없다고 정하기 때문에
2. 뷰 갱신 제약(insert, update, delete 등)
  - 다음의 경우에는 뷰 갱신이 가능
    1. from에 테이블이 1개만 포함
    2. select에 distinct가 없음
    3. group by이 없음
    4. having이 없음
      => 집약이 없는 경우 가능하다는 말!
      => 왜? 정합성 문제 때문에. 집약으로 이뤄진 경우 어느 테이블에서 비롯된 것인지 모르게 되므로 갱신 불가능

## 서브쿼리
1. 정의
- 서브쿼리는 한마디로 일회용 뷰.
- 뷰 정의 select문을 그대로 from 구에 삽입한 것.
2. 순서
- select 문은 내포 구조로 되어있어서 from 구 안의 select 문이 먼저 실행되고 그뒤에 바깥쪽 select 문이 실행된다.
<pre><code>select goods_classify,cnt_goods from( --> 2번째로 실행
  select goods_classify, count(*)as cnt_goods from Goods group by goods_classify  --> 1번째로 실행
)as GoodsSum;</code></pre>
3. 이름
- 서브쿼리에는 이름이 원칙상으로 필요하다.
- 서브 쿼리 뒤에 as라는 키워드와 함께 사용 가능하다.

### 스칼라 서브쿼리
* 스칼라 : '단일'이라는 의미
- 반드시 1행 1열만을 반환 값으로 반환하는 것.
- 스칼라 서브 쿼리의 값을 =,<,> 등 스칼라 값을 비교 연산자의 입력 값으로 사용할 수 있다는 것.
<pre><code>selct goods_id, goods_name, sell_price --> 2번째로 실행
from Goods
where sell_price > (select AVG(sell_price) from Goods --> 1번째로 실행);</code></pre>
- 상수나 열 명을 쓸 수 있는 곳이라면 어디든 가능
<pre><code>//having구에 서브쿼리 사용
select goods_classify, AVG(sell_price)
from Goods
group by goods_classify
having avg(sell_price) > (select AVG(sell_price) from Goods)</code></pre>
- 서브쿼리가 복수 행을 반환해서는 안된다!

## 상관 서브 쿼리
1. 일반 서브쿼리 vs 상관 서브쿼리
- 상관 서브 쿼리는 작은 그룹 내에서 비교가 필요할 때 사용 한다.
- 즉, group by처럼 집합을 '자르는' 기능을 가지고 있다.
2. 핵심은 서브 쿼리 내에 추가한 where 구문
<pre><code>select goods_classify,goods_name,sell_price
  from Goods AS S1
where sell_price > (select AVG(sell_price)
      from Goods as S2
      where S1.goods_classify = S2.goods_classfiy <<여기가 핵심!
      group by goods_classfiy)</code></pre>
3. 상관명 스코프
- 상관명이 통용될 수 있는 범위의 제한
- '묶기'위한 결합 조건을 서브쿼리 내부가 아닌 외부에 기술하지 않기!
<pre><code>select goods_classify,goods_name,sell_price
  from Goods AS S1
  where S1.goods_classify = S2.goods_classfiy <<oh no!😱
where sell_price > (select AVG(sell_price)
      from Goods as S2
      group by goods_classfiy)
-> S2는 실행후 사라지기 때문에 where 조건에서 S2를 찾을 수 없는 것!</code></pre>
