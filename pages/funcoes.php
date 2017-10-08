<?php
require_once 'dbconnect.php';

function redirect($url){
    header("Location: $url");
}

function ligar_base_dados(){    
    $ligacao = Connect();
    return $ligacao;
}

function utilizador_valido($username, $password){
    $ligacao = ligar_base_dados();   
    $username = mysqli_real_escape_string($ligacao, $username);
    $password = mysqli_real_escape_string($ligacao, $password);
    $expressao = "SELECT * FROM Utilizador WHERE username='$username' AND password='$password' AND visivel = 1 ";
    $resultado = mysqli_query($ligacao, $expressao);
    $valor_retorno = false;      
    
    if (mysqli_num_rows($resultado) > 0){
        $dados = mysqli_fetch_assoc($resultado);           
        $valor_retorno = ($dados['password'] == $password);            
    }
    
    mysqli_free_result($resultado);
    mysqli_close($ligacao);              
    
    return $valor_retorno;
}

function utilizador_ativo($valor1) {

    $ligacao = ligar_base_dados();
    
    $query = "SELECT * FROM Utilizador WHERE username = '$valor1'";
    
    $resultado = mysqli_query($ligacao, $query);
    
    
    return $resultado;
}


?>
