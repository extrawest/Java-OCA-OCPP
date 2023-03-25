package eu.chargetime.ocpp.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.chargetime.ocpp.model.RequestWithId;
import eu.chargetime.ocpp.model.dataTypes.CustomDataType;
import eu.chargetime.ocpp.model.dataTypes.ReportDataType;
import eu.chargetime.ocpp.model.validation.RequiredValidator;
import eu.chargetime.ocpp.model.validation.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "requestId",
        "generatedAt",
        "reportData",
        "tbc",
        "seqNo"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class NotifyReportRequest extends RequestWithId {

    private transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * The id of the GetReportRequest or GetBaseReportRequest that requested this report
     *
     * (Required)
     *
     */
    @JsonProperty("requestId")
    public Integer requestId;
    /**
     * Timestamp of the moment this message was generated at the Charging Station.
     *
     * (Required)
     *
     */
    @JsonProperty("generatedAt")
    public Date generatedAt;
    @JsonProperty("reportData")
    public List<ReportDataType> reportData;
    /**
     * “to be continued” indicator. Indicates whether another part of the report follows in an upcoming notifyReportRequest message. Default value when omitted is false.
     *
     *
     *
     */
    @JsonProperty("tbc")
    public Boolean tbc = false;
    /**
     * Sequence number of this message. First message starts at 0.
     *
     * (Required)
     *
     */
    @JsonProperty("seqNo")
    public Integer seqNo;

    public NotifyReportRequest(Integer requestId, Date generatedAt, Integer seqNo) {
        requiredValidator.validate(requestId);
        requiredValidator.validate(generatedAt);
        requiredValidator.validate(seqNo);
        this.requestId = requestId;
        this.generatedAt = generatedAt;
        this.seqNo = seqNo;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setRequestId(Integer requestId) {
        requiredValidator.validate(requestId);
        this.requestId = requestId;
    }

    public void setGeneratedAt(Date generatedAt) {
        requiredValidator.validate(generatedAt);
        this.generatedAt = generatedAt;
    }

    public void setReportData(List<ReportDataType> reportData) {
        this.reportData = reportData;
    }

    public void setTbc(Boolean tbc) {
        this.tbc = tbc;
    }

    public void setSeqNo(Integer seqNo) {
        requiredValidator.validate(seqNo);
        this.seqNo = seqNo;
    }

    @Override
    public boolean transactionRelated() {
        return false;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(requestId)
                &&requiredValidator.safeValidate(generatedAt)
                &&requiredValidator.safeValidate(seqNo);
    }
}