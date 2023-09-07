let playerScore = 0;
let computerScore = 0;

function play(playerSelection) {
  const computerSelection = computerPlay();
  const result = playRound(playerSelection, computerSelection);
  updateScore(result);
  displayResult(result, playerSelection, computerSelection);
}

function computerPlay() {
  const options = ['rock', 'paper', 'scissors'];
  return options[Math.floor(Math.random() * options.length)];
}

function playRound(playerSelection, computerSelection) {
  if (playerSelection === computerSelection) {
    return 'draw';
  } else if (
    (playerSelection === 'rock' && computerSelection === 'scissors') ||
    (playerSelection === 'paper' && computerSelection === 'rock') ||
    (playerSelection === 'scissors' && computerSelection === 'paper')
  ) {
    return 'win';
  } else {
    return 'lose';
  }
}

function updateScore(result) {
  if (result === 'win') {
    playerScore++;
  } else if (result === 'lose') {
    computerScore++;
  }
}

function displayResult(result, playerSelection, computerSelection) {
  const resultElement = document.getElementById('result');
  resultElement.textContent = `You played ${playerSelection}. The computer played ${computerSelection}. `;
  
  if (result === 'win') {
    resultElement.textContent += 'You win!';
  } else if (result === 'lose') {
    resultElement.textContent += 'You lose!';
  } else {
    resultElement.textContent += 'It\'s a draw!';
  }

  const playerScoreElement = document.getElementById('player-score');
  const computerScoreElement = document.getElementById('computer-score');
  playerScoreElement.textContent = `Player: ${playerScore}`;
  computerScoreElement.textContent = `Computer: ${computerScore}`;
}