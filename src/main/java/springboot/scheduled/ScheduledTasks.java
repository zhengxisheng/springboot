package springboot.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
	@Scheduled(cron="0 */1 * * * ?")
    public void reportCurrentTime() {
		
        System.out.println("每一分钟执行一次:" + dateFormat.format(new Date()));
    }

}