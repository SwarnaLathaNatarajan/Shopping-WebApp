<%
Cookie clientCookies[] = request.getCookies();       
      for( int i = 0; i < clientCookies.length; i++)     
      {
  		if(clientCookies[i].getName().equals("JSESSIONID"))
  		continue;
        out.print("<B>" + clientCookies[i].getName() + " : " + clientCookies[i].getValue() + "</B><BR>");
      }                

 %>