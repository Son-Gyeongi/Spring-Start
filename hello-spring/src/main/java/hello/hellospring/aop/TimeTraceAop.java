package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 시간 측정 AOP 등록
@Aspect
@Component // 스프링 빈 등록 또는 SpringConfig 에 빈 등록하기
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") // 공통 관심사항 타겟팅
    public Object execute(ProceedingJoinPoint joinPoint) throws  Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            // 다음 메서드로 진행
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
