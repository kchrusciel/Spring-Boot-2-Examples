package pl.codecouple.graceful.shutdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LongController {

    private static final Logger logger = LoggerFactory.getLogger(LongController.class);

    @GetMapping("/long")
    String longJob() throws InterruptedException {
        logger.info("Start");
        Thread.sleep(30_000);
        logger.info("Done");
        return "Done";
    }

    @GetMapping("/veryLong")
    String veryLongJob() throws InterruptedException {
        logger.info("Start");
        Thread.sleep(50_000);
        logger.info("Done");
        return "Done";
    }

}