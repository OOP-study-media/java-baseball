const { body } = document
let arr = []
let result = null
let description = null
let answer = 0

const chooseNumber = () => {
  var numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9]
  arr = []
  for (let i = 0; i < 3; i++) {
    const randomNumber = Math.floor(Math.random() * (9 - i))
    const chosen = numbers.splice(randomNumber, 1)[0]
    arr.push(chosen)
  }
}

const compareTwoArray = (answer) => {
  let strike = 0
  let ball = 0
  for (let i = 0; i < 4; i++) {
    if (Number(answer[i]) === arr[i]) {
      strike += 1
    } else if (arr.indexOf(Number(answer[i])) > -1) {
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
input.maxLength = 4
form.append(input)

const button = document.createElement('button')
button.textContent = '입력!'
form.append(button)

chooseNumber()
makeDescription()
console.log(arr)

form.addEventListener('submit', (e) => {
  e.preventDefault()
  answer = input.value
  if (answer === '2') {
    body.style.display = 'none'
  } else if (answer === arr.join('')) {
    result = document.createElement('div')
    body.append(result)
    result.textContent = `3개의 숫자를 모두 맞히셨습니다! 게임종료 종료하려면 2를 입력하세요.`
    makeDescription()
    input.value = ''
    input.focus()
    chooseNumber()
  } else {
    const answerArray = answer.split('')
    let [strike, ball] = compareTwoArray(answerArray)
    result = document.createElement('div')
    description.textContent = `숫자를 입력해주세요: ${answer}`
    body.append(result)
    makeDescription()
    strike === 0 && ball === 0
      ? (result.textContent = `낫싱`)
      : (result.textContent = `${strike}스트라이크 ${ball}볼입니다.`)
    input.value = ''
    input.focus()
  }
})
