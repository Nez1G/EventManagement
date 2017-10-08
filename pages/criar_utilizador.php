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
                        <h1 class="page-header">Criar Utilizador</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                         <form role="form" name="formUtilizador" >
                            
                            <div class="form-group">
                                <label>Função</label>
                                    <select class="form-control" id="tipoUtilizador">
                                    </select>
                            </div>                          
                            
                            <div class="form-group">
                               
                                <input placeholder="Nome" class="form-control" id="nicename">  
                            </div>
                            
                            <div class="form-group">

                                <input  placeholder="Username" class="form-control" id="username">  
                            </div>
                            
                            <div class="form-group">
                                <input placeholder="Password" class="form-control" type="password" id="password">  
                            </div>
                            
                            <div class="form-group">
                                <input placeholder="E-mail" class="form-control" id="email">  
                            </div>
                            
                            <div class="form-group">
                                <input placeholder="Telemóvel" class="form-control" id="telemovel">  
                            </div>
                            
                            <div class="form-group">
                                <input placeholder="Nº Identificação Fiscal" class="form-control" id="nif">  
                            </div>
                            
                            
                            
                            <button type="button" id="cancelar" class="btn btn-danger">Voltar</button>
                            <button type="button" class="btn btn-success" id="criarutilizador" onclick = "validarUtilizador()">Criar</button>
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
                  $('#criarutilizador').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
               
                   $.ajax({
                        url: "/daihugo/webresources/Utilizador/criar/".concat($('#nicename').val(),'/',$('#username').val(),'/',$('#password').val(),'/',$('#email').val(),'/',$('#nif').val(),'/',$('#telemovel').val(),'/',$('#tipoUtilizador').val()),
                        method: "POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Utilizador criado com sucesso!");
                            window.location.replace("lista_utilizadores.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              alert("Não foi possível criar o Utilizador!");
                              console.log(errorThrown);
                         }
                    });
                    
               });
               
               $('#cancelar').click(function() {
                   history.go(-1)
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
