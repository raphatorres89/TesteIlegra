package com.rct.ilegra.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.rct.ilegra.entities.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositorryTest {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String CNPJ = "12345678901234";
	
	@Before
	public void setUp() {
		Empresa empresa = new Empresa();
		empresa.setCnpj(CNPJ);
		empresa.setRazaoSocial("Empresa Teste");
		empresaRepository.save(empresa);
	}
	
	@After
	public void tearDown() {
		empresaRepository.deleteAll();
	}
	
	@Test
	public void buscarPorCnpj() {
		Empresa empresa = empresaRepository.findByCnpj(CNPJ);
		
		assertEquals(CNPJ, empresa.getCnpj());
	}
}
