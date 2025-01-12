package com.extrawest.ocpp_2_0_1.model.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpp_2_0_1.util.EnumUtil.findByField;


/**
 * This field specifies the connector type.
 *
 *
 */
public enum ConnectorEnumType {

    C_CCS_1("cCCS1"),
    C_CCS_2("cCCS2"),
    C_G_105("cG105"),
    C_TESLA("cTesla"),
    C_TYPE_1("cType1"),
    C_TYPE_2("cType2"),
    S_309_1_P_16_A("s309-1P-16A"),
    S_309_1_P_32_A("s309-1P-32A"),
    S_309_3_P_16_A("s309-3P-16A"),
    S_309_3_P_32_A("s309-3P-32A"),
    S_BS_1361("sBS1361"),
    S_CEE_7_7("sCEE-7-7"),
    S_TYPE_2("sType2"),
    S_TYPE_3("sType3"),
    OTHER_1_PH_MAX_16_A("Other1PhMax16A"),
    OTHER_1_PH_OVER_16_A("Other1PhOver16A"),
    OTHER_3_PH("Other3Ph"),
    PAN("Pan"),
    W_INDUCTIVE("wInductive"),
    W_RESONANT("wResonant"),
    UNDETERMINED("Undetermined"),
    UNKNOWN("Unknown");
    private final String value;

    ConnectorEnumType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static ConnectorEnumType fromValue(String value) {
        return findByField(
                ConnectorEnumType.class,
                ConnectorEnumType::value,
                value
        );
    }
}
