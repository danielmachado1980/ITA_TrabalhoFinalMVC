<!DOCTYPE html>
<html >
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Tela Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}" class="navbar-brand">Fórum com Gamification</a>
                </div>
                <div class="navbar-collapse collapse" id="navbar-main">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="Cadastrar">Cadastrar Usuário</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">

            <form class="form-signin" action="Login" method="POST">
                <h2 class="form-signin-heading">Autenticação</h2>
                <label for="inputLogin" class="sr-only">Login</label>
                <input type="text" id="inputLogin" name="login" class="form-control" placeholder="Entre com o login" required autofocus>
                <label for="inputPassword" class="sr-only">Senha</label>
                <input type="password" id="inputPassword" name="senha" class="form-control" placeholder="Entre com a senha" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
            </form>

        </div> <!-- /container -->
</html>
