const prompt = require("prompt-sync")();//criando a função de leitura de informações do terminal
let qtdAlunos = prompt("Quantos alunos serão Informados?");//armazenando quantos alunso serão informados
let sala = [];//criando o array que irá armazenar objetos de alunos

for(i=0;i<qtdAlunos;i++){//laço de repetição que controla as inserções de alunos, limite pela variavel de quantidade
    
    let aluno = {//criando o objeto de alunos dentro do laço de repeição para que seja criado um novo em toda passagem do laço
        nome: null,
        idade: null,
        notas: [],
        media: 0,
        statusAluno: null
    }

    aluno.nome= prompt("Informe o nome do "+Number(i+1)+"° aluno: ");//solicitando o nome do aluno
    aluno.idade= prompt("Informe a idade do(a) "+aluno.nome+": ");//solicitando a idade do aluno
    for(j=0;j<3;j++){//laço de repeição para solicitar 3 notas
        aluno.notas[j]= prompt("Informe a "+Number(j+1)+" nota do(a) "+aluno.nome+": ");//solocitando a nota
        aluno.media= aluno.media + Number(aluno.notas[j]);//somando a nota recebida na media
    }
    aluno.media= aluno.media/3;//fazendo o calculo da media
    if(aluno.media >= 7){//verificando se a media é maior que 7
        aluno.statusAluno= "Aprovado";
    }else if(aluno.media >= 4){//verificando se a media é maior que 4
        aluno.statusAluno= "Exame";
    }else{//verificando se a media é menor que 4
        aluno.statusAluno= "Reprovado"
    }
    sala[i]= aluno;//gravando o objeto dentro de uma posição do array
}

console.log(sala);//mostrandos todos os objetos gravados em todas as posições do array