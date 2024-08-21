//Para ler informações disponibilizadas pelo usuario via terminal
//vamos utilizar a biblioteca prompt-sync

//Antes de utilizar a biblioteca precisamos instala-la no computador
//para isso, utilize o comando "npm install prompt-sync"

//Após a instalação, poderá coletar informações do usuario via terminal
//e armazena-las dentro variaveis ou constantes
//Segue exemplo

const leitor = require("prompt-sync")(); //declarando uma variavel para consumir a biblioteca prompt-sync

let nome = leitor("Informe o nome: ");
console.log("O nome informado foi: "+nome);