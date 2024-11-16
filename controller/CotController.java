/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Admin;
import view.CotAdminFrame;

/**
 *
 * @author Aline Rocha
 */
public class CotController {
    private CotAdminFrame view;
    private Admin admin;

    public CotController(CotAdminFrame view, Admin admin) {
        this.view = view;
        this.admin = admin;
    }

    public CotController() {
    }
    
    
}
