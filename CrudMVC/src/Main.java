import Controller.CtrlProduct;
import Model.ConsultaProducto;
import Model.Product;
import View.frmProduct;

public class Main {
    public static void main(String[] args) {

        Product mod = new Product();
        ConsultaProducto modC = new ConsultaProducto();
        frmProduct frm = new frmProduct();

        CtrlProduct ctrl = new CtrlProduct(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);

    }
}