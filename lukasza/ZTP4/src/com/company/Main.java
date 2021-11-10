package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        final Baza dane = new Baza();

        final JFrame frame = new JFrame("Zadanie 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane splitPane = new JSplitPane();

        Adapter adapter=new Adapter(new RealData(0));

        final JList<Data> list = new JList<>(dane);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Tablice: "));
        splitPane.setLeftComponent(scrollPane);

        JTable table = new JTable(adapter/* ... tutaj dodaj adapter: TableModel ... */);
        table.getColumnModel().getColumn(0).setHeaderValue("id");
        table.getColumnModel().getColumn(1).setHeaderValue("zawartość");
        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Zawartość: "));
        splitPane.setRightComponent(scrollPane);

        frame.getContentPane().add(splitPane);

        JMenuBar bar = new JMenuBar();
        JButton add = new JButton("Dodaj tablicę");
        JButton del = new JButton("Usuń tablicę");
        JButton copy = new JButton("Kopiuj tablicę");
        bar.add(add);
        bar.add(del);
        bar.add(copy);

        frame.setJMenuBar(bar);

        frame.setSize(600, 450);
        frame.setVisible(true);

        splitPane.setDividerLocation(0.5);

        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog(frame,
                        "Podaj rozmiar tablicy",
                        "Dodaj",
                        JOptionPane.INFORMATION_MESSAGE);
                try{
                    int size = Integer.parseInt(value);
                    dane.add(new PropData(size));
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(frame,"Podaj ilość");

                };
            }
        });

        del.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int idx = list.getSelectedIndex();
                try{
                    dane.remove(idx);
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(frame,"Wybierz tablice którą chcesz usunąć");
                };
            }
        });

        copy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    dane.add(new CopyData(list.getSelectedValue()));
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(frame,"Wybierz tablice którą chcesz usunąć");
                };
            }
        });


        // zmiana wyboru na liście powoduje odświeżenie tabeli
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int idx = list.getSelectedIndex();
                if (idx >= 0) {
                    adapter.setContent(list.getSelectedValue());
                }
            }
        });
    }
}
