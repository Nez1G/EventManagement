<?php
require_once('topo.php');
?>    
<style>
h1{
    color: #337ab7;
}
</style>
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Eventos</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Data</th>
                                        <th>Titulo</th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                       
                                    </tr>
                                </thead>
                                <tbody id="teste">
                                   
                                

                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                           
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

    <!-- DataTables JavaScript -->
    <script src="vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
    
    <script>

 $.getJSON("/daihugo/webresources/Evento/listar",
function (data) {
   
    var tr;
     $("#teste").empty();
    for (var i = 0; i < data.length; i++) {
        tr = $('<tr/>');
        if(data[i].estado == 0) {
            tr.append("<td>" + data[i].dataInicio + "</td>");
            tr.append("<td>" + data[i].nomeEvento + "</td>");
            tr.append("<td>" + "<a href='aprovar_evento.php?idEvento="+data[i].idEvento +"'> Aprovar" + "</td>");
            tr.append("<td>" + "<a onclick='avisoRemover();' href='remover_evento.php?idEvento="+data[i].idEvento +"'> Remover" + "</td>");
            tr.append("<td></td>");
            tr.append("<td bgcolor='#ffff00'>" + "Pendente" + "</td>");
           $('#teste').append(tr);
        } else if(data[i].estado == 1) {
            tr.append("<td>" + data[i].dataInicio + "</td>");
            tr.append("<td>" + data[i].nomeEvento + "</td>");
            tr.append("<td>" + "<a href='info_evento.php?idEvento="+data[i].idEvento +"'> Informação </a>" + "</td>");
            tr.append("<td>" + "<a href='editar_evento.php?idEvento="+data[i].idEvento +"'> Editar </a>" + "</td>");
            tr.append("<td>" + "<a onclick='avisoRemover();' href='remover_evento.php?idEvento="+data[i].idEvento +"'> Remover </a>" + "</td>");
            tr.append("<td bgcolor='#66ff33'>" + "Aprovado" + "</td>");
           $('#teste').append(tr);   
        } else if(data[i].estado == 2) {
            tr.append("<td>" + data[i].dataInicio + "</td>");
            tr.append("<td>" + data[i].nomeEvento + "</td>");
            tr.append("<td>" + "<a href='info_evento.php?idEvento="+data[i].idEvento +"'> Informação </a>" + "</td>");
            tr.append("<td>" + "<a onclick='avisoAtivar();' href='reativar_evento.php?idEvento="+data[i].idEvento +"'> Reativar </a>" + "</td>");
            tr.append("<td>" + "<a onclick='avisoRemover();' href='remover_evento.php?idEvento="+data[i].idEvento +"'> Remover </a>" + "</td>");
            tr.append("<td bgcolor='#ff3300'>" + "Recusado" + "</td>");
           $('#teste').append(tr);  
       } else if(data[i].estado == 3) {
            tr.append("<td>" + data[i].dataInicio + "</td>");
            tr.append("<td>" + data[i].nomeEvento + "</td>");
            tr.append("<td>" + "<a href='info_evento.php?idEvento="+data[i].idEvento +"'> Informação </a>" + "</td>");
            tr.append("<td>" + "<a href='editar_evento.php?idEvento="+data[i].idEvento +"'> Editar </a>" + "</td>");
            tr.append("<td></td>");
            tr.append("<td bgcolor='#ff9900'>" + "Preparação" + "</td>");
           $('#teste').append(tr);  
           
       } else {
            tr.append("<td>" + data[i].dataInicio + "</td>");
            tr.append("<td>" + data[i].nomeEvento + "</td>");
            tr.append("<td>" + "<a href='info_evento.php?idEvento="+data[i].idEvento +"'> Informação </a>" + "</td>");
            tr.append("<td>" + "<a href='avalia_evento.php?idEvento="+data[i].idEvento +"'> Avaliar </a>" + "</td>");
            tr.append("<td></td>");
            tr.append("<td bgcolor='#33ccff'>" + "Terminado" + "</td>");
           $('#teste').append(tr);  
       }
    }
});

    function avisoAtivar () {
        return confirm('Tem a certeza que pretende ativar este evento?');
    }
    
    function avisoRemover () {
        return confirm('Tem a certeza que pretende remover este evento?');
    }
</script>
</body>

</html>