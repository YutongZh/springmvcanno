servlet filter listener

myServlet 继承 httpServlet;

//重写doGet方法
向页面resp.getWriter().write("dff");

@WebServlet("/order")  相当于web.xml

shared libraries / runtimes debug
ServletContainerInitializer:tomcat启动，进行自定义化的实现
 新建目录 META-INF /services/javax.servlet.ServletContainerInitializer :tomcat启动，优先扫描此路径下这个文件自定义注册的组件
  com.yt.servlet.myServletContainerInitializer
 
 在指定文件 指定类启动
 新建类myServletContainerInitializer实现ServletContainerInitializer
 //arg0:父类感兴趣的类的子类型 接口的实现等
 //servletContext 与三大组件有关 代表当前web应用 注册三大组件
 
 @HandlesTypes(value={OrderService.class}) 扫描感兴趣的父类
 OrderService为接口
  OrderServiceImpl 
 OrderServiceOther接口 继承接口
 AbstractOrderService实现 接口
 
 PayFilter 实现 Filter
 //过滤请求
 //放行
 
 //监听项目的启动或停止
 PayListener 实现 servletContextListener
 arg0.getServletContest()
 
 PayServlet 继承 httpServlet
 
 myServletContainerInitializer
 注册PayServlet组件
 arg1.addServlet("payServlet", new PayServlet());
 servlet.addMapping("/payTest");
 
 //注册监听器listener
 arg1.addListener(PayListener.class);
 
 //注册filter
 arg1.addFilter("payFilter", OrderFilter.class);
 //添加filter的映射信息，指定专门拦截哪个servlet
 filter.addMappingForUrlPatterns(EnumSet.of(DispatcherTypes.REQUEST),true,"/");
 
 springmvc anno
 打包方式war包  web.xml 报错
 <build>
  <plugins>
   <groupId>org.apache.maven.plugins>
   <arti>maven-war-plugin
   <version>2.4</
   
   <configuration>
    <failOnMiss>false</failOnMiss>
   </
  </>
 </build>
 
 spring-webmvc  5.0.6
 servelet 3.0-alpha-1  (jdk也有servelet 排除)
 scope provided 
 spring-web中有META-INF services javax.servletContainerInitialzer 这是入口
 
 
 反射创建 关注感兴趣的类
WebApplicationInitializer 为核心类
registerContext 创建根容器
WebApplicationContext 继承了 ApplicationContext  为spring容器的子容器
添加监听器的注册

AbstractDispatcherServletInitializer  初始化servlet
registerDispatcherServlet(); servlet mapping  filter

AnnotationConfigWebApplicationContext 类似于AnnotationConfigApplicationContext也是子容器主要创建
dispathcerServlet

dispathcerServlet包含两个容器：
根容器：Root WebApplicationContext  继承ioc 子容器  层：service repositories
子容器：servlet WebApplicationContext  controller  handlerMapping 拦截过滤 viewResolver 

//web容器启动的时候创建的对象：调用方法来初始化容器以前一个控制器
AbstractAnnotationConfigDispacherServletInitalizer
//根容器
    //对非controller层进行bean注入
    MyAppConfig
    @ComponentScan(value="com.yt", includeFilters={
        @Fllter(type=Filter.type.annotation,classes={Controller.class})
    }, useDefaultFilters=false)
//子容器
//获取dispatcherservlet的映射信息
//拦截所有请求（静态资源，js,css,png） 但是不包括*.jsp(jsp 的解析是tomcat的jsp引擎解析)
 
 MyAppConfig
 MyRootConfig
 OrderController
 OrderService
 
 定制springmvc 接管
 
 application-mvc.xml
 //将springmvc处理不了的请求交给tomcat处理：静态资源（js png css）
 <mvc:default-servlet-handler>
 <mvc:annotation-driven>
 <mvc:interceptors>
 
 注解：
 servlet @WebServlet
 spring @EnableWebMvc  相当于上述三个配置
 实现WebMvcConfigurer
 用适配器 WebMvcConfigurerAdapter
 viewrESOLVER
 
 //比如我们想用jsp解析器，默认的所有页面都从/WEB-INF/aaa.jsp
 registry.jsp("/WEB-INF/pages",".jsp");
 
 //静态资源的访问 定制了默认访问不到
 configureDefaultServletHandling
 configurer.enable（）
 
 //拦截器
 addInterceptors
 registry.addInterceptor().add 
 HandlerInterceptor()
 
 过滤器 字符集
 拦截器 
 
