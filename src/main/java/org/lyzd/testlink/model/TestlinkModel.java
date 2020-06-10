package org.lyzd.testlink.model;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.*;
import org.lyzd.testlink.common.TestlinkUtils;
import org.lyzd.testlink.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuchao
 * @create 2020 06 09 16:18
 * @description
 */
public class TestlinkModel {
    private TestLinkAPI api;
    private TestProject project;
    private TestPlan plan;

    public TestlinkModel(){
        api = TestlinkUtils.connect();
    }

    public TestPlanDTO queryPlan(String planName, String projectName) {
        TestProject testProject = api.getTestProjectByName(projectName);
        TestPlan testPlan = api.getTestPlanByName(planName, projectName);
        TestCase[] cases = api.getTestCasesForTestPlan(testPlan.getId(), null, null, null, null,
                null, null, null, null, null, null);
        Build build = api.getLatestBuildForTestPlan(testPlan.getId());

        TestPlanDTO planDTO = new TestPlanDTO();
        //设置project info
        planDTO.setProjectId(testProject.getId());
        planDTO.setProjectName(testProject.getName());

        //设置plan info
        planDTO.setPlanId(testPlan.getId());
        planDTO.setPlanName(testPlan.getName());

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

    public boolean updateResult(CaseResultDTO caseResultDTO){
        Build build = api.getLatestBuildForTestPlan(caseResultDTO.getPlanId());
        ReportTCResultResponse response = api.reportTCResult(caseResultDTO.getCaseId(), null, caseResultDTO.getPlanId(), caseResultDTO.getExecutionStatus(),
                null, build.getId(), build.getName(), caseResultDTO.getNotes(),
                caseResultDTO.getExecutionDuration(), false, null, null,
                null, null, caseResultDTO.getOverWrite(), caseResultDTO.getUser(),
                null);
        System.out.println(response);
        return true;
    }

    public static void main(String[] args){
        TestlinkModel model = new TestlinkModel();
        TestPlanDTO dto = model.queryPlan("plan-test1", "bank-devops-demo");
    }
}
