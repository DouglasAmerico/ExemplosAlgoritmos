//Ler três variáveis (a,b,c) e apresentar o resultado da seguinte fórmula: d=a+c-b, onde d também é uma variável. 

const leitor = require("prompt-sync")();

let a = Number(leitor("Informe o valor de A: "));
let b = Number(leitor("Informe o valor de B: "));
let c = Number(leitor("Informe o valor de C: "));
let d = a+b+c;

console.log("A soma de "+a+"+"+b+"+"+c+"="+d);

//Foi inserido Number() na leitura das informações para que o programa entenda que ao 
//receber qualquer informação ali, ela deve ser tratada como numero