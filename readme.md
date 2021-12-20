1. @PostConstruct作用:
@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init（）方法之前执行。该注解的方法在整个Bean初始化中的执行顺序：Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法),轻量级逻辑放在postConstruct中执行，耗时较长可使用异步线程执行，初始化操作放在runner中执行

2. CommandLineRunner或ApplicationRunner的作用和区别:
平常开发中有可能需要实现在项目启动后执行的功能，SpringBoot提供的一种简单的实现方案就是添加一个model并实现CommandLineRunner或ApplicationRunner接口，实现功能的代码放在实现的run方法中,SpringBoot在项目启动后会遍历所有实现CommandLineRunner或ApplicationRunner的实体类并执行run方法，如果需要按照一定的顺序去执行，那么就需要在实体类上使用一个@Order注解（或者实现Order接口）来表明顺序,@Order 注解的执行优先级是按value值从小到大顺序。
区别在于参数不一样，CommandLineRunner中run方法参数为String数组，ApplicationRunner参数为ApplicationArguments,ApplicationRunner接口实现方法默认先于CommandLineRunner接口实现方法执行

3. springboot配置文件方式，默认放在resources文件夹下，放在resources/config文件夹下也可以读取，加载顺序yml>yaml>properties，生效顺序相反
SpringBoot读取配置文件的优先级为：
第一、项目jar包同级下的config文件夹是优先级最高的，是在执行命令的目录下建config文件夹。（在jar包的同一目录下建config文件夹，执行命令需要在jar包目录下才行），然后把配置文件放到这个文件夹下。
第二、项目jar包同级下直接放properties文件是次优先级，是直接把配置文件放到jar包的同级目录。
第三、项目内部的classpath同级config文件夹是第三优先级，在classpath下建一个config文件夹，然后把配置文件放进去。
第四、项目内部的classpath同级放properties文件是最低优先级，是在classpath下直接放配置文件。
springboot默认是优先读取它本身jar包同级目录下的一个config/application.properties 文件的。
在项目内src/main/resources 文件夹下创建的application.properties 文件的优先级是最低的
自定义配置文件：
> java -jar myproject.jar --spring.config.location=classpath:/default.properties,classpath:/override.properties或者java -jar -Dspring.config.location=D:\config\config.properties springbootrestdemo-0.0.1-SNAPSHOT.jar 
> 
代码指定加载： 
> @SpringBootApplication
       @PropertySource(value={"file:config.properties"})
       public class SpringbootrestdemoApplication {
           public static void main(String[] args) {
               SpringApplication.run(SpringbootrestdemoApplication.class, args);
           }
       }
> 
Profile不同环境读取不同配置，不同环境的配置设置一个配置文件，例如：
dev环境下的配置配置在application-dev.properties中；
prod环境下的配置配置在application-prod.properties中。
在application.properties中指定使用哪一个文件，spring.profiles.active = dev，也可以启动时指定，java -jar myproject.jar --spring.profiles.active = prod

4. 约定大于配置，除了自己修改的配置，其余配置默认使用springboot自动装配的配置

5. ApplicationListener监听器用来实现对业务的监听

6. lifeCycle与smasrtLifeCycle:
lifeCycle在调用AbstractApplicationContext#start方法或者显式调用后生效，smartLifeCycle可以配置start方法自动生效

7. bean实现InitializingBean可以在注入完成后立刻实现某些操作
