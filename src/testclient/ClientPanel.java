/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mah537
 */
public class ClientPanel extends JPanel implements ActionListener{
    
    
    JPanel buttonPanel = new JPanel();
    ArrayList<JButton> buttons;
    int numberOfButtons = 6;
    int bPanelHeight;
    int bPanelWidth;
    int buttonSize;// = 40;
    JButton newSiteButton;
    
    public ClientPanel(){
        
        super();
        setLayout(null);
        buttonSize = 40;
        createButtonArray(numberOfButtons);
        buttonPanel = createButtonPanel(buttons);
        buttonPanel.setBounds(50, 50, bPanelWidth, bPanelHeight);
        add(buttonPanel);
        newSiteButton = new JButton();
        newSiteButton.addActionListener(this);
        newSiteButton.setBounds(150, 350, 80, 40);
        newSiteButton.setText("new");
        add(newSiteButton);
        
    }
 
    
    
    
    
    
    private void createButtonArray(int numberOfButtons){
        
        buttons = new ArrayList();
      for(int i = 0; i < numberOfButtons; i++){
          JButton b = new JButton();
       buttons.add(b);
          
      }  
        
        
    }
    
private JPanel createButtonPanel(ArrayList buttonArray){
    JPanel p = new JPanel();
    int across = 4;//(buttonArray.size()%4) + 1;
    bPanelWidth = 200;//across * buttonSize;
    int down  = (buttonArray.size()/4) + 1;
    bPanelHeight = down * buttonSize;
    System.out.println("bPanelWidth: " + bPanelWidth + "(" + across + "*" + buttonSize + ") "  
            +  " bPanelHeight: " + bPanelHeight+ "(" + down + "*" + buttonSize + ") "  );
      p.setLayout(new GridLayout(across ,down));
      System.out.println("grid layout: " + across + " by " + down);
        for(int i = 0; i < buttons.size(); i++){
        buttons.get(i).setText(""+i);
       p.add(buttons.get(i));
          
      } 
        
     return p;   
}    

    @Override
    public void actionPerformed(ActionEvent e) {
        remove(buttonPanel);
       numberOfButtons++; 
      createButtonArray(numberOfButtons);
      buttonPanel = createButtonPanel(buttons);
      buttonPanel.setBounds(50, 50, bPanelWidth, bPanelHeight);
      buttonPanel.repaint();
    }
    
    
    
}
