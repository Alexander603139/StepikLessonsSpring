package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop")
@EnableAspectJAutoProxy // позволяет нам за кулисами использовать Spring АОР Proxy
public class MyConfig {

}
