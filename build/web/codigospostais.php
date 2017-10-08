<?php
require_once 'dbconnect.php';
require_once 'funcoes.php';
$ligacao = ligar_base_dados();

$codigo_postal = $_GET['codigo_postal'];
	
$query = "SELECT art_tipo, pri_prep, art_titulo, seg_prep, art_desig, art_local, localidade FROM CodigoPostal WHERE concat(cp4,'-',cp3) = '$codigo_postal'";
	
$resultado = mysqli_query($ligacao , $query);
        

while($row= mysqli_fetch_array($resultado)) {
    echo utf8_encode('<option value="'. $row['art_tipo'] .' '.$row['pri_prep'].' '.$row['art_titulo'].' '.$row['seg_prep'].' '.$row['art_desig'].' '.$row['art_local'].' , '.$row['localidade'].'">' . $row['art_tipo'] .' '.$row['pri_prep'].' '.$row['art_titulo'].' '.$row['seg_prep'].' '.$row['art_desig'].' '.$row['art_local'].' , '.$row['localidade'].'</option>');
}
?>