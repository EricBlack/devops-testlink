package org.lyzd.testlink.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author shuchao
 * @create 2020 06 09 13:13
 * @description
 */
public class TestPlanDTO implements Serializable {
    private static final long serialVersionUID = 5057954049311281252L;

    @ApiModelProperty(value="产品id")
    @JsonProperty(value = "project_id")
    private Integer projectId;

    @ApiModelProperty(value="产品名称")
    @JsonProperty(value = "project_name")
    private String projectName;

    @ApiModelProperty(value="计划id")
    @JsonProperty(value = "plan_id")
    private Integer planId;

    @ApiModelProperty(value="计划名称")
    @JsonProperty(value = "plan_name")
    private String planName;

    @ApiModelProperty(value="测试用例集")
    @JsonProperty(value = "test_cases")
    private List<TestCaseDTO> testCaseDTOS;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public List<TestCaseDTO> getTestCaseDTOS() {
        return testCaseDTOS;
    }

    public void setTestCaseDTOS(List<TestCaseDTO> testCaseDTOS) {
        this.testCaseDTOS = testCaseDTOS;
    }
}
