package org.lyzd.testlink.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UpdateResultDTO {
    @JsonProperty("test_user")
    private String testUser;

    @JsonProperty("plan_id")
    private Integer planId;

    @JsonProperty(value = "build_id")
    private Integer buildId;

    @JsonProperty(value = "build_name")
    private String buildName;

    @JsonProperty("case_results")
    private List<CaseResultDTO> caseResults;

    public String getTestUser() {
        return testUser;
    }

    public void setTestUser(String testUser) {
        this.testUser = testUser;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
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

    public List<CaseResultDTO> getCaseResults() {
        return caseResults;
    }

    public void setCaseResults(List<CaseResultDTO> caseResults) {
        this.caseResults = caseResults;
    }
}
