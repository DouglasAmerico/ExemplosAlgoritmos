const prompt = require("prompt-sync")();

function calculoDeMedia(media) {
    let status;
    if(media >= 7){
        status= "Aprovado";
    }else if(media >= 4){
        status= "Exame";
    }else{
        status= "Reprovado";
    }
    
    return status;
}

function funcaoMedia(notas,qtd){
    let media= 0;
    for(i=0;i<qtd;i++){
        media= media + notas[i];
    }
    media= media/qtd;
    return media;
}

function apresentacao(aluno,qtd){
    console.log("O aluno "+aluno.nome+" tem idade "+aluno.idade+" e as notas:");
    for(i=0;i<qtd;i++){
        console.log("Nota "+Number(i+1)+": "+aluno.notas[i]);
    }
    console.log("Ficou com a media "+aluno.media);
    console.log("O status é "+calculoDeMedia(aluno.media));
}

let aluno = {
    nome: null,
    idade: null,
    notas: [],
    media: null
}

aluno.nome= prompt("Informe o nome: ");
aluno.idade= prompt("Informe a idade: ");
for(i=0;i<3;i++){
    aluno.notas[i]= Number(prompt("Informe a nota"+Number(i+1)+": "));
}
aluno.media= funcaoMedia(aluno.notas,3);

apresentacao(aluno,3)