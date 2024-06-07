const prompt = require("prompt-sync")();
let qtdAlunos = prompt("Quantos alunos serão Informados?");
let sala = [];

for(i=0;i<qtdAlunos;i++){
    
    let aluno = {
        nome: null,
        idade: null,
        notas: [],
        media: 0,
        statusAluno: null
    }

    aluno.nome= prompt("Informe o nome do "+Number(i+1)+"° aluno: ");
    aluno.idade= prompt("Informe a idade do(a) "+aluno.nome+": ");
    for(j=0;j<3;j++){
        aluno.notas[j]= prompt("Informe a "+Number(j+1)+" nota do(a) "+aluno.nome+": ");
        aluno.media= aluno.media + Number(aluno.notas[j]);
    }
    aluno.media= aluno.media/3;
    if(aluno.media >= 7){
        aluno.statusAluno= "Aprovado";
    }else if(aluno.media >= 4){
        aluno.statusAluno= "Exame";
    }else{
        aluno.statusAluno= "Reprovado"
    }
    sala[i]= aluno;
}

console.log(sala);