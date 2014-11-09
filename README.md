cpabeEncriptor
==============

Front-End (Interface Gráfica) desenvolvido em Java Web com a finalidade de facilitar ao usuário comum (com pouca ou nenhuma prática no Shell comando) a utilização da Criptografia Baseada em Atributos desenvolvida por John Bethencourt, Amit Sahai (advisory role), Brent Waters (advisory role), disponível em http://acsc.cs.utexas.edu/cpabe/.

Requisitos do Sistema:

SO Linux;
Instalação da aplicação desenvolvida por Bethencourt et all, conforme disponibilizado em http://acsc.cs.utexas.edu/cpabe/tutorial.html
Ter instalado no Linux um servidor Web (Apache TomCat ou outro).
Instalação:

Para os que tiverem alguma dificuldade em instalar a aplicação de Bethencourt et all, segue abaixo os passos executados para baixar e instalar as bibliotecas e arquivos necessários para o funcionamento da aplicação de Bethencourt:
sudo apt-get install libgmp-dev gawk bison flex autoconf libtool gnu-standards libcrypto++-dev libssl-dev ming-w64-dev build-essential flex autotools-dev libglib2.0-dev

wget http://crypto.stanford.edu/pbc/files/pbc-0.5.14.tar.gz

wget http://hms.isi.jhu.edu/acsc/cpabe/libbswabe-0.9.tar.gz

wget http://hms.isi.jhu.edu/acsc/cpabe/cpabe-0.11.tar.gz

O próximo passo é conforme disponibilizado em http://acsc.cs.utexas.edu/cpabe/tutorial.html (make install e setup)
Até agora o que foi instalado é a aplicação de criptografia Cpabe desenvolvida por Bethencourt et all. Neste momento já é possível utilizar este sistema criptográfico via Shell comando conforme http://acsc.cs.utexas.edu/cpabe/tutorial.html.

Adiante teremos a implantação da Interface Gráfica que facilitará ao usuário a utilização deste método criptográfico:

Utilizando a IDE de sua escolha, acesse o pacote controladores e edite os Servlets CPABEAdvancedServlet e CPABEServlet alterando o caminho dos executáveis cpabe-keygen, cpabe-dec e cpabe-enc que foram instalados, bem como os caminhos das chaves pública e master:
Ex.: exe.executeCommand("/home/user/cpabe-0.11/cpabe-enc /home/user/cpabe-0.11/arquivos/pub_key " + caminho + " " + atributo_advanced + ""); --> os caminhos /home/user/cpabe-0.11 e /home/user/cpabe-0.11/arquivos/ devem ser substituídos conforme local de instalação.
