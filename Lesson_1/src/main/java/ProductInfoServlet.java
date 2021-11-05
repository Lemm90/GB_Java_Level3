import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductInfoServlet", urlPatterns = "/info")
public class ProductInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList <Product> arrayList = new ArrayList<>();
        init(arrayList);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < arrayList.size(); i++) {
            resp.getWriter().printf("<h1> Product: %s; Cost: %s </h1>", arrayList.get(i).name, arrayList.get(i).cost);
            resp.getWriter().println(" ");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    public void init(ArrayList<Product> arrayList) throws ServletException {
        arrayList.add(new Product(1, "milk", 22));
        arrayList.add(new Product(2, "apple", 9));
        arrayList.add(new Product(3, "pork", 7));
        arrayList.add(new Product(4, "potato", 25));
        arrayList.add(new Product(5, "water", 2));
        arrayList.add(new Product(6, "egg", 77));
        arrayList.add(new Product(7, "sausage", 103));
        arrayList.add(new Product(8, "cheese", 45));
        arrayList.add(new Product(9, "chocolate", 8));
        arrayList.add(new Product(10, "crackers", 23));
    }
}