package com.jojoldu.book.springboot.config.auth;


import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    /*
    index 메소드 외에 다른 컨트롤러와 메소드에서 세션값이 필요하면 그때마다 직접 세션에서 값을 가져와야 한다.
    같은 코드가 계속되서 반복되는 것은 불필요하다.
    그래서 이 부분을 메소드 인자로 세션값을 바로 받을 수 있도록 변경한다.
     */
}
