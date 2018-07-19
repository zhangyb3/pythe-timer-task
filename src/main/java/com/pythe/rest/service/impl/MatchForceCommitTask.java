package com.pythe.rest.service.impl;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pythe.mapper.TblCompositionMatchMapper;
import com.pythe.pojo.TblCompositionMatchExample;

@Component
public class MatchForceCommitTask {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TblCompositionMatchMapper compositionMatchMapper;

	/**
	 * 每间隔1秒检查是否比赛时限已到
	 */
	@Scheduled(cron = "0/1 * * * * ? ")
	public void matchForceCommit() {

		TblCompositionMatchExample compositionMatchExample = new TblCompositionMatchExample();
		compositionMatchExample.createCriteria().andStopTimeGreaterThan(new DateTime().plusMinutes(1).toDate());

		int resultNum = compositionMatchMapper.countByExample(compositionMatchExample);

		logger.info("即将提交的作文数量：" + resultNum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
