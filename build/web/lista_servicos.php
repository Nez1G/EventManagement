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
                        <h1 class="page-header">Serviços</h1>
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
                                        <th>Nome</th>
                                        <th>E-mail</th>
                                        <th>Telemóvel</th>
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

 $.getJSON("/daihugo/webresources/Servico/listar",
function (data) {
    var tr;
     $("#teste").empty();
    for (var i = 0; i < data.length; i++) {
        tr = $('<tr/>');
       
        tr.append("<td>" + data[i].nome + "</td>");
        tr.append("<td>" + data[i].email + "</td>");
        tr.append("<td>" + data[i].contacto + "</td>");
        tr.append("<td>" + "<a href='info_servico.php?idServico="+data[i].idServico +"'> Informação </a>" + "</td>");
        tr.append("<td>" + "<a href='editar_servico.php?idServico="+data[i].idServico +"'> Editar </a>" + "</td>");
        tr.append("<td onclick='avisoRemover();'>" + "<a href='remover_servico.php?idServico="+data[i].idServico +"'> Remover </a>" + "</td>");
      //  tr.append("<td>" + data[i].team + "</td>");
       $('#teste').append(tr);
    }
});

    function avisoAtivar () {
        return confirm('Tem a certeza que pretende ativar este serviço?');
    }
    
    function avisoRemover () {
        return confirm('Tem a certeza que pretende remover este serviço?');
    }
</script>
</body>

</html>