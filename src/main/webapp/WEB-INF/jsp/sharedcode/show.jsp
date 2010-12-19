<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>

<p>
  <b>Nome:</b>
   ${sharedcode.nome}
</p>
<p>
  <b>Tags:</b>
   ${sharedcode.tags}
</p>
<p>
  <b>Linguagem:</b>
   ${sharedcode.linguagem}
</p>
<p>
  <b>Codigo:</b>
   ${sharedcode.codigo}
</p>

<a href="<c:url value="/sharedcodes/${sharedcode.id}/edit"/>">Edit</a>
<a href="<c:url value="/sharedcodes"/>">Back</a>

</body>
