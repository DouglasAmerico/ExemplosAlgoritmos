//Faça um programa que lê 10 valores, um de cada vez, e conte quantos estão no intervalo de 100 a 500

const leitor = require("prompt-sync")();

const tamanho = 10;
let valores = [];
let contadorDeNumerosEntre100e500= 0;

for (let index = 0; index < tamanho; index++) {
    valores[index]= leitor("Informe o "+Number(index+1)+"° valor: ");    
}

for (let index = 0; index < valores.length; index++) {
    if(valores[index] >= 100 && valores[index] <= 500){
        contadorDeNumerosEntre100e500++;
    }
}

console.log("No array foram identificados "+contadorDeNumerosEntre100e500+" numeros entre 100 e 500");