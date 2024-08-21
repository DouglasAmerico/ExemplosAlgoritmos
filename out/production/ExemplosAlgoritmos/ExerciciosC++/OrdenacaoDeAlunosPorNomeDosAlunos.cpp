#include <iostream>
#include <string>

using namespace std;

int main()
{
    //foram criados 2 vetores e estão relacionados pela posição, ou seja, João Siva a nota 8, Andressa Lemos tem a nota 7.5, ...
    string nome[] = {"João Silva", "Andressa Lemos", "Bruno Souza", "Mariana Bueno"};
    float nota[] = {8,7.5,6.3,10};

    cout << "Lista Desordenada" << endl;  //apresenta os vetores originais, sem ordenação.
    for (int i=0; i<4; i++){
        cout << nome[i] << " tem " << nota[i] << " anos." << endl;
    }
    cout << endl;

    int auxNota;
    string auxNome;
    for (int i=0; i<4; i++){
        for (int j=i+1; j<4; j++){
            if (nome[j] < nome[i]){
                /*
                  caso o nome que está em uma posição a frente seja menor (em relação a ordem alfabética) 
                  então é feita a troca entre os elementos dos vetores.
                  é preciso uma variável auxiliar para não perder nenhum valor. 
                  (imagine que vc precise trocar o conteúdo liquido de 2 copos, vc vai precisar de um 3º copo para não perder nenhum liquido)
                */
                auxNome = nome[i];
                nome[i] = nome[j];
                nome[j] = auxNome;

                /*
                Se você trocar a posição de 2 elementos do vetor de nomes, também irá precisar trocar as notas para que a referência não seja perdida
                */
                auxNota = nota[i];
                nota[i] = nota[j];
                nota[j] = auxNota;
            }
        }
    }
    cout << "Lista Ordenada" << endl;  //apresenta os vetores modificados, após a ordenação.
    for (int i=0; i<4; i++){
        cout << nome[i] << " tem " << nota[i] << " anos." << endl;
    }

    return 0;
}