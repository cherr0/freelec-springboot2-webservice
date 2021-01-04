package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  // 스프링 시큐리티 관련 설정들을 활성화시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()     // h2-console 화면을 사용하기 위해 csrf(), headers().frameOptions() 비활성화 함
                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**","/images/**","/js/**","/h20console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")      // 로그아웃이 성공하면 해당 URL로 보냄
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
    /*
    authorizeRequests() : URL별 권한 관리를 설정하는 옵션의 시작점. 이게 있어야 antMatchers 옵션 사용 가능
    antMatchers() : 권한 관리 대상을 지정하는 옵션. URL,Http 메소드별로 관리 가능
    anyRequest() : 설정된 값을 이외 나머지 URL들을 나타냄
    logout().logoutSuccessUrl() : 로그아웃이 성공하면 /로 이동
    oauth2Login() : OAuth2 로그인 기능에 대한 여러 설정의 진입점
     */
}
