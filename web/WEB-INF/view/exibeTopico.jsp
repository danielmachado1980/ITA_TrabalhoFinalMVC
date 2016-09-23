<%-- 
    Document   : exibeTopico
    Created on : 20/09/2016, 15:26:02
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tela Exibe Tópico</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
        
    </head>
    <body>
        <div class="container">
            <!-- Forms
            ================================================== -->
            <div class="bs-docs-section">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="page-header">
                            <h1 id="forms">${topico.getTitulo()}</h1>
                            <h5 id="forms">Por: ${topico.getUsuario().getNome()}</h5>
                        </div>
                    </div>
                </div>
                <c:forEach var="comentario" items="${topico.getComentarios()}">
                    <blockquote>
                        <p>${comentario.getComentario()}</p>
                        <small>Someone famous in <cite title="Source Title">Source Title</cite></small>
                    </blockquote>
                </c:forEach>
                
                <div class="row">
                    <div class="col-lg-6">
                        <div class="well bs-component">
                            <form class="form-horizontal" method="POST">
                                <fieldset>
                                    <legend></legend>
                                    <div class="form-group">
                                        <label for=for="textArea" class="col-lg-2 control-label">Comentário</label>
                                        <div class="col-lg-10">
                                            <textarea class="form-control" name="conteudo" rows="6" id="textArea" required=""></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-10 col-lg-offset-2">
                                            <a href="${pageContext.request.contextPath}/Topicos" class="btn btn-default" role="button">Cancelar</a>
                                            <button type="submit" class="btn btn-primary">Enviar</button>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- jQuery (necessario para os plugins Javascript do Bootstrap) -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </head>
</html>
