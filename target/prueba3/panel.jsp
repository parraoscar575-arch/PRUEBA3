<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" data-theme="light">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MI proyecto</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
</head>
<body>
    <%
        if (session.getAttribute("nomusu") == null) {
            response.sendRedirect("index.html");
            return;
        }
    %>
    <main class="container-fluid">
        <h1>Bienvenidos a mi Proyecto ADSO</h1>
    </main>
</body>
</html>
