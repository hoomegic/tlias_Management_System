package com.czk.tliasmanagementsystem.aop;

import com.czk.tliasmanagementsystem.mapper.OperateLogMapper;
import com.czk.tliasmanagementsystem.pojo.OperateLog;
import com.czk.tliasmanagementsystem.utils.CurrentHolder;
import com.czk.tliasmanagementsystem.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.czk.tliasmanagementsystem.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        OperateLog operateLog = new OperateLog();

        operateLog.setOperateUser(CurrentHolder.getCurrentLocal());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(joinPoint.getArgs().toString());

        long start = System.currentTimeMillis();
        operateLog.setOperateTime(LocalDateTime.now());

        //调用原始方法
        Object result = joinPoint.proceed();

        operateLog.setCostTime(System.currentTimeMillis() - start);
        operateLog.setReturnValue(result.toString());
        operateLogMapper.insert(operateLog);

        //返回原始方法的return
        return result;
    }

}
