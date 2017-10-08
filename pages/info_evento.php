<?php
require_once('topo.php');
?>

<style>
    
.titulo {
    width: 61%;
    float: left;
    margin-bottom: 15px;
    padding-right: 10px;
}
.tipoEvento {
    float: left;
     padding-right: 10px;
}
.novoTipoEvento {
    float: left;
}
.esquerda {
    width: 18%;
    float: left;
    margin-bottom: 15px;
    padding-right: 10px;
}
.direita {
    margin-left: 18%;
    margin-bottom: 15px;
    padding-right: 630px;
}
h1{
    color: #337ab7;
}



/* Style the tab */
div.tab {
    overflow: hidden;
    border-radius: 5px;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 4px 50px;
    transition: 0.3s;
    font-size: 18px;
}

/* Change background color of buttons on hover */
div.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
div.tab button.active {
    background-color:#337ab7;
    color: white;
}

/* Style the tab content */
.tabcontent {
    display: none;
    border: none;
    border-top: none;
}


</style>

        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- TÍTULO -->
                <br>
                <div class="tab">
                    <button class="tablinks" id="botaoEvento" onclick="openCity(event, 'CriarEvento')">Informação Evento</button>
                    <button class="tablinks" onclick="openCity(event, 'Recurso')">Alocar Recursos</button>
                    <button class="tablinks" onclick="openCity(event, 'Servico')">Alocar Serviços</button>
                </div>

            <div id="CriarEvento" class="tabcontent">
               
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                    <div class="panel-body">
                        <form role="form" name="formEvento">
                            <input type="hidden" id="estado"/>
                            <input type="hidden" id="idEvento"/>
                            <input type="hidden" id="tipoEvento"/>
                            <br>       
                     <section> 
                        <fieldset> 
                          <legend>Nome e Tipo do Evento</legend>
                           <div class="titulo">
                            <input placeholder="Nome do Evento" class="form-control" id="nomeEvento" disabled>  
                           </div>
                          
                        </fieldset>
                    </section>    

                            <br>
                            
                            <fieldset> 
                              <legend>Cliente</legend>
                                <div class="form-group">
                                
                                    <input placeholder="Nome" class="form-control" id="nomeCliente" disabled>  
                                    <br>
                                  
                                    <input placeholder="E-mail" class="form-control" id="emailCliente" disabled>  
                                    <br>
                                 
                                    <input placeholder="Telemóvel" class="form-control" id="contactoCliente" disabled>
                                </div> 
                            </fieldset>
                            <br>

                            <br>

                            <fieldset> 
                                <legend>Informação Evento</legend>
                                    <div class="form-group">
                                      <section>
                                       <div class="esquerda">
                                        <label>Data Início</label>
                                        <input class="form-control" min="2016-10-28" max="2030-01-01" type="text" id="dataInicio" disabled> 
                                       </div>
                                       
                                       <div class="direita"> 
                                        <label>Data Fim</label>
                                        <input class="form-control" min="2016-10-28" max="2030-01-01" type="text" id="dataFim" disabled>
                                        </div>
                                        <br>
                                      </section>  
                                      <section>
                                       <div class="esquerda">   
                                        <label>Hora Início</label>
                                        <input class="form-control" type="text" id="horaInicio" disabled> 
                                       </div>
                                       <div class="direita">    
                                        <label>Hora Fim</label>
                                        <input class="form-control" type="text" id="horaFim" disabled>
                                       </div> 
                                      </section>
                                    </div>   
                                
                                    
                                    <div class="form-group">
                                        <label>Descrição</label>
                                        <textarea class="form-control" rows="3" id="descricao" disabled></textarea>
                                    </div>
                            </fieldset> 
                         </form>
                    </div>
                </div>
                
                
                 
                
</div>

<div id="Recurso" class="tabcontent">
  <p>Recursos necessários</p>
  <div class="form-group">
     <select multiple class="form-control" id="recursos" size="10">

     </select>
  </div>

</div>

<div id="Servico" class="tabcontent">
  <p>Serviços necessários</p>
  <div class="form-group">
     <select multiple class="form-control" id="servicos" size="10">

     </select>
  </div>
  <button type="button" class="btn btn-primary" id="okEvento">Voltar</button>
</div>
              
              
              <br>
              <br>
                
                
                <!-- FIM CORPO -->
            </div>
        </div>
    </div>


    <!-- JAVASCRIPT -->
    
    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>
    
    <script>
    function autoBotao() {
    document.getElementById("botaoEvento").click(); // Click on the checkbox
}  
    window.onload=autoBotao();
    
    function openCity(evt, cityName) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
    </script>
    
    <script>
        
 function getQueryVariable(variable) {
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i=0;i<vars.length;i++) {
    var pair = vars[i].split("=");
    if (pair[0] == variable) {
      return pair[1];
    }
  } 
  alert('Query Variable ' + variable + ' not found');
}

 $.getJSON("/daihugo/webresources/Evento/listarPorId/"+getQueryVariable("idEvento"),
function (data) {
    for (var i = 0; i < data.length; i++) {
       document.getElementById("idEvento").value= data[i].idEvento;
       document.getElementById("horaInicio").value = data[i].horaInicio;
       document.getElementById("dataInicio").value = data[i].dataInicio;
       document.getElementById("horaFim").value = data[i].horaFim;
       document.getElementById("dataFim").value = data[i].dataFim;
       document.getElementById("descricao").value = data[i].descricao;
       document.getElementById("nomeCliente").value = data[i].nomeCliente;
       document.getElementById("emailCliente").value = data[i].emailCliente;
       document.getElementById("contactoCliente").value = data[i].contactoCliente;
       document.getElementById("nomeEvento").value= data[i].nomeEvento;
       document.getElementById("estado").value= data[i].estado;
    }
});



</script>

 <script>
                  $('#okEvento').click(function(){
                      history.go(-1);
                  });
                   
</script>


<script>
     $.getJSON("/daihugo/webresources/Recurso/listar",
function (data) {
    for (var i = 0; i < data.length; i++) {
        $('#recursos').append("<option value='"+data[i].idRecurso+"'>"+ data[i].designacao+ "</option>"); // adds item 5 at the end
    }
});
</script>

<script>
     $.getJSON("/daihugo/webresources/Servico/listar",
function (data) {
    for (var i = 0; i < data.length; i++) {
        $('#servicos').append("<option value='"+data[i].idServico+"'>"+ data[i].nome+ "</option>"); // adds item 5 at the end
    }
});
</script>

</body>

</html>

        
