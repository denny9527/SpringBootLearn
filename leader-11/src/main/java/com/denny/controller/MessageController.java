/**   
 * @Title: MessageController.java 
 * @Package com.denny.controller 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年11月5日 下午2:53:15 
 * @version V1.0   
 */
package com.denny.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @ClassName: MessageController 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年11月5日 下午2:53:15 
 *  
 */
@Controller
public class MessageController {

    @MessageMapping("/message/send")
    @SendTo("/topic/greetings")
    public Response greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Response("Hello, " + message.getName() + "!");
    }

    @RequestMapping("/message/send_page")
    public String sendPage(Message message) {
        return "message/send_messge";
    }
}
