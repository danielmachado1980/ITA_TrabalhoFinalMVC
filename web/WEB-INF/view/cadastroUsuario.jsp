<%-- 
    Document   : cadastroUsuario
    Created on : 20/09/2016, 15:21:54
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Tela Cadastro</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="col-md-8 col-md-offset-4">
                <h2>Cadastro de Usuário</h2>
            </div>
            <form class="form-horizontal" action="Cadastrar" method="POST">
                <div class="form-group">
                    <label class="control-label col-sm-4" for="nome">Nome:</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="nome" placeholder="Entre com o nome" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4" for="email">Email:</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" name="email" placeholder="Entre com o email" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4" for="email">Login:</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="login" placeholder="Entre com o login" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4" for="pwd">Senha:</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" name="senha" placeholder="Entre com a senha" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-7 col-md-offset-5">
                        <a href="${pageContext.request.contextPath}" class="btn btn-default" role="button">Cancelar</a>
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
