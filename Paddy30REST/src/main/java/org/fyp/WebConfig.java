package org.fyp;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.CorsRegistry;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// disable web security on server to allow testing of server from client on same machine
// the client will also have settings in this regard ... angular config object holds these settings.

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}