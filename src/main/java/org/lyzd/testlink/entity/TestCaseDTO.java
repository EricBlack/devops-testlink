package org.lyzd.testlink.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author shuchao
 * @create 2020 06 09 13:16
 * @description
 */
public class TestCaseDTO implements Serializable {
    @ApiModelProperty(value = "测试用例id", required = true)
    @JsonProperty(value = "case_id")
    private Integer caseId;

    @ApiModelProperty(value = "测试用例名称", required = true)
    @JsonProperty(value = "case_name")
    private String caseName;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }
}
