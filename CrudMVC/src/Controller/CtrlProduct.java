package Controller;

import Model.ConsultaProducto;
import Model.Product;
import View.frmProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlProduct implements ActionListener {
    private Product mod;
    private ConsultaProducto modC;
    private frmProduct frm;

    public CtrlProduct(Product mod, ConsultaProducto modC, frmProduct frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.guardarButton.addActionListener(this);
        this.frm.modificarButton.addActionListener(this);
        this.frm.eliminarButton.addActionListener(this);
        this.frm.limpiarButton.addActionListener(this);
        this.frm.buscarButton.addActionListener(this);
    }

    public void iniciar(){
        frm.setTitle("Products");
        frm.setLocationRelativeTo(null);
        frm.textField1.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == frm.guardarButton){
            mod.setCode(frm.textPane1.getText());
            mod.setName(frm.textPane2.getText());
            mod.setPrice(Double.parseDouble(frm.textPane3.getText()));
            mod.setCount(Integer.parseInt(frm.textPane4.getText()));

            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error al guardar");
                limpiar();
            }

        }


        if(e.getSource() == frm.modificarButton){
            mod.setId(Integer.parseInt(frm.textField1.getText()));
            mod.setCode(frm.textPane1.getText());
            mod.setName(frm.textPane2.getText());
            mod.setPrice(Double.parseDouble(frm.textPane3.getText()));
            mod.setCount(Integer.parseInt(frm.textPane4.getText()));

            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error al madificar");
                limpiar();
            }

        }


        if(e.getSource() == frm.eliminarButton){
            mod.setId(Integer.parseInt(frm.textField1.getText()));

            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "registro eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error al eliminar");
                limpiar();
            }

        }


        if(e.getSource() == frm.buscarButton){
            mod.setCode(frm.textPane1.getText());

            if(modC.buscar(mod)){
                frm.textPane1.setText(mod.getCode());
                frm.textPane2.setText(mod.getName());
                frm.textPane3.setText(String.valueOf(mod.getPrice()));
                frm.textPane4.setText(String.valueOf(mod.getCount()));
                frm.textField1.setText(String.valueOf(mod.getId()));

            }else{
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }

        }

        if(e.getSource() == frm.eliminarButton){
            limpiar();
        }

    }

    public void limpiar(){
        frm.textPane1.setText(null);
        frm.textPane2.setText(null);
        frm.textPane3.setText(null);
        frm.textPane4.setText(null);
        frm.textField1.setText(null);
    }

}
