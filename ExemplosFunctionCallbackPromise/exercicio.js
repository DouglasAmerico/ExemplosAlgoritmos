let minhaPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve("Dados da API recebidos!");
    }, 2000); // Simula uma requisição de 2 segundos
})

// Vamos usar a Promise
minhaPromise
    .then(resultado => {
        console.log(resultado.mensagem);
    })
    .catch(erro => {
        console.error('Erro na requisição:', erro);
    });
