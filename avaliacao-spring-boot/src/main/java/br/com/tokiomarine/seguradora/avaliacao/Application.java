package br.com.tokiomarine.seguradora.avaliacao;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * BeanApplication da inicializacao do projeto.
 * @author Bruno Alves Justino.
 */
@SpringBootApplication
@EnableJpaRepositories("br.com.tokiomarine.seguradora.avaliacao.repository")
public class Application {

	/**
	 * Utilizado no contexto dos arquivos de mensagens da aplicacao.
	 * @return MessageSource - objeto de mensagem.
	 */
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        return messageSource;
    }

	/**
	 * Utilizado no contexto dos arquivos de mensagens da aplicacao. 
	 * @return LocalValidatorFactoryBean - objeto de valicao spring.
	 */
    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
	
    /**
     * Inicializa a aplicacao.
     * @param args - String[] - parametros de inicializacao da jvm.
     */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}