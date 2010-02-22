/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/

package org.apache.cayenne.modeler.dialog.validator;

import javax.swing.JFrame;

import org.apache.cayenne.configuration.DataChannelDescriptor;
import org.apache.cayenne.map.DataMap;
import org.apache.cayenne.modeler.Application;
import org.apache.cayenne.modeler.ProjectController;
import org.apache.cayenne.modeler.event.DataMapDisplayEvent;
import org.apache.cayenne.project2.validate.ValidationInfo;

/**
 * DataMap validation message.
 */
public class DataMapErrorMsg extends ValidationDisplayHandler {

    protected DataMap map;

    public DataMapErrorMsg(ValidationInfo result) {
        super(result);

        Object object = result.getValidatedObject();
        map = (DataMap) object;
        domain = (DataChannelDescriptor) Application.getProject().getRootNode();
    }

    public void displayField(ProjectController mediator, JFrame frame) {
        DataMapDisplayEvent event;
        event = new DataMapDisplayEvent(frame, map, domain);
        mediator.fireDataMapDisplayEvent(event);
    }
}
