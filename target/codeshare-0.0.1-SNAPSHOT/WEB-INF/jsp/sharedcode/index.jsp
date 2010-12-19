<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<h1>Listing Sharedcodes</h1>

<table>
  <tr>
   <th>nome</th>
   <th>tags</th>
   <th>linguagem</th>
   <th>codigo</th>
   <th></th>
   <th></th>
   <th></th>
  </tr>

<c:forEach items="${sharedcodeList}" var="sharedcode">
  <tr>
      <td>
      ${sharedcode.nome}
    </td>
      <td>
      ${sharedcode.tags}
    </td>
      <td>
      ${sharedcode.linguagem}
    </td>
      <td>
      ${sharedcode.codigo}
    </td>
      <td><a href="<c:url value="/sharedcodes/${sharedcode.id}"/>">show</a></td>
    <td><a href="<c:url value="/sharedcodes/${sharedcode.id}/edit"/>">edit</a></td>
    <td>
      <form action="<c:url value="/sharedcodes/${sharedcode.id}"/>" method="post">
    	  <input type="hidden" name="_method" value="delete"/>
    	  <button type="submit" onclick="return confirm('Are you sure?')">destroy</button>
	    </form>
	  </td>
    </tr>
</c:forEach>
</table>

<br />
<a href="<c:url value="/sharedcodes/new"/>">New Sharedcode</a> 
</body>
