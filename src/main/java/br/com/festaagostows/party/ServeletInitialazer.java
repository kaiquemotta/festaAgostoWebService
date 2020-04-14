package br.com.festaagostows.party;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import br.com.festaagostows.FestaagostoWsApplication;

public class ServeletInitialazer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FestaagostoWsApplication.class);
	}
}
