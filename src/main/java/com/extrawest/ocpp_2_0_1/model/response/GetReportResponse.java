package com.extrawest.ocpp_2_0_1.model.response;

import com.extrawest.common.model.Confirmation;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.ocpp_2_0_1.model.dataTypes.CustomDataType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.StatusInfoType;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.GenericDeviceModelStatusEnumType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "status",
        "statusInfo"
})
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class GetReportResponse extends Confirmation {

    private final transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    public CustomDataType customData;
    /**
     * This field indicates whether the Charging Station was able to accept the request.
     *
     * (Required)
     *
     */
    @JsonProperty("status")
    public GenericDeviceModelStatusEnumType status;
    /**
     * Element providing more information about the status.
     *
     *
     */
    @JsonProperty("statusInfo")
    public StatusInfoType statusInfo;

    public GetReportResponse(GenericDeviceModelStatusEnumType status) {
        requiredValidator.validate(status);
        this.status = status;
    }

    public void setCustomData(CustomDataType customData) {
        this.customData = customData;
    }

    public void setStatus(GenericDeviceModelStatusEnumType status) {
        requiredValidator.validate(status);
        this.status = status;
    }

    public void setStatusInfo(StatusInfoType statusInfo) {
        this.statusInfo = statusInfo;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(status);
    }
}