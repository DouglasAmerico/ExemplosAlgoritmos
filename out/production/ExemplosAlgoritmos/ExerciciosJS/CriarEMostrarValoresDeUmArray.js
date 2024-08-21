//Faça um programa que lê 10 números de ponto flutuante para um vetor e, 
//em seguida, exiba todos os elementos na tela.

const leitor = require("prompt-sync")();
const tamanho = 10;
let vetor= [];

for(i=0;i<tamanho;i++){
    vetor[i]= leitor("Informe o "+Number(i+1)+"° valor do vetor: ");
    //recebendo o valor do terminal e inserindo no array (vetor)
    vetor[i]= parseFloat(vetor[i]);
    //pegando o valor do array, convertendo em Float (decimal) e inserindo novamente no array
}

for(i=0;i<tamanho;i++){
    console.log("O "+Number(i+1)+"° elemento do array é: "+vetor[i]);
}