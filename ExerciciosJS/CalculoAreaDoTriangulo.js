//Faça um algoritmo que calcule e apresente a área de um triângulo. 
//Sabe-se que área = (base * altura) / 2. 
//Os valores da base e da altura devem ser informados pelo usuário. 

const leitor = require("prompt-sync")();

let base = leitor("Informe a base do triangulo: ");
let altura = leitor("Informe a altura do triangulo: ");
let area = (base*altura)/2;

console.log("A area do triangulo é: "+area);