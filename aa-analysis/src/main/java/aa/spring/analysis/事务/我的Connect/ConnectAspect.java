package aa.spring.analysis.事务.我的Connect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * @author lla, 2021/2/17  14:54
 */
@Aspect
@Component
public class ConnectAspect {
	Connection myConnect = null;

	public void setMyConnect(Connection myConnect) {
		this.myConnect = myConnect;
	}


	@Pointcut("execution(* org.springframework.jdbc.datasource.DriverManagerDataSource.getConnection())")
	public void springConnectPointCut() {
	}

	;

	@Around(value = "springConnectPointCut()")
	public Connection processConnect(ProceedingJoinPoint pj) {
		Connection connectionTemp = null;
		try {
			System.out.println("开始切...");
			connectionTemp = (Connection) pj.proceed();
			this.myConnect = new ConnectAll(connectionTemp);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return this.myConnect;
	}

}
