const fileSystem = require("fs");

const promiseLeituraDeArquivo = dados => new Promise((resolve, reject) => {
    fileSystem.readFile(dados, (erro,conteudo) => {

       if(conteudo){
        resolve(conteudo);
       }else{
        reject(erro);
       }
    })
})

promiseLeituraDeArquivo("Arquivo1.txt")
    
    .then(conteudo => {
        console.log(String("Conteudo arquivo 1: "));
        console.log(String(conteudo));
        let conteudoToUpperCase = String(conteudo);
        return conteudoToUpperCase.toUpperCase();
    })
    .then(conteudo => {
        console.log(String(conteudo));
        return promiseLeituraDeArquivo("Arquivo.txt");
    })
    .then(conteudo => {
        console.log(String("Conteudo arquivo 2: "));
        console.log(String(conteudo));
    })
    .catch(erro => {
        console.log(String(erro));
    })

/*
const promessa = promiseLeituraDeArquivo("Arquivo1.txt");
console.log(promessa);

setTimeout(() => {
    console.log(promessa);
},1000)
*/