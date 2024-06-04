//Preencha um array com valores numericos (solicitando ao usuario) e depois ordene e apresente
//esses valores em ordem crescente

const leitor = require("prompt-sync")();
let array= [];
let aux;
let tamanho= Number(leitor("Quantos valores quer informar? "));

for (let index = 0; index < tamanho; index++) {
    array[index]= Number(leitor("Informe o "+Number(index+1)+"° do array: "));
}

for (let index = 0; index < tamanho; index++) {
    for (let index2 = 0; index2 < array.length; index2++) {
        if(index != index2){//verifica se os indices não são os mesmos
            if(array[index2] > array[index]){
                aux= array[index2]; //armazena a informação na variavel auxiliar para não se perder os valores
                array[index2]= array[index];
                array[index]= aux;
                //realiza a inversão dos valores caso o valor de indice maior seja menor que o 
                //valor do indice menor
            }
        }   
    }
}

console.log(array);