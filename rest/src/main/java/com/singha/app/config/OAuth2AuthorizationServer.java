package com.singha.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
	
	@Value("${security.jwt.clientId}")
	private String clientId;

	@Value("${security.jwt.clientSecret}")
	private String clientSecret;

	@Value("${security.jwt.resourceIds}")
	private String resourceIds;
	
	@Value("${security.jwt.accessTokenValidititySeconds}")
    private int accessTokenValiditySeconds;

    @Value("${security.jwt.authorizedGrantTypes}")
    private String[] authorizedGrantTypes;

    @Value("${security.jwt.refreshTokenValiditySeconds}")
    private int refreshTokenValiditySeconds;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
    
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        return converter;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
            .authenticationManager(authenticationManager)
            .tokenStore(jwtTokenStore())
            .accessTokenConverter(accessTokenConverter());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient(clientId)
            .secret(passwordEncoder().encode(clientSecret))
            .accessTokenValiditySeconds(accessTokenValiditySeconds)
            .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
            .scopes("read_profile")
            .authorizedGrantTypes(authorizedGrantTypes)
            .resourceIds(resourceIds);
    }

}
