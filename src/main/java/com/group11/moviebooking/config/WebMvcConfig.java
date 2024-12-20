package com.group11.moviebooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(viewResolver());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/dashboard/assets/**").addResourceLocations("/resources/assets/");
        registry.addResourceHandler("/movies/assets/**").addResourceLocations("/resources/assets/");
        registry.addResourceHandler("/seat_sel/assets/**").addResourceLocations("/resources/assets/");
        registry.addResourceHandler("/ticket-booking/assets/**").addResourceLocations("/resources/assets/");
        registry.addResourceHandler("/home/assets/**").addResourceLocations("/resources/assets/");
        registry.addResourceHandler("/assets/**").addResourceLocations("/resources/assets/");
        registry.addResourceHandler("/seat_selection/**").addResourceLocations("/resources/seat_selection/");
        registry.addResourceHandler("/editCustomer/assets/**").addResourceLocations("/resources/assets/");
    }
}
