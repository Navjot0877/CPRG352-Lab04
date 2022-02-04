<%-- 
    Document   : viewnote
    Created on : 3-Feb-2022, 3:33:51 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        
        <h2>View Note</h2>
        <b>Title:</b> ${note.title}
        <br>
        <br>
        <b>Contents:</b><br>
        ${note.contents}
        <br>
        <a href="note?edit">Edit</a>
    </body>
</html>
