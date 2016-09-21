<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Tela Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
        <div id="wrap">
            <div id="regbar">
                <div id="navthing">
                    <h2><a href="#" id="loginform">Login</a> | <a href="Cadastrar">Cadastrar</a></h2>
                    <div class="login">
                        <div class="arrow-up"></div>
                        <div class="formholder">
                            <div class="randompad">
                                <fieldset>
                                    <label name="email">Login</label>
                                    <input type="email" />
                                    <label name="password">Senha</label>
                                    <input type="password" />
                                    <input type="submit" value="Login" />

                                </fieldset>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/index.js"></script>
    </body>
</html>
