package com.dafengsu.ssm.controller;

import com.dafengsu.ssm.domain.SysLog;
import com.dafengsu.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author su
 * @description
 * @date 2020/4/3
 */
@Component
@Aspect
public class LogAop {
    private Date visitTime;
    private Class clazz;
    private Method method;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    //前置通知
    @Before("execution(* com.dafengsu.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = jp.getTarget().getClass();//具体要访问的类
        String methodName = jp.getSignature().getName();//获取访问的方法的名称
        Object[] args = jp.getArgs();
        //获取method
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < classArgs.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName, classArgs);
        }

    }

    @After("execution(* com.dafengsu.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long execTime = new Date().getTime() - visitTime.getTime();
        //获取url
        String url = null;
        if (clazz != null && method != null && clazz != LogAop.class) {
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation != null) {
                String classValue = (clazzAnnotation.value())[0];
                RequestMapping methodAnnotation = (RequestMapping) method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String methodValue = (methodAnnotation.value())[0];
                    url = classValue + methodValue;
                }
            }
        }
        //获取访问的ip地址
        String ip = request.getRemoteAddr();
        //获取当前操作的用户
        SecurityContext context = SecurityContextHolder.getContext();
        String username = ((User) context.getAuthentication().getPrincipal()).getUsername();
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(execTime);
        sysLog.setIp(ip);
        sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + clazz.getName());
        sysLog.setVisitTime(visitTime);
        sysLog.setUrl(url);
        sysLog.setUsername(username);
        sysLogService.save(sysLog);
    }
}
