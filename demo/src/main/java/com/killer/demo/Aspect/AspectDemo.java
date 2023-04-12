package com.killer.demo.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * spring boot 使用注解方式实现切面
 * 第一步：先导入依赖 spring-boot-starter-aop
 * 第二步：写个切面类，加上@Aspect注解，告诉spring boot它是一个切面类
 * 第三步：在切面类中写相关的通知方法
 * 第四步：可以@Pointcut注解统一定义切入点表达式，不用一个一个写表达式了
 * 注意：
 *  环绕通知需要接收参数ProceedingJoinPoint，并且调用joinPoint.proceed()进行目标方法放行，否则目标方法执行后不会返回结果
 *  后置通知可以接收返回的对象，在切入点表达式上配置returning，然后在方法上接收returning的形参即可
 *  异常通知可以接收返回的异常对象，在切入点表达式上配置throwing，然后在方法上接收throwing的形参，原理同后置通知接收对象一样
 *  切入点表达式可以根据方法返回值来切，也可以根据方法参数列表来切，这样粒度更细
 *  如果有异常，程序将直接走异常通知和最终通知了，不会再走环绕后和后置通知了
 */
@Component
@Aspect
public class AspectDemo {

    @Pointcut("execution(String com.killer.demo.service.*.*(..)))")
    public void mx(){}

    @Before("mx()")
    public void before(){
        System.out.println("前置通知***");
    }
    @Around("execution(* com.killer.demo.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知之前***");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知之后***");
        return proceed;
    }
    @AfterReturning(value = "execution(* com.killer.demo.service.*.*(..))",returning = "obj")
    public void afterReturn(Object obj){
        System.out.println("后置通知***"+obj);
    }
    @AfterThrowing(value = "execution(* com.killer.demo.service.*.*(..))",throwing = "e")
    public void ex(Throwable e){
        System.out.println("异常通知***"+e);
    }
    @After("execution(* com.killer.demo.service.*.*(..))")
    public void after(){
        System.out.println("最终通知***");
    }
}
