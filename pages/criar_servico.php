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
                        <h1 class="page-header">Criar Serviço</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                        <form role="form" name="formServico" >
                            
                            <div class="form-group">
                                <input placeholder="Nome do Serviço" class="form-control" id="nome">  
                            </div>
                            
                            <div class="form-group">
                                <input placeholder="E-mail" class="form-control" id="email">  
                            </div>
                            
                            <div class="form-group">
                                <input placeholder="Contacto" class="form-control" id="contacto">  
                            </div>
                            <br>
                            <button type="button" id="cancelar" class="btn btn-danger">Voltar</button>
                            <button type="button" class="btn btn-success" id="criarservico" onclick = "validarServico()">Criar</button>
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
                  $('#criarservico').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
               
                   $.ajax({
                        url: "/daihugo/webresources/Servico/criar/".concat($('#nome').val(),'/',$('#email').val(),'/',$('#contacto').val()),
                        method: "POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Serviço criado com Sucesso!");
                            window.location.replace("lista_servicos.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                             alert("Não foi possível criar o serviço!");
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