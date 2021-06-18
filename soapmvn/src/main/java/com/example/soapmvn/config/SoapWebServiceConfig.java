package com.example.soapmvn.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    // register application during startup with particular path
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext cxt){

        MessageDispatcherServlet mt = new MessageDispatcherServlet();
        mt.setApplicationContext(cxt);
        mt.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(mt, "/wss/*");

    }
    @Bean(name = "soap_mvn")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        //defaultWsdl11Definition.setPortTypeName("LoanEligibilityindicator");
        defaultWsdl11Definition.setSchema(userSchema);
        defaultWsdl11Definition.setPortTypeName("UserServicePort");
        defaultWsdl11Definition.setLocationUri("/wss");
        //defaultWsdl11Definition.setTargetNamespace("http://www.javatechie.com/spring/soap/api/loanEligibility");
        defaultWsdl11Definition.setTargetNamespace("http://www.example.com/soap-mvn");
        //defaultWsdl11Definition.setTargetNamespace("http://javatechie.com/soapMvn");

        return defaultWsdl11Definition;

    }

    @Bean
    public XsdSchema userSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
    }


}
