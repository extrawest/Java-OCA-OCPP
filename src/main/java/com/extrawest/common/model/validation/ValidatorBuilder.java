package com.extrawest.common.model.validation;
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

import java.util.ArrayList;

public class ValidatorBuilder {

  private boolean required = false;
  private ArrayList<IValidationRule> rules;

  public ValidatorBuilder() {
    rules = new ArrayList<>();
  }

  public ValidatorBuilder addRule(IValidationRule rule) {
    rules.add(rule);
    return this;
  }

  public ValidatorBuilder setRequired(boolean isRequired) {
    required = isRequired;
    return this;
  }

  public Validator build() {
    Validator validator = new StringValidator(rules.toArray(new IValidationRule[0]));

    if (required) validator = new RequiredDecorator(validator);
    else validator = new OptionalDecorator(validator);

    return validator;
  }
}
