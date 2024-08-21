const prompt = require("prompt-sync")();

function funcaoMedia(v1,v2,v3){
    let calculo= (v1+v2+v3)/3;
    return calculo;
}

function apresentacao(nome,idade,v1,v2,v3,media){
    console.log("O aluno(a) "+nome+" com a idade "+idade+" com as notas "+v1+" , "+v2+" , "+v3+" obteve a media "+media);
}

let nome= prompt("Informe o nome: ");
let idade= prompt("Informe a idade: ");
let nota1= Number(prompt("Informe a nota: "));
let nota2= Number(prompt("Informe a nota: "));
let nota3= Number(prompt("Informe a nota: "));
let media= funcaoMedia(nota1,nota2,nota3);

apresentacao(nome,idade,nota1,nota2,nota3,media);