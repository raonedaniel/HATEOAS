package br.senaigo.mobile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class JaxbMarshallerXML {
	
	static String PACKAGE_DOMAIN="br.senaigo.mobile";
	
	@Bean
	public Jaxb2Marshaller marshaller() throws Exception
	{
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	    marshaller.setPackagesToScan(PACKAGE_DOMAIN);
	    return marshaller;
	}
}
