package com.company;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main {

    public static void main (String[] args){
        GUI UI = new GUI ();
        UI.setVisible(true);
        UI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    // write your code here
    }

