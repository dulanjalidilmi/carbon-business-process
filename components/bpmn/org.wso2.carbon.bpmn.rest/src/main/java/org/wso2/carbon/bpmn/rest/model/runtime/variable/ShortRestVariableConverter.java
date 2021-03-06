/**
 *  Copyright (c) 2015 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */



package org.wso2.carbon.bpmn.rest.model.runtime.variable;

import org.activiti.engine.ActivitiIllegalArgumentException;
import org.wso2.carbon.bpmn.rest.engine.variable.RestVariable;


public class ShortRestVariableConverter implements RestVariableConverter {

  @Override
  public String getRestTypeName() {
    return "short";
  }

  @Override
  public Class< ? > getVariableType() {
    return Short.class;
  }

  @Override
  public Object getVariableValue(RestVariable result) {
    if(result.getValue() != null) {
      if(!(result.getValue() instanceof Number)) {
        throw new ActivitiIllegalArgumentException("Converter can only convert shorts");
      }
      return ((Number) result.getValue()).shortValue();
    }
    return null;
  }

  @Override
  public void convertVariableValue(Object variableValue, RestVariable result) {
    if(variableValue != null) {
      if(!(variableValue instanceof Short)) {
        throw new ActivitiIllegalArgumentException("Converter can only convert shorts");
      }
      result.setValue(variableValue);
    } else {
      result.setValue(null);
    }
  }

}
