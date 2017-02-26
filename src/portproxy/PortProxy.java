/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portproxy;

import javax.swing.JOptionPane;

/**
 *
 * @author jerry
 */
public class PortProxy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //跳转到主界面

       String osname=System.getProperty("os.name");
       if(osname.indexOf("Windows")<0){
          JOptionPane.showMessageDialog(null, "目前仅支持Windows系统!请在Win下打开", "提示", JOptionPane.INFORMATION_MESSAGE);
        return; 
       }
        
        MainJFrame main = new MainJFrame();
        main.setVisible(true);

    }

}
