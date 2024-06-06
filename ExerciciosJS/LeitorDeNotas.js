const prompt = require("prompt-sync")();

function valoresProva1(nome, qtdAlunos) {
    let prova1 = new Array(qtdAlunos);
    for (let i = 0; i < qtdAlunos; i++) {
        do {
            prova1[i] = prompt("Por favor insira o valor da Prova 1 do Aluno " + nome[i] + ": ");
        } while (prova1[i] > 100 || prova1[i] < 0);
    }
    return prova1;
}

function valoresProva2(nome, qtdAlunos) {
    let prova2 = new Array(qtdAlunos);
    for (let i = 0; i < qtdAlunos; i++) {
        do {
            prova2[i] = prompt("Por favor insira o valor da Prova 2 do Aluno " + nome[i] + ": ");
        } while (prova2[i] > 100 || prova2[i] < 0);
    }
    return prova2;
}

function trabalhosnotas(nome, qtdAlunos) {
    let trabalhos = new Array(qtdAlunos);
    for (let i = 0; i < qtdAlunos; i++) {
        do {
            trabalhos[i] = prompt("Por favor insira o valor dos trabalhos do Aluno " + nome[i] + ": ");
        } while (trabalhos[i] > 100 || trabalhos[i] < 0);
    }
    return trabalhos;
}

function calculoDasNotas(prova1, prova2, trabalhos, qtdAlunos) {
    let somaNotas = new Array(qtdAlunos);
    for (let i = 0; i < qtdAlunos; i++) {
        somaNotas[i] = prova1[i] * 0.4 + prova2[i] * 0.3 + trabalhos[i] * 0.3;
    }
    return somaNotas;
}

function aprovados(somaNotas, alunosAprovados, qtdAlunos) {
    for (let i = 0; i < qtdAlunos; i++) {
        if (somaNotas[i] >= 70) {
            alunosAprovados[i] = "Aprovado";
        } else if (somaNotas[i] >= 40) {
            alunosAprovados[i] = "Exame";
        } else {
            alunosAprovados[i] = "Reprovado";
        }
    }
    return alunosAprovados;
}

let qtdAlunos = prompt("Irá informar a nota de quantos alunos?");
let nomes = new Array(qtdAlunos);
let prova1 = new Array(qtdAlunos);
let prova2 = new Array(qtdAlunos);
let trabalhos = new Array(qtdAlunos);
let somaNotas = new Array(qtdAlunos);
let alunosAprovados = new Array(qtdAlunos);

for (let i = 0; i < qtdAlunos; i++) {
    nomes[i] = prompt("Por favor informa o nome do Aluno " + (i + 1) + ": ");
}

prova1 = valoresProva1(nomes, qtdAlunos);
prova2 = valoresProva2(nomes, qtdAlunos);
trabalhos = trabalhosnotas(nomes, qtdAlunos);
somaNotas = calculoDasNotas(prova1, prova2, trabalhos, qtdAlunos);
alunosAprovados = aprovados(somaNotas, alunosAprovados, qtdAlunos);

for (let i = 0; i < qtdAlunos; i++) {
    console.log("O aluno: " + nomes[i] + " foi " + alunosAprovados[i] + " com a nota " + somaNotas[i]);
}
