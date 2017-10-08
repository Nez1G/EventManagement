<?php
require_once('topo.php');
?>
<style>
h1{
    color: #337ab7;
}
</style>
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- TÍTULO -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Editar Utilizador</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                        <form role="form" name="formUtilizador" >
                            <input type="hidden" id="idUtilizador"/>

                            <div class="form-group">
                                <label>Função</label>
                                    <select class="form-control" id="tipoUtilizador">

                                    </select>
                            </div>
                            
                            <div class="form-group">
                                <label for="disabledSelect">Nome</label>
                                <input class="form-control" id="nicename" type="text" disabled>
                            </div>
                            
                            <div class="form-group">
                                <label>Username</label>
                                <input class="form-control" id="username" disabled>  
                            </div>
                            
                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="password" id="password" disabled>  
                            </div>
                            
                            <div class="form-group">
                                <label>E-mail</label>
                                <input class="form-control" id="email" disabled>  
                            </div>
                            
                            <div class="form-group">
                                <label>Telemóvel</label>
                                <input class="form-control" id="telemovel" disabled>  
                            </div>
                            
                            <div class="form-group">
                                <label for="disabledSelect">Nº Identificação Fiscal</label>
                                <input class="form-control" id="nif" type="text"  disabled>
                            </div>
                            
                            <button type="button" class="btn btn-success" id="editarUtilizador" onclick = "validarUtilizador()">Alterar</button>
                            
                            <button type="button" class="btn btn-primary" id="okUtilizador">Voltar</button>
                        </form>
                    </div>
                </div>
                <!-- FIM CORPO -->
            </div>
        </div>
    </div>

    <!-- JAVASCRIPT -->

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>
    
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

 $.getJSON("/daihugo/webresources/Utilizador/listarUtilizadorPorId/"+getQueryVariable("idUtilizador"),
function (data) {
    for (var i = 0; i < data.length; i++) {
       document.getElementById("idUtilizador").value= data[i].idUtilizador;
       document.getElementById("nicename").value = data[i].nicename;
       document.getElementById("username").value = data[i].username;
       document.getElementById("password").value = data[i].password;
       document.getElementById("email").value = data[i].email;
       document.getElementById("nif").value = data[i].nif;
       document.getElementById("telemovel").value = data[i].telemovel;
     }
});
                  $('#editarUtilizador').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
               
                   $.ajax({
                        url: "/daihugo/webresources/Utilizador/editar/".concat($('#idUtilizador').val(),'/',$('#nicename').val(),'/',$('#username').val(),'/',$('#password').val(),'/',$('#email').val(),'/',$('#nif').val(),'/',$('#telemovel').val(),'/',$('#tipoUtilizador').val()),
                        method: "POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Função editada com sucesso!");
                            window.location.replace("lista_utilizadores.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              alert("Não foi possível editar a função!");
                              console.log(errorThrown);
                         }
                    });
                    
               });
               
               $('#okUtilizador').click(function() {
                   hitory.go(-1)
               });
        </script>
        
        <script>
     $.getJSON("/daihugo/webresources/TipoUtilizador/listar",
function (data) {
    for (var i = 0; i < data.length; i++) {
        $('#tipoUtilizador').append("<option value='"+data[i].idTipoUtilizador+"'>"+ data[i].designacao+ "</option>"); // adds item 5 at the end
    }
});
</script>
    <!-- FIM JAVASCRIPT -->

</body>

</html>
