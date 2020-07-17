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

    @ApiModelProperty(value = "产品id")
    @JsonProperty(value = "project_id")
    private Integer projectId;

    @ApiModelProperty(value = "产品名称")
    @JsonProperty(value = "project_name")
    private String projectName;

    @ApiModelProperty(value = "计划id")
    @JsonProperty(value = "plan_id")
    private Integer planId;

    @ApiModelProperty(value = "计划名称")
    @JsonProperty(value = "plan_name")
    private String planName;

    @ApiModelProperty(value = "环境")
    @JsonProperty(value = "plan_env")
    private String planEnvironment;

    @ApiModelProperty(value = "执行系统")
    @JsonProperty(value = "plan_system")
    private String platformEnvironment;

    @ApiModelProperty(value = "测试工程版本id")
    @JsonProperty(value = "version_id")
    private Integer buildId;

    @ApiModelProperty(value = "测试版本工程名称")
    @JsonProperty(value = "version_name")
    private String buildName;

    @ApiModelProperty(value = "测试用例集")
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

    public String getPlanEnvironment() {
        return planEnvironment;
    }

    public void setPlanEnvironment(String planEnvironment) {
        this.planEnvironment = planEnvironment;
    }

    public String getPlatformEnvironment(){
        return platformEnvironment;
    }

    public void setPlatformEnvironment(String platformEnvironment) {
        this.platformEnvironment = platformEnvironment;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public List<TestCaseDTO> getTestCaseDTOS() {
        return testCaseDTOS;
    }

    public void setTestCaseDTOS(List<TestCaseDTO> testCaseDTOS) {
        this.testCaseDTOS = testCaseDTOS;
    }
}
