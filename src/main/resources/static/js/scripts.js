function actorSelected(select ){
	var index = select.selectedIndex;
	var option = select.options[index];
	var id = option.value;
	var nombre = option.text;
	var urlImagen = option.dataset.url;
	
	console.log("Actor seleccionado:", id, nombre, urlImagen);
	
	option.disabled = true;
	select.selectedIndex = 0;
	
	agregarActor(id, nombre, urlImagen);
	var ids = $("#ids").val();
	 // si ids es igual a " " agrega este id
	if(ids == ""){
		$("#ids").val(id);
	}else{
		//Si ya hay ids concatena
		$("#ids").val(ids + "," + id);
	}
}

function agregarActor(id, nombre, urlImagen){

	var htmlString = `
		<div class="card col-md-3 m-2" style="width: 10rem">
			<img src="{URL-IMAGEN}" class="card-img-top" />
			<div class="card-body">
			<p class="card-text" >{NOMBRE}</p>
			<button class="btn btn-danger" data-id="{ID}" onclick="eliminarActor(this); return false">ELIMINAR</button>
			</div>
		</div> 
		`;
		
		htmlString = htmlString.replace("{URL-IMAGEN}",urlImagen);
		htmlString = htmlString.replace("{NOMBRE}",nombre);
		htmlString = htmlString.replace("{ID}",id);
		
		$("#protagonistas_container").append(htmlString)
}

function eliminarActor(btn){
	var id = btn.dataset.id;
	var node = btn.parentElement.parentElement;
	
	// 1,2,3,4,.10 => [1,2,3,4,.10] => [1,2,4,.10]
	var arrayIds = $("#ids").val().split(",").filter(idActor => idActor != id);
	
	// => "1,2,4,. 10"
	$("#ids").val(arrayIds.join(","));
	
	$("#protagonista option[value='"+id+ "']" ).prop("disabled", false);
	$(node).remove();
}

// Funcion que permitira previsualizar una imagen seleccionada por el usuario
function previsualizador(){
	var reader = new FileReader();

// Se lee el archivo seleccionado en el input
	reader.readAsDataURL(document.getElementById("imagen"). files[0])
	
	reader.onload = function(e){
		var vista = document.getElementById("vista_previa");
		vista.classList.remove("d-none");
		vista.style.backgroundImage = 'url("' + e.target.result + '")';
	}
}







