<?php
require_once('topo.php');
?>
<style>
h1{
    color: #337ab7;
}
</style>
<script type="text/javascript">

    function devolve_morada() {
        var codigopostal = document.getElementById("codigo_postal").value;
        var xhr = new XMLHttpRequest();
        xhr.open('GET', 'codigospostais.php?codigo_postal=' + codigopostal);
        xhr.send(null);
        
        xhr.onreadystatechange = function () {
            var DONE = 4; // readyState 4 means the request is done.
            var OK = 200; // status 200 is a successful return.
            if (xhr.readyState === DONE) {
                if (xhr.status === OK) 
                var teste = xhr.responseText; 
                document.getElementById("morada").innerHTML = teste;
                } else {
                    console.log('Error: ' + xhr.status); // An error occurred during the request.
                }
            if(teste == "undefined") {
            
            } else {
                
            }
        }
    }
    ;
</script>
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- TÍTULO -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Criar Local</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                        <form role="form" name="formRecurso">
                            
                            <div class="form-group">
                                <input placeholder="Nome do Local" class="form-control" id="nome">  
                            </div>
                            
                            <div class="form-group">

                                <input placeholder="Código-Postal" type="text" name="codigo_postal" id="codigo_postal" class="form-control" value="" onchange="devolve_morada()">
                                <span class="erro_form" id="validar"></span>
                                <br><br>
                                <label>Morada</label>
                                 <select name="morada" id="morada" class="form-control">

                                 </select>
                            </div>
                            <br>
                            <button type="button" id="cancelar" class="btn btn-danger">Voltar</button>
                            <button type="button" class="btn btn-success" id="criarlocal" onclick="validarLocais()">Criar</button>
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
                  $('#criarlocal').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
               
                   $.ajax({
                        url: "/daihugo/webresources/Local/criar/".concat($('#nome').val(),'/',$('#coordenadaX').val(),'/',$('#coordenadaY').val(),'/',$('#morada').val()),
                        method: "POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Local criado com sucesso!");
                            window.location.replace("dashboard.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              alert("Não foi possível criar o local!");
                              console.log(errorThrown);
                         }
                    });
                    
               });
               
               $('#cancelar').click(function() {
                   history.go(-1)
               });
               
    </script>

    <!-- FIM JAVASCRIPT -->

</body>

</html>
