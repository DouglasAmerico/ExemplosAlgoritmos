#include <iostream>
#include <math.h>

using namespace std;

double verificacaoPercIR(int mes){
    double percentual;
    if     (mes < 6 ) percentual= 22.5;
    else if(mes < 12) percentual= 20.0;
    else if(mes < 24) percentual= 17.5;
    else              percentual= 15.0;
    
    return percentual;
}

double calculoInvestimentosCDB(int qtdMeses, double valor, double valoresInvestimentoCDB[], double percCDB, double CDIAnual,
                                                                                                double umAnoConvertidoEmMes){
    double percDescontoIR= verificacaoPercIR(qtdMeses);
    double valorCalculo,valorDescontoIR=0;                                                                                                  
    percCDB= (percCDB/100) * CDIAnual; //aplicando a porcentagem de investimento de LCI sobre o CDI  
    percCDB= percCDB/100; //convertendo o valor percentual de investimento para decimal, assim a formula 
                          //de juros compostos funcionará perfeitamente
    for(int i=0;i<qtdMeses;i++){
        valorCalculo= valor;
        valor= valor * pow(1 + percCDB, umAnoConvertidoEmMes);
                         //realiza o calculo do rendimento mensal utilizando a formula de juros compostos
        valorCalculo= valor - valorCalculo;
        valorCalculo= valorCalculo/100*percDescontoIR;
        valorDescontoIR= valorDescontoIR + valorCalculo;
        valoresInvestimentoCDB[i]= valor;
    }
    
    valoresInvestimentoCDB[qtdMeses]= valoresInvestimentoCDB[qtdMeses-1] - valorDescontoIR;
    //o vetor de cdb foi criado com uma posição a mais para poder armazenar o ultimo valor calculado menor o desconto de ir
    
    return valoresInvestimentoCDB[qtdMeses];
}

double calculoInvestimentosLCI(int qtdMeses, double valorInicial, double valoresInvestimentoLCI[], double percLCI, double CDIAnual,
                                                                                                    double umAnoConvertidoEmMes){
    percLCI= (percLCI/100) * CDIAnual; //aplicando a porcentagem de investimento de LCI sobre o CDI  
    percLCI= percLCI/100; //convertendo o valor percentual de investimento para decimal, assim a formula 
                          //de juros compostos funcionará perfeitamente
    for(int i=0;i<qtdMeses;i++){
        valorInicial= valorInicial * pow(1 + percLCI, umAnoConvertidoEmMes);
                         //realiza o calculo do rendimento mensal utilizando a formula de juros compostos
        valoresInvestimentoLCI[i]= valorInicial;
    }
    
    return valoresInvestimentoLCI[qtdMeses];
}

void apresentacaoDeResultadosMensais(int qtdMeses, double valoresInvestimentoCDB[], double valoresInvestimentoLCI[]){
    cout<<endl;
    for(int i=0;i<qtdMeses;i++){
        cout<<"No mês "<<i+1<<" o CDB terá acumulado "<<valoresInvestimentoCDB[i]<<" e o LCI "
            <<valoresInvestimentoLCI[i]<<" por enquanto esta valendo a pensa investir em ";
        if(valoresInvestimentoCDB[i] > valoresInvestimentoLCI[i]) cout<<"CDB\n";
        else if(valoresInvestimentoCDB[i] < valoresInvestimentoLCI[i]) cout<<"LCI\n";
        else cout<<"Ambos\n";
    }
}

void apresentacaoDoResultadoFinal(double valorFinalCDB, double valorFinalLCI){
    cout<<endl<<"valores Finais"<<endl;
    cout<<"O CDB livre de IR terá acumulado "<<valorFinalCDB<<" e o LCI "<<valorFinalLCI
        <<" sendo assim esta valendo a pensa investir em ";
    if(valorFinalCDB > valorFinalLCI) cout<<"CDB\n";
    else if(valorFinalCDB < valorFinalLCI) cout<<"LCI\n";
    else cout<<"Ambos\n";
}

int main(){
    const double umAnoConvertidoEmMes= 1.0/12.0;//constante criada para representar 1/12
    double txSelicAnual, txSelicMensal, CDIAnual, CDIMensal, percCDB, percLCI,valorInicial;
    int qtdMeses;
    cout<<"Informe a taxa Selic Anual (Exemplo 13.25): ";
    cin>>txSelicAnual;
    txSelicMensal= txSelicAnual/12;
    CDIAnual= txSelicAnual- 0.10;
    
    cout<<"Informe a quantidade de meses que irá investir: ";
    cin>>qtdMeses;
    double valoresInvestimentoCDB[qtdMeses], valoresInvestimentoLCI[qtdMeses];
    
    cout<<"Informe o percentual do CDI que o CDB esta oferencendo (Exemplo 100): ";
    cin>>percCDB;
    cout<<"Informe o percentual do CDI que o LCI esta oferencendo (Exemplo 93): ";
    cin>>percLCI;
    cout<<"Qual o valor que irá investir inicialmente: ";
    cin>>valorInicial;
    
    valoresInvestimentoCDB[qtdMeses+1] = calculoInvestimentosCDB(qtdMeses,valorInicial,valoresInvestimentoCDB,percCDB,CDIAnual,
    umAnoConvertidoEmMes);//criei o vetor com uma posição a mais para armazenar o valor final calculado descontando o ir
    valoresInvestimentoLCI[qtdMeses]   = calculoInvestimentosLCI(qtdMeses,valorInicial,valoresInvestimentoLCI,percLCI,CDIAnual,
    umAnoConvertidoEmMes);
    apresentacaoDeResultadosMensais(qtdMeses, valoresInvestimentoCDB, valoresInvestimentoLCI);
    apresentacaoDoResultadoFinal(valoresInvestimentoCDB[qtdMeses],valoresInvestimentoLCI[qtdMeses-1]);
    
    return 0;
}