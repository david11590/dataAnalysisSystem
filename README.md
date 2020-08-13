# dataAnalysisSystem
 Project related to the challenge proposed by DBC Company to select Agibank

# Arquitetura
A aplicação foi desenvolvida baseada em Spring boot e Java 8,o gerenciamento de dependencias esta a cargo do Gradle. 
É utilizado padrão Singleton, principalmente para classes auxiliares. O codigo esta com o de propriedades YAML e enum's.
A classe Application não esta na raiz, ela tem um pacote proprio e o mapeamento dos componetes esta sendo feito nela
via notação "@ComponetScam".Isso evita que o Spring crie vinculos desnecessarios entre classes.
Para criar,ler, alterar, mover e deletar os arquivos ".dat" e Diretorios  esta sendo utilizado os recursos
do java 8,assim como para manipular as listas. O processamento de cada linha esta sendo feito no pacote de 
reflexão, onde cada linha passa o id correspondente ao Enum de classes Reflexivas e o mesmo devolve o nome
da clase que sera utilizada no processamento, sendo somada ao pacote de reflexão, assim estanciando em tempo 
de execução e convertida a Interface que a classe Implementa, utilizando a propria para executar o processamento 
da linha.

# Funcionamento
Conforme desafio, a aplicação processa arquivos com extensão ".dat" em um diretorio predeterminado(configurado no 
arquivo YALM), sendo processado e gerando um arquivo de mesmo nome em um diretorio de saida(tambem configurado no 
arquivo YALM) de final ".done.dat".
Sugestão, quando a aplicação estiver rodando e for para colocar algum arquivo para processar, retire a extensão
".dat" do arquivo e o renomeie depois que ele estiver totalmente copiado para a pasta de entrada(%HOMEPATH%/data/in),
essa precaução é para o arquivo não começar a ser processado antes de terminar de ser copiado.
Quando o arquivo é processado ele perde a extensão ".dat", isso para não ser processado novamente.
Tanto o diretorio de entrada de arquivos e o de saida(%HOMEPATH%/data/out) são criados logo que aplicação é iniciada, 
caso não existam, o mesmo ocorre nos testes.


# Rodando aplicação
Você pode executar a classe DataAnalysisSystemApplication em sua IDE de preferencia ou compilar via gradle e rodar o jar 
com comando "java -jar app.name.jar" ou ainda rodar o arquivo gradlew.bat para o windows. ou ainda via gradle 
"gradle init --type java-application:".



