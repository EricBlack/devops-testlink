package org.lyzd.testlink.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * update case result dto
 *
 * @author shuchao
 * @create 2020-08-13 12:14
 **/
public class UpdateCaseDTO implements Serializable {
    @JsonProperty(value = "case_id")
    private Integer caseId;

    @JsonProperty(value = "update_result")
    private boolean updateResult;

    @JsonProperty(value = "update_message")
    private String updateMessage;

    @JsonProperty(value = "update_time")
    private Date updateTime;

    public UpdateCaseDTO(int caseId){
        this.caseId = caseId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public boolean isUpdateResult() {
        return updateResult;
    }

    public void setUpdateResult(boolean updateResult) {
        this.updateResult = updateResult;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
