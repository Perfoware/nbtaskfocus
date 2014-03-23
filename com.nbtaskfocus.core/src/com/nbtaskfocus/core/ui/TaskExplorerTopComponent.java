/*
 * The MIT License
 *
 * Copyright 2011 Tushar Joshi, Nagpur.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.nbtaskfocus.core.ui;

import com.nbtaskfocus.core.ui.nodes.TaskRootNode;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.explorer.view.TreeView;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.nbtaskfocus.core.ui//TaskExplorer//EN",
autostore = false)
@TopComponent.Description(preferredID = "TaskExplorerTopComponent",
iconBase = "com/nbtaskfocus/core/ui/resources/tasklist_icon.png",
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
@ActionID(category = "Window", id = "com.nbtaskfocus.core.ui.TaskExplorerTopComponent")
@ActionReference(path = "Menu/Window/Task Focus", position = 333)
@TopComponent.OpenActionRegistration(displayName = "#CTL_TaskExplorerAction",
preferredID = "TaskExplorerTopComponent")
public final class TaskExplorerTopComponent extends TopComponent 
implements ExplorerManager.Provider {

    private transient final ExplorerManager manager = new ExplorerManager();
    
    public TaskExplorerTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(TaskExplorerTopComponent.class, "CTL_TaskExplorerTopComponent"));
        setToolTipText(NbBundle.getMessage(TaskExplorerTopComponent.class, "HINT_TaskExplorerTopComponent"));

        manager.setRootContext(new TaskRootNode());
        setDisplayName (NbBundle.getMessage(TaskEditorTopComponent.class, "TITLE_TaskExplorer"));
        ((TreeView)jScrollPane1).setQuickSearchAllowed(true);
        
        associateLookup(ExplorerUtils.createLookup(manager, getActionMap()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new BeanTreeView();

        setLayout(new java.awt.BorderLayout());
        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public void requestActive() {
        super.requestActive();
        jScrollPane1.requestFocusInWindow();
    }

    @Override
    protected void componentActivated() {
        ExplorerUtils.activateActions(manager, true);
    }

    @Override
    protected void componentDeactivated() {
        ExplorerUtils.activateActions(manager, false);
    }
    
    @Override
    public ExplorerManager getExplorerManager() {
        return manager;
    }
}