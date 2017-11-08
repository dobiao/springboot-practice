package main.java.com.souche.db.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dubiao on 2017/10/12.
 */
@Component
@Slf4j
public class Jobs {

    public final static long SECOND = 1 * 1000;
    FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");


    @Scheduled(cron = "0/4 * * * * ?")
    public void cronJob() {
        log.info("[CronJob Execute]" + fdf.format(new Date()));
    }

}
