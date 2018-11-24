<%-- 
    Document   : viewProfile
    Created on : 12-Nov-2018, 3:44:02 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
        <!--<meta charset="utf-8">-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--<meta http-equiv="X-UA-Compatible" content="IE=edge">-->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/form.css" >
        
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Profile</title>
    </head>
    <body>
        <div>
            <%
                out.print("Insertion was successful.");
            %>
            <div class="container">
            <div id="form-main">
                <div id="form-div">
                    <form class="montform" id="reused_form" action="BlobViewServ" enctype="multipart/form-data" method="post">
                        <p class="name">
                            <input name="blobID" type="text" class="feedback-input" required placeholder="Blob ID" id="blobID" />
                        </p>
			
                            
                        <div class="submit">
                            <button type="submit" class="button-blue">SUBMIT</button>
                            <div class="ease"></div>
                            
                        </div>
                    </form>
                   </div>
            </div>
        </div>
        </div>
        <div>
            <a href="formpage.html">Back to form</a>
        </div>
        
    </body>
</html>
