package com.walmart.reminder;

import com.walmart.reminder.DatabaseConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@Configuration
@ComponentScan
@Import(DatabaseConfig.class)
public class SpringConfig {

}
