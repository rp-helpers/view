package com.pryjda.chat_view_service.bean

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.thymeleaf.TemplateEngine
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring5.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.ServletContextTemplateResolver

@Configuration
@EnableWebMvc
class Config(private val applicationContext: ApplicationContext) : WebMvcConfigurer {

/*    override fun configureViewResolvers(registry: ViewResolverRegistry) {
//        super.configureViewResolvers(registry)
        val resolver: ThymeleafViewResolver = ThymeleafViewResolver()
        resolver.templateEngine = templateEngine()
        registry.viewResolver(resolver)
    }

    @Bean
    fun templateResolver(): SpringResourceTemplateResolver {
        val templateResolver: SpringResourceTemplateResolver = SpringResourceTemplateResolver()
        templateResolver.setApplicationContext(applicationContext)
        templateResolver.prefix = "/WEB_INF/views/"
        templateResolver.suffix = ".html"
        return templateResolver
    }

    @Bean
    fun templateEngine(): SpringTemplateEngine {
        val templateEngine: SpringTemplateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(templateResolver())
        templateEngine.enableSpringELCompiler = true
        return templateEngine
    }*/

//    @Bean
//    fun viewResolver(templateEngine: SpringTemplateEngine): ViewResolver {
//        val thymeleafViewResolver: ThymeleafViewResolver = ThymeleafViewResolver()
//        thymeleafViewResolver.templateEngine = templateEngine
//        return thymeleafViewResolver
//    }
//
//    @Bean
//    fun templateEngine(templateResolver: ServletContextTemplateResolver): TemplateEngine{
//        val templateEngine: SpringTemplateEngine = SpringTemplateEngine()
//        templateEngine.setTemplateResolver(templateResolver)
//        return templateEngine
//    }
//
//    @Bean
//    fun templateResolver(): ServletContextTemplateResolver{
//        val templateResolver: ServletContextTemplateResolver = ServletContextTemplateResolver()
//
//
//    }

}