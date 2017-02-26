/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package portproxy;

import java.util.Vector;

/**
 *所有Os定义统一的方法接口
 * @author jerry
 */
public interface OsInterface {
    
    /**
     * 获得已经生效的转发规则列表
     * @return 返回Vector对象数组
     */
    public Vector GetPortList();
    
    /**
     * 添加一个新的端口转发
     * @param FromIp    源IP
     * @param FromPort  源端口
     * @param ToIp      转发到ip
     * @param ToPort    转发到端口
     * @return true 成功 false 失败
     */
    public Boolean SetOnePort(String FromIp,String FromPort,String ToIp,String ToPort);
    
    /**
     * 删除一个接口转发
     * @param DelIp     源IP
     * @param DelPort   源端口
     * @return true 成功 false 失败
     */
    public Boolean DelOnePort(String DelIp,String DelPort);
}
