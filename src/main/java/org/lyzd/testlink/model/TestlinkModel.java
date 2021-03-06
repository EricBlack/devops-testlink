package org.lyzd.testlink.model;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.lyzd.testlink.common.TestlinkUtils;
import org.lyzd.testlink.entity.*;
import org.lyzd.testlink.exception.ResultException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shuchao
 * @create 2020 06 09 16:18
 * @description
 */

@Slf4j
public class TestlinkModel {
    private TestLinkAPI api;

    public TestlinkModel(){
        api = TestlinkUtils.connect();
    }

    public TestPlanDTO queryPlan(String planName, String projectName) {
        TestProject testProject = api.getTestProjectByName(projectName);
        if(testProject == null){
            throw new ResultException(ResultCode.PROJECT_ERROR);
        }

        TestPlan testPlan = api.getTestPlanByName(planName, projectName);
        if(testPlan == null){
            throw new ResultException(ResultCode.PLAN_ERROR);
        }

        TestCase[] cases = api.getTestCasesForTestPlan(testPlan.getId(), null, null, null, null,
                null, null, null, null, null, null);
        if(cases == null){
            throw new ResultException(ResultCode.CASE_ERROR);
        }

        Build build = api.getLatestBuildForTestPlan(testPlan.getId());
        if(build == null){
            throw new ResultException(ResultCode.BUILD_ERROR);
        }

        //获取version信息
        CustomField environment = api.getTestPlanCustomFieldDesignValue(testPlan.getId(), testProject.getId(), "EnvironmentList", null);
        if("".equals(environment.getValue())){
            throw new ResultException(ResultCode.ENVIRONMENT_ERROR);
        }

        TestPlanDTO planDTO = new TestPlanDTO();
        //设置project info
        planDTO.setProjectId(testProject.getId());
        planDTO.setProjectName(testProject.getName());

        //设置plan info
        planDTO.setPlanId(testPlan.getId());
        planDTO.setPlanName(testPlan.getName());

        //设置测试环境
        planDTO.setPlanEnvironment(environment.getValue());

        //设置版本信息
        planDTO.setBuildId(build.getId());
        planDTO.setBuildName(build.getName());

        //设置cases info
        List<TestCaseDTO> caseDTOS = new ArrayList<TestCaseDTO>();
        for(TestCase testCase : cases){
            TestCaseDTO dto = new TestCaseDTO();
            dto.setCaseId(testCase.getId());
            dto.setCaseName(testCase.getName());
            caseDTOS.add(dto);
        }
        planDTO.setTestCaseDTOS(caseDTOS);

        return planDTO;
    }

    public Map<Integer, Boolean> updateResult(UpdateResultDTO updateResultDTO){
        List<CaseResultDTO> caseResultDTOS = updateResultDTO.getCaseResults();
        Integer planId = updateResultDTO.getPlanId();
        Integer buildId = updateResultDTO.getBuildId();
        String buildName = updateResultDTO.getBuildName();
        String tester = updateResultDTO.getTestUser();
        Map<Integer, Boolean> updateResults = new HashMap();
        for(CaseResultDTO caseResultDTO : caseResultDTOS){
            try{
                ReportTCResultResponse response = api.reportTCResult(caseResultDTO.getCaseId(), null, planId, caseResultDTO.getExecutionStatus(),
                        null, buildId, buildName, caseResultDTO.getNotes(),
                        caseResultDTO.getExecutionDuration(), false, null, null,
                        null, null, caseResultDTO.getOverWrite(), tester,
                        null);
                log.info(response.getExecutionId() + response.getMessage());
                updateResults.put(caseResultDTO.getCaseId(), true);
            }catch(Exception e){
                updateResults.put(caseResultDTO.getCaseId(), false);
                log.error(e.getMessage());
            }
        }

        return updateResults;
    }
}
