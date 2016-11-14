/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-11-14 13:24:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title> REST</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var prefix = '/myProject/save';\r\n");
      out.write("\r\n");
      out.write("    var RestGet = function() {\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type: 'GET',\r\n");
      out.write("            url:  prefix + '/' + Date.now(),\r\n");
      out.write("            dataType: 'json',\r\n");
      out.write("            async: true,\r\n");
      out.write("            success: function(result) {\r\n");
      out.write("                alert('Время: ' + result.time\r\n");
      out.write("                        + ', сообщение: ' + result.message);\r\n");
      out.write("            },\r\n");
      out.write("            error: function(jqXHR, textStatus, errorThrown) {\r\n");
      out.write("                alert(jqXHR.status + ' ' + jqXHR.responseText);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var RestPut = function() {\r\n");
      out.write("        var JSONObject= {\r\n");
      out.write("            'time': Date.now(),\r\n");
      out.write("            'message': 'Это пример вызова PUT метода'\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type: 'PUT',\r\n");
      out.write("            url:  prefix,\r\n");
      out.write("            contentType: 'application/json; charset=utf-8',\r\n");
      out.write("            data: JSON.stringify(JSONObject),\r\n");
      out.write("            dataType: 'json',\r\n");
      out.write("            async: true,\r\n");
      out.write("            success: function(result) {\r\n");
      out.write("                alert('Время: ' + result.time\r\n");
      out.write("                        + ', сообщенеи: ' + result.message);\r\n");
      out.write("            },\r\n");
      out.write("            error: function(jqXHR, textStatus, errorThrown) {\r\n");
      out.write("                alert(jqXHR.status + ' ' + jqXHR.responseText);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var RestPost = function() {\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type: 'POST',\r\n");
      out.write("            url:  prefix,\r\n");
      out.write("            dataType: 'json',\r\n");
      out.write("            async: true,\r\n");
      out.write("            success: function(result) {\r\n");
      out.write("                alert('Время: ' + result.time\r\n");
      out.write("                        + ', сообщение: ' + result.message);\r\n");
      out.write("            },\r\n");
      out.write("            error: function(jqXHR, textStatus, errorThrown) {\r\n");
      out.write("                alert(jqXHR.status + ' ' + jqXHR.responseText);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var RestDelete = function() {\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type: 'DELETE',\r\n");
      out.write("            url:  prefix + '/' + Date.now(),\r\n");
      out.write("            dataType: 'json',\r\n");
      out.write("            async: true,\r\n");
      out.write("            success: function(result) {\r\n");
      out.write("                alert('Время: ' + result.time\r\n");
      out.write("                        + ', сообщение: ' + result.message);\r\n");
      out.write("            },\r\n");
      out.write("            error: function(jqXHR, textStatus, errorThrown) {\r\n");
      out.write("                alert(jqXHR.status + ' ' + jqXHR.responseText);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <h3>Это простой пример использования REST c помощью Ajax</h3>\r\n");
      out.write("\r\n");
      out.write("    <button type=\"button\" onclick=\"RestGet()\">Метод GET</button>\r\n");
      out.write("    <button type=\"button\" onclick=\"RestPost()\">Метод POST</button>\r\n");
      out.write("    <button type=\"button\" onclick=\"RestDelete()\">Метод DELETE</button>\r\n");
      out.write("    <button type=\"button\" onclick=\"RestPut()\">Метод PUT</button>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}