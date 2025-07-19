function actorSelected(select ){
	var index = select.selectedIndex;
	var option = select.options[index];
	var id = option.value;
	var nombre = option.text;
	var urlImagen = option.sataset.url;
	
	option.disabled = "true";
	select.selectedIndex = 0;
	
	var ids = $("#ids").val();
	
	if(ids == ""){
		$("#ids").val(id);
	}else{
		$("#ids").val(ids + "," + id);
	}
}

function agregarActor(id, nombre, urlImagen){
	
}