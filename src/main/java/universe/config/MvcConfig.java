package universe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");

        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/pub").setViewName("publications");
        registry.addViewController("/terms").setViewName("terms");
        registry.addViewController("/laws").setViewName("laws");
        registry.addViewController("/votes").setViewName("votes");

        registry.addViewController("/login").setViewName("login");
    }
}
