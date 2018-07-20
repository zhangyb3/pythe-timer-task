package com.pythe.rest.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pythe.mapper.TblCompositionMatchMapper;
import com.pythe.mapper.TblMatchMapper;
import com.pythe.pojo.TblCompositionMatch;
import com.pythe.pojo.TblCompositionMatchExample;
import com.pythe.pojo.TblMatch;
import com.pythe.pojo.TblMatchExample;

@PropertySource(value = { "classpath:resource/parameter.properties" })
@Component
public class MatchForceStopTask {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${MATCH_ONLINE}")
	private Integer MATCH_ONLINE;

	@Value("${MATCH_OFFLINE}")
	private Integer MATCH_OFFLINE;

	@Value("${COMPOSITION_APPRAISE}")
	private Integer COMPOSITION_APPRAISE;

	@Autowired
	private TblCompositionMatchMapper compositionMatchMapper;

	@Autowired
	private TblMatchMapper matchMapper;

	/**
	 * 每间隔1分钟检查是否比赛是否已截止，如果已截止，则改变相关参赛作文是否可提交属性
	 */
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void matchForceStop() {

		// 检查比赛是否已截止
		DateTime nowTime = new DateTime();
		TblMatchExample matchExample = new TblMatchExample();
		matchExample.createCriteria().andStatusEqualTo(MATCH_ONLINE)
				.andStopTimeLessThanOrEqualTo(nowTime.plusMinutes(1).toDate())
				.andStopTimeGreaterThanOrEqualTo(nowTime.minusMinutes(1).toDate());
		List<TblMatch> matches = new LinkedList<>();
		matches.addAll(matchMapper.selectByExample(matchExample));
		// System.err.println("===============> match quantity: " +
		// matches.size());

		if (!matches.isEmpty()) {
			List<Long> matchIds = new LinkedList<Long>();
			for (TblMatch tblMatch : matches) {
				matchIds.add(tblMatch.getId());
			}

			TblCompositionMatchExample compositionMatchExample = new TblCompositionMatchExample();
			compositionMatchExample.createCriteria().andTaskIdIn(matchIds);
			int resultNum = compositionMatchMapper.countByExample(compositionMatchExample);
			logger.info("即将提交的作文数量：" + resultNum);

			TblCompositionMatch compositionMatch = new TblCompositionMatch();
			compositionMatch.setStatus(COMPOSITION_APPRAISE);
			compositionMatchMapper.updateByExampleSelective(compositionMatch, compositionMatchExample);

			TblMatch match = new TblMatch();
			match.setStatus(MATCH_OFFLINE);
			matchMapper.updateByExampleSelective(match, matchExample);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
