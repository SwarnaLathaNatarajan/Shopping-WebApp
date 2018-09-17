<style type="text/css">
</style>
<body>
<%
	int t;
	String[] name=(String[])request.getAttribute("name");
	String[] descp=(String[])request.getAttribute("descp");
	String[] img=(String[])request.getAttribute("img");
	String[] rs=(String[])request.getAttribute("rs");
	int num=Integer.valueOf((String)request.getAttribute("num"));
	for(int i=0;i<num;i++)
		{
			t=i+1;
			out.println("<b>"+t+" ) "+name[i]+"</b><br><br>");
			out.println("<img src='"+img[i]+"'/><br><br>");
			out.println(descp[i]+"<br>Rs."+rs[i]+"<br>");
			%>
			Qty:


<input type='button' name='subtract' size="5" onclick='javascript: document.getElementById(<%=i%>).value--;' value='-'/>
<input type='text' value="1" name='qty' size="3" required id=<%=i%> />
<input type='button' name='add' onclick='javascript: document.getElementById(<%=i%>).value++;' value='+'/>
<input type="button" value="Add to cart" onclick='addtocart("<%=name[i]%>",<%=rs[i]%>,document.getElementById(<%=i%>).value)'/><br>
	<%	} %>
	</body>
