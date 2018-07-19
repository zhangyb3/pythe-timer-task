package com.pythe.rest.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoTask {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 每间隔10秒输出时间
	 */
	@Scheduled(cron = "0/5 * * * * ? ")
	public void logTime() {
		logger.info("定时任务，现在时间：" + new Date());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
