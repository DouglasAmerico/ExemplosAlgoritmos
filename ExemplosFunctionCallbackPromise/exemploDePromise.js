let minhaPromise = new Promise((resolve, reject) => {
    let operacaoBemSucedida = true;  // Simula o sucesso ou falha de uma operação

    if (operacaoBemSucedida) {
        resolve("A operação foi bem-sucedida!");
    } else {
        reject("A operação falhou!");
    }
});
minhaPromise
    .then(resultado => {
        console.log(resultado);  // Será executado se a Promise for resolvida
    })
    .catch(erro => {
        console.log(erro);  // Será executado se a Promise for rejeitada
    });
