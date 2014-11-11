<%-- 
    Document   : 
    Created on : 01/11/2014, 16:16:28
    Author     : BV1210122
--%>

<%@page import="cpabe.entidades.CaminhoArquivo"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <!-- SCRIPT E CSS VALIDAÇÃO -->
        <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/css/validate.css" type="text/css" media="screen" rel="stylesheet" />
        <!--[if lte IE 7]>
        <link href="${pageContext.request.contextPath}/css/validate_ie7.css" type="text/css" media="screen" rel="stylesheet" />
        <![endif]-->
        <style type="text/css">

            label.error { float: none; color: red; margin: 0 .5em 0 0; vertical-align: top; font-size: 10px }
            p { clear: both; }
            .submit { margin-top: 1em; }
            em { font-weight: bold; padding-right: 1em; vertical-align: top; }
        </style>
        <!-- SCRIPT E CSS VALIDAÇÃO -->
        <script type="text/javascript">
            function buscarArquivo() {


                return a;
            }


        </script>
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
                    <div class="hero">
                        <div class="container-fluid">
                            <div class="well">

                                <span class="label label-success"><h3>Encriptar Advanced</h3></span>

                                <h4>Orientações Gerais:</h4>
                                <p>Para encriptar no modo Avançado (com dois ou mais atributos, aplicandos os Operadores OR, AND), <i><strong>digite os atributos</strong></i> que limitarão a decodificação do arquivo e clicar no botão <i><strong>"Criptografar"</strong></i></p>
                                <p>Após o arquivo ser criptografado, será disponibilizado um link para efetuar o <i><strong>Download</strong></i>.</p>


                                <form id="frm" class="validate" onsubmit="return validaForm(this);" method="post" action="${pageContext.request.contextPath}/CPABEAdvancedServlet">

                                    <input name="acao" type="hidden" value="criptografar">

                                    <label> Local do Arquivo Selecionado: </label>${requestScope.caminho.way}

                                    <input type="hidden" name="arquivo" value="${requestScope.caminho.way}" >
                                    <label> Arquivo Selecionado: </label>${requestScope.caminho.nome}
                                    <input name="fileName" type="hidden" value="${requestScope.caminho.nome}" >

                                    <label>Atributo: </label> 
                                    <input placeholder="Digite os atributos, separados pelos operadores, conforme exemplo" type="text" size="100" name="atributo_advanced"/>

                                    <br>
                                    <p><i>Exemplo de Utilização de Atributos variados: </i> </p>

                                    <p><i>(sofi or sirh) or (admin and sofi)</i> </p>
                                    <p><i>Exemplo combinando 10 atributos diferentes:</i> </p>

                                    <p> <i> ( (a1 and a2) or (a3 and a4 and a5) ) or ( (a6 and a7 and a8) and (a9 or a10) ) )</i> </p>

                                    <br>
                                    <button class="btn btn-primary" type="submit" value="criptografar">Criptografar</button>

                                    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary">Voltar</a></button>

                                </form>
                            </div>
                        </div>
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
