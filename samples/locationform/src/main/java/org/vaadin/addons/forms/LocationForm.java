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

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class LocationForm extends GridForm {

    public LocationForm() {
        super(3, 5);
        this.setSizeFull();
        this.setImmediate(false);
        this.setWriteThrough(false);
        this.setReadThrough(false);

        GridConstraints constraints = new GridConstraints();
        constraints.addConstraint("address1", 0, 0, 1, 0);
        constraints.addConstraint("address2", 2, 0);
        constraints.addConstraint("city", 0, 1);
        constraints.addConstraint("state", 1, 1);
        constraints.addConstraint("zip", 2, 1);
        constraints.addConstraint("notes", 0, 2, 1, 4);
        constraints.addConstraint("county", 2, 2);
        constraints.addConstraint("x", 2, 3);
        constraints.addConstraint("y", 2, 4);

        this.setItemDataSource(new BeanItem<Location>(new Location()), constraints);

        this.getField("address1").setCaption("Address");
        this.getField("address1").setRequired(true);
        this.getField("address2").setCaption("Apt./Suite");

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);
        layout.setWidth("100%");

        Label label = new Label();
        layout.addComponent(label);

        Button cancelButton = new Button("Cancel");
        cancelButton.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                discard();
                close();
            }
        });
        layout.addComponent(cancelButton);

        Button saveButton = new Button("Save");
        saveButton.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                commit();
                close();
            }
        });
        layout.addComponent(saveButton);

        layout.setExpandRatio(label, 1);

        this.setFooter(layout);
    }

    private void close() {
        getApplication().getMainWindow().removeWindow(getWindow());
    }
}
