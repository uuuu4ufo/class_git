package servlet_examples;

import java.io.*;	//拿掉地10, 15行報錯
import javax.servlet.*;		//拿掉第10行報錯
import javax.servlet.http.*;	//拿掉則7, 9行報錯

public class HelloWorld extends HttpServlet {	//就算不繼承也不會出現編譯錯誤, 因為doGet不是抽象方法

  public void doPost(HttpServletRequest req, HttpServletResponse res)	//override條件1.方法更公開 2.例外只能更低階或沒有
                               throws ServletException, IOException {
	  
	  //用doPost應該要不能執行(但我可以??)

    res.setContentType("text/html; charset=Big5");	//編碼沒有寫就是預設ISO-8859-1(西歐語系)
//  上列(簡易版)等同於=> (標準版)res.setHeader("Content-Type", "text/html; charset=BIG5"); => ContentType太常用
//  可對照form.html的HEAD標籤, 內容是一樣的
    
    PrintWriter out = res.getWriter();	//不能用PrintStream(非西歐語系會亂碼~)

    out.println("<HTML>");
    out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
    out.println("<BODY>");
    out.println("<BIG>Hello World , 世界你好 !</BIG>");
    out.println("</BODY></HTML>");

    //* 課堂補充
    out.println(getServletContext().getAttribute(ServletContext.TEMPDIR));
    // C:\TFA101_WebApp\eclipse_WTP_workspace1\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\SL314
  }
  
  public void doGet(HttpServletRequest req, HttpServletResponse res) 
		  						throws ServletException, IOException {
	  doPost(req,res);
  }
}
