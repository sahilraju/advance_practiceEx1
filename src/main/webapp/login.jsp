<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
 <body>

    <form action="login" >  
         <label for="username">User Name: </label> <br>
         <input type="text" id="username" name="username" required> <br>
         
         <label for="password">Password: </label> <br>
         <input type="password" id="password" name="password" required> <br>
         
         <input type="submit" value="Submit">
         <input type="reset" value="Reset"> 
    </form>
    
    <!-- Error message display -->  
    <div class="error">
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
               out.print(errorMessage); 
            }
        %> 
    </div>

 </body>
</html>
