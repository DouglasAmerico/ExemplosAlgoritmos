const prompt = require("prompt-sync")();


function verificacaoPercIR(mes) {
    let percentual;
    if (mes < 6) percentual = 22.5;
    else if (mes < 12) percentual = 20.0;
    else if (mes < 24) percentual = 17.5;
    else percentual = 15.0;
    
    return percentual;
}

function calculoInvestimentosCDB(qtdMeses, valor, percCDB, CDIAnual, umAnoConvertidoEmMes) {
    let valoresInvestimentoCDB = [];
    let percDescontoIR = verificacaoPercIR(qtdMeses);
    let valorCalculo, valorDescontoIR = 0;
    percCDB = (percCDB / 100) * CDIAnual; // aplicando a porcentagem de investimento de CDB sobre o CDI
    percCDB = percCDB / 100; // convertendo o valor percentual de investimento para decimal

    for (let i = 0; i < qtdMeses; i++) {
        valorCalculo = valor;
        valor = valor * Math.pow(1 + percCDB, umAnoConvertidoEmMes);
        valorCalculo = valor - valorCalculo;
        valorCalculo = valorCalculo / 100 * percDescontoIR;
        valorDescontoIR += valorCalculo;
        valoresInvestimentoCDB[i] = valor;
    }

    valoresInvestimentoCDB[qtdMeses] = valoresInvestimentoCDB[qtdMeses - 1] - valorDescontoIR;
    return valoresInvestimentoCDB;
}

function calculoInvestimentosLCI(qtdMeses, valorInicial, percLCI, CDIAnual, umAnoConvertidoEmMes) {
    let valoresInvestimentoLCI = [];
    percLCI = (percLCI / 100) * CDIAnual; // aplicando a porcentagem de investimento de LCI sobre o CDI
    percLCI = percLCI / 100; // convertendo o valor percentual de investimento para decimal

    for (let i = 0; i < qtdMeses; i++) {
        valorInicial = valorInicial * Math.pow(1 + percLCI, umAnoConvertidoEmMes);
        valoresInvestimentoLCI[i] = valorInicial;
    }

    return valoresInvestimentoLCI;
}

function apresentacaoDeResultadosMensais(qtdMeses, valoresInvestimentoCDB, valoresInvestimentoLCI) {
    console.log();
    for (let i = 0; i < qtdMeses; i++) {
        console.log(`No mês ${i + 1} o CDB terá acumulado ${valoresInvestimentoCDB[i]} e o LCI ${valoresInvestimentoLCI[i]} por enquanto está valendo a pena investir em `);
        if (valoresInvestimentoCDB[i] > valoresInvestimentoLCI[i]) console.log("CDB");
        else if (valoresInvestimentoCDB[i] < valoresInvestimentoLCI[i]) console.log("LCI");
        else console.log("Ambos");
    }
}

function apresentacaoDoResultadoFinal(valorFinalCDB, valorFinalLCI) {
    console.log();
    console.log("Valores Finais");
    console.log(`O CDB livre de IR terá acumulado ${valorFinalCDB} e o LCI ${valorFinalLCI}`);
    console.log("Sendo assim está valendo a pena investir em ");
    if (valorFinalCDB > valorFinalLCI) console.log("CDB");
    else if (valorFinalCDB < valorFinalLCI) console.log("LCI");
    else console.log("Ambos");
}

// Entrada de dados
let txSelicAnual = parseFloat(prompt("Informe a taxa Selic Anual (Exemplo 13.25): "));
let txSelicMensal = txSelicAnual / 12;
let CDIAnual = txSelicAnual - 0.10;
let qtdMeses = parseInt(prompt("Informe a quantidade de meses que irá investir: "));
let percCDB = parseFloat(prompt("Informe o percentual do CDI que o CDB está oferecendo (Exemplo 100): "));
let percLCI = parseFloat(prompt("Informe o percentual do CDI que o LCI está oferecendo (Exemplo 93): "));
let valorInicial = parseFloat(prompt("Qual o valor que irá investir inicialmente: "));
const umAnoConvertidoEmMes = 1.0 / 12.0;

let valoresInvestimentoCDB = calculoInvestimentosCDB(qtdMeses, valorInicial, percCDB, CDIAnual, umAnoConvertidoEmMes);
let valoresInvestimentoLCI = calculoInvestimentosLCI(qtdMeses, valorInicial, percLCI, CDIAnual, umAnoConvertidoEmMes);

apresentacaoDeResultadosMensais(qtdMeses, valoresInvestimentoCDB, valoresInvestimentoLCI);
apresentacaoDoResultadoFinal(valoresInvestimentoCDB[qtdMeses], valoresInvestimentoLCI[qtdMeses - 1]);
