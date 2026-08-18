package com.example.task_manager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        String descriptionConfig = """
                **INTRODUCTION**\s



                **VERBS**\s




                As such, the API uses http methods as **verbs** as follows:

                * **GET** - To retrieve a resource or list of resources

                * **POST** - To create or update a resource

                * **PUT** - To update a resource

                * **DELETE** - To delete a resource





                **STATUS CODES**



                It also uses http **status codes** in responses to inform about the status of the response. Some usual response status codes and meanings are as follows:

                * _**200**_ - **OK** - the request was successful (some API calls may return 201 or 204 instead).

                 * _**201**_ - **Created** - the request was successful and a resource was created.

                * _**204**_ - **No Content** - the request was successful but there is nothing to return (i.e. an empty list).

                * _**400**_ - **Bad Request** - the request wasn't understood, it was missing required parameters or the parameters didn't pass a validation test.

                * _**401**_ - **Unauthorized** - authentication failed or the user doesn't have permissions for the requested operation.

                * _**403**_ - **Forbidden** - access denied, mainly for an expired token.

                * _**404**_ - **Not Found** - the resource wasn't found or doesn't exists.

                * _**405**_ - **Method not allowed** - the requested method is not supported for the resource. Returned any time you use a http method in a resource that doesn't support it.

                * _**409**_ - **Conflict** -  there was a conflict with the request, i.e. if there is an attempt to create a resource that already exists.

                * _**429**_ - **Too Many Requests** - exceeded API calls request rate limit by a single client. May be returned by any method.

                * _**500**_ - **Internal Server Error** - a generic error message, given when an unexpected condition was encountered and no more specific m May be returned by any method.

                * _**501**_ - **Not Implemented** - the requested method is not implemented.

                * _**503**_ - **Service Unavailable** - service is temporary unavailable (i.i. scheduled maintenance).





                **AUTHENTICATION**\s



                If a method requires authentication it is stated in its reference.


                The API uses [Basic Access Authentication] in the login method. Login method should return a token used in the next methods that require aing to [Bearer Token Authentication].<br/><br/>






                 This document is still a work in progress
                """;

        return new OpenAPI()
                .info(new Info().title("Task Manager API")
                        .description(descriptionConfig)
                        .version("1.0.0"));
    }

    @Bean
    GroupedOpenApi answer(){
        return GroupedOpenApi.builder().group("Task Manager API").pathsToMatch("/**").build();
    }

}

