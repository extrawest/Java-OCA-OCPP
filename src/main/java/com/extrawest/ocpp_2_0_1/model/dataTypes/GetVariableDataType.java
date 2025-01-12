package com.extrawest.ocpp_2_0_1.model.dataTypes;
/*
   ChargeTime.eu - Java-OCA-OCPP

   MIT License

   Copyright (C) 2018 Thomas Volden <tv@chargetime.eu>

   Permission is hereby granted, free of charge, to any person obtaining a copy
   of this software and associated documentation files (the "Software"), to deal
   in the Software without restriction, including without limitation the rights
   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
   copies of the Software, and to permit persons to whom the Software is
   furnished to do so, subject to the following conditions:

   The above copyright notice and this permission notice shall be included in all
   copies or substantial portions of the Software.

   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
   SOFTWARE.
*/

import com.extrawest.common.model.Validatable;
import com.extrawest.ocpp_2_0_1.model.dataTypes.enums.AttributeEnumType;
import com.extrawest.common.model.validation.RequiredValidator;
import com.extrawest.common.model.validation.Validator;
import com.extrawest.common.utilities.MoreObjects;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
public class GetVariableDataType implements Validatable {
  private final transient Validator<Object> requiredValidator = new RequiredValidator();

  private AttributeEnumType attributeType;
  private ComponentType component;
  private VariableType variable;

  public GetVariableDataType(ComponentType component, VariableType variable) {
    requiredValidator.validate(component);
    requiredValidator.validate(variable);
    this.component = component;
    this.variable = variable;
  }

  /**
   * Optional. Attribute type for which value is requested. When absent, default Actual is assumed.
   *
   * @param attributeType {@link AttributeEnumType}
   */
  public void setAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
  }

  /**
   * Required. Component for which the Variable is requested.
   *
   * @param component {@link ComponentType}
   */
  public void setComponent(ComponentType component) {
    requiredValidator.validate(component);
    this.component = component;
  }

  /**
   * Required. Variable for which the attribute value is requested.
   *
   * @param variable {@link VariableType}
   */
  public void setVariable(VariableType variable) {
    requiredValidator.validate(variable);
    this.variable = variable;
  }

  @Override
  public boolean validate() {
    return requiredValidator.safeValidate(component)
        && requiredValidator.safeValidate(variable)
        && component.validate()
        && variable.validate();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GetVariableDataType that = (GetVariableDataType) o;
    return Objects.equals(attributeType, that.attributeType)
        && Objects.equals(component, that.component)
        && Objects.equals(variable, that.variable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeType, component, variable);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("attributeType", attributeType)
        .add("component", component)
        .add("variable", variable)
        .toString();
  }
}
