/**
 * Classe que irá validar o contato 

 * @author Pedro Duarte
 */

 function validar(){
	 let nome = frmContato.nome.value;
	 let fone = frmContato.fone.value;
	 if(nome === ""){
		 alert("Preencha o campo nome ")
		 frmContato.nome.focus
		return false 
	 }	 
	else if(fone === ""){
		 alert("Preencha o campo fone")
		 frmContato.fone.focus
		 return false
	 }
	 else{
		 document.forms["frmContato"].submit() /* aqui é um método que válida se a função será enviada sem erro de dados no cadastro */
	 }
 }