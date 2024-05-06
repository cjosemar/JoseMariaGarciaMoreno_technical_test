package org.example.inditex.infraestructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Technical Test for Inditex",
                description = """
                    Build an application/service in SpringBoot that provides a rest query endpoint such that:
                    \s
                    Accept as input parameters: application date, product identifier, string identifier. Return as output data:
                    product identifier, chain identifier, rate to apply, application dates and final price to apply.
                    \s
                    You must use an in-memory database (type h2) and initialize with the data from the example
                    (you can change the name of the fields and add new ones if you want, choose the data type that is considered appropriate for them ).
                """,
                contact = @Contact(
                        name = "José María García Moreno",
                        email = "cjosemar@gmail.com",
                        url = "https://www.linkedin.com/in/jos%C3%A9-mar%C3%ADa-g-99659a1a4/"
                ))
)
public class OpenApiConfig {
}