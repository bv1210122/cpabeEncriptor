<%-- 
    Document   : 
    Created on : 01/11/2014, 16:16:28
    Author     : BV1210122
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

        <script type="text/javascript">
            function check() {
                if (frm.atributo_id.value == "") {
                    alert("Por favor, informe o ID do atributo a ser pesquisado.");
                    frm.atributo_id.focus();
                    return false;
                }
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
                    <div class="container-fluid">
                        <div class="hero" >
                            <div class="well" >
                                <span class="label label-success"><h3>Pesquisar Atributo</h3></span>

                                <form id="frm" onsubmit="return check(this);" class="form-search" method="post" action="${pageContext.request.contextPath}/AtributoServlet">
                                    <input name="acao" type="hidden" value="listarAtributoID"/>
                                    <td class="label"><h5>ID do Atributo a ser Pesquisado:</h5></td>
                                    <div class="input-append">
                                        <input class="span6 search-query" type="text" name="atributo_id">
                                        <button  class="btn btn-primary" type="submit" value="listarAtributoID">Buscar</button>
                                    </div>
                                    <table>
                                        <tr>
                                            <td class="label">ID do Atributo:</td>
                                            <td>${requestScope.atributo.atributo_id}</td>
                                        </tr>
                                        <tr>
                                            <td class="label">Nome:</td>
                                            <td>${requestScope.atributo.atributo_nome}</td>
                                        </tr>
                                        <tr>
                                            <td class="label">Descrição:</td>
                                            <td>${requestScope.atributo.atributo_descricao}</td>
                                        </tr>
                                    </table>
                                    <a href="${pageContext.request.contextPath}/AtributoServlet?acao=prepAlteracao&atributo_id=${requestScope.atributo.atributo_id}"><button class="btn btn-mini btn" type="button">Alterar</button></a>
                                    <a href="${pageContext.request.contextPath}/AtributoServlet?acao=prepExclusao&atributo_id=${requestScope.atributo.atributo_id}"><button class="btn btn-mini btn-danger" type="button">Excluir</button></a>
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