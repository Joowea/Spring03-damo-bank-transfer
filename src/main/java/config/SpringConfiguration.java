package config;

import org.springframework.context.annotation.*;


/**
 * 相当于bean.xml
 */
@Configuration //指定当前类是一个配置类
@ComponentScan(basePackages = "com.joo") //扫描包
@Import(JdbcConfig.class) //导入其他配置类
@PropertySource("classpath:jdbcConfig.properties") //指定properties文件位置
public class SpringConfiguration {

}
