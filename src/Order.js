let correctOrder = []

function order(words){
  let individualWords = words.split(" ");
  for (let i = 0; i <= individualWords.length; i++) {
    individualWords.forEach(test);
  }
  return correctOrder.join(" ");
}

function test (word, i) {
  if(word.includes( "" + i)){
    correctOrder.push(word);
  }
}