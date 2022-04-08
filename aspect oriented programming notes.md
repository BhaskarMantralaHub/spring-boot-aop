***Aspect Oriented Programming***

https://www.youtube.com/watch?v=x2f4NzNCkCI

Cross Cutting Concerns => Moving non-business logic outside of Business logic like transactions, logging, security, ...

Aspect classes => Hold non-business logic

Business Classes will be binded with Aspect classes

`*****************************************************************`

**Terminologies:**
1. Aspect - Class - Like transactions, logging, security, ...
2. Advice - Aspect Class methods and must be any one of the following:
   1. Before Advice - Before running business method
   2. After Advice - After running business method
   3. Around Advice - 2 Parts. Order of execution:
      1. First part
      2. Before advice
      3. Business method
      4. Second part
   4. After returning Advice - Only runs with successful business method response
   5. After throwing Advice - Only runs with failed business method response
3. Pointcut - It is an expression and defines business method who seeks advice
   1. Example: 
   ```java
      @Pointcut("execution(public * com.bhaskarmantrala.hub.springbootfoundation.*(..))")
      public void pointCutMethod() {} 
   ```

4. JoinPoint - Specifies / Binds what advice is required by business method
   1. Example:
      ```java
         import org.aspectj.lang.annotation.Before;
         
         @Pointcut("execution(public * com.bhaskarmantrala.hub.springbootfoundation.*(..))")
         public void pointCutMethod() {} 
      
         @Before("pointCutMethod()")
         public void adviceMethod() {}
      ```
5. Target - Business class object
6. Weaving - Creates a new Proxy class consists of both business logic code and aspect logic together
   **@EnableAspectJAutoProxy** 
****Configuration file****
```
@Configuration
@ComponentScan(basePackages = {"com.bhaskarmantrala.hub.springbootaop.core",
        "com.bhaskarmantrala.hub.springbootaop.advice"})
@EnableAspectJAutoProxy
```

8. Proxy - JDK Dynamic Proxy - Class object with both business logic + aspect logic

`*****************************************************************`

**Spring AOP using AspectJ using Annotations**

Add a dependency - `Spring Boot Starter AOP`

```
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-aop -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
    <version>2.5.12</version>
</dependency>```

