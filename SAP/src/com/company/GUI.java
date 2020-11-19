package com.company;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

public class GUI extends JFrame {
    private JPanel Panel;
    private JButton swapWordsButton;
    private JButton swapLinesButton;
    private JTextField DocumentName;
    private JTextField IndexLine1;
    private JTextField IndexLine2;
    private JTextField IndexLine3;
    private JTextField IndexLine4;
    private JTextArea Info;
    private JButton LoadFile;
    private JButton saveFileButton;
    private JScrollPane Scroller;


    public GUI() throws IndexOutOfBoundsException{
        WordOrder order = new WordOrder ();
        setTitle("WordSwapper");
        add(Panel);
        setSize(1200,700);
        swapLinesButton.addActionListener (e -> {
            try {
                order.swapLines (Integer.parseInt (IndexLine1.getText ()), Integer.parseInt (IndexLine2.getText ()));
            }catch(IndexOutOfBoundsException ib){
                JOptionPane.showMessageDialog(Panel, "Invalid indexes. Please enter valid indexes");
            }
            PrintWords (order);
        });
        swapWordsButton.addActionListener (e -> {
            try {
            order.swapWords (Integer.parseInt(IndexLine1.getText ()), Integer.parseInt (IndexLine2.getText ()), Integer.parseInt(IndexLine3.getText ()), Integer.parseInt (IndexLine4.getText ()));
            }catch(IndexOutOfBoundsException iob){
                JOptionPane.showMessageDialog(Panel, "Invalid indexes. Please enter valid indexes");
            }
            PrintWords (order);

        });
        DocumentName.addFocusListener (new FocusAdapter () {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained (e);
            }
        });


        LoadFile.addActionListener  (e -> {
            try {

                order.wordReading (DocumentName.getText ());
            }catch(IOException IOE){
                JOptionPane.showMessageDialog(Panel, "File failed to load. Try entering a valid path");
            }finally{
                JOptionPane.showMessageDialog(Panel, "File successfully loaded");
            }
           PrintWords (order);

        });
        saveFileButton.addActionListener (e -> {
            try{
                order.wordWriting (DocumentName.getText ());

            }catch(IOException ioe){
                JOptionPane.showMessageDialog(Panel, "File failed to save.");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(Panel, "File error");
                Info.append ("File  error");
                Info.append (ex.getMessage ());
            }finally{
                JOptionPane.showMessageDialog(Panel, "File successfully written");
            }
        });
    Scroller.addFocusListener(new FocusAdapter() { } );}
    private void PrintWords(WordOrder order){
        Info.setText ("");
        for(int i =0; i< order.LinesList.size (); i++){
            Info.append (order.LinesList.get (i));
            Info.append ("\n");
        }

    }

    private void createUIComponents() {


        // TODO: place custom component creation code here

    }


}

