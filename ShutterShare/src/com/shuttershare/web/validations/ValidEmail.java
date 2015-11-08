package com.shuttershare.web.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;



/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: ValidEmail class 

*/



// interface that is used to create a custom SpringFramework Email annotation used to validate email addresses. 
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = com.shuttershare.web.validations.ImplValidEmail.class)
public @interface ValidEmail {

	String message() default "This does not appear to be a valid email address";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	int min() default 5;
}
