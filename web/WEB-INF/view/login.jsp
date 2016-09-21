<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Tela Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
        <form action="Login" method="POST">
        <div id="wrap">
            <div id="regbar">
                <div id="navthing">
                    <h2><a href="" id="loginform">Login</a> | <a href="Cadastrar">Cadastrar</a></h2>
                    <div class="login">
                        <div class="arrow-up"></div>
                        <div class="formholder">
                            <div class="randompad">
                                <fieldset>
                                    <label>Login</label>
                                    <input type="login" name="login" required/>
                                    <label>Senha</label>
                                    <input type="password" name="senha" required/>
                                    <input type="submit" value="Login" />
                                </fieldset>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/index.js"></script>
    </body>
</html>
