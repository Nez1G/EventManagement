function validarEvento(){
        if (document.formEvento.nomeEvento.value=="")
	{
	alert(" O campo Título é de preenchimento obrigatório.");
	document.formEvento.nomeEvento.focus();
	document.formEvento.nomeEvento.select();
	return false;
	}

        if (document.formEvento.nomeCliente.value=="")
	{
	alert(" O campo Nome do Cliente é de preenchimento obrigatório.");
	document.formEvento.nomeCliente.focus();
	document.formEvento.nomeCliente.select();
	return false;
	}

        var x = document.forms["formEvento"]["emailCliente"].value;
        var atpos = x.indexOf("@");
        var dotpos = x.lastIndexOf(".");
        if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
            alert("E-mail inválido");
            return false;
        }
        
        if (document.formEvento.contactoCliente.value=="" || document.formEvento.contactoCliente.value.length < 9 || document.formEvento.contactoCliente.value.length > 9)
	{
	alert(" O campo telemóvel do Cliente é de preenchimento obrigatório.");
	document.formEvento.contactoCliente.focus();
	document.formEvento.contactoCliente.select();
	return false;
	}
        
        if (document.formEvento.dataInicio.value=="")
	{
	alert(" O campo data de início é de preenchimento obrigatório.");
	document.formEvento.dataInicio.focus();
	document.formEvento.dataInicio.select();
	return false;
	}
	
        if (document.formEvento.dataFim.value=="")
	{
	alert(" O campo data de fim é de preenchimento obrigatório.");
	document.formEvento.dataFim.focus();
	document.formEvento.dataFim.select();
	return false;
	}
        
        if (document.formEvento.horaInicio.value=="")
	{
	alert(" O campo hora de início é de preenchimento obrigatório.");
	document.formEvento.horaInicio.focus();
	document.formEvento.horaInicio.select();
	return false;
	}
        
        if (document.formEvento.horaFim.value=="")
	{
	alert(" O campo hora de fim é de preenchimento obrigatório.");
	document.formEvento.horaFim.focus();
	document.formEvento.horaFim.select();
	return false;
	}
        
       if (document.formEvento.descricao.value=="")
	{
	alert(" A descrição é de preenchimento obrigatório.");
	document.formEvento.descricao.focus();
	document.formEvento.descricao.select();
	return false;
	}
	
return true;
}    


function validarUtilizador(){
        if (document.formUtilizador.nicename.value=="")
	{
	alert(" O campo Nome é de preenchimento obrigatório.");
	document.formUtilizador.nicename.focus();
	document.formUtilizador.nicename.select();
	return false;
	}

        if (document.formUtilizador.username.value=="")
	{
	alert(" O campo Username é de preenchimento obrigatório.");
	document.formUtilizador.username.focus();
	document.formUtilizador.username.select();
	return false;
	}

        if (document.formUtilizador.password.value=="")
	{
	alert(" O campo password é de preenchimento obrigatório.");
	document.formUtilizador.password.focus();
	document.formUtilizador.password.select();
	return false;
	}
        
        var x = document.forms["formUtilizador"]["email"].value;
        var atpos = x.indexOf("@");
        var dotpos = x.lastIndexOf(".");
        if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
            alert("E-mail inválido");
            return false;
        }
        
        if (document.formUtilizador.telemovel.value=="" || document.formUtilizador.telemovel.value.length < 9 || document.formUtilizador.telemovel.value.length > 9)
	{
	alert(" O campo telemóvel é de preenchimento obrigatório.");
	document.formUtilizador.telemovel.focus();
	document.formUtilizador.telemovel.select();
	return false;
	}
	
        if (document.formUtilizador.nif.value=="" || document.formUtilizador.nif.value.length < 9 || document.formUtilizador.nif.value.length > 9)
	{
	alert(" O campo NIF é de preenchimento obrigatório.");
	document.formUtilizador.nif.focus();
	document.formUtilizador.nif.select();
	return false;
	}
	
return true;
}   

function validarRecurso(){
        if (document.formRecurso.designacao.value=="")
	{
	alert(" O campo Nome é de preenchimento obrigatório.");
	document.formRecurso.designacao.focus();
	document.formRecurso.designacao.select();
	return false;
	}

        if (document.formRecurso.quantidade.value=="")
	{
	alert(" O campo Quantidade é de preenchimento obrigatório.");
	document.formRecurso.quantidade.focus();
	document.formRecurso.quantidade.select();
	return false;
	}

        if (document.formRecurso.valorunitario.value=="")
	{
	alert(" O campo valor monetário é de preenchimento obrigatório.");
	document.formRecurso.valorunitario.focus();
	document.formRecurso.valorunitario.select();
	return false;
	}
	
return true;
}   

function validarServico(){
        if (document.formServico.nome.value=="")
	{
	alert(" O campo Nome é de preenchimento obrigatório.");
	document.formServico.nome.focus();
	document.formServico.nome.select();
	return false;
	}

        var x = document.forms["formServico"]["email"].value;
        var atpos = x.indexOf("@");
        var dotpos = x.lastIndexOf(".");
        if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
            alert("E-mail inválido");
            return false;
        }

        if (document.formServico.contacto.value=="" || document.formServico.contacto.value.length < 9 || document.formServico.contacto.value.length > 9)
	{
	alert(" O campo contacto é de preenchimento obrigatório.");
	document.formServico.contacto.focus();
	document.formServico.contacto.select();
	return false;
	}
	
return true;
}    

function validarTipoEvento(){
        if (document.formTipoEvento.designacao.value=="")
	{
	alert(" O campo Nome é de preenchimento obrigatório.");
	document.formTipoEvento.designacao.focus();
	document.formTipoEvento.nome.select();
	return false;
	}
return true;
}

function validarLocais(){
        if (document.formLocais.nome.value=="")
	{
	alert(" O campo Nome é de preenchimento obrigatório.");
	document.formLocais.nome.focus();
	document.formLocais.nome.select();
	return false;
	}
        
        if (document.formLocais.coordenadaX.value=="")
	{
	alert(" O campo Latitude é de preenchimento obrigatório.");
	document.formLocais.coordenadaX.focus();
	document.formLocais.coordenadaX.select();
	return false;
	}
        
        if (document.formLocais.coordenadaY.value=="")
	{
	alert(" O campo Longitude é de preenchimento obrigatório.");
	document.formLocais.coordenadaY.focus();
	document.formLocais.coordenadaY.select();
	return false;
	}
        
        if (document.formLocais.morada.value=="")
	{
	alert(" O campo morada é de preenchimento obrigatório.");
	document.formLocais.morada.focus();
	document.formLocais.morada.select();
	return false;
	}
        
return true;
}

function validarFeedback(){
        if (document.formFeedback.nome.value=="")
	{
	alert(" O campo Observação é de preenchimento obrigatório.");
	document.formFeedback.observacao.focus();
	document.formFeedback.observacao.select();
	return false;
	}
        
return true;
}
