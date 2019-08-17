package com.adsddm.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adsddm.apirest.repository.MedicoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.adsddm.apirest.models.Medico;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Medicos")
@CrossOrigin(origins="*")
public class MedicoResource {
	
	@Autowired
	MedicoRepository medicoRepository;
	
	@ApiOperation(value="Mostra uma lista de medico")
	@GetMapping("/medicos")
	public List<Medico> listaMedicos(){
		return medicoRepository.findAll();
	}
	
	@ApiOperation(value="Mostra um unico medico")
	@GetMapping("/medico/{id}")
	public Medico listaMedicoUnico(@PathVariable(value="id") long id){
		return medicoRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um medico")
	@PostMapping("/medico")
	public Medico salvarMedico(@RequestBody @Valid Medico medico) {
		return medicoRepository.save(medico);
	}
	
	@ApiOperation(value="Deleta um medico")
	@DeleteMapping("/medico")
	public void deletarMedico(@RequestBody @Valid Medico medico) {
		medicoRepository.delete(medico);
	}
	
	@ApiOperation(value="Atualiza um medico")
	@PutMapping("/medico")
	public Medico atualizarMedico(@RequestBody @Valid Medico medico) {
		return medicoRepository.save(medico);
	}

}
