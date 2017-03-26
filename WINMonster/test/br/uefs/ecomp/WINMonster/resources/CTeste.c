#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>

int menu();
int verifica_erro_leitura_de_arquivo(FILE* arq);
int importa_pais_modalidade(int* npais, int* nmod, FILE* arq_entrada);
void importa_quantidade_de_medalhas(int npais, int nmod, int quadro[npais][5], FILE* arq_entrada);
int calcula_quantprovas(int npais, int matriz[npais][5]);
void soma_totalmedalhas(int npais, int quadro[npais][5]);
void ordena_quadro(int npais, int quadro[npais][5]);
void ordenacao_bolha(int npais, int matriz[npais][5]);
void ordenacao_verifica_empates(int npais, int quadro[npais][5]);
void grava_quadroinicial(int npais, int nmod, int quadro[npais][5], FILE *arq_saida);
void grava_ranking(int npais, int quadro[npais][5], int cont_rank, FILE* arq_saida);
void grava_quadrototaldemedalhas(int npais, int quadro_totalmedalhas[npais][5], int cont_quadro, FILE *arq_saida);
void converte_matrizquadro_em_matrizquadrototalmedalhas(int npais, int quadro_totalmedalhas[npais][5], int quadro[npais][5]);
void menu_adicionamedalhas(int* ptr_adc_pais, int* ptr_adc_tipo, int* ptr_adc_quantidade);
void adiciona_medalhas(int npais, int quadro[npais][5], int quadro_totalmedalhas[npais][5]);
int procura_linha_adcmedalhas(int npais, int matriz[npais][5], int pais);
void preenche_matriz_com_indicacao_de_paises(int l, int c, int matriz[l][c]);
void preenche_matriz_com_0(int l, int c, int matriz[l][c]);

int main()
{
    FILE* arq_entrada; //ponteiro para o arquivo de entrada (entrada.txt)
    FILE* arq_saida; //ponteiro para o arquivo de saída (relatorio.txt)
    int opcao; //responsável por receber retorno da função que exibe o menu
    int cont_rank = 0; //contagem de vezes que a função grava ranking foi chamada para gravar indicação correta no arquivo
    int cont_quadro = 0; //contagem e vezes que a função grava quadro foi chamada para gravar indicação correta no arquivo

    arq_saida = NULL; //faz o ponteiro de arquivo não apontar para nenhum lugar de memória, esse comando é feito para evitar erros caso o usuário abra o programa e feche sem executar nenhum comando

    arq_entrada = fopen("entrada.txt", "r"); //abertura do arquivo de entrada no modo de leitura

    if(verifica_erro_leitura_de_arquivo(arq_entrada) == 0)
    {
        return 0; //caso ocorra algum erro na leitura do arquivo de entrada o programa é fechado
    }

    int npais; //numero de países
    int nmod; //numero de modalidades

     if(importa_pais_modalidade(&npais, &nmod, arq_entrada) == 0)
     {
         return 0;
     }

    int quadro [npais][5];
    /*A matriz quadro é uma versão sintetizada das quantidades de medalhas presente no arquivo de entrada, na qual são somadas as medalhas de ouro, prata
    e bronze de todos os países e o total de medalhas de cada país é guardado na última coluna.
    Ela possuirá sempre 5 colunas:
    0- Indicação de países (P1, P2, P3...)
    1- Medalhas de ouro
    2- Medalhas de prata
    3- Medalhas de broze
    4- Total de medalhas */

    int quadro_totalmedalhas[npais][5]; // versão da matrizmatriz quadro na qual o total de medalhas se localiza na segunda coluna e é ordenada pela quantidade total de medalhas

    preenche_matriz_com_0(npais, 5, quadro);

    preenche_matriz_com_0(npais, 5, quadro_totalmedalhas);

    preenche_matriz_com_indicacao_de_paises(npais, 5, quadro);

    printf("**ATENCAO: O arquivo deve ser lido primeiramente. Caso tente inserir medalhas antes de ler ocorrerao erros de execucao.\n\n");

    do
    {
        opcao = menu();

        if(opcao == 1)
        {
            arq_saida = fopen("relatorio.txt", "w");

            if(verifica_erro_leitura_de_arquivo(arq_saida) == 0)
            {
                return 0; //caso ocorra algum erro na criacao do arquivo de saida o programa é fechado
            }

            importa_quantidade_de_medalhas(npais, nmod, quadro, arq_entrada);
            fclose(arq_entrada);
            grava_quadroinicial(npais, nmod, quadro, arq_saida);
            soma_totalmedalhas(npais, quadro);
            converte_matrizquadro_em_matrizquadrototalmedalhas(npais, quadro_totalmedalhas, quadro);
            ordena_quadro(npais, quadro);
            ordenacao_bolha(npais, quadro_totalmedalhas);
            grava_ranking(npais, quadro, cont_rank, arq_saida);
            grava_quadrototaldemedalhas(npais, quadro_totalmedalhas, cont_quadro, arq_saida);
            cont_rank++;
            cont_quadro++;
            printf("\nArquivo de entrada lido com sucesso! \n"); //mensagem informado ao usuário sucesso ao ler o arquivo
            system("pause"); //mantem a mensagem de sucesso na leitura do arquivo na tela
            system("cls"); //limpa a tela
        }
        else if(opcao == 2)
        {
            system("cls"); //limpa a tela
            adiciona_medalhas(npais, quadro, quadro_totalmedalhas);
            ordena_quadro(npais, quadro);
            converte_matrizquadro_em_matrizquadrototalmedalhas(npais, quadro_totalmedalhas, quadro);
            ordenacao_bolha(npais, quadro_totalmedalhas);
            cont_quadro++;
            cont_rank++;
        }
        else if(opcao == 3 && arq_saida != NULL) //só encerra o programa dessa maneira se o ponteiro de arq_saida tiver sido inicializado
        {
            grava_ranking(npais, quadro, cont_rank, arq_saida);
            grava_quadrototaldemedalhas(npais, quadro_totalmedalhas, cont_quadro, arq_saida);
            fclose(arq_saida);
        }

    }while(opcao != 3);

    return 0;
}

int menu()
{
    int m; //variável auxiliar do menu

    printf("O que voce deseja fazer? \n 1- Entrada de dados via arquivo \n 2- Leitura de dados via teclado \n 3- Encerramento do programa\n");
    scanf("%d", &m);

    return m;
}

int verifica_erro_leitura_de_arquivo(FILE* arq)
{
    /* Essa função imprime mensagem e fecha o programa caso ocorra algum erro na abertura do arquivo. */

    if(arq == NULL) //caso ocorra erro de leitura
    {
        printf("ERRO: %s", strerror(errno));
        return 0;
    }
}

int importa_pais_modalidade(int* npais, int* nmod, FILE* arq_entrada)
{
    /* Importa o número de países e modalidades do arquivo de entrada e verifica se houve alguma informação inválida */

    fscanf(arq_entrada, "%d", &(*npais));

    fscanf(arq_entrada, "%d", &(*nmod));

    if(*npais <=0 || *nmod <=0)
    {
        printf("Numero de paises ou numero de molidades invalido");
        return 0; //se as informações forem inválidas fecha o programa
    }
}

void importa_quantidade_de_medalhas(int npais, int nmod, int quadro[npais][5], FILE* arq_entrada)
{
    /* Importa as quantidades de medalhas presente no arquivo de entrada. A matriz quadro segue um padrão de organização já
    explicitado na sua declaração no main */

    int l, c; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz
    int aux; //variavel auxiliar para copiar o valor lido do arquivo para matriz

    for(l=0; l<npais; l++)
    {
        for(c=0; c<nmod*3; c++)
        {
            if(c%3 == 0) //caso o resto da divisão do indice da coluna por 3 seja 0 a medalha é de ouro
            {
                fscanf(arq_entrada, "%d", &aux);
                quadro[l][1] += aux;
            }
            else if(c%3 == 1) //caso o resto da divisão do indice da coluna por 3 seja 1 a medalha é de prata
            {
                fscanf(arq_entrada, "%d", &aux);
                quadro[l][2] += aux;
            }
            else if(c%3 == 2) //caso o resto da divisão do indice da coluna por 3 seja 2 a medalha é de bronze
            {
                fscanf(arq_entrada, "%d", &aux);
                quadro[l][3] += aux;
            }
        }
    }
}

int calcula_quantprovas(int npais, int matriz[npais][5])
{
    /* Calcula a quantidade de provas com base na matriz que recebeu, podendo ser a matriz quadro ou a matriz quadro_totalmedalhas */
    /* O nome genérico "matriz" foi designado pois as duas matrizes do programa podem ser passadas para essa função */

    int l, c; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz
    int qtd_provas=0; //variavel que guardará a quantidade de provas

    for(l=0; l<npais; l++)
    {
        qtd_provas += matriz[l][2]; //soma medalhas de prata caso a matriz passada seja a "quadro" ou somando todas as medalhas de ouro caso a matriz passada seja a matriz "quadro_totalmedalhas"
    }

    return qtd_provas;
}

void soma_totalmedalhas(int npais, int quadro[npais][5])
{
    /* Soma e guarda o total de medalhas na última coluna da matriz quadro */

    int l, c; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz

    for(l=0; l<npais; l++)
    {
        for(c=1; c<=3; c++)
        {
            quadro[l][4] += quadro[l][c]; //incrementa a quantidade de medalhas na última coluna da matriz
        }
    }
}

void ordena_quadro(int npais, int quadro[npais][5])
{
    /* Ordena a matriz quadro, primeiramente utilizando o método bolha para ordenar as medalhas de ouro e em seguida verificando se há empates */

    ordenacao_bolha(npais, quadro); //ordena a matriz com base nas medalhas de ouro

    ordenacao_verifica_empates(npais, quadro); //verifica se há empates em relação às medalhas de ouro e ordena
}

void ordenacao_bolha(int npais, int matriz[npais][5])
{
    /* A versão do método de ordenação BubbleSort (Bolha) implementado compara a quantidade de medalhas de ouro de dois países em posições
    adjacentes na matriz. Caso o país em posição inferior possua mais medalhas de ouro toda sua linha sobe uma posição, enquanto a linha
    correspondente ao país que possui menos medalhas desce uma posição. */

    int l, c; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz
    int i; //variável auxiliar para o loop da ordenação bolha
    int aux; //variavel auxiliar para trocar valores na ordenação bolha

    for(i=0; i<npais-1; i++)
    {
        for(l=0; l<npais-i-1; l++)
        {
            if(matriz[l][1] < matriz[l+1][1])
            {
                for(c=0; c<5; c++)
                {
                    aux = matriz[l][c];
                    matriz[l][c] = matriz[l+1][c];
                    matriz[l+1][c] = aux;
                }
            }
        }
    }
}

void ordenacao_verifica_empates(int npais, int quadro[npais][5])
{
    /* Verifica se há empates em relação às medalhas de ouro e ordena novamente a matriz quando necessário. O critério para desempate em relação às
    medalhas de ouro é verificar qual dos países empatados possuem mais medalhas de prata, persistindo o erro a comparação passa a ser em relação às
    medalhas de bronze. */

    int l, c; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz
    int aux; //variavel auxiliar para troca de valores

    for(l=0; l<npais-1; l++)
    {
        if(quadro[l][1] == quadro[l+1][1])//verifica se há empate entre dois países adjacentes na matriz em relação a medalhas de ouro
        {
            if(quadro[l][2] == quadro[l+1][2])//verifica se há empate entre dois países adjacentes na matriz em relação a medalhas de prata
            {
                if(quadro[l][3] < quadro[l+1][3])//verifica se o número de medalhas de bronze de um país é maior que o seu anterior
                {
                    /* Quando todas as condições são satisfeitas as informações que são diferentes entre os paises (numeração do país, medalhas de bronze
                    e total de medalhas) são trocadas de linha, de forma que as informações do país que possui mais medalhas de bronze sobem uma linha e
                    as informações do país que possui menos medalhas de bronze descem uma linha.*/

                    aux = quadro[l][0];
                    quadro[l][0] = quadro[l+1][1];
                    quadro[l+1][0] = aux;

                    aux = quadro[l][3];
                    quadro[l][3] = quadro[l+1][3];
                    quadro[l+1][3] = aux;

                    aux = quadro[l][4];
                    quadro[l][4] = quadro[l+1][4];
                    quadro[l+1][4] = aux;
                }
            }
            else if(quadro[l][2] < quadro[l+1][2])
            /* Caso o número de medalhas de prata não seja igual, verifica se o número de medalhas de prata de um país é maior que a
            quantidade do país anterior a ele. */
            {
                /* Quando a condição é satisfeita as informações que são diferentes entre os paises (numeração do país, medalhas de prata,
                medalhas de bronze e total de medalhas) são trocas de linha, de forma que as informações do país que possui mais medalhas de prata
                sobem uma linha e as informações do país que possui menos medalhas de prata descem uma linha.*/

                aux = quadro[l][0];
                quadro[l][0] = quadro[l+1][0];
                quadro[l+1][0] = aux;

                aux = quadro[l][2];
                quadro[l][2] = quadro[l+1][2];
                quadro[l+1][2] = aux;

                aux = quadro[l][3];
                quadro[l][3] = quadro[l+1][3];
                quadro[l+1][3] = aux;

                aux = quadro[l][4];
                quadro[l][4] = quadro[l+1][4];
                quadro[l+1][4] = aux;
            }
        }
    }
}

void grava_quadroinicial(int npais, int nmod, int quadro[npais][5], FILE *arq_saida)
{
    /* Grava no arquivo de saída o quadro inicial, a quantidade inicial de provas disputadas e o percentual de provas disputadas*/

    int l, c; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz
    int qtd_provas; //guarda o valor retornado da função que calcula a quantidade de provas


    fprintf(arq_saida, "Quadro de medalhas inicial \nPaís | Ouro | Prata | Bronze \n");

    for(l=0; l<npais; l++)
    {
        fprintf(arq_saida, "P"); //a letra P serve para a indicação dos paises

        for(c=0; c<4; c++) //printa apenas a coluna de indicações dos países e os tipos de medalha
        {
            fprintf(arq_saida, "%-7d ", quadro[l][c]);
        }

        fprintf(arq_saida, "\n");
    }

    qtd_provas = calcula_quantprovas(npais, quadro);

    fprintf(arq_saida, "\n Quantidade Inicial de provas disputadas: %d", qtd_provas);
    fprintf(arq_saida, "\n Percentual de provas disputadas: %.1f%%", ((float)qtd_provas/306)*100);
}

void grava_ranking(int npais, int quadro[npais][5], int cont_rank, FILE* arq_saida)
{
    /* Grava os rankings no arquivo de saída. A função "printa" diferentes denominações com base na chamada, isto é, com base em qual ranking
    será "printado" naquele instante da execução. */

    int l, c; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz

    if(cont_rank == 0) //caso seja a primeira chamada da função printa no arquivo a indicação correta do ranking que será escrito
    {
        fprintf(arq_saida, "\n\n Ranking com Desempenho Inicial dos países \nPaís | Ouro | Prata | Bronze | Total\n");
    }
    else //caso não seja a primeira chamada da função printa no arquivo a indicação correta do ranking que será escrito
    {
        fprintf(arq_saida, "\n\n Ranking com Desempenho dos países ao encerrar o programa \nPaís | Ouro | Prata | Bronze | Total\n");
    }

    for(l=0; l<npais; l++)
    {
        for(c=0; c<5; c++)
        {
            if(c==0) //confere se a primeira coluna do quadro está sendo acessada
            {
                fprintf(arq_saida, "P"); //caso a primeira coluna esteja sendo acessada grava o "P" indicativo de país
            }

            fprintf(arq_saida, "%-8d", quadro[l][c]);
        }

        fprintf(arq_saida, " \n");
    }
}

void grava_quadrototaldemedalhas(int npais, int quadro_totalmedalhas[npais][5], int cont_quadro, FILE *arq_saida)
{
    /* Grava os quadros de medalhas ordenados com base no número total de medalhas recebidas. O procedimento "printa" diferentes denominações
    para este quadro com base no objetivo da chamada da função, podendo ser o quadro total antes e depois da inserção de novas medalhas. */

    int l, c; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz
    int qtd_provas;

    if(cont_quadro == 0) //grava no arquivo a indicação do quadro ordenado pela quantidade total de medalhas
    {
        fprintf(arq_saida, "\n \nQuadro ordenado pela quantidade total de medalhas recebidas \nPaís | Total | Ouro | Prata | Bronze\n");
    }
    else//grava no arquivo a indicação do quadro ordenado pela quantidade total de medalhas após inserções
    {
        fprintf(arq_saida, "\n \nQuadro ordenado pela quantidade total de medalhas recebidas ao encerrar o programa \nPaís | Total | Ouro | Prata | Bronze\n");
    }

    for(l=0; l<npais; l++)
    {
        for(c=0; c<5; c++)
        {
            if(c==0) //confere se a primeira coluna do quadro está sendo acessada
            {
                fprintf(arq_saida, "P"); //caso a primeira coluna esteja sendo acessada grava o "P" indicativo de país
            }

            fprintf(arq_saida, "%-8d", quadro_totalmedalhas[l][c]);
        }

        fprintf(arq_saida, " \n");
    }

    if(cont_quadro != 0) //se não for a primeira chamada da função grava também a quantidade de provas disputas e o percentual após inserções
    {
        qtd_provas = calcula_quantprovas(npais, quadro_totalmedalhas);
        fprintf(arq_saida, "\n Quantidade de provas disputadas após inserções: %d", qtd_provas);
        fprintf(arq_saida, "\n Percentual de provas disputadas após inserções: %.1f%%", ((float)qtd_provas/306)*100);
    }
}

void converte_matrizquadro_em_matrizquadrototalmedalhas(int npais, int quadro_totalmedalhas[npais][5], int quadro[npais][5])
{
    /* Organiza a matriz quadro_total colocando o total na segunda coluna (logo após a coluna que guardará o numero indetificador do país)
    e arrumando as outras quantidades de medalhas nas posições seguintes*/

    int l, c; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz

    for(l=0; l<npais; l++)
    {
        for(c=0; c<5; c++)
        {
            if(c==0)
            {
                quadro_totalmedalhas[l][0] = quadro[l][0];
            }
            else if(c==1)
            {
                quadro_totalmedalhas[l][1] = quadro[l][4];
            }
            else if(c==2)
            {
                quadro_totalmedalhas[l][2] = quadro[l][1];
            }
            else if(c==3)
            {
                quadro_totalmedalhas[l][3] = quadro[l][2];
            }
            else if(c==4)
            {
                quadro_totalmedalhas[l][4] = quadro[l][3];
            }
        }
    }
}

void menu_adicionamedalhas(int* ptr_adc_pais, int* ptr_adc_tipo, int* ptr_adc_quantidade)
{
    /* Exibe as opções disponíveis ao usuário no processo de adicionar novas medalhas. */

    printf("\nA qual pais voce deseja adicionar medalhas? \n");
    scanf("%d", &(*ptr_adc_pais));

    printf("\nQual tipo de medalha voce deseja adicionar ao pais?\n 1- Ouro \n 2- Prata \n 3- Bronze \n");
    scanf("%d", &(*ptr_adc_tipo));

    printf("\nInforme a quantidade de medalhas que deseja adicionar \n");
    scanf("%d", &(*ptr_adc_quantidade));
}

void adiciona_medalhas(int npais, int quadro[npais][5], int quadro_totalmedalhas[npais][5])
{
    /* Permite que o usuário insira novas quantidades de medalhas aos países em tempo de execução do programa. */

    int l, c; //variáveis para acessar, respectivamente, linhas e colunas da matriz
    int adc_pais; //guarda o número do país que irá receber novas quantidades de medalhas
    int adc_tipo; //guarda o tipo de medalha (ouro, prata ou bronze) que será adicionada a um determinado país
    int adc_quantidade; //guarda a quantidade de medalhas que será adicionada ao país determinado
    int adc_continua; //controla se o usuário deseja continuar adicionando medalhas

    do
    {
        printf("Quadro de medalhas atual \n  Ouro|Prata|Bronze|Total \n");

        /* Mostra na tela as diversas atualizações do quadro enquanto o usuário está adicionando novas medalhas. */

        for(l=0; l<npais; l++)
        {
            printf("P");

            for(c=0; c<5; c++)
            {
                printf("%-4d ", quadro[l][c]);
            }

            printf("\n");
        }

        menu_adicionamedalhas(&adc_pais, &adc_tipo, &adc_quantidade);

        l = procura_linha_adcmedalhas(npais, quadro, adc_pais);

        quadro[l][adc_tipo] += adc_quantidade; //acrescenta o valor que se deseja adicionar na matriz quadro

        quadro[l][4] += adc_quantidade; //soma a quantidade adicionada na coluna correspondente ao total de medalhas

        l = procura_linha_adcmedalhas(npais, quadro_totalmedalhas, adc_pais);

        quadro_totalmedalhas[l][adc_tipo+1] += adc_quantidade; //acrescenta o valor que se deseja adicionar na matriz quadro_totalmedalhas

        quadro_totalmedalhas[l][1] += adc_quantidade; //acrescenta o valor que se deseja adicionar na coluna correspondente ao total de medalhas

        printf("\nDeseja continuar adicionando?\n 1- Sim \n 2- Nao \n");
        scanf("%d", &adc_continua);

        system("cls"); //limpa a tela

    }while(adc_continua == 1);
}

int procura_linha_adcmedalhas(int npais, int matriz[npais][5], int pais)
{
    /* Como as matrizes quadro e quadro_totalmedalhas estão organizadas de forma decrescente, pelo quantidade de medalhas de ouro, prata e bronze
    ou pela quantidade total de medalhas, nem sempre o primeiro país ocupará a primeira linha, por exemplo. Portanto é preciso procurar na matriz
    em qual linha se localiza o país para o qual deseja-se adicionar novas quantidades de medalhas. */
    /* O nome genérico "matriz" foi designado pois as duas matrizes do programa podem ser passadas para essa função */

    int linha=0; //variavel auxiliar para procurar linha na qual se deseja inserir medalhas na matriz

    /* Procura em qual linha da matriz está o país para o qual o usuário deseja inserir novas medalhas */
    while(matriz[linha][0] != pais) //confere e executa o bloco anterior se a linha que está sendo verificada na matriz nao for a procurada
    {
        linha++; //nao sendo a linha procurada a variável é incrementada com 1 para que a linha seguinte na matriz seja verificada na próxima iteracao
    }

    return linha;
}

void preenche_matriz_com_indicacao_de_paises(int l, int c, int matriz[l][c])
{
    /* Preenche a matriz passada com o número identifiador dos países. */
    /* O nome genérico "matriz" foi designado pois as duas matrizes do programa podem ser passadas para essa função */

    int i; //variável auxiliar para acessar linhas da matriz
    int pais = 1; //numero de identificação de cada país que é guardado na matriz

    /* Acessa cada valor da primeira coluna da matriz e guarda as indicações de países (1, 2, 3...) */
    for(i=0; i<l; i++)
    {
        matriz[i][0] = pais;
        pais++;
    }
}

void preenche_matriz_com_0(int l, int c, int matriz[l][c])
{
    /* Preenche a matriz passada completamente com zeros para evitar problemas com lixo de memória em tempo de execução do programa. */

    int i, j; //variaveis auxiliares para acessar, respectivamente, linhas e colunas da matriz

    /* Acessa cada linha e coluna da matriz e preenche completamente com 0 */
    for(i=0; i<l; i++)
    {
        for(j=0; j<c; j++)
        {
            matriz[i][j] = 0;
        }
    }
}
