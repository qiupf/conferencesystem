package com.noerrorsnowarning.conferencesystem.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Access {

    String[] value() default {};

    String[] auths() default {};

    String[] roles() default {};

}
