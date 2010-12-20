<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<h1>CodeShare</h1>

<c:if test="${not empty errors}">
	<c:forEach items="${errors}" var="error">
		 ${error.category} - ${error.message}<br />
	</c:forEach>
</c:if>

<form action="<c:url value="/sharedcodes/search"/>" method="get">

<div style="float:right" >
  <div class="field">
    Busca:<br />
    <input type="text" name="tags" value=""/>
  </div>
    <div class="actions">
    <button type="submit">Pesquisar</button>
  </div>

 <c:if test="${not empty sharedcodeList}"> 
	<h3>Resultado da Pesquisa:</h3>
	<ul>
	<c:forEach items="${sharedcodeList}" var="sharedcode">
		    <input type="hidden" id="sharedcode.id_${sharedcode.id}"   value="${sharedcode.id}"/>
    		<input type="hidden" id="sharedcode.nome_${sharedcode.id}" value="${sharedcode.nome}"/>
    		<input type="hidden" id="sharedcode.tags_${sharedcode.id}" value="${sharedcode.tags}"/>
    		<input type="hidden" id="sharedcode.linguagem_${sharedcode.id}" value="${sharedcode.linguagem}"/>
    		<input type="hidden" id="sharedcode.codigo_${sharedcode.id}" value="${sharedcode.codigo}"/>
	      <li>
	      <div class="item">
	      <a href="#" onclick="setCampos('${sharedcode.id}');"> ${sharedcode.nome} </a>   
			<br/>
	      ${sharedcode.tags}
	      </div>
	      </li>	
	</c:forEach>
	</ul>
 </c:if>
 <c:if test="${empty sharedcodeList}">
 	<h3>Nenhum resultado</h3>
 </c:if>
</div>
</form>


<form id="formPost" action="<c:url value="/sharedcodes"/>" method="post">
  
  <c:if test="${not empty sharedcode.id}">
    <input type="hidden" id="sharedcode.id.campo" name="sharedcode.id" value="${sharedcode.id}"/>
    <input type="hidden" name="_method" value="put"/>
  </c:if>

  <div class="field">
    Nome:<br />
    <input type="text" id="sharedcode.nome.campo" name="sharedcode.nome" value="${sharedcode.nome}"/>
  </div>
  <div class="field">
    Tags:<br />
    <input type="text" id="sharedcode.tags.campo" name="sharedcode.tags" value="${sharedcode.tags}"/>
  </div>
  <div class="field">
    Linguagem:<br />
   <select id="sharedcode.linguagem.campo" name="sharedcode.linguagem">
           <option value="Java">Java</option>
           <option value="C">C</option>
           <option value="Ruby">Ruby</option>
           <option value="Python">Python</option>
   </select>
  </div>
  <div class="field">
    Codigo:<br />
    <textarea id="sharedcode.codigo.campo" cols=30 rows=10  name="sharedcode.codigo">
    </textarea>
  </div>
  <div class="actions">
    <button type="submit">Salvar</button>
  </div>
</form>



<script type="text/javascript">
function setCampos(id){	
	try {
		document.getElementById("sharedcode.id.campo").value = document.getElementById("sharedcode.id_"+id).value;
	} catch(err) {
		var hiddenElement = document.createElement("input");
		hiddenElement.setAttribute("type", "hidden");
		hiddenElement.setAttribute("id", "sharedcode.id.campo");
		hiddenElement.setAttribute("name", "sharedcode.id");
		hiddenElement.setAttribute("value", id);
		document.getElementById("formPost").appendChild(hiddenElement);		
	}
	document.getElementById("sharedcode.nome.campo").value = document.getElementById("sharedcode.nome_"+id).value;
	document.getElementById("sharedcode.tags.campo").value = document.getElementById("sharedcode.tags_"+id).value;
	document.getElementById("sharedcode.linguagem.campo").value = document.getElementById("sharedcode.linguagem_"+id).value;
	document.getElementById("sharedcode.codigo.campo").value = document.getElementById("sharedcode.codigo_"+id).value;
	document.getElementById("formPost").setAttribute("action", "<c:url value="/sharedcodes/update"/>");	
}
</script>
</body>