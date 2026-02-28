package com.algaworks.algafood;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.ContenteFromResources;
import com.algaworks.algafood.util.DatabaseCleaner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
class CadastroCozinhaIT {
	
	private static final int _COZINHA_ID_INEXISTENTE = 100;

	@LocalServerPort
	private int port;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	private String nomeCozinhaExistente;
	private Long idCozinhaExistente;
	private int qtdeCozinhacadastradas;
	private String jsonCorretoCozinhaChinesa;


    @BeforeEach
    void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";
		
		databaseCleaner.clearTables();
		preparaDados();
		
		jsonCorretoCozinhaChinesa = ContenteFromResources.getContentFromResource(
				"/jsons/cozinha-chinesa.json");
		
	}
	
	private void preparaDados() {
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);
		
		idCozinhaExistente = cozinha1.getId();
		nomeCozinhaExistente = cozinha1.getNome();
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Americana");
		cozinhaRepository.save(cozinha2);
		
		
		qtdeCozinhacadastradas = (int) cozinhaRepository.count();
		
	}

    @Test
    void deveRetornarRespostaEStatusCorretos_quandoConsultarCozinahExistente() {
		given()
			.pathParam("cozinhaId", idCozinhaExistente)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.SC_OK)
			.body("nome", equalTo(nomeCozinhaExistente));
	}

    @Test
    void deveRetornarRespostaEStatus404_quandoConsultarCozinahInexistente() {
		given()
			.pathParam("cozinhaId", _COZINHA_ID_INEXISTENTE)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.SC_NOT_FOUND);
	}


    @Test
    void deveRetornarStatus200_quandoConsultarCozinha() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.SC_OK);
	}


    @Test
    void deveRetornarNumerodeQuantidadesReferentesDeCozinhas_QuandoConsultaCozinhas() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.body("", Matchers.hasSize(qtdeCozinhacadastradas));
	}

    @Test
    void deveRetornarStatus201_quandoCadastrarCozinha() {
		given()
			.body(jsonCorretoCozinhaChinesa)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.SC_CREATED);
	}
	
	
	

}
