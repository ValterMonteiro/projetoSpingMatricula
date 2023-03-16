package br.edu.ifms.matricula.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.matricula.controller.dto.EstudanteRequest;
import br.edu.ifms.matricula.model.dto.EstudanteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/estudante")
@Tag(name = "Aluno", description = "Gerenciamento de estudantes")

public class EstudanteController {

	@GetMapping
	public ResponseEntity<String> olamundo() {
		return ResponseEntity.ok("Ola mundo");
	}

	@Operation(summary = "Novo recurso", description = "Serviço para cadastrar um recurso")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", 
					description = "Operação de sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstudanteResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha no serviço", content = @Content) })

	@PostMapping
	public ResponseEntity<EstudanteResponse> create(@RequestBody EstudanteRequest estudanteRequest) {
		EstudanteResponse estudante = new EstudanteResponse();
		estudante.setNome(estudanteRequest.getNome());
		estudante.setCpf(estudanteRequest.getCpf());
		estudante.setEmail(estudanteRequest.getEmail());
		estudante.setId(UUID.randomUUID());

		return ResponseEntity.ok(estudante);
	}

}
