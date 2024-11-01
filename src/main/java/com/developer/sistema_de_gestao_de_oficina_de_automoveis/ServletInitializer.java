package com.developer.sistema_de_gestao_de_oficina_de_automoveis;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SistemaDeGestaoDeOficinaDeAutomoveisApplication.class);
	}

}
