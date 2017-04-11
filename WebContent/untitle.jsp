<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link rel="stylesheet" href="datatable/bootstrap.min.css" />
<link href="datatable/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
<link href="datatable/datatables.min.css" rel="stylesheet" type="text/css" />
<link href="datatable/jquery.dataTables.css" rel="stylesheet" type="text/css" />
<link href="datatable/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
<script src="datatable/dataTables.bootstrap.js" ></script>
<script src="datatable/dataTables.bootstrap.min.js" ></script>
<script src="datatable/datatables.min.js"></script>
<script src="datatable/jquery.dataTables.js" ></script>
<script src="datatable/jquery.dataTables.min.js" ></script>

 
 
 <script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#example').DataTable();
			} );
		</script>
		
		<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body>
<%-- <%@include file="AdminHeader.jsp" %> --%>
<table id="example" >
		<thead>
                
<tr>
                  
<th>ID</th>
                  
<th>Product</th>
                  
<th>Brand</th>
                  
<th>Quantity</th>
                  
<th>Price\Unit</th>
                
</tr>
              
</thead>
              


<tbody>
                
<tr>
                  
<td>1,001</td>
                  
<td>TV</td>
                  
<td>Sony</td>
                  
<td>10</td>
                  
<td>1,00,000</td>
                
</tr>
                

<tr>
                  
<td>1,002</td>
                  
<td>Laptop</td>
                  
<td>Apple</td>
                  
<td>15</td>
                  
<td>85,000</td>
                
</tr>
                

<tr>
                  
<td>1,003</td>
                  
<td>Laptop</td>
                  
<td>Apple</td>
                  
<td>55</td>
                  
<td>95,000</td>
                
</tr>



<tr>
                  
<td>1,002</td>
                  
<td>Laptop</td>
                  
<td>Apple</td>
                  
<td>15</td>
                  
<td>85,000</td>
                
</tr>



<tr>
                  
<td>1,004</td>
                  
<td>Laptop</td>
                  
<td>Lenovo</td>
                  
<td>05</td>
                  
<td>75,000</td>
                
</tr>



<tr>
                  
<td>1,006</td>
                  
<td>Iphone6s</td>
                  
<td>Apple</td>
                  
<td>35</td>
                  
<td>95,000</td>
                
</tr>


 </tbody>
            
</table>
</body>
</html>
