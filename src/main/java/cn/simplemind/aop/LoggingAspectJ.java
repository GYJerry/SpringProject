package cn.simplemind.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import com.alibaba.fastjson.JSON;

import cn.simplemind.aop.annotation.ClassAnnotation;
import cn.simplemind.aop.annotation.MethodAnnotation;
import cn.simplemind.aop.annotation.ParamAnnotation;
import cn.simplemind.aop.annotation.ParamTypeAnnotation;
import cn.simplemind.aop.annotation.ReturnTypeAnnotation;

/**
 * 
 * @author yingdui_wu
 * @date 2018年5月3日 上午8:46:44
 */
@Aspect
public class LoggingAspectJ {
    
    @Pointcut("execution(* cn.simplemind.aop.Student.*(..))")
    private void selectAll() {
        
    }
    
    @Pointcut("execution(* cn.simplemind.aop.Student.special(..))")
    private void special() {
        
    }
    
    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("Going to setup student profile.");
    }

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("Student profile has been setup.");
    }

    @AfterReturning(pointcut = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("Returning:" + JSON.toJSONString(retVal));
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }
    
    @Around(value = "special()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        /**
         * 环绕通知内部一定要确保执行该方法，如果不执行该方法，业务bean中被拦截的方法就不会被执行。
         * 当执行该方法，如果后面还有切面的话，它的执行顺序应该是这样的：先执行后面的切面，如果后面没有切面了，
         * 再执行最终的目标对象的业务方法。若不执行该方法，则后面的切面，业务bean的方法都不会被执行。
         */
        Object result = "do nothing";
        
        System.out.println("进入方法");
        
        Object[] args = pjp.getArgs();
        System.out.println("args : " + JSON.toJSON(args));
        
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        
        // 参数中的注解
        Annotation[][] paramAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < paramAnnotations.length; i++) {
            Annotation[] annotations = paramAnnotations[i];
            for (int j = 0; j < annotations.length; j++) {
                Annotation annotation = annotations[j];
                if (annotation.annotationType().isAssignableFrom(ParamAnnotation.class)) {
                    System.out.println("successfully get annotation ParamAnnotation");
                }
            }
        }
        
        // 参数类型中的注解
        Class<?>[] paramTypes = method.getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> paramType = paramTypes[i];
            Annotation[] paramTypeAnnotations = paramType.getAnnotations();
            // 根据注解类型获取
            ParamTypeAnnotation paramTypeAnnotation = paramType.getAnnotation(ParamTypeAnnotation.class);
            for (int j = 0; j < paramTypeAnnotations.length; j++) {
                Annotation annotation = paramTypeAnnotations[j];
                if (annotation.annotationType().isAssignableFrom(ParamTypeAnnotation.class)) {
                    System.out.println("successfully get annotation ParamTypeAnnotation");
                }
            }
        }
        
        // 方法中的注解
        Annotation[] methodAnnotations = method.getAnnotations();
        // 根据注解类型获取
        MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
        for (int i = 0; i < methodAnnotations.length; i++) {
            Annotation annotation = methodAnnotations[i];
            if (annotation.annotationType().isAssignableFrom(MethodAnnotation.class)) {
                System.out.println("successfully get annotation MethodAnnotation");
            }
        }
        
        // 返回值类型中的注解
        Annotation[] returnTypeAnnotations = method.getReturnType().getAnnotations();
        // 根据注解类型获取
        ReturnTypeAnnotation returnTypeAnnotation = method.getReturnType().getAnnotation(ReturnTypeAnnotation.class);
        for (int i = 0; i < returnTypeAnnotations.length; i++) {
            Annotation annotation = returnTypeAnnotations[i];
            if (annotation.annotationType().isAssignableFrom(ReturnTypeAnnotation.class)) {
                System.out.println("successfully get annotation ReturnTypeAnnotation");
            }
        }
        
        // 方法所在类中的注解
        ClassAnnotation classAnnotation = method.getDeclaringClass().getAnnotation(ClassAnnotation.class);
        Annotation[] classAnnotations = method.getDeclaringClass().getAnnotations();
        for (int i = 0; i < classAnnotations.length; i++) {
            Annotation annotation = classAnnotations[i];
            if (annotation.annotationType().isAssignableFrom(ClassAnnotation.class)) {
                System.out.println("successfully get annotation ClassAnnotation");
            }
        }
        
        result = pjp.proceed();
        System.out.println("退出方法");
        
        
        return result;
    }
}
