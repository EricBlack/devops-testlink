package org.lyzd.testlink.entity;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author shuchao
 * @create 2020 06 09 14:19
 * @description
 */
public class CaseResultDTO {
    @JsonProperty(value = "case_id")
    private Integer caseId;

    @JsonProperty(value = "execution_status")
    private Integer executionStatus;

    @JsonProperty(value = "execution_duration")
    private Integer executionDuration;

    @JsonProperty(value = "over_write")
    private Boolean overWrite;

    @JsonProperty(value = "notes")
    private String notes;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public ExecutionStatus getExecutionStatus() {
        switch (executionStatus) {
            case 0:
                return ExecutionStatus.NOT_RUN;
            case 1:
                return ExecutionStatus.PASSED;
            case 2:
                return ExecutionStatus.FAILED;
            case 3:
                return ExecutionStatus.BLOCKED;
        }

        return null;
    }

    public void setExecutionStatus(Integer executionStatus) {
        this.executionStatus = executionStatus;
    }

    public Integer getExecutionDuration() {
        return executionDuration;
    }

    public void setExecutionDuration(Integer executionDuration) {
        this.executionDuration = executionDuration;
    }

    public Boolean getOverWrite() {
        return overWrite;
    }

    public void setOverWrite(Boolean overWrite) {
        this.overWrite = overWrite;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
