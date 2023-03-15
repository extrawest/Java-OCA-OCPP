package eu.chargetime.ocpp.model.dataTypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.chargetime.ocpp.model.Validatable;
import eu.chargetime.ocpp.model.validation.RequiredValidator;
import eu.chargetime.ocpp.model.validation.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;


/**
 * Consumption_ Cost
 * urn:x-oca:ocpp:uid:2:233259
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customData",
        "startValue",
        "cost"
})
@Getter
@EqualsAndHashCode
public class ConsumptionCost implements Validatable {

    private transient Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     *
     */
    @JsonProperty("customData")
    private CustomData customData;
    /**
     * Consumption_ Cost. Start_ Value. Numeric
     * urn:x-oca:ocpp:uid:1:569246
     * The lowest level of consumption that defines the starting point of this consumption block. The block interval extends to the start of the next interval.
     *
     * (Required)
     *
     */
    @JsonProperty("startValue")
    private Double startValue;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("cost")
    private List<CostType> costType;

    public ConsumptionCost(Double startValue, List<CostType> costType) {
        this.startValue = startValue;
        this.costType = costType;
    }

    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    public void setStartValue(Double startValue) {
        requiredValidator.validate(startValue);
        this.startValue = startValue;
    }

    public void setCostType(List<CostType> costType) {
        requiredValidator.validate(costType);
        this.costType = costType;
    }

    @Override
    public boolean validate() {
        return costType.stream().filter(CostType::validate).count() == costType.size()
                &&requiredValidator.safeValidate(costType)
                &&requiredValidator.safeValidate(startValue);
    }
}