/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Admin;
import view.MenuAdminFrame;

/**
 *
 * @author Aline Rocha
 */
public class MenuController {
    private MenuAdminFrame view;
    private Admin admin;

    public MenuController(MenuAdminFrame view, Admin admin) {
        this.view = view;
        this.admin = admin;
    }

    public MenuController() {
    }

    public MenuAdminFrame getView() {
        return view;
    }

    public void setView(MenuAdminFrame view) {
        this.view = view;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
}
