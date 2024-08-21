#include <iostream>
#include <string>

using namespace std;

const int quantidadeMaximaDeProdutos_DAA = 3;
int seletorMenu_DAA; // opção selecionada no menu
int controleQuantidadeCadastrados_DAA = 3; //variavel para controlar quantos produtos foram cadastrados
const int retornoInformativoDeErro_DAA = 404; //constante criada para ser um valor de retorno que 
                                            //demonstre que ocorreu um erro

string nomeProduto_DAA[quantidadeMaximaDeProdutos_DAA]= {"ROUNDUP","GLIFOSATO","2,4-D"}; // vetor de nomes de produtos
float precoProduto_DAA[quantidadeMaximaDeProdutos_DAA]= {258.99,327.54,400.00}; // vetor de preço de produtos
float quantidadeProdutoEstoque_DAA[quantidadeMaximaDeProdutos_DAA]= {35,42,53.5}; // vetor de quantidade de produtos em estoque
string unidadeMedidaProduto_DAA[quantidadeMaximaDeProdutos_DAA]= {" Unidades"," Unidades"," Mililitros"}; //tipos Unidade e Mililitros

void menu(); // declaração da função que apresenta o MENU
void cadastrarProdutos_DAA(); // declaração da função que cadastro os produtos
void listarProdutos_DAA(); // declaração da função que lista os produtos
void compraDeProdutos_DAA(); // declaração da função que compra os produtos
void vendaDeProdutos_DAA();  // declaração da função que vende os produtos
void editarProdutos_DAA(); // declaração da função que edita os produtos
void excluiProdutos_DAA(); // declaração da função que excluir os produtos

//---------------------------------------------------------------------------------------------------
string voltaMenu_DAA; //variável auxiliar para esperar o usuário pressionar enter para voltar ao menu

void operacaoSucesso_DAA(){ //função para informar que a operação foi realizada com sucesso
    cout<<"Operação Realizada com Sucesso\n\n";
}

void limparTela_DAA(){ //função para limpar o console
    system("clear");
}

void limpaTelaTeclando_DAA(){ //função para limpar o console assim que o usuario teclar ENTER
    cout << "pressione enter para voltar ao MENU...";
    getline(cin,voltaMenu_DAA); // getline permite ler mais de uma palavra na mesma variável
    getline(cin,voltaMenu_DAA); // 2x getline para contornar o problema de passar pela variável sem digital nada
    limparTela_DAA(); //chamando a função de limpar o console
}

bool validacaoSN_DAA(string mensagem_DAA){  //função criada para receber uma mensagem, apresentar essa mensagem, coletar se o 
                                           //usuario digitou s ou n e retornar a quem chamou um valor booleano true ou false
    bool resposta_DAA;
    string simOuNao_DAA = "s";
    
    do{
        cout<<mensagem_DAA<<"\n";
        cout<<"s = SIM ou n = Não\n";
        cin>>simOuNao_DAA;
        if(simOuNao_DAA != "s" && simOuNao_DAA != "n" && simOuNao_DAA != "S" && simOuNao_DAA != "N"){
            cout<<"Responda somente com s ou n\n";
        }else if(simOuNao_DAA == "n" || simOuNao_DAA == "N"){
            resposta_DAA = false;
        }else{
            resposta_DAA = true;
        }
    }while(simOuNao_DAA != "s" && simOuNao_DAA != "n" && simOuNao_DAA != "S" && simOuNao_DAA != "N");
    
    return resposta_DAA;
}

int validacaoCodigoValido_DAA(int codigo_DAA){// função implementada para validar se o codigo existe ou não
                                            //caso exista a função retornará o mesmo codigo, caso não 
                                            //exista ela retornará sempre o valor 404 da Constante
                                            // indicando que o codigo é inexistente
    
    while(codigo_DAA < 0 || codigo_DAA > controleQuantidadeCadastrados_DAA){
        cout<<"Codigo inexistente, informe um codigo valido\n";
        
        if(validacaoSN_DAA("Tentar Novamente?")){
            cout<<"Informe o codigo do Produto: ";
            cin>>codigo_DAA;
        }else{
            codigo_DAA = retornoInformativoDeErro_DAA;
        }
    }
    
    return codigo_DAA;
}
//--------------------------------------------------------------------------------------------------

int DAA_informeCodigo(string mensagemInformacaoCodigo){
    int codigoInformado_DAA;
    
    cout<<mensagemInformacaoCodigo<<endl;
    cin>>codigoInformado_DAA;
    
    if(validacaoCodigoValido_DAA(codigoInformado_DAA) == retornoInformativoDeErro_DAA){
        cout<<"Codigo Invalido\n";
        codigoInformado_DAA = retornoInformativoDeErro_DAA;
    }
    
    return codigoInformado_DAA;
}

//---------------------------------------------------------------------------------------------------

void DAA_compraDeProdutos(){
}

//---------------------------------------------------------------------------------------------------

void DAA_vendaDeProdutos(){
}

//---------------------------------------------------------------------------------------------------

void editarProdutos_DAA(){
        
}

//---------------------------------------------------------------------------------------------------

void excluiProdutos_DAA(){
    int codigoASerExcluido;
    bool continuarExcluido;
    
    do{
        continuarExcluido = false;
        codigoASerExcluido = DAA_informeCodigo("Informe o codigo a ser Excluido: ");
        if(codigoASerExcluido != retornoInformativoDeErro_DAA){
            
            if(quantidadeProdutoEstoque_DAA[codigoASerExcluido] == 0){
            
                for(int i=codigoASerExcluido; i<controleQuantidadeCadastrados_DAA;i++){
                    if(i < (controleQuantidadeCadastrados_DAA-1)){
                        nomeProduto_DAA[i] = nomeProduto_DAA[i+1];
                        unidadeMedidaProduto_DAA[i] = unidadeMedidaProduto_DAA[i+1];
                        precoProduto_DAA[i] = precoProduto_DAA[i+1];
                        quantidadeProdutoEstoque_DAA[i] = quantidadeProdutoEstoque_DAA[i+1];
                    }else{
                        controleQuantidadeCadastrados_DAA--;
                        cout<<"Produto excluido com sucesso\n";
                    }
                }
            }else{
                cout<<"Produto "<<nomeProduto_DAA[codigoASerExcluido]<<
                    " não pode ser excluido até que sua quantidade seja 0\n";
            }
            
        }
        
        if(validacaoSN_DAA("Deseja excluir outro codigo? \n")){
           continuarExcluido = true; 
        }
        
    }while(continuarExcluido);
    
    limpaTelaTeclando_DAA();
}

//---------------------------------------------------------------------------------------------------

void cadastrarProdutos_DAA(){
    bool continuarCadastrando_DAA = true;
    while(continuarCadastrando_DAA == true){
        
        if (controleQuantidadeCadastrados_DAA < quantidadeMaximaDeProdutos_DAA){ //verifica se não chegou no nivel maximo de cadastros
            cout<<"############## Cadastro de Produto #################\n";
            cout << "Nome do produto: ";
            getline(cin,nomeProduto_DAA[controleQuantidadeCadastrados_DAA]);
            getline(cin,nomeProduto_DAA[controleQuantidadeCadastrados_DAA]);
            quantidadeProdutoEstoque_DAA[controleQuantidadeCadastrados_DAA] = 0;
            cout << "Preço do produto "<<nomeProduto_DAA[controleQuantidadeCadastrados_DAA]<<": ";
            cin >> precoProduto_DAA[controleQuantidadeCadastrados_DAA];
            int auxiliarEscolhaUnidadeMedida_DAA=0;
            do{
                cout<<"Qual a unidade de Medida do Produto?\n";
                cout<<"1 - ML ou 2 - Unidade\n";
                cin>>   auxiliarEscolhaUnidadeMedida_DAA;
                     if(auxiliarEscolhaUnidadeMedida_DAA == 1) unidadeMedidaProduto_DAA[controleQuantidadeCadastrados_DAA] = " Mililitros";
                else if(auxiliarEscolhaUnidadeMedida_DAA == 2) unidadeMedidaProduto_DAA[controleQuantidadeCadastrados_DAA] = " Unidades";
                else cout<<"Somente deve ser inserido valores 1 e 2, sendo 1 - ML ou 2 - Unidade\n";
            }while(auxiliarEscolhaUnidadeMedida_DAA < 1 || auxiliarEscolhaUnidadeMedida_DAA > 2);
        
            controleQuantidadeCadastrados_DAA++;
            operacaoSucesso_DAA();
            
            if(validacaoSN_DAA("Deseja Continuar Cadastrando?") == true) 
                limparTela_DAA();
            else 
                continuarCadastrando_DAA = false;
        }else{
            cout << "Quantidade máxima de produtos atingida\n";
            continuarCadastrando_DAA = false;
        }
        
    }
    
    limpaTelaTeclando_DAA();
    
}

//---------------------------------------------------------------------------------------------------

void listarProdutos_DAA(){
    cout << "################ Lista de Produtos ################"<< endl;
    for (int i=0; i < controleQuantidadeCadastrados_DAA; i++) {
        cout<< quantidadeProdutoEstoque_DAA[i] << unidadeMedidaProduto_DAA[i] << " do Produto " <<
        nomeProduto_DAA[i] << "\nCom o Valor de " << precoProduto_DAA[i] << "RS em estoque, ";
        cout<<"Codigo: "<<i<<endl;
        cout<<"-------------------------------------------------------------------------\n";
    }
    limpaTelaTeclando_DAA();
}

//---------------------------------------------------------------------------------------------------

void menu_DAA(){
    bool fechar_DAA = false;
    
    while(fechar_DAA == false){
    
        cout << "*************************************************"<< endl;
        cout << "**************** Defensivos NSLO ****************"<< endl;
        cout << "*************************************************"<< endl;
        cout << "1 - Realizar Cadastro de Produtos"                << endl;
        cout << "2 - Realizar a Alteraração de um Produto"         << endl;
        cout << "3 - Realizar a Deleção de um Produto"             << endl;
        cout << "4 - Realizar a Compra de um Produto"              << endl;
        cout << "5 - Realizar a Venda de um Produto"               << endl;
        cout << "6 - Lista Todos os Produtos"                      << endl;
        cout << "0 - Sair do Sistema"                              << endl;
        cout << "Opção do Menu: ";
        cin >> seletorMenu_DAA;
        if (seletorMenu_DAA == 1){
            limparTela_DAA();
            cadastrarProdutos_DAA();
        }else if(seletorMenu_DAA == 2){
            limparTela_DAA();
            editarProdutos_DAA();
        }else if(seletorMenu_DAA == 3){ 
            limparTela_DAA();
            excluiProdutos_DAA();
        }else if(seletorMenu_DAA == 6){
            limparTela_DAA();
            listarProdutos_DAA();
        }else if(seletorMenu_DAA == 0){
            fechar_DAA = true;
        }else{
            system("clear");
            cout << "\nOpção inválida " << endl;
            limpaTelaTeclando_DAA();
        }
    }

}

int main(){
    menu_DAA();
    return 0;
}