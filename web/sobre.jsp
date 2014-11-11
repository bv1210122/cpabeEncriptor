<%-- 
    Document   : avaliacao
    Created on : 01/11/2014, 16:16:28
    Author     : BV1210122
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>CPABE Encriptor</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- INSERINDO O JQUERY -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>

        <!-- TWITTER BOOTSTRAP CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css">
        <link rel="stylesheet/less" href="${pageContext.request.contextPath}/less/bootstrap.less">

        <!-- TWITTER BOOTSTRAP JS -->
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>   
    </head>

    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <!--INÍCIO DO CABEÇALHO -->
                    <div class="navbar">
                        <div class="navbar-inner">
                            <div class="container-fluid">
                                <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand">CPABE Encriptor</a>
                                <div class="nav-collapse collapse navbar-responsive-collapse">
                                    <ul class="nav">
                                        <li class="active">
                                            <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
                                        </li>
                                        <li class="divider-vertical"></li>
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Gerenciar Cadastro<strong class="caret"></strong></a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/usuario/usuario.jsp">Cadastrar Usuário</a>
                                                </li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/atributo/atributo.jsp">Cadastrar Atributo</a>
                                                </li> 
                                                <li class="divider"></li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/usuario/alterar.jsp">Alterar Usuário</a>
                                                </li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/atributo/alterar.jsp">Alterar Atributo</a>
                                                </li>                                                
                                                <li class="divider"></li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/usuario/excluir.jsp">Excluir Usuário</a>
                                                </li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/atributo/excluir.jsp">Excluir Atributo</a>
                                                </li> 
                                            </ul>
                                        </li>
                                        <li class="divider-vertical"></li> 
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Listar<strong class="caret"></strong></a>
                                            <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/usuario/listagem.jsp">Usuário</a>
                                                </li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/atributo/listagem.jsp">Atributo</a>
                                                </li>                                               
                                                <li class="divider"></li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/usuario/listaUsuarioID.jsp">Usuário por ID</a>
                                                </li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/atributo/listaAtributoID.jsp">Atributo por ID</a>
                                                </li>                                                
                                            </ul>
                                        </li>
                                        <li class="divider-vertical"></li>                                        
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Criptografia CPABE<strong class="caret"></strong></a>
                                            <ul class="dropdown-menu">                                                
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/gerar/chave_privada.jsp">Gerar Chave Privada</a>
                                                </li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/encriptar/encriptar.jsp">Encriptar</a>
                                                </li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/formularios/decriptar/decriptar.jsp">Decriptar</a>
                                                </li>
                                                <li class="divider"></li>                                                
                                            </ul>
                                        </li>
                                        <li class="divider-vertical"></li> 
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Criptografia CPABE Advanced<strong class="caret"></strong></a>
                                            <ul class="dropdown-menu">                                                
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/avancado/gerar/chave_privada.jsp">Gerar Chave Privada Advanced</a>
                                                </li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/avancado/encriptar/encriptar.jsp">Encriptar Advanced</a>
                                                </li>                                                
                                                <li class="divider"></li>                                                
                                            </ul>
                                        </li>
                                        <li class="divider-vertical"></li> 
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Avaliação da Aplicação<strong class="caret"></strong></a>
                                            <ul class="dropdown-menu">                                               
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/avaliacao.jsp">Avaliação da Aplicação</a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- FIM DO CABEÇALHO -->
                    <div class="hero" >
                        <h3>	Análise do funcionamento do Algoritmo de Criptografia CP-ABE</h3>

                        <p>Este algoritmo de criptografia baseada em atributos com políticas de acesso no Cifrotexto, proposto por Goyal at. Al (2006) e implementado por Bethencourt, Sahai e Waters (2007) é importante por trazer esquema de chave pública que permite a melhora de gestão das chaves. </p>
                        <p>Enquanto nos modelos anteriores, baseados em chave pública, era necessário um par de chaves para cada usuário, neste novo modelo, apenas uma chave pública é gerada, baseada no conjunto de parâmetros (privilégios/atributos) existentes. Esta única chave permite a criptografia, enquanto as diversas chaves privadas permitirão a decodificação, se satisfeitas a política de acesso definida no texto cifrado.</p>
                        <p>O mais importante é que, neste modelo de criptografia, o texto plano não é criptografado mais por usuário, conforme modelos anteriores, e sim por privilégios.</p>

                        <h3>	Funcionamento prático do algoritmo</h3>

                        <p>Para utilizar o algoritmo é definida uma lista de usuários (Ex: U = {u1, u2, ...., un}) e uma lista de atributos possíveis (Ex: A = {a1, a2, ...., an}). Neste momento, cada usuário deverá ser relacionado diretamente com um ou mais atributos. Ex: R= {u1(a1,a2); u2(a1);</p>
                        <p>A Figura abaixo ilustra este relacionamento.</p>

                        <img src="img/Nova Imagem (10).jpg" width="500px" height="500px"/>
                        Figura – Relacionamento Usuários X Atributos

                        <p>Definidos os relacionamentos, é necessário montar uma árvore de acesso na qual os nós folha são atributos existentes no conjunto dos atributos definidos anteriormente e os demais nós são portas com Threshold atribuído (ou seja com limite de tolerância ou níveis máximos permitidos). </p>
                        <p>A figura abaixo apresenta um exemplo de estrutura de acesso em formato de árvore:</p>

                        <img src="img/Nova Imagem (11).jpg" width="500px" height="500px"/>
                        Figura – Árvore de Acesso

                        <p>Neste exemplo acima, a partir do nó raiz, para se atender a política de acesso há duas opções iniciais aceitáveis: OU atende a politica direcionando-se ao nó “AND”, OU atende a política direcionando-se ao nó “1 OF”.</p>
                        <p>Para atender ao nó “AND” o usuário deverá possuir em sua chave privada os dois atributos “raio” e “sol”. Não atendendo este Threshold, verifica se atende o outro Threshold “1 OF”, ou seja, o usuário deverá ter em sua chave privada um dos atributos estrela (4, 5 ou 6 pontas). Se atendido algum dos Threshold o arquivo criptografado permitirá que o usuário o decodifique.</p>


                    </div>

                    <!-- INÍCIO DO RODAPÉ -->
                    <div class="well" id="rodapé" align="center"> 
                        <p><small>______________________________________________________________________________________________________________________</small></p> 
                        <p><small><em>" Desenvolvido por <a href="mailto:1408509@gmail.com">LUCIANO</a>"</em></small></p>

                        <p><small><em>All Rights Reserved</em></small></p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
