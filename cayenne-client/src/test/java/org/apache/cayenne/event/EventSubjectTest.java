/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.event;

import org.apache.cayenne.map.EntityResolver;
import org.apache.cayenne.remote.hessian.service.HessianUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class EventSubjectTest {

    @Test
    public void testEqualityOfClonedSubjectsHessian() throws Exception {
        EventSubject s1 = EventSubject.getSubject(EventSubjectTest.class, "MySubject");
        EventSubject s2 = (EventSubject) HessianUtil.cloneViaClientServerSerialization(s1, new EntityResolver());

        assertNotSame(s1, s2);
        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
    }

}
