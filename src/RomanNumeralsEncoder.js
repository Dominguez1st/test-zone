function solution(number){

  let answer = "";
  let decimals = [1,4,5,9,10,40,50,90,100,400,500,900,1000]
  let numerals = ["I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"];

  for (let i = decimals.length; i > 0; i--){
    while (number >= decimals[i - 1]){
      answer += numerals[i - 1]
      number -= decimals[i - 1];
    }
  }

  return answer;
}