/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package portproxy;

import java.util.Vector;

/**
 *Linux类系统控制类
 * @author jerry
 */
public class LinuxControlService implements OsInterface{
 
       @Override
    public Vector GetPortList() {
        Vector backVector = new Vector();

 
        
        return backVector;
    }
 

    @Override
    public Boolean SetOnePort(String FromIp, String FromPort, String ToIp, String ToPort) {
        return false;
    }

    @Override
    public Boolean DelOnePort(String DelIp, String DelPort) {
        return false;
    }
}
