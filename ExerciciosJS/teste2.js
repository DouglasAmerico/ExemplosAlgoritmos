//Com base nos conceitos aprendidos sobre objetos em JavaScript, escreva um código em JS que armazene 
//    as informações em um objeto da aluna Agnes, que tem 31 anos, estuda na turma 1C e no ano passado 
//    obteve as notas bimestrais (5.8 , 8.8 , 6.3 e 7.4).
//
//Após o armazenamento faça a média das notas utilizando um laço de repetição para percorrer o array 
//    que armazena as notas, e com a média calculada apresente todas as informações do objeto. 
//    Apesente também se a Agnes reprovou no ano letivo passado (caso sua média seja menor que 4), 
//    ou se ela tem que fazer uma prova de recuperação (caso sua média seja maior ou igual 4.0 e 
//    menor que 7), ou se ainda a aluna foi aprovada (caso sua média seja maior ou igual a 7.0).

const aluna = {
    nome: "Agnes",
    idade: 31,
    turma: "1C",
    notas: [5.8 , 8.8 , 6.3 , 7.4],
    media: 0,
    status: null
}

for (let index = 0; index < aluna.notas.length; index++) {
    aluna.media= aluna.media + aluna.notas[index];
}

aluna.media= aluna.media / aluna.notas.length;

if(aluna.media >= 7.0){
    aluna.status= "Aprovada";
}else if(aluna.media >= 4.0){
    aluna.status= "Exame";
}else{
    aluna.status= "Reprovada";
}

console.log(aluna);