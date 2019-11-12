package cn.jhc.zx.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class TeacherLogger {

    @Pointcut("execution(public void cn.jhc.zx.service.TeacherService.save())")
    private void pt(){

    }

    /**
     * 前置通知
     */
//    @Before("pt()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了！");
    }
    /**
     * 后置通知
     */
//    @AfterReturning("pt()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了！");
    }/**
     * 异常通知
     */
//    @AfterThrowing("pt()")
    public void beforeThrowingPrintLog(){
        System.out.println("异常通知Logger类中的beforeThrowingPrintLog方法开始记录日志了！");
    }
    /**
     * 最终通知
     */
//    @After("pt()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了！");
    }

    /**
     * 环绕通知
     */
    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了！前置通知");
            rtValue = pjp.proceed(args);
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了！后置通知");
            return rtValue;
        }catch (Throwable throwable){
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了！异常通知");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了！最终通知");
        }
    }


}
