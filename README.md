# java-baseball

숫자야구게임 저장소

https://taenykim.github.io/java-baseball/

## 구현해야할 기능 목록

난수생성 `chooseNumber`

스트라이크, 볼 구하기 `compareNumbers`

# 🖌 memo

### 1. 매직넘버 -> 상수

매직넘버는 상수 변수에 담아줘야 가독성도 좋고 수정하기도 쉬움

```js
const BASEBALL_NUMBER_LENGTH = 3
```

<hr/>

### 2. 변수네이밍(자료구조명 명시 X)

변수명은 `할당된 값의 의미`를 드러내게 작성할 것.

타입(형식)까지 명시하면 자료구조 형태를 수정할 때 제약이 생김.

> bad

```js
const compareTwoArray = (myNum) => {}
const numberArr = [1, 2, 3, 4]
```

> good

```js
const compareNumbers = (myNum) => {}
const numbers = [1, 2, 3, 4]
```

<hr/>

### 3. 변수 타입 체크?

변수명에 Num이 들어가지만 타입은 문자열이라 헷갈릴 것 같아서 상단에 변수의 타입을 명시해주었다.

> 타입스크립트를 왜 쓰는지 살짝 알 수 있었다.

```js
let answerNum = ''
let myNum = ''
// htmlDivElement
let result = null
// htmlSpanElement
let description = null
```
