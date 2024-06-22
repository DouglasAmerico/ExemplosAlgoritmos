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
        console.log(String(conteudo));
    })
    .catch(erro => {
        console.log(String(erro));
    })


