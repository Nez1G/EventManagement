<?php
require_once('topo.php');
require_once('funcoes.php');
$utilizador = utilizador_ativo($_SESSION['username']);
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
                        <h1 class="page-header">O Meu Perfil</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                        <form role="form" name="formUtilizador" >
                                <?php
                                    while($row = mysqli_fetch_assoc($utilizador)) {
               
                                ?> 
                            <input type="hidden" value="<?php echo $row['id_utilizador']?>" id="idUtilizador"/>

                            <div class="form-group">
                                <label>Função</label>
                                    <select class="form-control" id="tipoUtilizador">

                                    </select>
                            </div>
                            
                            <div class="form-group">
                                <label for="disabledSelect">Nome</label>
                                <input class="form-control" id="nicename" type="text" value="<?php echo $row['nicename']?>" disabled>
                            </div>
                            
                            <div class="form-group">
                                <label>Username</label>
                                <input class="form-control" id="username" value="<?php echo $row['username']?>" disabled>  
                            </div>
                            
                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="password" id="password" value="<?php echo $row['password']?>">  
                            </div>
                            
                            <div class="form-group">
                                <label>E-mail</label>
                                <input class="form-control" id="email" value="<?php echo $row['email']?>">  
                            </div>
                            
                            <div class="form-group">
                                <label>Telemóvel</label>
                                <input class="form-control" id="telemovel" value="<?php echo $row['telemovel']?>">  
                            </div>
                            
                            <div class="form-group">
                                <label for="disabledSelect">Nº Identificação Fiscal</label>
                                <input class="form-control" id="nif" type="text" value="<?php echo $row['nif']?>" disabled>
                            </div>
                                  <?php
           }
        ?>
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
                            window.location.replace("lista_utilizadores.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              console.log(errorThrown);
                         }
                    });
                    
               });
               
               $('#okUtilizador').click(function() {
                 history.go(-1);
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
