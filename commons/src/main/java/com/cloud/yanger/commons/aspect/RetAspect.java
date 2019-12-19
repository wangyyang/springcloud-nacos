package com.cloud.yanger.commons.aspect;

import com.cloud.yanger.commons.model.ApiResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(9)
@Aspect
public class RetAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        if(!(result instanceof ApiResult)) {
            if (result instanceof Boolean) {
                boolean b = (boolean) result;
                result = b ? ApiResult.success() : ApiResult.error();
            } else {
                result = ApiResult.success().setData(result);
            }
        }
        return result;
    }
}
