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

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Window;

public class LocationApplication extends Application {

    public void init() {
        Window mainWindow = new Window("Location Form Sample");

        Button button = new Button("Open Location Form");
        button.setWidth("150px");
        button.setHeight("30px");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                Window window = new Window("Update Location");
                window.addComponent(new LocationForm());
                window.setModal(true);
                window.setResizable(false);
                window.setWidth("510px");
                window.setHeight("370px");
                getMainWindow().addWindow(window);
                window.center();
            }
        });
        mainWindow.addComponent(button);
        setMainWindow(mainWindow);
    }
}
