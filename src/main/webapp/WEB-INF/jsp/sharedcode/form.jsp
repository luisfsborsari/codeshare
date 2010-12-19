<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	      <li>
	      <div class="item">
	      <a href="<c:url value="/sharedcodes/${sharedcode.id}"/>">${sharedcode.nome}</a>   
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
    <input type="hidden" name="sharedcode.id" value="${sharedcode.id}"/>
    <input type="hidden" name="_method" value="put"/>
  </c:if>
  


  <div class="field">
    Nome:<br />
    <input type="text" name="sharedcode.nome" value="${sharedcode.nome}"/>
  </div>
  <div class="field">
    Tags:<br />
    <input type="text" name="sharedcode.tags" value="${sharedcode.tags}"/>
  </div>
  <div class="field">
    Linguagem:<br />
   <select name="sharedcode.tags">
           <option value="Java">Java</option>
           <option value="C">C</option>
           <option value="Ruby">Ruby</option>
           <option value="Python">Python</option>
   </select>
  </div>
  <div class="field">
    Codigo:<br />
    <textarea cols=30 rows=10  name="sharedcode.codigo" value="">
    </textarea>
  </div>
  <div class="actions">
    <button type="submit">Salvar</button>
  </div>
</form>


