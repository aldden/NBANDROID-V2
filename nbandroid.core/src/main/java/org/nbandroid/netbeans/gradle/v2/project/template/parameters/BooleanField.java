/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.nbandroid.netbeans.gradle.v2.project.template.parameters;

import android.studio.imports.templates.Parameter;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author arsi
 */
public class BooleanField extends javax.swing.JPanel implements ParameterValueProvider, ItemListener {

    /**
     * Creates new form BooleanField
     */
    private final Parameter parameter;
    private final ParameterUpdateListener updateListener;

    public BooleanField(Parameter parameter, ParameterUpdateListener updateListener) {
        initComponents();
        this.parameter = parameter;
        boolean value = Boolean.valueOf(parameter.initial);
        box.setSelected(value);
        label.setText(parameter.name);
        box.setToolTipText(parameter.help);
        this.updateListener = updateListener;
        box.addItemListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        box = new javax.swing.JCheckBox();

        label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(label, org.openide.util.NbBundle.getMessage(BooleanField.class, "BooleanField.label.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(box, org.openide.util.NbBundle.getMessage(BooleanField.class, "BooleanField.box.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(label)
                    .addComponent(box))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox box;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables

    @Override
    public Parameter getParameter() {
        return parameter;
    }

    @Override
    public Object getValue() {
        return box.isSelected();
    }

    @Override
    public void update(Map<Parameter, Object> values) {
        box.removeItemListener(this);
        Object value = values.get(parameter);
        if ((value instanceof Boolean) && !Objects.equals(value, box.isSelected())) {
            box.setSelected((boolean) value);
        }
        box.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        updateListener.parameterUpdated(parameter, box.isSelected());
    }
}