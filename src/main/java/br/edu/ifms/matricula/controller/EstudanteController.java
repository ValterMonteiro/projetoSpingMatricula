package br.edu.ifms.matricula.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.matricula.controller.dto.EstudanteRequest;
import br.edu.ifms.matricula.controller.dto.EstudanteResponse;
import br.edu.ifms.matricula.controller.mapper.EstudanteMapper;
import br.edu.ifms.matricula.model.dto.EstudanteDto;
import br.edu.ifms.matricula.model.entities.Estudante;
import br.edu.ifms.matricula.model.services.EstudanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estudante")
@Tag(name = "Estudante", description = "Gerenciamento de estudantes")
public class EstudanteController {
	
	private final EstudanteService estudanteService;
	
	public EstudanteController(EstudanteService estudanteService) {
		this.estudanteService = estudanteService;
	}
	
	@GetMapping
	public ResponseEntity<String> olamundo() {
		return ResponseEntity.ok("Ola mundo");
	}
	
	@Operation(summary = "Novo recurso", description = "Serviço para cadastrar um recurso")
	@ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Operação de sucesso",
          content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = EstudanteResponse.class))),
      @ApiResponse(responseCode = "500", description = "Falha no serviço", content = @Content)
	})
	@PostMapping
	public ResponseEntity<EstudanteResponse> create(
			@RequestBody @Valid EstudanteRequest estudanteRequest ) {
		
		EstudanteDto estudanteDto = EstudanteMapper.requestToDto(estudanteRequest);
		EstudanteDto estudanteDto2 = estudanteService.create(estudanteDto);
		
		EstudanteResponse estudanteResponse = EstudanteMapper.dtoToResponse(estudanteDto2);
		return ResponseEntity.ok(estudanteResponse);
	}
	
	@Operation(sumary = "Atualizar recurso", description = "Serviço atualizar um recurso")
	
	@ApiResponses(value = {
	
			@ApiResponse(responseCode = "200" , description = "Operação de sucesso" , content = @Content(mediaType = "application/json",
			schema=@Schema(implementation = EstudanteResponse.class))),
			
	
			@ApiResponse(responseCode = "400" , description = "Solicitação incorreta" , content = @Content(mediaType = "application/json",
			schema=@Schema(implementation = EstudanteResponse.class))),
			

			@ApiResponse(responseCode = "404" , description = "Recurso não encontrado" , content = @Content(mediaType = "application/json",
			schema=@Schema(implementation = EstudanteResponse.class))),
			

			@ApiResponse(responseCode = "500" , description = "Falha no serviço" , content = @Content(mediaType = "application/json",
			schema=@Schema(implementation = EstudanteResponse.class)))
		})
	
		
	@PutMapping("/{id}")
	public ResponseEntity<EstudanteResponse> update(@PathVariable UUID id, @RequestBody @Valid EstudanteRequest estudanteRequest)
	
	EstudanteDto estudanteDto = EstudanteMapper.requestToDto(estudanteRequest);
	EstudanteDto estudanteDto2 = EstudanteService.update(id, estudanteDto);
	EstudanteResponse estudanteResponse = EstudanteMapperToResponse(estudanteDto2);
	
	return ResponseEntity.ok(estudanteResponse);
	
}
