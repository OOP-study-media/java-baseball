const { body } = document
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9]
const BASEBALL_NUMBER_LENGTH = 3

let answerNums = []
let result = null
let description = null
let myNum = 0

const chooseNumber = () => {
  answerNums = []
  for (let i = 0; i < 3; i++) {
    const randomNumber = Math.floor(Math.random() * (9 - i))
    const chosen = numbers.splice(randomNumber, 1)[0]
    answerNums.push(chosen)
  }
}

const compareNumbers = (myNum) => {
  let strike = 0
  let ball = 0
  for (let i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
    if (Number(myNum[i]) === answerNums[i]) {
      strike += 1
    } else if (answerNums.indexOf(Number(myNum[i])) > -1) {
      ball += 1
    }
  }
  return [strike, ball]
}

const makeDescription = () => {
  description = document.createElement('span')
  description.textContent = '숫자를 입력해주세요: '
  body.append(description)
}

const form = document.createElement('form')
body.append(form)

const input = document.createElement('input')
input.type = 'text'
input.maxLength = BASEBALL_NUMBER_LENGTH
form.append(input)

const button = document.createElement('button')
button.textContent = '입력!'
form.append(button)

chooseNumber()
makeDescription()
console.log(answerNums)

form.addEventListener('submit', (e) => {
  e.preventDefault()
  myNum = input.value
  if (myNum === '2') {
    body.style.display = 'none'
  } else if (myNum === answerNums.join('')) {
    result = document.createElement('div')
    body.append(result)
    description.textContent = `숫자를 입력해주세요: ${myNum}`
    body.append(result)
    result.textContent = `3개의 숫자를 모두 맞히셨습니다! 게임종료 종료하려면 2를 입력하세요.`
    makeDescription()
    input.value = ''
    input.focus()
    chooseNumber()
  } else {
    let [strike, ball] = compareNums(myNum.split(''))
    result = document.createElement('div')
    description.textContent = `숫자를 입력해주세요: ${myNum}`
    body.append(result)
    makeDescription()
    strike === 0 && ball === 0
      ? (result.textContent = `낫싱`)
      : (result.textContent = `${strike}스트라이크 ${ball}볼입니다.`)
    input.value = ''
    input.focus()
  }
})
