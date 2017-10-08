<?php
require_once 'topo.php';

$utilizador_ativo = $_SESSION['username'];
?>

<style>
    .marquee{
        border:none; 
        padding:0; 
        margin:0;
    }
    

h1{
    color: #337ab7;
}

</style>

        <div id="page-wrapper">
            <!-- TÍTULO -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Bem-vindo(a), <?php echo $utilizador_ativo; ?></h1>
                </div>
            </div>
            <!-- FIM TÍTULO -->
            
            <!-- CORPO -->
            <div class="row">
                <img src="img/fotoCamara.png" width="100%">
            </div>
            
            <br>
            
                <div style="float:left;">
                 <table height="55" width="100%" border="0" cellpadding="0" cellspacing="10">

 <tr>
 <td style="padding: 0px 10px 0px 5px;" align="left"><a target="_blank" href="http://www.famalicaomadein.pt"><img src="http://www.vilanovadefamalicao.org/op/image/?co=90379&amp;h=d2957" alt="Famalicão Made IN" title="Famalicão Made IN" height="32" width="92" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a target="_blank" href="http://albertosampaio.no-ip.org"><img src="http://www.vilanovadefamalicao.org/op/image/?co=80852&amp;h=88d9e" alt="Arquivo Alberto Sampaio" title="Arquivo Alberto Sampaio" height="35" width="45" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a target="_blank" href="http://www.bibliotecacamilocastelobranco.org"><img src="http://www.vilanovadefamalicao.org/op/image/?co=54197&amp;h=a48f0" alt="Biblioteca Municipal Camilo Castelo Branco" title="Biblioteca Municipal Camilo Castelo Branco" height="35" width="42" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a href="http://www.camilocastelobranco.org" target="_blank"><img src="http://www.vilanovadefamalicao.org/op/image/?co=56993&amp;h=9e089" alt="Casa-Museu Camilo Castelo Branco" title="Casa-Museu Camilo Castelo Branco" height="35" width="38" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a target="_blank" href="http://www.casadasartes.org"><img src="http://www.vilanovadefamalicao.org/op/image/?co=54196&amp;h=5f6a9" alt="Casa das Artes" title="Casa das Artes" height="35" width="32" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a href="http://www.bernardinomachado.org" target="_blank"><img src="http://www.vilanovadefamalicao.org/op/image/?co=56994&amp;h=c4024" alt="Museu Bernardino Machado" title="Museu Bernardino Machado" height="35" width="38" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a href="http://www.museudaindustriatextil.org" target="_blank"><img src="http://www.vilanovadefamalicao.org/op/image/?co=54200&amp;h=a9ea4" alt="Museu da Indústria Textil" title="Museu da Indústria Textil" height="35" width="31" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a target="_blank" href="http://famalicaoid.inwebonline.net/"><img src="http://www.vilanovadefamalicao.org/op/image/?co=86198&amp;h=460ca" alt="Famalicão ID" title="Famalicão ID" height="35" width="88" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a href="http://www.juventudefamalicao.org" target="_blank"><img src="http://www.vilanovadefamalicao.org/op/image/?co=99779&amp;h=5f413" alt="Portal da Juventude" title="Portal da Juventude" height="35" width="35" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a href="http://arqueologia.vilanovadefamalicao.org" target="_blank"><img src="http://www.vilanovadefamalicao.org/op/image/?co=54202&amp;h=a416d" alt="Portal da Arqueologia" title="Portal da Arqueologia" height="35" width="36" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a target="_blank" href="http://www.vilanovadefamalicao.org/redesocial"><img src="http://www.vilanovadefamalicao.org/op/image/?co=54201&amp;h=f5161" alt="Rede Social Famalicão" title="Rede Social Famalicão" height="35" width="44" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a target="_blank" href="http://www.parquedadevesa.com"><img src="http://www.vilanovadefamalicao.org/op/image/?co=74244&amp;h=8dba5" alt="Parque da Devesa Famalicão" title="Parque da Devesa Famalicão" height="35" width="40" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a target="_blank" href="http://81.90.61.41:2222/correfamalicao"><img src="http://www.vilanovadefamalicao.org/op/image/?co=90378&amp;h=37739" alt="Corre Famalicão" title="Corre Famalicão" height="35" width="35" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 10px 0px 10px;" align="left"><a target="_blank" href="http://voluntariado.vilanovadefamalicao.org"><img src="http://www.vilanovadefamalicao.org/op/image/?co=82562&amp;h=68209" alt="Banco Local de Voluntariado Famalicão" title="Banco Local de Voluntariado Famalicão" height="35" width="35" border="0"/></a></td>
 <td style="border-left: 1px dotted rgb(190, 190, 190);" width="1"><img src="http://www.vilanovadefamalicao.org/op/image/?co=63244&amp;h=42b01" height="1" width="1" border="0"/></td>
 <td style="padding: 0px 5px 0px 10px;" align="left"><a target="_blank" href="http://www.quadrilatero.eu"><img src="http://www.vilanovadefamalicao.org/op/image/?co=90377&amp;h=b72e8" alt="Quadrilátero Cultural" title="Quadrilátero Cultural" height="35" width="35" border="0"/></a></td>
 </tr>
                 </table>         
  <br>          
 <marquee behavior="scroll" direction="left">Fábio Carmo | João Costa | Wilson Dias | Francisco Marques | André Sousa | Eduardo Pereira | Tiago Pereira | Hugo Ferreira | Catarina Freitas | Joana Pinto | Manuel Sousa | André Gonçalves | Rui Duarte | Filipe Bravo | 
     Nuno Fernandes | José Carlos | Francisco Silva | Inês Pereira | João Azevedo | Carlos Castro | Fábio Carmo | João Costa | Wilson Dias | Francisco Marques | André Sousa | Eduardo Pereira | Tiago Pereira | Hugo Ferreira | Catarina Freitas | Joana Pinto | Manuel Sousa | André Gonçalves | Rui Duarte | Filipe Bravo | Nuno Fernandes | José Carlos | Francisco Silva | Inês Pereira | João Azevedo | Carlos Castro | Fábio Carmo | João Costa | Wilson Dias | Francisco Marques | André Sousa | Eduardo Pereira | Tiago Pereira | Hugo Ferreira | Catarina Freitas | Joana Pinto | Manuel Sousa | André Gonçalves | Rui Duarte | Filipe Bravo | Nuno Fernandes | José Carlos | Francisco Silva | Inês Pereira | João Azevedo | Carlos Castro |</marquee>
 <br>
 <br>
 
                </div>
            <!-- FIM CORPO -->
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

    <!-- FIM JAVASCRIPT -->

</body>

</html>
