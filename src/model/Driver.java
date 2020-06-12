/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ControllerMenu;

/**
 *
 * @author ventodeco
 */
public class Driver {
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
        ControllerMenu cm = new ControllerMenu(app);
    }
}
