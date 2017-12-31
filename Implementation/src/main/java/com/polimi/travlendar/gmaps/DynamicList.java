/*
 * Copyright 2017 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.polimi.travlendar.gmaps;

import com.vaadin.ui.Button;
import com.vaadin.ui.ItemCaptionGenerator;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class DynamicList extends VerticalLayout {
    
    private SelectionListener listener;
    
    private List<Object> list;   
    private List<Button> buttons;
    
    int dimension;
    
    private ItemCaptionGenerator captionGenerator;
    
    public DynamicList(SelectionListener listener, int dimension, ItemCaptionGenerator captionGenerator){
        this.listener = listener;
        list = new ArrayList<Object>();
        this.setSpacing(false);
        this.setWidth("300px");
        this.dimension = dimension;
        this.captionGenerator = captionGenerator;
        this.addComponent(new Label("Predictions list"));
    }
    
    public DynamicList(SelectionListener listener, int dimension) {
        this(listener, dimension, new DefaultCaptionGenerator());
    }
    
    public void setList(List<Object> newList){
        list.clear();
        list.addAll(newList);
        while(list.size()>dimension){
            list.remove(list.size()-1);
        }
        this.removeAllComponents();
        for(Object o : list){
            Button b = new Button(captionGenerator.apply(o));
            b.setWidth("300px");
            b.addClickListener(e -> {
               listener.listen(o);
            });
            this.addComponent(b);
        }
    }

}
