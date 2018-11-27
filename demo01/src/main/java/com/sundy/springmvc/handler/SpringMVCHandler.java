package com.sundy.springmvc.handler;

import com.sundy.springmvc.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
//@RequestMapping(value="/springmvc")
public class SpringMVCHandler {
    /**
     * 测试原生的Servlet API
     *
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("request: " + request);

        System.out.println("response: " + response);
        // 转发
        //request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);

        // 重定向  将数据写给客户端
        //response.sendRedirect("http://www.baidu.com");

        response.getWriter().println("Hello Springmvc ");
    }

    /**
     * POJO
     */
    @RequestMapping("/testPOJO")
    public String testPOJO(User user) {
        System.out.println("user:" + user);
        return "success";
    }

    /**
     * @CookieValue 映射cookie信息到请求处理方法的形参中
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("sessionid:" + sessionId);
        return "success";
    }

    /**
     * @RequestHeader 映射请求头信息到请求处理方法的形参中
     */

    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String acceptLanguage) {
        System.out.println("acceptLanguage:" + acceptLanguage);
        return "success";
    }

    /**
     * @RequestParam 映射请求参数到请求处理方法的形参
     * 1. 如果请求参数名与形参名一致， 则可以省略@RequestParam的指定。
     * 2. @RequestParam 注解标注的形参必须要赋值。 必须要能从请求对象中获取到对应的请求参数。
     * 可以使用required来设置为不是必须的。
     * 3. 可以使用defaultValue来指定一个默认值取代null
     * 客户端的请求:testRequestParam?username=Tom&age=22
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String username,
                                   @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        //web: request.getParameter()    request.getParameterMap()

        System.out.println(username + " , " + age);

        return "success";
    }


    /**
     * REST PUT
     */
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public String testRestPUT() {
        System.out.println("REST PUT");
        return "success";
    }

    /**
     * REST POST
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String testRestPOST() {
        System.out.println("REST POST");

        return "success";
    }


    /**
     * REST DELETE
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public String testRestDELETE(@PathVariable("id") Integer id) {
        System.out.println("REST DELETE: " + id);
        return "success";
    }

    /**
     * REST GET
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String testRestGET(@PathVariable("id") Integer id) {
        System.out.println("REST GET: " + id);
        return "success";
    }

    /**
     * 带占位符的URL
     * <p>
     * 浏览器:  http://localhost:8888/Springmvc01/testPathVariable/admin/1001
     */
    @RequestMapping(value = "/testPathVariable/{name}/{id}")
    public String testPathVariable(@PathVariable("name") String name, @PathVariable("id") Integer id) {
        System.out.println(name + " : " + id);

        return "success";
    }


    /**
     * @RequestMapping 映射请求参数   以及  请求头信息
     * <p>
     * params  : username=tom&age=22
     * headers
     */

    @RequestMapping(value = "/testRequestMappingParamsAndHeaders",
            params = {"username", "age=22"},
            headers = {"Accept-Language"})
    public String testRequestMappingParamsAndHeaders() {
        System.out.println("xxxxxxxxxx");
        return "success";
    }


    /**
     * @RequestMapping method 映射请求方式
     */
    @RequestMapping(value = "/testRequestMappingMethod", method = {RequestMethod.POST, RequestMethod.GET})
    public String testRequestMappingMethod() {
        return "success";
    }

    /**
     * @RequestMapping
     */
    @RequestMapping(value = "/testRequestMapping")
    public String testRequestMapping() {
        return "success";
    }
}
