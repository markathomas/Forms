/*
 *
 *  * Licensed to the Apache Software Foundation (ASF) under one or more
 *  * contributor license agreements.  See the NOTICE file distributed with
 *  * this work for additional information regarding copyright ownership.
 *  * The ASF licenses this file to You under the Apache License, Version 2.0
 *  * (the "License"); you may not use this file except in compliance with
 *  * the License.  You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.vaadin.addons.forms;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class GridConstraints {

    private final Map<Object, GridConstraint> constraintMap = new LinkedHashMap<Object, GridConstraint>();

    public void addConstraint(Object propertyId, int col, int row) {
        this.addConstraint(propertyId, col, row, col, row);
    }

    public void addConstraint(Object propertyId, int col, int row, int col1, int row1) {
        this.addConstraint(propertyId, new GridConstraint(col, row, col1, row1));
    }

    public void addConstraint(Object propertyId, GridConstraint constraint) {
        if (propertyId == null)
            throw new IllegalArgumentException("propertyId cannot be null");
        if (constraint == null)
            throw new IllegalArgumentException("grid constraint cannot be null");
        this.constraintMap.put(propertyId, constraint);
    }

    public GridConstraint removeConstraint(Object propertyId) {
        return this.constraintMap.remove(propertyId);
    }

    public GridConstraint getContraint(Object propertyId) {
        return this.constraintMap.get(propertyId);
    }

    public Set<Object> getPropertyIds() {
        return Collections.unmodifiableSet(this.constraintMap.keySet());
    }

    void clear() {
        this.constraintMap.clear();
    }

    Set<Map.Entry<Object, GridConstraint>> entrySet() {
        return this.constraintMap.entrySet();
    }

    int size() {
        return this.constraintMap.size();
    }
}
