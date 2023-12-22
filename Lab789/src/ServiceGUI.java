
import Services.Auto.CarService;
import Services.Auto.TruckService;
import Services.ComputingTechnics.ComputerService;
import Services.ComputingTechnics.PhoneService;
import Services.Service;
import Technics.ComputerTechnics.Computer;
import Technics.ComputerTechnics.Phone;
import Technics.Technic;
import Technics.Transport.Car;
import Technics.Transport.Truck;

import javax.swing.DefaultListCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ServiceGUI extends JFrame {
    List<String> history = new ArrayList<>();
    List<Technic> Technics = new ArrayList<>();
    public JComboBox<ComboString> Combo = new JComboBox<>();
    private final JTextField textField1 = new JTextField(5);
    private final JTextField textField2 = new JTextField(5);
    private final JRadioButton computerRadio = new JRadioButton("Computer", false);
    private final JRadioButton phoneRadio = new JRadioButton("Phone");
    private final JRadioButton truckRadio = new JRadioButton("Truck");
    private final JRadioButton carRadio = new JRadioButton("Car");
    private final JLabel label1 = new JLabel("Ram");
    private final JLabel label2 = new JLabel("CPUcores");
    private JButton repairButton = new JButton("Repair");
    private JTextArea area = new JTextArea("История \n");
    private JButton historyButton = new JButton("History");
    private JScrollPane scroll = new JScrollPane(area);

    public ServiceGUI() {
        super("Service");
        this.setBounds(100, 100, 500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 5, 2));
        container.add(label1);
        container.add(textField1);
        container.add(label2);
        container.add(textField2);
        ButtonGroup typeOfTechnic = new ButtonGroup();
        typeOfTechnic.add(computerRadio);
        typeOfTechnic.add(phoneRadio);
        typeOfTechnic.add(truckRadio);
        typeOfTechnic.add(carRadio);
        computerRadio.setSelected(true);
        container.add(computerRadio);
        container.add(phoneRadio);
        container.add(truckRadio);
        container.add(carRadio);
        JButton addButton = new JButton("To add technic");
        container.add(addButton);
        addButton.addActionListener(new AddAction());
        JButton smashButton = new JButton("To smash technic");
        container.add(smashButton);
        smashButton.addActionListener(new SmashAction());
        Combo.setRenderer(new MyItemRenderer());
        container.add(repairButton);
        repairButton.addActionListener(new RepairAction());
        container.add(Combo);
        container.add(historyButton);
        historyButton.addActionListener(new HistoryAction());
        container.add(scroll);
        area.setEditable(false);
        computerRadio.addActionListener(new RadioAction());
        phoneRadio.addActionListener(new RadioAction());
        truckRadio.addActionListener(new RadioAction());
        carRadio.addActionListener(new RadioAction());
    }

    class RadioAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (computerRadio.isSelected()) {
                label1.setText("Ram");
                label2.setText("CPUcores");
            } else if (phoneRadio.isSelected()) {
                label1.setText("Brand");
                label2.setText("CPUcores");
            } else if (carRadio.isSelected()) {
                label1.setText("carBrand");
                label2.setText("Transmission(true/false)");
            } else if (truckRadio.isSelected()) {
                label1.setText("carBrand");
                label2.setText("Capacity");
            }


        }
    }

    class HistoryAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder text = new StringBuilder(" ");
            for (int count = 0; count < history.size(); count++) {
                text.append(history.get(count));
            }
            area.setText(text.toString());
        }
    }


    class AddAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = " ";

            if (computerRadio.isSelected()) {
                if (tryParseInt(textField1.getText()) && tryParseInt(textField2.getText())) {
                    Technics.add(new Computer(Technics.size(), Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText()), true));
                    Combo.addItem(new ComboString((Technics.size() - 1) + " Computer  ", Technics.get(Technics.size() - 1).getCondition()));
                    text = " Ram: " + textField1.getText() + " CPUcores " + textField2.getText();
                } else history.add("Failed add operation(wrong format)\n");
            }

            if (phoneRadio.isSelected()) {
                if (!textField1.getText().isEmpty() && tryParseInt(textField2.getText())) {
                    Technics.add(new Phone(Technics.size(), textField1.getText(), Integer.parseInt(textField2.getText()), true));
                    Combo.addItem(new ComboString((Technics.size() - 1) + " Phone  ", Technics.get(Technics.size() - 1).getCondition()));
                    text = " Brand: " + textField1.getText() + " CPUcores: " + textField2.getText();
                    history.add("Added " + Combo.getItemAt(Technics.size() - 1).FirstString + text + "\n");
                } else history.add("Failed add operation(wrong format) \n");
            }
            if (truckRadio.isSelected()) {
                if (!textField1.getText().isEmpty() && tryParseFloat(textField2.getText())) {
                    Technics.add(new Truck(Technics.size(), textField1.getText(), Float.parseFloat(textField2.getText()), true));
                    Combo.addItem(new ComboString((Technics.size() - 1) + " Truck  ", Technics.get(Technics.size() - 1).getCondition()));
                    text = " CarBrand: " + textField1.getText() + " Capacity: " + textField2.getText();
                    history.add("Added " + Combo.getItemAt(Technics.size() - 1).FirstString + text + "\n");
                } else history.add("Failed add operation(wrong format) \n");
            }
            if (carRadio.isSelected()) {
                if (!textField1.getText().isEmpty()) {
                    Technics.add(new Car(Technics.size(), textField1.getText(), Boolean.parseBoolean(textField2.getText()), true));
                    Combo.addItem(new ComboString((Technics.size() - 1) + " Car  ", Technics.get(Technics.size() - 1).getCondition()));
                    text = " CarBrand: " + textField1.getText() + " Transsmision: " +  Boolean.parseBoolean(textField2.getText());
                    history.add("Added " + Combo.getItemAt(Technics.size() - 1).FirstString + text + "\n");
                } else history.add("Failed add operation(wrong format) \n");
            }

            // history.set(history.size()-1, )
        }
    }

    public class ComboString {
        String FirstString;
        boolean condition;

        public ComboString(String FirstString, boolean condition) {
            this.FirstString = FirstString;
            this.condition = condition;
        }

        public String getFirstString() {
            return FirstString;
        }

        public boolean getCondition() {
            return condition;
        }
    }

    class SmashAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Technics.get(Combo.getSelectedIndex()).toSmash();
                ComboString item = (ComboString) Combo.getSelectedItem();
                assert item != null;
                item.condition = Technics.get(Combo.getSelectedIndex()).getCondition();
                Combo.setSelectedItem(item);
                history.add("Smashed " + Combo.getItemAt(Technics.size() - 1).FirstString + "\n");
            } catch (IndexOutOfBoundsException k) {
                history.add("Nothing can't be smashed");
            }
        }
    }

    class RepairAction implements ActionListener {

        List<Service> listService = ListOfServices();
        String text = "";

        public void actionPerformed(ActionEvent e) {
            try {
                ComboString item = (ComboString) Combo.getSelectedItem();
                if (!item.condition) {
                    if (Technics.get(Combo.getSelectedIndex()) instanceof Computer) {
                        for (int count = 0; count < listService.size(); count++) {
                            if (listService.get(count) instanceof ComputerService) {
                                listService.get(count).repair(Technics.get(Combo.getSelectedIndex()));
                                text += "ComputerService ";
                            }
                        }
                    } else if (Technics.get(Combo.getSelectedIndex()) instanceof Car) {
                        for (int count = 0; count < listService.size(); count++) {
                            if (listService.get(count) instanceof CarService) {
                                listService.get(count).repair(Technics.get(Combo.getSelectedIndex()));
                                text += "CarService ";
                            }
                        }
                    } else if (Technics.get(Combo.getSelectedIndex()) instanceof Truck) {
                        for (int count = 0; count < listService.size(); count++) {
                            if (listService.get(count) instanceof TruckService) {
                                listService.get(count).repair(Technics.get(Combo.getSelectedIndex()));
                                text += "TruckService ";
                            }
                        }
                    } else if (Technics.get(Combo.getSelectedIndex()) instanceof Phone) {
                        for (int count = 0; count < listService.size(); count++) {
                            if (listService.get(count) instanceof PhoneService) {
                                listService.get(count).repair(Technics.get(Combo.getSelectedIndex()));
                                text += "PhoneService ";
                            }
                        }
                    }
                    assert item != null;
                    item.condition = Technics.get(Combo.getSelectedIndex()).getCondition();
                    Combo.setSelectedItem(item);
                    history.add(text + "Repaired " + item.FirstString + "\n");
                } else history.add("Repaired technic can't be repaired ");

            } catch (NullPointerException k) {
                history.add("Nothing can't be repaired \n");
            }
        }
    }

    public class MyItemRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof ComboString) {
                ComboString myItem = (ComboString) value;
                setText(myItem.getFirstString() + myItem.getCondition());
            }
            return this;
        }
    }

    public static List<Service> ListOfServices() {
        List<Service> listService = new ArrayList<Service>();
        listService.add(new PhoneService(0, "Телефонная"));
        listService.add(new ComputerService(1, "Компьютерная"));
        listService.add(new TruckService(2, "Грузовичная"));
        listService.add(new CarService(3, "Машинная "));
        return listService;
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean tryParseFloat(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

   /* private boolean tryParseBoolean(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }*/
}


