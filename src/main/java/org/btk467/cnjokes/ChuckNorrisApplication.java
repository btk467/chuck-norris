package org.btk467.cnjokes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.sentry.Sentry;

@SpringBootApplication
public class ChuckNorrisApplication {

	public static void main(String[] args) {

	  Sentry.init(options -> {
	    options.setDsn("https://af90203206ae4026b73f7f8d92106837@o335612.ingest.sentry.io/1866341");
	    // Set tracesSampleRate to 1.0 to capture 100% of transactions for performance monitoring.
	    // We recommend adjusting this value in production.
	    options.setTracesSampleRate(1.0);
	    // When first trying Sentry it's good to see what the SDK is doing:
	    options.setDebug(true);
	  });

	  SpringApplication.run(ChuckNorrisApplication.class, args);
	}

}
