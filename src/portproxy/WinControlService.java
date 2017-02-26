/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portproxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Win系统的 控制方法类
 *
 * @author jerry
 */
public class WinControlService implements OsInterface {

    @Override
    public Vector GetPortList() {
        Vector backVector = new Vector();
        //准备获取转发列表，使用cmd
        BufferedReader cmd_back = CmdB("cmd /c netsh interface  portproxy show  v4tov4");
        //把返回的数据整理成Vector
        String line = null;
        int num = 0;
        try {
            while ((line = cmd_back.readLine()) != null) {

                if (num > 4 && !line.equals("")) {
//                    System.out.println(line);
                    backVector.add(line);
                }
                num = num + 1;
            }
        } catch (IOException ex) {
            Logger.getLogger(WinControlService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return backVector;
    }
 

    @Override
    public Boolean SetOnePort(String FromIp, String FromPort, String ToIp, String ToPort) {
        
        BufferedReader cmd_back = CmdB("cmd /c netsh interface  portproxy  add v4tov4  "
                + "listenaddress=" + FromIp + " listenport=" + FromPort + ""
                + " connectaddress=" + ToIp + "  connectport=" + ToPort + " ");
        
        try {
             
             if(cmd_back.read()!=-1){
               return true;  
             }
        } catch (IOException ex) {
            Logger.getLogger(WinControlService.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }

    @Override
    public Boolean DelOnePort(String DelIp, String DelPort) {
         BufferedReader cmd_back = CmdB("cmd /c netsh interface  portproxy delete v4tov4 listenaddress=" + DelIp + "  listenport=" + DelPort);
        try {
             
             if(cmd_back.read()!=-1){
               return true;  
             }
        } catch (IOException ex) {
            Logger.getLogger(WinControlService.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }

    /**
     * 运行cmd命令并输出结果
     *
     * @param CmdString
     * @return
     */
    public BufferedReader CmdB(String CmdString) {
        BufferedReader CmdTest = null;
        Runtime runtime = Runtime.getRuntime();
        Process p;
        try {
            p = runtime.exec(CmdString);
            CmdTest = new BufferedReader(new InputStreamReader(p.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(WinControlService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return CmdTest;
    }
}
