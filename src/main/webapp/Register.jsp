<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


    
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>  
<html>
<head>
<title>Student Registration Form</title>
<style type="text/css">
h3{
  font-family: Calibri; 
  font-size: 25pt;         
  font-style: normal; 
  font-weight: bold; 
  color:lightblue;
  text-align: center; 
  text-decoration: underline;
}

table{
  font-family: Calibri; 
  color:Black; 
  font-size: 11pt; 
  font-style:italic;
  font-weight: bold;
  text-align:; 
  background-color:lightblue; 
  border-collapse: collapse; 
  border: none;
}
table.inner{
  border: 0px
}
body,html{
 background-image: url("https://cdn3.vectorstock.com/i/1000x1000/48/77/background-web-design-website-development-network-vector-21604877.jpg");
}
.button {
background-color: #4CAF50;
}
input[type=text], select, textarea {
  width: 100%; /* Full width */
  padding: 12px; /* Some padding */ 
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; 
  resize: vertical ;
}

/* Style the submit button with a specific background color etc */
input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=reset] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* When moving the mouse over the submit button, add a darker green color */
input[type=submit]:hover {
  background-color: #45a049;
}
input[type=reset]:hover {
  background-color: #45a049;
}


    
</style>
<script type="text/javascript">
function clicked() {
    alert('Register successfully');
}

</script>

</head>
 
<body>
<h3>STUDENT REGISTRATION FORM</h3>

 <form class="frm1" action="signup" method="post" enctype="multipart/form-data">
<table align="center" cellpadding = "10">
 
<tr>
<td>FIRST NAME</td>
<td><input type="text" name="First_Name" maxlength="30"/>
(max 30 characters a-z and A-Z)
</td>
</tr>
 
<!----- Last Name ---------------------------------------------------------->
<tr>
<td>LAST NAME</td>
<td><input type="text" name="Last_Name" maxlength="30"/>
(max 30 characters a-z and A-Z)
</td>
</tr>
 

<!----- Email Id ---------------------------------------------------------->
<tr>
<td>EMAIL ID</td>
<td><input type="text" name="Email_Id" maxlength="100" /></td>
</tr>
 
<!----- Mobile Number ---------------------------------------------------------->
<tr>
<td>MOBILE NUMBER</td>
<td>
<input type="text" name="Mobile_Number" maxlength="10" />
(10 digit number)
</td>
</tr>
 
 
<!----- Address ---------------------------------------------------------->
<tr>
<td>ADDRESS <br /><br /><br /></td>
<td><textarea name="Address" rows="4" cols="30"></textarea></td>
</tr>

<!----- Course ---------------------------------------------------------->
<tr>
<td>COURSES</td>
<td>
<input type="text" name="Course_BCA" value="">

</td>
</tr>
 
<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="2" align="center">
<input type="submit" onclick="clicked();" value="SUBMIT"/>
<input type="reset"   value="RESET">
</td>
</tr>
</table>
 
</form>
 
</body>
</html>  

