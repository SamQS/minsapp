function eliminarUsuario(id) {
	swal({
		title: "Estas seguro de Eliminar?",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				
				$.ajax({
					url:"/delete/"+id,
					success: function(res){
						console.log(res);
					}
				});
				
				swal("Se elimino el registro con exito!", {
					icon: "success",
				}).then((ok) =>{
					if(ok){						
						location.href="/listar";
					}
				});
			} else {
				swal("No se elimino nada!");
			}
		});

}


function eliminarServicio(id) {
	swal({
		title: "Estas seguro de Eliminar?",
		text: "Una vez eliminado, no podrá recuperar este registro!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				
				$.ajax({
					url:"/deleteServicio/"+id,
					success: function(res){
						console.log(res);
					}
				});
				
				swal("Poof! Tu registro fue eliminado!", {
					icon: "success",
				}).then((ok) =>{
					if(ok){						
						location.href="/listarServicios";
					}
				});
			} else {
				swal("Your imaginary file is safe!");
			}
		});

}


function eliminarCentro(id) {
	swal({
		title: "Estas seguro de Eliminar?",
		text: "Once deleted, you will not be able to recover this imaginary file!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				
				$.ajax({
					url:"/deleteCentro/"+id,
					success: function(res){
						console.log(res);
					}
				});
				
				swal("Poof! Your imaginary file has been deleted!", {
					icon: "success",
				}).then((ok) =>{
					if(ok){						
						location.href="/listarCentros";
					}
				});
			} else {
				swal("Your imaginary file is safe!");
			}
		});

}


