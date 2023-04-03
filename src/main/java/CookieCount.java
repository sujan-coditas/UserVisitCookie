import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookieCount")
public class CookieCount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        try{

            if(req.getCookies()==null){
                out.println("no cookies");
                Cookie co=new Cookie("visitCount","1");
                resp.addCookie(co);
            }
            else {
                int noctr=0;
                Cookie[] all=req.getCookies();
                for(int i=0;i<all.length;i++){
                    if(all[i].getName().equals("visitCount")){
                        out.println(all[i].getValue());
                        noctr=1;
                        break;
                    }
                }
                if(noctr==0){
                    Cookie co=new Cookie("visitCount","1");
                    resp.addCookie(co);
                }
            }


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
