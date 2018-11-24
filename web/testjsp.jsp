<%-- 
    Document   : testjsp
    Created on : 24-Nov-2018, 12:40:52 AM
    Author     : Danny
--%>

<%@page import="dataTransfer.Profile"%>
<%@page import="dataAccess.ProfileDaoImpl"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <% 

int blobID = Integer.parseInt(request.getParameter("blobID"));
System.out.println(blobID);
byte[ ] imgData = null ;

try {

ProfileDaoImpl dao= new ProfileDaoImpl();
Profile profile =new Profile();
profile=dao.getProfileById(blobID);
Blob blob=profile.getProfilePictureBlob();
imgData = blob.getBytes(1,(int)blob.length());

// display the image 
//response.setContentType("image/gif");

OutputStream o = response.getOutputStream();
o.write(imgData);

o.flush();

o.close();

} catch (Exception e) {

out.println("Unable To Display image");

out.println("Image Display Error=" + e.getMessage());



}

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <h1>Hello World!</h1>
    </body>
</html>
