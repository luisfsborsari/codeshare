<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function setCampos(id){
	alert(id);
	document.getElementById("sharedcode.id.campo").value = document.getElementById("sharedcode.id_"+id).value;
	document.getElementById("sharedcode.nome.campo").value = document.getElementById("sharedcode.nome_"+id).value;
	document.getElementById("sharedcode.tags.campo").value = document.getElementById("sharedcode.tags_"+id).value;
	document.getElementById("sharedcode.linguagem.campo").value = document.getElementById("sharedcode.linguagem_"+id).value;
	document.getElementById("sharedcode.codigo.campo").value = document.getElementById("sharedcode.codigo_"+id).value;
}
</script>

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
	<ul>
	<h3>Resultado da Pesquisa:</h3>
	<c:forEach items="${sharedcodeList}" var="sharedcode">
		    <input type="hidden" id="sharedcode.id_${sharedcode.id}"   value="${sharedcode.id}"/>
    		<input type="hidden" id="sharedcode.nome_${sharedcode.id}" value="${sharedcode.id}"/>
    		<input type="hidden" id="sharedcode.tags_${sharedcode.id}" value="${sharedcode.tags}"/>
    		<input type="hidden" id="sharedcode.linguagem_${sharedcode.id}" value="${sharedcode.linguagem}"/>
    		<input type="hidden" id="sharedcode.codigo_${sharedcode.id}" value="${sharedcode.codigo}"/>
	      <li>
	      <div class="item">
	      <a href="javascript:setCampos(${sharedcode.id})" value=""> ${sharedcode.nome} </a>   
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


<form action="<c:url value="/sharedcodes"/>" method="post">
  
  <c:if test="${not empty sharedcode.id}">
    <input type="hidden" name="sharedcode.id.campo" value="${sharedcode.id}"/>
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
    <textarea id="sharedcode.codigo.campo" cols=30 rows=10  name="sharedcode.codigo" value="">
    </textarea>
  </div>
  <div class="actions">
    <button type="submit">Salvar</button>
  </div>
</form>


