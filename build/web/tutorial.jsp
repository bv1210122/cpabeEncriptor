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
                        <h3>	TUTORIAL - CRIPTOGRAFIA CPABE SIMPLES (com apenas 1 atributo)</h3>

                        <h4>Passo 1 – Cadastrar atributo e usuário na aba “Gerenciar Cadastro”:</h4>
                        <p>1 – Selecione a opção “Cadastrar Atributo” e cadastre o atributo que deseja vincular à sua chave privada.</p>
                        <p>IMPORTANTE:  Caso o atributo seja composto, ex. "sessão rh", este deverá ser listado utilizando-se o underline. Ex.: sessão_rh.</p>
                        <p>2 – Selecione a opção “Cadastrar Usuário”  e cadastre o usuário e selecione, na “lista de atributos”, o atributo que deseja vincular a este usuário.</p>
                        <p>IMPORTANTE: Se o nome desejado for COMPOSTO, este deverá ser escrito utilizando-se do underline. Ex.: Luciano_1210122</p>
                        <h4>Passo 2 – Gerar Chave Privada</h4>
                        <p>1 – Na aba “Criptografia CPABE”, clique na opção “Gerar Chave Privada”.</p>
                        <p>2 – Selecione na “lista de usuários” o usuário para o qual pretende gerar a chave privada. (neste caso, o usuário cadastrado por você no passo anterior).</p>
                        <p>3 – Clique no botão “Gerar”.</p>
                        <p>4 – Aparecerá uma mensagem de confirmação da geração da chave e um link para download da chave gerada.</p>
                        <p>5 – Faça o download da chave gerada e guarde sua localização pois será necessária para decriptar os arquivos criptografados com o seu atributo cadastrado.</p>
                        <h4>Passo 3 – Encriptar</h4>
                        <p>1 – Na aba “Criptografia CPABE”, clique na opção “Encriptar”.</p>
                        <p>2 – Para encriptar, primeiramente clique no botão “Selecionar Arquivo” e selecione o arquivo a ser criptografado.</p>
                        <p>3 – Clique no botão "Upload".</p>
                        <p>IMPORTANTE: Se o arquivo possuir NOME COMPOSTO ou CARACTERE ESPECIAL (Ç,~,^,@, etc) o nome deverá ser editado e escrito utilizando-se do underline antes de ser feito o upload. Ex.: Encriptação 12.doc --> Encriptacao_12.doc</p>
                        <p>4 – Selecione, na “lista de atributos”, o atributo com o qual deseja criptografar o arquivo. Lembrando que, somente o usuário que possuir na chave privada o mesmo atributo conseguirá decriptografar este arquivo.</p>
                        <p>5 – Aparecerá uma mensagem de confirmação da criptografia e um link para download do arquivo criptografado. O arquivo possui a extensão “.cpabe”. </p>
                        <p>OBS.: Caso apareça a mensagem de confirmação da criptografia e ao tentar fazer o download aparecer uma mensagem de erro com a informação de que o arquivo não está disponível no servidor, o problema deve ser relacionado ao nome do arquivo (ver passo 3 – item 3) ou nome do atributo (ver passo 1 – item 1).</p>
                        <p>OBS.2: Este erro pode acontecer devido o sistema montar, com os dados selecionados, uma “String de comandos” que é enviada ao Shell Comando Linux, que por sua vez, executa o sistema de criptografia CPABE. Se os dados cadastrados (nome de usuários, arquivos)  possuir uma das falhas elencadas (espaços em branco, caracteres especiais, etc), esta String não é montada corretamente e o sistema não criptografa o arquivo.</p>
                        <p>6 – Faça o download do arquivo criptografado, guarde sua localização pois será necessário fazer o upload deste arquivo para decriptação.</p>
                        <p>7 – Por fim, tente abrir este arquivo e acessar o seu conteúdo.</p>
                        <h4>Passo 3 – Decriptar</h4>
                        <p>1 – Na aba “Criptografia CPABE”, clique na opção “Decriptar”.</p>
                        <p>2 – Para Decriptar, primeiramente clique no 1º botão “Selecionar Arquivo” e selecione o arquivo a ser descriptografado.</p>
                        <p>3 – Na sequência clique no 2º botão “Selecionar Arquivo” e selecione a chave privada com a qual tentará descriptografar o arquivo.</p>
                        <p>4 – Clique no botão "Upload".</p>
                        <p>5 – O sistema mostrará o arquivo e a chave selecionada. Clique no botão “Descriptografar”.</p>
                        <p>6 – Aparecerá uma mensagem de confirmação do comando de descriptografia executado com sucesso e um link para download do arquivo descriptografado. </p>
                        <p>OBS.: Ao tentar fazer o download aparecer uma mensagem de erro com a informação de que o arquivo não está disponível no servidor, significa que a chave privada informada não preenche os requisitos para descriptografar o arquivo, ou seja, não possui em seu interior o atributo que permite a decodificação.</p>
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
