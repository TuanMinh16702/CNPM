/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BackFrameQuanLy;

import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author Admin
 */
public class GD_QuanLy extends javax.swing.JFrame {

    /**
     * Creates new form GD_QuanLy
     */
    Color ColorFrame ;
    public GD_QuanLy() {
        initComponents();
        ColorFrame = new Color(97,148,153) ;
        showPieChart();

    }
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue("Khách mua hàng" , Double.valueOf(30));  
      barDataset.setValue("Lượt mua sắm" , Double.valueOf(120));   
      barDataset.setValue("Đơn hoàn thành" , Double.valueOf(25));    
      barDataset.setValue("Đơn hàng trả" , Double.valueOf(5));
      barDataset.setValue("Đơn đã hủy" , Double.valueOf(2));
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Thống kê đơn hàng",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setSectionPaint("Khách mua hàng", new Color(255,255,102));
        piePlot.setSectionPaint("Lượt mua sắm", new Color(102,255,102));
        piePlot.setSectionPaint("Đơn hoàn thành", new Color(255,102,153));
        piePlot.setSectionPaint("Đơn hàng trả", new Color(0,204,204));
        piePlot.setSectionPaint("Đơn đã hủy", new Color(150,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }
    
      public void showLineChart(){
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Thống kê doanh thu","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelBarChart.removeAll();
        panelBarChart.add(lineChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }
      
    public void showHistogram(){
        
         double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                            77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
                          };
 
 
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, 20);
        
         JFreeChart chart = ChartFactory.createHistogram("Thống kê doanh thu","Data", "Frequency", dataset,PlotOrientation.VERTICAL, false,true,false);
            XYPlot plot= chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);

        
        
        ChartPanel barpChartPanel2 = new ChartPanel(chart);
         panelBarChart.removeAll();
         panelBarChart.add(barpChartPanel2, BorderLayout.CENTER);
         panelBarChart.validate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bgDoanhThu = new javax.swing.JPanel();
        btnDoanhThu = new javax.swing.JLabel();
        bgDanhSachNV = new javax.swing.JPanel();
        btnDanhSachNV = new javax.swing.JLabel();
        bgBangChamCong = new javax.swing.JPanel();
        btnBangChamCong = new javax.swing.JLabel();
        bgKhoHang = new javax.swing.JPanel();
        btnKhoHang = new javax.swing.JLabel();
        bgThongBao = new javax.swing.JPanel();
        btnThongBao = new javax.swing.JLabel();
        bgKhuyenMai = new javax.swing.JPanel();
        btnKhuyenMai = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        DoanhThu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtKHmua = new javax.swing.JLabel();
        txtLuotMuaSam = new javax.swing.JLabel();
        txtDonHoanThanh = new javax.swing.JLabel();
        txtDonHangTra = new javax.swing.JLabel();
        txtDonDaHuy = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtTongDoanhThu = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtTiXuatLoiNhuan = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        panelBarChart = new javax.swing.JPanel();
        btnBieuDoCot = new javax.swing.JButton();
        btnBieuDoDuong = new javax.swing.JButton();
        btnBieuDoTron = new javax.swing.JButton();
        DanhsachNV = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Bangchamcong = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        KhoHang = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ThongBao = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        KhuyenMai = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 148, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo cf take away (1).png"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(97, 148, 153));
        jLabel6.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(97, 148, 153));
        jLabel6.setText("Menu");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu icon (1).png"))); // NOI18N
        jLabel7.setText("jLabel7");

        bgDoanhThu.setBackground(new java.awt.Color(97, 148, 153));
        bgDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bgDoanhThu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bgDoanhThu.setEnabled(false);
        bgDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgDoanhThuMousePressed(evt);
            }
        });

        btnDoanhThu.setBackground(new java.awt.Color(114, 149, 153));
        btnDoanhThu.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        btnDoanhThu.setText("Doanh Thu");

        javax.swing.GroupLayout bgDoanhThuLayout = new javax.swing.GroupLayout(bgDoanhThu);
        bgDoanhThu.setLayout(bgDoanhThuLayout);
        bgDoanhThuLayout.setHorizontalGroup(
            bgDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDoanhThuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgDoanhThuLayout.setVerticalGroup(
            bgDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgDoanhThuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDoanhThu)
                .addContainerGap())
        );

        bgDanhSachNV.setBackground(new java.awt.Color(255, 255, 255));
        bgDanhSachNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bgDanhSachNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgDanhSachNVMousePressed(evt);
            }
        });

        btnDanhSachNV.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnDanhSachNV.setForeground(new java.awt.Color(114, 149, 153));
        btnDanhSachNV.setText("Danh sách nhân viên");

        javax.swing.GroupLayout bgDanhSachNVLayout = new javax.swing.GroupLayout(bgDanhSachNV);
        bgDanhSachNV.setLayout(bgDanhSachNVLayout);
        bgDanhSachNVLayout.setHorizontalGroup(
            bgDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDanhSachNVLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnDanhSachNV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgDanhSachNVLayout.setVerticalGroup(
            bgDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgDanhSachNVLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(btnDanhSachNV)
                .addContainerGap())
        );

        bgBangChamCong.setBackground(new java.awt.Color(255, 255, 255));
        bgBangChamCong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bgBangChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgBangChamCongMousePressed(evt);
            }
        });

        btnBangChamCong.setBackground(new java.awt.Color(255, 255, 255));
        btnBangChamCong.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnBangChamCong.setForeground(new java.awt.Color(97, 148, 153));
        btnBangChamCong.setText("Bảng chấm công");

        javax.swing.GroupLayout bgBangChamCongLayout = new javax.swing.GroupLayout(bgBangChamCong);
        bgBangChamCong.setLayout(bgBangChamCongLayout);
        bgBangChamCongLayout.setHorizontalGroup(
            bgBangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBangChamCongLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnBangChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        bgBangChamCongLayout.setVerticalGroup(
            bgBangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBangChamCongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBangChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bgKhoHang.setBackground(new java.awt.Color(255, 255, 255));
        bgKhoHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bgKhoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgKhoHangMousePressed(evt);
            }
        });

        btnKhoHang.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnKhoHang.setForeground(new java.awt.Color(97, 148, 153));
        btnKhoHang.setText("Kho hàng");

        javax.swing.GroupLayout bgKhoHangLayout = new javax.swing.GroupLayout(bgKhoHang);
        bgKhoHang.setLayout(bgKhoHangLayout);
        bgKhoHangLayout.setHorizontalGroup(
            bgKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgKhoHangLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnKhoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgKhoHangLayout.setVerticalGroup(
            bgKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgKhoHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKhoHang)
                .addContainerGap())
        );

        bgThongBao.setBackground(new java.awt.Color(255, 255, 255));
        bgThongBao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bgThongBao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgThongBaoMousePressed(evt);
            }
        });

        btnThongBao.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnThongBao.setForeground(new java.awt.Color(97, 148, 153));
        btnThongBao.setText("Thông báo");

        javax.swing.GroupLayout bgThongBaoLayout = new javax.swing.GroupLayout(bgThongBao);
        bgThongBao.setLayout(bgThongBaoLayout);
        bgThongBaoLayout.setHorizontalGroup(
            bgThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgThongBaoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgThongBaoLayout.setVerticalGroup(
            bgThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgThongBaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThongBao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bgKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        bgKhuyenMai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bgKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgKhuyenMaiMousePressed(evt);
            }
        });

        btnKhuyenMai.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnKhuyenMai.setForeground(new java.awt.Color(97, 148, 153));
        btnKhuyenMai.setText("Khuyến mãi");

        javax.swing.GroupLayout bgKhuyenMaiLayout = new javax.swing.GroupLayout(bgKhuyenMai);
        bgKhuyenMai.setLayout(bgKhuyenMaiLayout);
        bgKhuyenMaiLayout.setHorizontalGroup(
            bgKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgKhuyenMaiLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgKhuyenMaiLayout.setVerticalGroup(
            bgKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKhuyenMai)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bgDanhSachNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(bgBangChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bgKhoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bgThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bgKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bgDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bgDanhSachNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bgBangChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bgKhoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bgThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bgKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setLayout(new java.awt.CardLayout());

        DoanhThu.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtKHmua.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtKHmua.setForeground(new java.awt.Color(0, 0, 0));
        txtKHmua.setText("30  Khách mua hàng");

        txtLuotMuaSam.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtLuotMuaSam.setForeground(new java.awt.Color(0, 0, 0));
        txtLuotMuaSam.setText("120   Lượt mua sắm");

        txtDonHoanThanh.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtDonHoanThanh.setForeground(new java.awt.Color(0, 0, 0));
        txtDonHoanThanh.setText("25   Đơn Hoàn thành");

        txtDonHangTra.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtDonHangTra.setForeground(new java.awt.Color(0, 0, 0));
        txtDonHangTra.setText("5   Đơn hàng trả");

        txtDonDaHuy.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtDonDaHuy.setForeground(new java.awt.Color(0, 0, 0));
        txtDonDaHuy.setText("2   Đơn đã hủy");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon khách hàng (1).png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon mua sắm.png"))); // NOI18N
        jLabel16.setText("jLabel16");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/đơn_hàng-removebg-preview (1).png"))); // NOI18N
        jLabel13.setText("jLabel13");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon trả hàng.png"))); // NOI18N
        jLabel17.setText("jLabel17");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon xóa.png"))); // NOI18N
        jLabel19.setText("jLabel19");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonHoanThanh)
                            .addComponent(txtLuotMuaSam, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKHmua))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtDonDaHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDonHangTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txtKHmua, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(txtLuotMuaSam))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDonHoanThanh)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonHangTra)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonDaHuy)
                    .addComponent(jLabel19))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtTongDoanhThu.setFont(new java.awt.Font("UTM Avo", 0, 18)); // NOI18N
        txtTongDoanhThu.setForeground(new java.awt.Color(99, 147, 153));
        txtTongDoanhThu.setText("3.125.00 vnđ");

        jLabel20.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(99, 147, 153));
        jLabel20.setText("Tổng lợi nhuận");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon doanh thu.png"))); // NOI18N
        jLabel30.setText("jLabel30");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTongDoanhThu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtTiXuatLoiNhuan.setFont(new java.awt.Font("UTM Avo", 0, 18)); // NOI18N
        txtTiXuatLoiNhuan.setForeground(new java.awt.Color(99, 147, 153));
        txtTiXuatLoiNhuan.setText("82,75%");

        jLabel22.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(99, 147, 153));
        jLabel22.setText("Tỉ xuất lợi nhuận");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon tỉ xuất lợi nhuận.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTiXuatLoiNhuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtTiXuatLoiNhuan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(99, 147, 153));
        jLabel23.setText("Đánh giá khách hàng");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon star.png"))); // NOI18N
        jLabel25.setText("jLabel25");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon star.png"))); // NOI18N
        jLabel24.setText("jLabel24");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon star.png"))); // NOI18N
        jLabel26.setText("jLabel26");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon star.png"))); // NOI18N
        jLabel27.setText("jLabel27");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(43, 43, 43))
        );

        panelBarChart.setBackground(new java.awt.Color(255, 255, 255));
        panelBarChart.setLayout(new java.awt.BorderLayout());

        btnBieuDoCot.setBackground(new java.awt.Color(255, 255, 255));
        btnBieuDoCot.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnBieuDoCot.setForeground(new java.awt.Color(114, 149, 153));
        btnBieuDoCot.setText("Biểu đồ cột");
        btnBieuDoCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoCotActionPerformed(evt);
            }
        });

        btnBieuDoDuong.setBackground(new java.awt.Color(255, 255, 255));
        btnBieuDoDuong.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnBieuDoDuong.setForeground(new java.awt.Color(114, 149, 153));
        btnBieuDoDuong.setText("Biểu đồ đường");
        btnBieuDoDuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoDuongActionPerformed(evt);
            }
        });

        btnBieuDoTron.setBackground(new java.awt.Color(255, 255, 255));
        btnBieuDoTron.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnBieuDoTron.setForeground(new java.awt.Color(114, 149, 153));
        btnBieuDoTron.setText("Biểu đồ tròn");
        btnBieuDoTron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoTronActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DoanhThuLayout = new javax.swing.GroupLayout(DoanhThu);
        DoanhThu.setLayout(DoanhThuLayout);
        DoanhThuLayout.setHorizontalGroup(
            DoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoanhThuLayout.createSequentialGroup()
                        .addComponent(btnBieuDoCot, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBieuDoDuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DoanhThuLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelBarChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBieuDoTron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DoanhThuLayout.setVerticalGroup(
            DoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBarChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(DoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(DoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBieuDoDuong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBieuDoTron, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBieuDoCot, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Menu.add(DoanhThu, "card2");

        DanhsachNV.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Danh sach NV");

        javax.swing.GroupLayout DanhsachNVLayout = new javax.swing.GroupLayout(DanhsachNV);
        DanhsachNV.setLayout(DanhsachNVLayout);
        DanhsachNVLayout.setHorizontalGroup(
            DanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhsachNVLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
        );
        DanhsachNVLayout.setVerticalGroup(
            DanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhsachNVLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        Menu.add(DanhsachNV, "card3");

        Bangchamcong.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Bang cham cong");

        javax.swing.GroupLayout BangchamcongLayout = new javax.swing.GroupLayout(Bangchamcong);
        Bangchamcong.setLayout(BangchamcongLayout);
        BangchamcongLayout.setHorizontalGroup(
            BangchamcongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangchamcongLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
        );
        BangchamcongLayout.setVerticalGroup(
            BangchamcongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangchamcongLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        Menu.add(Bangchamcong, "card4");

        KhoHang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Kho hang");

        javax.swing.GroupLayout KhoHangLayout = new javax.swing.GroupLayout(KhoHang);
        KhoHang.setLayout(KhoHangLayout);
        KhoHangLayout.setHorizontalGroup(
            KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhoHangLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(437, Short.MAX_VALUE))
        );
        KhoHangLayout.setVerticalGroup(
            KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhoHangLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );

        Menu.add(KhoHang, "card5");

        ThongBao.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Thong bao");

        javax.swing.GroupLayout ThongBaoLayout = new javax.swing.GroupLayout(ThongBao);
        ThongBao.setLayout(ThongBaoLayout);
        ThongBaoLayout.setHorizontalGroup(
            ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongBaoLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        ThongBaoLayout.setVerticalGroup(
            ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongBaoLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(296, Short.MAX_VALUE))
        );

        Menu.add(ThongBao, "card6");

        KhuyenMai.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Khuyen mai");

        javax.swing.GroupLayout KhuyenMaiLayout = new javax.swing.GroupLayout(KhuyenMai);
        KhuyenMai.setLayout(KhuyenMaiLayout);
        KhuyenMaiLayout.setHorizontalGroup(
            KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );
        KhuyenMaiLayout.setVerticalGroup(
            KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        Menu.add(KhuyenMai, "card7");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel28.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Nguyễn Tiến Đạt");

        jLabel29.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Quản lý");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(99, 147, 153));
        jButton1.setText("Thông tin");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(114, 149, 153));
        jButton2.setText("Đăng xuất");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBieuDoTronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoTronActionPerformed
         showPieChart();
    }//GEN-LAST:event_btnBieuDoTronActionPerformed

    private void btnBieuDoDuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoDuongActionPerformed
        
        showLineChart();
    }//GEN-LAST:event_btnBieuDoDuongActionPerformed

    private void btnBieuDoCotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoCotActionPerformed
        showHistogram();
       
    }//GEN-LAST:event_btnBieuDoCotActionPerformed

    private void bgDoanhThuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgDoanhThuMousePressed
        bgDoanhThu.setBackground(ColorFrame);
        btnDoanhThu.setForeground(Color.WHITE);
        
        bgDanhSachNV.setBackground(Color.WHITE);
        btnDanhSachNV.setForeground(ColorFrame);
        
        bgBangChamCong.setBackground(Color.WHITE);
        btnBangChamCong.setForeground(ColorFrame);
        
        bgKhoHang.setBackground(Color.WHITE);
        btnKhoHang.setForeground(ColorFrame);
        
        bgThongBao.setBackground(Color.WHITE);
        btnThongBao.setForeground(ColorFrame);
        
        bgKhuyenMai.setBackground(Color.WHITE);
        btnKhuyenMai.setForeground(ColorFrame);
       
        DoanhThu.setVisible(true);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(false);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(false);
    }//GEN-LAST:event_bgDoanhThuMousePressed

    private void bgDanhSachNVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgDanhSachNVMousePressed
         bgDoanhThu.setBackground(Color.WHITE);
        btnDoanhThu.setForeground(ColorFrame);
        
        bgDanhSachNV.setBackground(ColorFrame);
        btnDanhSachNV.setForeground(Color.WHITE);
        
        bgBangChamCong.setBackground(Color.WHITE);
        btnBangChamCong.setForeground(ColorFrame);
        
        bgKhoHang.setBackground(Color.WHITE);
        btnKhoHang.setForeground(ColorFrame);
        
        bgThongBao.setBackground(Color.WHITE);
        btnThongBao.setForeground(ColorFrame);
        
        bgKhuyenMai.setBackground(Color.WHITE);
        btnKhuyenMai.setForeground(ColorFrame);
      
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(true);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(false);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(false);
    }//GEN-LAST:event_bgDanhSachNVMousePressed

    private void bgBangChamCongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgBangChamCongMousePressed
        bgDoanhThu.setBackground(Color.WHITE);
        btnDoanhThu.setForeground(ColorFrame);
        
        bgDanhSachNV.setBackground(Color.WHITE);
        btnDanhSachNV.setForeground(ColorFrame);
        
        bgBangChamCong.setBackground(ColorFrame);
        btnBangChamCong.setForeground(Color.WHITE);
        
        bgKhoHang.setBackground(Color.WHITE);
        btnKhoHang.setForeground(ColorFrame);
        
        bgThongBao.setBackground(Color.WHITE);
        btnThongBao.setForeground(ColorFrame);
        
        bgKhuyenMai.setBackground(Color.WHITE);
        btnKhuyenMai.setForeground(ColorFrame);
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(true);
        KhoHang.setVisible(false);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(false);
       
    }//GEN-LAST:event_bgBangChamCongMousePressed

    private void bgKhoHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgKhoHangMousePressed
        
        bgDoanhThu.setBackground(Color.WHITE);
        btnDoanhThu.setForeground(ColorFrame);
        
        bgDanhSachNV.setBackground(Color.WHITE);
        btnDanhSachNV.setForeground(ColorFrame);
        
        bgBangChamCong.setBackground(Color.WHITE);
        btnBangChamCong.setForeground(ColorFrame);
        
        bgKhoHang.setBackground(ColorFrame);
        btnKhoHang.setForeground(Color.WHITE);
        
        bgThongBao.setBackground(Color.WHITE);
        btnThongBao.setForeground(ColorFrame);
        
        bgKhuyenMai.setBackground(Color.WHITE);
        btnKhuyenMai.setForeground(ColorFrame);
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(true);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(false);
    }//GEN-LAST:event_bgKhoHangMousePressed

    private void bgThongBaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgThongBaoMousePressed
         bgDoanhThu.setBackground(Color.WHITE);
        btnDoanhThu.setForeground(ColorFrame);
        
        bgDanhSachNV.setBackground(Color.WHITE);
        btnDanhSachNV.setForeground(ColorFrame);
        
        bgBangChamCong.setBackground(Color.WHITE);
        btnBangChamCong.setForeground(ColorFrame);
        
        bgKhoHang.setBackground(Color.WHITE);
        btnKhoHang.setForeground(ColorFrame);
        
        bgThongBao.setBackground(ColorFrame);
        btnThongBao.setForeground(Color.WHITE);
        
        bgKhuyenMai.setBackground(Color.WHITE);
        btnKhuyenMai.setForeground(ColorFrame);
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(false);
        ThongBao.setVisible(true);
        KhuyenMai.setVisible(false);
    }//GEN-LAST:event_bgThongBaoMousePressed

    private void bgKhuyenMaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgKhuyenMaiMousePressed
        bgDoanhThu.setBackground(Color.WHITE);
        btnDoanhThu.setForeground(ColorFrame);
        
        bgDanhSachNV.setBackground(Color.WHITE);
        btnDanhSachNV.setForeground(ColorFrame);
        
        bgBangChamCong.setBackground(Color.WHITE);
        btnBangChamCong.setForeground(ColorFrame);
        
        bgKhoHang.setBackground(Color.WHITE);
        btnKhoHang.setForeground(ColorFrame);
        
        bgThongBao.setBackground(Color.WHITE);
        btnThongBao.setForeground(ColorFrame);
        
        bgKhuyenMai.setBackground(ColorFrame);
        btnKhuyenMai.setForeground(Color.WHITE);
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(false);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(true);
    }//GEN-LAST:event_bgKhuyenMaiMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bangchamcong;
    private javax.swing.JPanel DanhsachNV;
    private javax.swing.JPanel DoanhThu;
    private javax.swing.JPanel KhoHang;
    private javax.swing.JPanel KhuyenMai;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel ThongBao;
    private javax.swing.JPanel bgBangChamCong;
    private javax.swing.JPanel bgDanhSachNV;
    private javax.swing.JPanel bgDoanhThu;
    private javax.swing.JPanel bgKhoHang;
    private javax.swing.JPanel bgKhuyenMai;
    private javax.swing.JPanel bgThongBao;
    private javax.swing.JLabel btnBangChamCong;
    private javax.swing.JButton btnBieuDoCot;
    private javax.swing.JButton btnBieuDoDuong;
    private javax.swing.JButton btnBieuDoTron;
    private javax.swing.JLabel btnDanhSachNV;
    private javax.swing.JLabel btnDoanhThu;
    private javax.swing.JLabel btnKhoHang;
    private javax.swing.JLabel btnKhuyenMai;
    private javax.swing.JLabel btnThongBao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JLabel txtDonDaHuy;
    private javax.swing.JLabel txtDonHangTra;
    private javax.swing.JLabel txtDonHoanThanh;
    private javax.swing.JLabel txtKHmua;
    private javax.swing.JLabel txtLuotMuaSam;
    private javax.swing.JLabel txtTiXuatLoiNhuan;
    private javax.swing.JLabel txtTongDoanhThu;
    // End of variables declaration//GEN-END:variables
}
