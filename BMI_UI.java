package bmi_ant;
import java.sql.*;
import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatLaf;
public class BMI_UI extends javax.swing.JFrame {
       Obese_routine Obrout = new Obese_routine();
    Overweight_routine Ovrout = new Overweight_routine();
    Normal_routine Nrout = new Normal_routine();
    Underweight_routine Urout = new Underweight_routine();
    private float currentBMI = 0;
    private String loggedInName;
    private int loggedInAge;
    private int userId;

    
    //para sa design Enhancement
    public BMI_UI(int userId, String name, int age) {
        FlatLaf.setup(new FlatLightLaf());
        UIManager.put("Component.arc", 20);
        
        initComponents(); 
        this.loggedInName = name;
        this.loggedInAge = age;
        this.userId = userId;
        nametxt.setText(name);
        agetxt.setText(String.valueOf(age));

        nametxt.setEditable(false);
        agetxt.setEditable(false);

        customizeUI();
    }
     private void customizeUI() {
        Color glassColor = new Color(255, 255, 255, 40);
        Font uiFont = new Font("Segoe UI", Font.BOLD, 14);

        JTextField[] fields = { nametxt, agetxt, Weighttxt, Heighttxt };
        for (JTextField field : fields) {
            field.setFont(uiFont);
            field.setBackground(glassColor);
            field.setForeground(Color.WHITE);
            field.setCaretColor(Color.WHITE);
            field.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }


        JButton[] buttons = { Calculatebtn, Prevbtn1, Printbtn, Prevbtn };
        for (JButton button : buttons) {
            button.setFocusPainted(false);
            button.setFont(new Font("Segoe UI", Font.BOLD, 14));
            button.setBackground(glassColor);
            button.setForeground(Color.WHITE);
        }

        getContentPane().setBackground(new Color(0, 30, 60));
    }
    public String getRoutineFromDatabase(String name) {
    String routine = "";
    Connection conn = DBConnection.DB_con();
    String sql = "SELECT routine FROM userroutine WHERE name = ? ORDER BY created_at DESC LIMIT 1";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            routine = rs.getString("routine");
        }
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return routine;
    }
    public String getPreviousRecord(String name) {
    String result = "";
    Connection conn = DBConnection.DB_con();
    
    String sql = "SELECT bmi, routine, created_at FROM userroutine WHERE name = ? ORDER BY created_at DESC LIMIT 1 OFFSET 1";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            double bmi = rs.getDouble("bmi");
            String routine = rs.getString("routine");
            Timestamp createdAt = rs.getTimestamp("created_at");
            result = String.format("📅 %s\nBMI: %.2f\nRoutine:\n%s", createdAt.toString(), bmi, routine);
        } else {
            result = "No previous record found.";
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return result;
}


    //para sa design ng text sa Jtextpane
    private void displayStyledRoutine(JTextPane pane, String plainText) {
    StyledDocument doc = pane.getStyledDocument();
    doc.removeUndoableEditListener(null);  
    pane.setText(""); 

    
    Style header = doc.addStyle("header", null);
    StyleConstants.setFontSize(header, 16);
    StyleConstants.setBold(header, true);
    StyleConstants.setFontFamily(header, "Arial");
    StyleConstants.setForeground(header, new Color(0, 102, 204)); 

    Style subheader = doc.addStyle("subheader", null);
    StyleConstants.setFontSize(subheader, 14);
    StyleConstants.setBold(subheader, true);
    StyleConstants.setForeground(subheader, new Color(0, 153, 76));

    Style body = doc.addStyle("body", null);
    StyleConstants.setFontSize(body, 12);
    StyleConstants.setFontFamily(body, "SansSerif");
    StyleConstants.setForeground(body, Color.DARK_GRAY);

  
    String[] lines = plainText.split("\n");
        for (String line : lines) {
            Style styleToUse = body;
            if (line.startsWith("⚠️") || line.matches(".*YOU.*WEIGHT.*")) {
                styleToUse = header;
            } else if (line.startsWith("🥗") || line.matches("^[0-9]+\\..*") || line.startsWith("🏋️") || line.startsWith("📈") || line.startsWith("😴")) {
                styleToUse = subheader;
            }
            try {
                doc.insertString(doc.getLength(), line + "\n", styleToUse);
            }catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    
    public BMI_UI() {
        
        initComponents();
        this.userId = userId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BMI_label = new javax.swing.JLabel();
        Namelbl = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        agelbl = new javax.swing.JLabel();
        agetxt = new javax.swing.JTextField();
        weightlbl = new javax.swing.JLabel();
        Weighttxt = new javax.swing.JTextField();
        heightlbl = new javax.swing.JLabel();
        Heighttxt = new javax.swing.JTextField();
        resultlbl = new javax.swing.JLabel();
        Calculatebtn = new javax.swing.JButton();
        Printbtn = new javax.swing.JButton();
        underw8lbl = new javax.swing.JLabel();
        nrmllbl = new javax.swing.JLabel();
        Overw8lbl = new javax.swing.JLabel();
        Obeselbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bmilbl = new javax.swing.JLabel();
        Prevbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Prevbtn1 = new javax.swing.JButton();
        Namelbl1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recommendation = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(java.awt.Color.orange);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BMI_label.setBackground(java.awt.Color.orange);
        BMI_label.setFont(new java.awt.Font("VALORANT", 1, 24)); // NOI18N
        BMI_label.setForeground(new java.awt.Color(255, 102, 0));
        BMI_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BMI_label.setText("FIT-Index");
        BMI_label.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3), javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 153, 51))));

        Namelbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        Namelbl.setForeground(new java.awt.Color(255, 102, 0));
        Namelbl.setText("Name:");

        nametxt.setEditable(false);
        nametxt.setBackground(new java.awt.Color(89, 217, 217));
        nametxt.setFont(new java.awt.Font("VALORANT", 0, 12)); // NOI18N
        nametxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nametxt.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 102, 0)), javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 102, 0))));
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        agelbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        agelbl.setForeground(new java.awt.Color(255, 102, 0));
        agelbl.setText("Age: ");

        agetxt.setEditable(false);
        agetxt.setBackground(new java.awt.Color(89, 217, 217));
        agetxt.setFont(new java.awt.Font("VALORANT", 0, 12)); // NOI18N
        agetxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        agetxt.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 102, 0)), javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 102, 0))));

        weightlbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        weightlbl.setForeground(new java.awt.Color(255, 102, 0));
        weightlbl.setText("Weight in Kg: ");

        Weighttxt.setBackground(new java.awt.Color(89, 217, 217));
        Weighttxt.setFont(new java.awt.Font("VALORANT", 0, 12)); // NOI18N
        Weighttxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Weighttxt.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 102, 0)), javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 102, 0))));
        Weighttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeighttxtActionPerformed(evt);
            }
        });

        heightlbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        heightlbl.setForeground(new java.awt.Color(255, 102, 0));
        heightlbl.setText("Height in Meters:");

        Heighttxt.setBackground(new java.awt.Color(89, 217, 217));
        Heighttxt.setFont(new java.awt.Font("VALORANT", 0, 12)); // NOI18N
        Heighttxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Heighttxt.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 102, 0)), javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 102, 0))));
        Heighttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeighttxtActionPerformed(evt);
            }
        });

        resultlbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        resultlbl.setForeground(new java.awt.Color(255, 102, 0));
        resultlbl.setText("BMI: ");

        Calculatebtn.setBackground(new java.awt.Color(89, 217, 217));
        Calculatebtn.setFont(new java.awt.Font("VALORANT", 0, 12)); // NOI18N
        Calculatebtn.setForeground(new java.awt.Color(255, 102, 0));
        Calculatebtn.setText("Calculate");
        Calculatebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Calculatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculatebtnActionPerformed(evt);
            }
        });

        Printbtn.setBackground(new java.awt.Color(89, 217, 217));
        Printbtn.setFont(new java.awt.Font("VALORANT", 0, 12)); // NOI18N
        Printbtn.setForeground(new java.awt.Color(255, 102, 0));
        Printbtn.setText("Print");
        Printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintbtnActionPerformed(evt);
            }
        });

        underw8lbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        underw8lbl.setForeground(new java.awt.Color(255, 102, 0));
        underw8lbl.setText("Underweight: ");

        nrmllbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        nrmllbl.setForeground(new java.awt.Color(255, 102, 0));
        nrmllbl.setText("Normal: ");

        Overw8lbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        Overw8lbl.setForeground(new java.awt.Color(255, 102, 0));
        Overw8lbl.setText("Overweight: ");

        Obeselbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        Obeselbl.setForeground(new java.awt.Color(255, 102, 0));
        Obeselbl.setText("Obese: ");

        jLabel1.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(89, 217, 217));
        jLabel1.setText("Less than 18.5");

        jLabel2.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(89, 217, 217));
        jLabel2.setText("18.5 - 24.9");

        jLabel3.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(89, 217, 217));
        jLabel3.setText("25 - 29.9");

        jLabel4.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(89, 217, 217));
        jLabel4.setText("30 or more");

        bmilbl.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        bmilbl.setForeground(new java.awt.Color(89, 217, 217));
        bmilbl.setText("?");

        Prevbtn.setBackground(new java.awt.Color(89, 217, 217));
        Prevbtn.setFont(new java.awt.Font("VALORANT", 0, 12)); // NOI18N
        Prevbtn.setForeground(new java.awt.Color(255, 102, 0));
        Prevbtn.setText("Previous Output");
        Prevbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevbtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("VALORANT", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("/ Search:");

        Prevbtn1.setBackground(new java.awt.Color(255, 102, 0));
        Prevbtn1.setFont(new java.awt.Font("VALORANT", 0, 12)); // NOI18N
        Prevbtn1.setForeground(new java.awt.Color(255, 102, 0));
        Prevbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bmi_ant/exit (1).png"))); // NOI18N
        Prevbtn1.setBorder(null);
        Prevbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Prevbtn1ActionPerformed(evt);
            }
        });

        Namelbl1.setFont(new java.awt.Font("VALORANT", 1, 20)); // NOI18N
        Namelbl1.setForeground(new java.awt.Color(255, 102, 0));
        Namelbl1.setText("grinding mode");

        recommendation.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 102)));
        jScrollPane2.setViewportView(recommendation);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(agelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(weightlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(heightlbl))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(agetxt)
                                    .addComponent(nametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                    .addComponent(Weighttxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Heighttxt, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(557, 557, 557))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Obeselbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Overw8lbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nrmllbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(underw8lbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resultlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Calculatebtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(bmilbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Printbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Prevbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Namelbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(80, 80, 80)
                        .addComponent(BMI_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(193, 193, 193)
                        .addComponent(Prevbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Namelbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(BMI_label, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Prevbtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Namelbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agetxt)
                            .addComponent(agelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Weighttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weightlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Heighttxt)
                            .addComponent(heightlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resultlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bmilbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(underw8lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nrmllbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Overw8lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Obeselbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Calculatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Printbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Prevbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2))
                .addGap(101, 101, 101))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CalculatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculatebtnActionPerformed
        // TODO add your handling code here:
       try {
        // input
        String name = loggedInName;
        int age = loggedInAge;
        if (name.isEmpty()) {
            recommendation.setText("Please enter your name.");
            return;
        }

        float height = Float.parseFloat(Heighttxt.getText().trim());
        float weight = Float.parseFloat(Weighttxt.getText().trim());

        if (height <= 0 || weight <= 0) {
            recommendation.setText("Height and weight must be greater than 0.");
            return;
        }

        // Calculate BMI
        float bmi = weight / (height * height);
        String routine = "";
        currentBMI = bmi;
        // Checking for routine
        if (bmi < 18.5) {
            bmilbl.setText(String.format("%.2f: Underweight", bmi));
            bmilbl.setForeground(Color.RED);
            routine = Urout.Message("");
        } else if (bmi < 25) {
            bmilbl.setText(String.format("%.2f: Normal", bmi));
            bmilbl.setForeground(Color.green);
            routine = Nrout.Message("");
        } else if (bmi <= 30) {
            bmilbl.setText(String.format("%.2f: Overweight", bmi));
            bmilbl.setForeground(Color.RED);
            routine = Ovrout.Message("");
        } else {
            bmilbl.setText(String.format("%.2f: Obese", bmi));
            bmilbl.setForeground(Color.RED);
            routine = Obrout.Message("");
        }

       String bmiInfo = String.format("Your current BMI is: %.2f\n\n", bmi);
       recommendation.setText(bmiInfo + routine);
       System.out.println("Routine length: " + routine.length());


        // Insert into DB
        try (Connection conn = DBConnection.DB_con()) {
            String sql = "INSERT INTO userroutine (ID, Name, Age, Height, Weight, BMI, Routine) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, this.userId);
                pstmt.setString(2, name);
                pstmt.setInt(3, age);
                pstmt.setFloat(4, height);
                pstmt.setFloat(5, weight);
                pstmt.setFloat(6, bmi);
                pstmt.setString(7, routine);
                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("BMI data inserted into database.");
                }
            }
        }

    } catch (NumberFormatException e) {
        recommendation.setText("Invalid input. Please enter valid numbers.");
    } catch (SQLException e) {
        recommendation.setText("Database error occurred.");
        e.printStackTrace();
    }

    }//GEN-LAST:event_CalculatebtnActionPerformed

    private void PrintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintbtnActionPerformed
        // TODO add your handling code here:
        String name = nametxt.getText().trim();
  
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name.");
            return;
        }

        String latestBMIText = getPreviousRecord(name);
        if (latestBMIText.isEmpty()) {
            latestBMIText = "No previous BMI data found.\n";
        }

        String routineText = getRoutineFromDatabase(name);
        if (routineText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No routine found for: " + name);
            return;
        }
        if (currentBMI <= 0) {
         JOptionPane.showMessageDialog(this, "Please calculate your BMI before exporting the report.");
         return;
        }

        StringBuilder combinedText = new StringBuilder();
        combinedText.append("=== Latest Previous BMI Record ===\n");
        combinedText.append(latestBMIText).append("\n");
        combinedText.append("=== Current Routine ===\n");
        combinedText.append(String.format("BMI: %.2f\n\n", currentBMI));
        combinedText.append(routineText);

        recommendation.setText(combinedText.toString());
        

        //Para maging doc
        String fileName = "BMI_Report_" + name + ".doc";
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(combinedText.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
            return;
        }

        // Open and print using Microsoft Word
        try {
            // Open the file in Word
            String command = "cmd /c start winword /q /n /mFilePrintDefault \"" + file.getAbsolutePath() + "\"";
            Runtime.getRuntime().exec(command);

            JOptionPane.showMessageDialog(this, "Report sent to Microsoft Word.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error opening Word: " + e.getMessage());
        }

    }//GEN-LAST:event_PrintbtnActionPerformed

    private void PrevbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevbtnActionPerformed
        // TODO add your handling code here:
      String name = nametxt.getText().trim();

      if (name.isEmpty()) {
        recommendation.setText("Please enter your name.");
        return;
      }

      String previousRecord = getPreviousRecord(name); 

      if (previousRecord.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No previous records found for " + name);
      } else {

        List<String> history = new ArrayList<>();
        history.add(previousRecord);

        History_UI historyWindow = new History_UI(name, history);
        historyWindow.setVisible(true);
      }


    }//GEN-LAST:event_PrevbtnActionPerformed

    private void Prevbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Prevbtn1ActionPerformed
     int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to logout?",
        "Logout Confirmation",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        this.dispose(); // close  window
        new BMILogin().setVisible(true); // open login window
    }
    }//GEN-LAST:event_Prevbtn1ActionPerformed
   
    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void WeighttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeighttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WeighttxtActionPerformed

    private void HeighttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeighttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeighttxtActionPerformed
 
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BMI_label;
    private javax.swing.JButton Calculatebtn;
    private javax.swing.JTextField Heighttxt;
    private javax.swing.JLabel Namelbl;
    private javax.swing.JLabel Namelbl1;
    private javax.swing.JLabel Obeselbl;
    private javax.swing.JLabel Overw8lbl;
    private javax.swing.JButton Prevbtn;
    private javax.swing.JButton Prevbtn1;
    private javax.swing.JButton Printbtn;
    private javax.swing.JTextField Weighttxt;
    private javax.swing.JLabel agelbl;
    private javax.swing.JTextField agetxt;
    private javax.swing.JLabel bmilbl;
    private javax.swing.JLabel heightlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel nrmllbl;
    private javax.swing.JTextPane recommendation;
    private javax.swing.JLabel resultlbl;
    private javax.swing.JLabel underw8lbl;
    private javax.swing.JLabel weightlbl;
    // End of variables declaration//GEN-END:variables
}
