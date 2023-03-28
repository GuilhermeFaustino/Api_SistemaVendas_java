$(function() {
	const bootao = document.querySelector("button");
	const icategoria = document.querySelector(".categoria");
	const icor = document.querySelector(".cor");
	const idepartamento = document.querySelector(".departamento");
	const idescricao = document.querySelector(".descricao");
	const iquantidade = document.querySelector(".quantidade");
	const isku = document.querySelector(".sku");
	const itamanho = document.querySelector(".tamanho");
	const ivalor = document.querySelector(".valor");
	loadLer();

	$("form").submit(function(e) {
		e.preventDefault();
		var form = $(this);
		var formSerialize = form.serialize();
		$.ajax({
			url: "products/cadastro",
			type: 'POST',
			contentType: 'application/json; charset=uft-8',
			data: JSON.stringify({
				categoria: icategoria.value,
				cor: icor.value,
				departamento: idepartamento.value,
				descricao: idescricao.value,
				quantidade: iquantidade.value,
				sku: isku.value,
				tamanho: itamanho.value,
				valor: ivalor.value
			}),
			dataType: 'text',
			beforeSend: function(xhr) {
				form.find("button").after("<span class='load'>Aguarde, carregando...</span>");
				$(".error, .warning, .success").fadeOut(300, function() {
					$(this).remove();
				});
			},
			success: function(response, textStatus, jqXHR) {
				if (response == '1') {
					form.prepend("<span class='warning'>Favor Verificar os Campos: " + response + "</span>");
				} else if (response == '2') {
					form.prepend("<span class='error'>Produto, de SKU Existente!: " + response + "</span>");
				} else if (response == '3') {
					loadLer();
					form.prepend("<span class='success'>Produto, Cadastrado com sucesso!: " + response + "</span>");

				}

			},
			error: function(jqXHR, textStatus, errorThrow) {
				if (textStatus == "error") {
					form.prepend("<span class='error'>Desculpe, erro ao processar Vericar Campos: " + errorThrow + "</span>");
				}
			},
			complete: function(jqXHR, textStatus) {
				form.find(".load").fadeOut(function() {
					$(this).remove();
				});
			}
		});
		
		


	});

	
	edit = {};
	function loadLer() {
		$.ajax({
			url: "products",
			type: 'GET',
			contentType: 'application/json; charset=uft-8',
			dataType: 'html',
			success: function(data) {
				var dados = JSON.parse(data);
				edit = dados;
				let lista = document.querySelector('.lista');
				lista.innerText = "";
				for (i = 0; i < dados.length; i++) {
					let tr = lista.insertRow();					
					let = td_id = tr.insertCell();
					let = td_categoria = tr.insertCell();
					let = td_cor = tr.insertCell();
					let = td_departamento = tr.insertCell();
					let = td_descricao = tr.insertCell();
					let = td_quantidade = tr.insertCell();
					let = td_sku = tr.insertCell();
					let = td_tamanho = tr.insertCell();
					let = td_valor = tr.insertCell();
					let = td_editar = tr.insertCell();
					let = td_excluir = tr.insertCell();

					td_id.innerText = dados[i].id;
					td_categoria.innerText = dados[i].categoria;
					td_cor.innerText = dados[i].cor;
					td_departamento.innerText = dados[i].departamento;
					td_descricao.innerText = dados[i].descricao;
					td_quantidade.innerText = dados[i].quantidade;
					td_sku.innerText = dados[i].sku;
					td_tamanho.innerText = dados[i].tamanho;
					td_valor.innerText = dados[i].valor;

					let btnEdit = document.createElement('button');
					let btnEx = document.createElement('button');

					td_editar.appendChild(btnEdit);
					td_excluir.appendChild(btnEx);


					btnEdit.append('Editar');
					btnEx.append('Excluir');
					btnEdit.classList.add('editProd');
					btnEx.classList.add('excluir');

					td_editar.classList.add('center');
					td_excluir.classList.add('center');
					
					btnEdit.setAttribute("id", dados[i].id);	
				}

			}
		});
	}
	
		
$(this).on('click', '.editProd', function() {
		var id = $(this).attr('id');
		$.ajax({
			url: "products/consult/" + id,
			type: 'GET',
			contentType: 'application/json; charset=uft-8',
			dataType: 'json',
			success: function(datas) {
				//seleciona a categoria
				var select = document.querySelector('.categoria');
				cat = datas.categoria;				
				//seleciona a cor
				var selectCor = document.querySelector('.cor');
				cor = datas.cor;				
				//seleciona a tamanho
				var selectTamanho = document.querySelector('.tamanho');
				tam = datas.tamanho;
				//selciona o departamento
				var selectDep = document.querySelector('.departamento');
				dep = datas.departamento;
								
				
				e_qtd = datas.quantidade
				e_sku = datas.sku;
				e_valor = datas.valor;
				e_desc = datas.descricao;
				
			    var des = document.querySelector('.descricao').value = e_desc;
			    var sku = document.querySelector('.sku').value = e_sku;
			    var valor = document.querySelector('.valor').value = e_valor;
			    var qtd = document.querySelector('.quantidade').value = e_qtd;
			    
			    var putprenche = [];
			    
			    putprenche.push(des, sku, valor, qtd);
			    console.log(putprenche);
			    
				for (var i = 0; i < select.options.length; i++) {
					if (select.options[i].text === cat) {
						select.selectedIndex = i;						
						break;
					}										
				}
				for (var x = 0; x < selectCor.options.length; x++) {
						if (selectCor.options[x].text === cor) {
							selectCor.selectedIndex = x;
							break;
						}
				}
				for (var j = 0; j < selectTamanho.options.length; j++) {
						if (selectTamanho.options[j].text === tam) {
							selectTamanho.selectedIndex = j;
							break;
						}
				}
				for (var a = 0; a < selectDep.options.length; a++) {
						if (selectDep.options[a].text === dep) {
							selectDep.selectedIndex = a;
							break;
						}
				}				
			}
			
		});
	});
	
	
	//editar form
	
});// fim jquery
     



