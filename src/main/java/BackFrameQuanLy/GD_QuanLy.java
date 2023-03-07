/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BackFrameQuanLy;

import CHAMCONG.CHAMCONG;
import CHAMCONG.CHAMCONGMANAGER;
import KHUYENMAI.CT_KM;
import KHUYENMAI.KHUYENMAI;
import MON.CT_MON;
import MON.MON;
import Main.VARIABLE;
import NGUYENLIEU.NGUYENLIEU;
import NHANVIEN.NHANVIEN;
import TAIKHOAN.TAIKHOAN;
import THONGBAO.THONGBAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
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

    private VARIABLE variables;
    private TAIKHOAN tk;
    private CHAMCONG cc;
    private List<CHAMCONG> listCC;
    public List<NGUYENLIEU> listNL;
    public List<THONGBAO> listTB;
    private List<CT_KM> listCTKM;
    private List<CT_MON> listCTM;
    private GD_TaoThongBao gdtb;
    Color ColorFrame ;
    DefaultTableModel model;
    private TableRowSorter<TableModel> RowSorter;
    public GD_QuanLy() {
        initComponents();
        ColorFrame = new Color(97,148,153) ;
        showPieChart();
    }
    
    public void runGDQL(VARIABLE variables, TAIKHOAN tk) throws SQLException{
        this.variables = variables;
        this.tk = tk;
        this.showInfo();
        
        initTableDSNV() ;
        fillTableDSNV() ;
        
        this.RowSorter = new TableRowSorter<>(tbDSNhanVien.getModel());
        tbDSNhanVien.setRowSorter(RowSorter);
        txtTimKiemNV.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (txtTimKiemNV.getText().trim().length() == 0) {
                    RowSorter.setRowFilter(null);
                } else {
                    RowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiemNV.getText().trim()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtTimKiemNV.getText().trim().length() == 0) {
                    RowSorter.setRowFilter(null);
                } else {
                    RowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiemNV.getText().trim()));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (txtTimKiemNV.getText().trim().length() == 0) {
                    RowSorter.setRowFilter(null);
                } else {
                    RowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiemNV.getText().trim()));
                }
            }
        });
        
        initTableDSNL() ;
        fillTableDSNL() ;
        
        initTableDSTB() ;
        fillTableDSTB() ;
        
        initTableDSKM() ;
        fillTableDSKM() ;
        
        initTableDSCT() ;
        fillTableDSCT() ;      
    }
    
    public void showInfo() throws SQLException{
        System.out.println(this.tk.getQuyen());
        if(this.tk.getQuyen().trim().equals("GD")){
            this.txtChucVu.setText("Giám Đốc");
        }if(this.tk.getQuyen().trim().equals("QL")){
            this.txtChucVu.setText("Quản Lý");
        }if(this.tk.getQuyen().trim().equals("NV")){
            this.txtChucVu.setText("Nhân Viên");
        }
        NHANVIEN nv = variables.getDB().checkInFo(variables.getStatement(), this.tk.getTk());
        this.txtHovaTen.setText(nv.getHo()+ " "+nv.getTen());
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
        bgDsCongThuc = new javax.swing.JPanel();
        btnDsCongThuc = new javax.swing.JLabel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDSNhanVien = new javax.swing.JTable();
        txtTimKiemNV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTongThoiGianLamViec = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbSapXep = new javax.swing.JComboBox<>();
        Bangchamcong = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        ViewTrangThaiQL = new javax.swing.JPanel();
        txtTrangThaiQL = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        KhoHang = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDsNguyenLieu = new javax.swing.JTable();
        txtTimKiemNL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CbSapXepNL = new javax.swing.JComboBox<>();
        btnXoaNL = new javax.swing.JButton();
        btnNhapNL = new javax.swing.JButton();
        ThongBao = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDsThongBao = new javax.swing.JTable();
        btnTaoThongBao = new javax.swing.JButton();
        txtTimKiemThongBao = new javax.swing.JTextField();
        cbSapXepThongBao = new javax.swing.JComboBox<>();
        btnXoaTB = new javax.swing.JButton();
        KhuyenMai = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDsKhuyenMai = new javax.swing.JTable();
        btnThemKhuyenMai = new javax.swing.JButton();
        btnXoaKhuyenMai = new javax.swing.JButton();
        Danhsachcongthuc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachCT = new javax.swing.JTable();
        txtTimKiemCongThuc = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtHovaTen = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();

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

        bgDsCongThuc.setBackground(new java.awt.Color(255, 255, 255));
        bgDsCongThuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bgDsCongThuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgDsCongThucMousePressed(evt);
            }
        });

        btnDsCongThuc.setBackground(new java.awt.Color(114, 149, 153));
        btnDsCongThuc.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnDsCongThuc.setForeground(new java.awt.Color(114, 149, 153));
        btnDsCongThuc.setText("Danh sách công thức");

        javax.swing.GroupLayout bgDsCongThucLayout = new javax.swing.GroupLayout(bgDsCongThuc);
        bgDsCongThuc.setLayout(bgDsCongThucLayout);
        bgDsCongThucLayout.setHorizontalGroup(
            bgDsCongThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDsCongThucLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnDsCongThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bgDsCongThucLayout.setVerticalGroup(
            bgDsCongThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgDsCongThucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDsCongThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
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
            .addComponent(bgDsCongThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bgDsCongThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setLayout(new java.awt.CardLayout());

        DoanhThu.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtKHmua.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtKHmua.setText("30  Khách mua hàng");

        txtLuotMuaSam.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtLuotMuaSam.setText("120   Lượt mua sắm");

        txtDonHoanThanh.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtDonHoanThanh.setText("25   Đơn Hoàn thành");

        txtDonHangTra.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtDonHangTra.setText("5   Đơn hàng trả");

        txtDonDaHuy.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
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
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnBieuDoCot.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnBieuDoCot.setForeground(new java.awt.Color(114, 149, 153));
        btnBieuDoCot.setText("Biểu đồ cột");
        btnBieuDoCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoCotActionPerformed(evt);
            }
        });

        btnBieuDoDuong.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnBieuDoDuong.setForeground(new java.awt.Color(114, 149, 153));
        btnBieuDoDuong.setText("Biểu đồ đường");
        btnBieuDoDuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoDuongActionPerformed(evt);
            }
        });

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
                    .addComponent(panelBarChart, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
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

        DanhsachNV.setBackground(new java.awt.Color(243, 243, 243));

        tbDSNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Trạng thái", "Giờ làm việc"
            }
        ));
        tbDSNhanVien.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbDSNhanVienAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbDSNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDSNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDSNhanVien);

        txtTimKiemNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemNVKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(114, 149, 153));
        jLabel1.setText("Danh sách nhân viên");

        jLabel2.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(114, 149, 153));
        jLabel2.setText("Ca làm việc: (7h - 10h) và (15h - 19h)");

        jPanel7.setBackground(new java.awt.Color(114, 149, 153));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(114, 149, 153));
        jLabel8.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(114, 149, 153));
        jLabel8.setText("Tổng số giờ làm việc");

        txtTongThoiGianLamViec.setFont(new java.awt.Font("UTM Avo", 0, 24)); // NOI18N
        txtTongThoiGianLamViec.setForeground(new java.awt.Color(114, 149, 153));
        txtTongThoiGianLamViec.setText("270h");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon đồng hồ.png"))); // NOI18N
        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongThoiGianLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtTongThoiGianLamViec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nhân viên", "Họ và tên", "Số giờ làm việc" }));
        cbSapXep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSapXepItemStateChanged(evt);
            }
        });
        cbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSapXepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DanhsachNVLayout = new javax.swing.GroupLayout(DanhsachNV);
        DanhsachNV.setLayout(DanhsachNVLayout);
        DanhsachNVLayout.setHorizontalGroup(
            DanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhsachNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(DanhsachNVLayout.createSequentialGroup()
                        .addGroup(DanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(txtTimKiemNV))
                        .addGap(18, 18, 18)
                        .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DanhsachNVLayout.setVerticalGroup(
            DanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhsachNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Menu.add(DanhsachNV, "card3");

        Bangchamcong.setBackground(new java.awt.Color(241, 241, 241));

        jPanel14.setBackground(new java.awt.Color(114, 149, 153));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("UTM Avo", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(114, 149, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bảng chấm công");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon quản lý.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(114, 149, 153));
        jLabel36.setText("Nguyễn Tiến Đạt");

        jLabel37.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(114, 149, 153));
        jLabel37.setText("Quản lý");

        jLabel38.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(114, 149, 153));
        jLabel38.setText("27-02-2023");

        javax.swing.GroupLayout ViewTrangThaiQLLayout = new javax.swing.GroupLayout(ViewTrangThaiQL);
        ViewTrangThaiQL.setLayout(ViewTrangThaiQLLayout);
        ViewTrangThaiQLLayout.setHorizontalGroup(
            ViewTrangThaiQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        ViewTrangThaiQLLayout.setVerticalGroup(
            ViewTrangThaiQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        txtTrangThaiQL.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        txtTrangThaiQL.setForeground(new java.awt.Color(102, 102, 102));
        txtTrangThaiQL.setText("Offline");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txtTrangThaiQL, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ViewTrangThaiQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTrangThaiQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(ViewTrangThaiQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel40.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(114, 149, 153));
        jLabel40.setText("Hồ Văn Tay");

        jLabel41.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(114, 149, 153));
        jLabel41.setText("Nhân viên");

        jLabel42.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(114, 149, 153));
        jLabel42.setText("27-02-2023");

        jLabel43.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 204, 0));
        jLabel43.setText("Online");

        jPanel18.setBackground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(114, 149, 153));
        jLabel44.setText("Phạm Hồng Ánh");

        jLabel45.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(114, 149, 153));
        jLabel45.setText("Nhân viên");

        jLabel46.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(114, 149, 153));
        jLabel46.setText("27-02-2023");

        jLabel47.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 0, 51));
        jLabel47.setText("Trễ");

        jPanel21.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel48.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(114, 149, 153));
        jLabel48.setText("Nguyễn Hoàng Hưng");

        jLabel49.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(114, 149, 153));
        jLabel49.setText("Nhân viên");

        jLabel50.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(114, 149, 153));
        jLabel50.setText("27-02-2023");

        jLabel51.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 204, 0));
        jLabel51.setText("Online");

        jPanel22.setBackground(new java.awt.Color(51, 204, 0));
        jPanel22.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel48)
                .addGap(18, 18, 18)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(114, 149, 153));
        jButton3.setText("Danh sách chấm công");

        jButton4.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(114, 149, 153));
        jButton4.setText("Chấm công");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BangchamcongLayout = new javax.swing.GroupLayout(Bangchamcong);
        Bangchamcong.setLayout(BangchamcongLayout);
        BangchamcongLayout.setHorizontalGroup(
            BangchamcongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangchamcongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BangchamcongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BangchamcongLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(BangchamcongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                        .addGap(183, 183, 183))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BangchamcongLayout.createSequentialGroup()
                        .addGroup(BangchamcongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(BangchamcongLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(53, 53, 53))
        );
        BangchamcongLayout.setVerticalGroup(
            BangchamcongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangchamcongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BangchamcongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        Menu.add(Bangchamcong, "card4");

        KhoHang.setBackground(new java.awt.Color(255, 255, 255));

        tblDsNguyenLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblDsNguyenLieu);

        jLabel4.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(114, 149, 153));
        jLabel4.setText("Danh sách nguyên liệu");

        CbSapXepNL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nguyên liệu", "Tên nguyên liệu", "Số lượng" }));
        CbSapXepNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbSapXepNLActionPerformed(evt);
            }
        });

        btnXoaNL.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnXoaNL.setForeground(new java.awt.Color(114, 149, 153));
        btnXoaNL.setText("Xóa nguyên liệu");
        btnXoaNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNLActionPerformed(evt);
            }
        });

        btnNhapNL.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnNhapNL.setForeground(new java.awt.Color(114, 149, 153));
        btnNhapNL.setText("Nhập nguyên liệu");

        javax.swing.GroupLayout KhoHangLayout = new javax.swing.GroupLayout(KhoHang);
        KhoHang.setLayout(KhoHangLayout);
        KhoHangLayout.setHorizontalGroup(
            KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhoHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addGroup(KhoHangLayout.createSequentialGroup()
                        .addGroup(KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiemNL)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(CbSapXepNL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhoHangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNhapNL, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        KhoHangLayout.setVerticalGroup(
            KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhoHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemNL, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbSapXepNL, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNhapNL, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnXoaNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        Menu.add(KhoHang, "card5");

        ThongBao.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(114, 149, 153));
        jLabel14.setText("Danh sách thông báo");

        tblDsThongBao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblDsThongBao);

        btnTaoThongBao.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnTaoThongBao.setForeground(new java.awt.Color(114, 149, 153));
        btnTaoThongBao.setText("Tạo thông báo");
        btnTaoThongBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoThongBaoActionPerformed(evt);
            }
        });

        cbSapXepThongBao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã thông báo", "Ngày " }));
        cbSapXepThongBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSapXepThongBaoActionPerformed(evt);
            }
        });

        btnXoaTB.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnXoaTB.setForeground(new java.awt.Color(114, 149, 153));
        btnXoaTB.setText("Xóa thông báo");
        btnXoaTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ThongBaoLayout = new javax.swing.GroupLayout(ThongBao);
        ThongBao.setLayout(ThongBaoLayout);
        ThongBaoLayout.setHorizontalGroup(
            ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongBaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addGroup(ThongBaoLayout.createSequentialGroup()
                        .addGroup(ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ThongBaoLayout.createSequentialGroup()
                                .addComponent(txtTimKiemThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbSapXepThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThongBaoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTaoThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        ThongBaoLayout.setVerticalGroup(
            ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongBaoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSapXepThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaoThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        Menu.add(ThongBao, "card6");

        KhuyenMai.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("UTM Avo", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(114, 149, 153));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Chương trình khuyến mãi");

        tblDsKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblDsKhuyenMai);

        btnThemKhuyenMai.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnThemKhuyenMai.setForeground(new java.awt.Color(114, 149, 153));
        btnThemKhuyenMai.setText("Thêm chương trình khuyến mãi");

        btnXoaKhuyenMai.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnXoaKhuyenMai.setForeground(new java.awt.Color(114, 149, 153));
        btnXoaKhuyenMai.setText("Xóa khuyến mãi");
        btnXoaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhuyenMaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KhuyenMaiLayout = new javax.swing.GroupLayout(KhuyenMai);
        KhuyenMai.setLayout(KhuyenMaiLayout);
        KhuyenMaiLayout.setHorizontalGroup(
            KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhuyenMaiLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemKhuyenMai)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        KhuyenMaiLayout.setVerticalGroup(
            KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        Menu.add(KhuyenMai, "card7");

        Danhsachcongthuc.setBackground(new java.awt.Color(255, 255, 255));

        tblDanhSachCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDanhSachCT);

        jLabel34.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(114, 149, 153));
        jLabel34.setText("Danh sách công thức các món");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã công thức", "Tên công thức", "Đánh giá" }));

        javax.swing.GroupLayout DanhsachcongthucLayout = new javax.swing.GroupLayout(Danhsachcongthuc);
        Danhsachcongthuc.setLayout(DanhsachcongthucLayout);
        DanhsachcongthucLayout.setHorizontalGroup(
            DanhsachcongthucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhsachcongthucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DanhsachcongthucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DanhsachcongthucLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(DanhsachcongthucLayout.createSequentialGroup()
                        .addGroup(DanhsachcongthucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DanhsachcongthucLayout.createSequentialGroup()
                                .addComponent(txtTimKiemCongThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 298, Short.MAX_VALUE))))
        );
        DanhsachcongthucLayout.setVerticalGroup(
            DanhsachcongthucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DanhsachcongthucLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DanhsachcongthucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiemCongThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jComboBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        Menu.add(Danhsachcongthuc, "card8");

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

        txtHovaTen.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        txtHovaTen.setForeground(new java.awt.Color(255, 255, 255));
        txtHovaTen.setText("Nguyễn Tiến Đạt");

        txtChucVu.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        txtChucVu.setForeground(new java.awt.Color(255, 255, 255));
        txtChucVu.setText("Quản lý");

        jButton1.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(99, 147, 153));
        jButton1.setText("Thông tin");

        btnDangXuat.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(114, 149, 153));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDangXuat))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHovaTen)))
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtHovaTen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChucVu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
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
        
        bgDsCongThuc.setBackground(Color.WHITE);
        btnDsCongThuc.setForeground(ColorFrame);
       
        DoanhThu.setVisible(true);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(false);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(false);
        Danhsachcongthuc.setVisible(false);
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
      
        bgDsCongThuc.setBackground(Color.WHITE);
        btnDsCongThuc.setForeground(ColorFrame);
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(true);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(false);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(false);
        Danhsachcongthuc.setVisible(false);
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
        
        bgDsCongThuc.setBackground(Color.WHITE);
        btnDsCongThuc.setForeground(ColorFrame);
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(true);
        KhoHang.setVisible(false);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(false);
        Danhsachcongthuc.setVisible(false);
       
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
        
        bgDsCongThuc.setBackground(Color.WHITE);
        btnDsCongThuc.setForeground(ColorFrame);
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(true);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(false);
        Danhsachcongthuc.setVisible(false);
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
        
        bgDsCongThuc.setBackground(Color.WHITE);
        btnDsCongThuc.setForeground(ColorFrame);
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(false);
        ThongBao.setVisible(true);
        KhuyenMai.setVisible(false);
        Danhsachcongthuc.setVisible(false);
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
        
        bgDsCongThuc.setBackground(Color.WHITE);
        btnDsCongThuc.setForeground(ColorFrame);
        
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(false);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(true);
        Danhsachcongthuc.setVisible(false);
    }//GEN-LAST:event_bgKhuyenMaiMousePressed

    private void bgDsCongThucMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgDsCongThucMousePressed
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
        
        bgKhuyenMai.setBackground(Color.WHITE);
        btnKhuyenMai.setForeground(ColorFrame);
        
        bgDsCongThuc.setBackground(ColorFrame);
        btnDsCongThuc.setForeground(Color.WHITE);
        
        DoanhThu.setVisible(false);
        DanhsachNV.setVisible(false);
        Bangchamcong.setVisible(false);
        KhoHang.setVisible(false);
        ThongBao.setVisible(false);
        KhuyenMai.setVisible(false);
        Danhsachcongthuc.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_bgDsCongThucMousePressed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        System.out.println("1");
        variables.openLogInAgain();
        
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnXoaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhuyenMaiActionPerformed
        
    }//GEN-LAST:event_btnXoaKhuyenMaiActionPerformed

    private void btnXoaTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTBActionPerformed
        try {
            this.deleteThongBao();
        } catch (SQLException ex) {
            Logger.getLogger(GD_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
    }//GEN-LAST:event_btnXoaTBActionPerformed

    private void cbSapXepThongBaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepThongBaoActionPerformed
        try {
            this.SortThongBao();
        } catch (SQLException ex) {
            Logger.getLogger(GD_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbSapXepThongBaoActionPerformed

    private void cbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepActionPerformed
        
    }//GEN-LAST:event_cbSapXepActionPerformed

    private void CbSapXepNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbSapXepNLActionPerformed
        this.SortNguyenLieu();
    }//GEN-LAST:event_CbSapXepNLActionPerformed

    private void btnXoaNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNLActionPerformed
        try {
            this.deleteNguyenLieu();
        } catch (SQLException ex) {
            Logger.getLogger(GD_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaNLActionPerformed

    private void btnTaoThongBaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoThongBaoActionPerformed
        this.variables.openGDTB();
    }//GEN-LAST:event_btnTaoThongBaoActionPerformed

    private void tbDSNhanVienAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbDSNhanVienAncestorAdded

    }//GEN-LAST:event_tbDSNhanVienAncestorAdded

    private void tbDSNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDSNhanVienMouseClicked
        String id =  model.getValueAt(tbDSNhanVien.getSelectedRow(), 0).toString() ;
        
        try {
           
            NHANVIEN NV = this.variables.getNhanVien(id);
            this.variables.openInfoNhanVien(NV);
        } catch (SQLException ex) {
            Logger.getLogger(GD_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbDSNhanVienMouseClicked

    private void cbSapXepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSapXepItemStateChanged
        if(cbSapXep.getSelectedItem().toString().compareTo("Họ và tên") == 0) {
            try {
                
                fillTableItemSelection("3");
            } catch (SQLException ex) {
                Logger.getLogger(GD_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (cbSapXep.getSelectedItem().toString().compareTo("Mã nhân viên") == 0) {
            try {
                fillTableItemSelection("1");
            } catch (SQLException ex) {
                Logger.getLogger(GD_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  else if (cbSapXep.getSelectedItem().toString().compareTo("Số giờ làm việc") == 0) {
            try {
                fillTableItemSelection("2");
            } catch (SQLException ex) {
                Logger.getLogger(GD_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (cbSapXep.getSelectedItem().toString().compareTo("Họ và tên") == 0) {
            try {
                fillTableItemSelection("3");
            } catch (SQLException ex) {
                Logger.getLogger(GD_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }//GEN-LAST:event_cbSapXepItemStateChanged

    private void txtTimKiemNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNVKeyReleased
        int position = txtTimKiemNV.getCaretPosition();
        txtTimKiemNV.setText(txtTimKiemNV.getText().toUpperCase());
        txtTimKiemNV.setCaretPosition(position);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemNVKeyReleased
    

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        txtTrangThaiQL.setText("Online");
        txtTrangThaiQL.setForeground(new Color(0,204,0));
        ViewTrangThaiQL.setBackground(new Color(0,204,0));
        
    }

            
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bangchamcong;
    private javax.swing.JComboBox<String> CbSapXepNL;
    private javax.swing.JPanel DanhsachNV;
    private javax.swing.JPanel Danhsachcongthuc;
    private javax.swing.JPanel DoanhThu;
    private javax.swing.JPanel KhoHang;
    private javax.swing.JPanel KhuyenMai;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel ThongBao;
    private javax.swing.JPanel ViewTrangThaiQL;
    private javax.swing.JPanel bgBangChamCong;
    private javax.swing.JPanel bgDanhSachNV;
    private javax.swing.JPanel bgDoanhThu;
    private javax.swing.JPanel bgDsCongThuc;
    private javax.swing.JPanel bgKhoHang;
    private javax.swing.JPanel bgKhuyenMai;
    private javax.swing.JPanel bgThongBao;
    private javax.swing.JLabel btnBangChamCong;
    private javax.swing.JButton btnBieuDoCot;
    private javax.swing.JButton btnBieuDoDuong;
    private javax.swing.JButton btnBieuDoTron;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JLabel btnDanhSachNV;
    private javax.swing.JLabel btnDoanhThu;
    private javax.swing.JLabel btnDsCongThuc;
    private javax.swing.JLabel btnKhoHang;
    private javax.swing.JLabel btnKhuyenMai;
    private javax.swing.JButton btnNhapNL;
    private javax.swing.JButton btnTaoThongBao;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JLabel btnThongBao;
    private javax.swing.JButton btnXoaKhuyenMai;
    private javax.swing.JButton btnXoaNL;
    private javax.swing.JButton btnXoaTB;
    private javax.swing.JComboBox<String> cbSapXep;
    private javax.swing.JComboBox<String> cbSapXepThongBao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JTable tbDSNhanVien;
    private javax.swing.JTable tblDanhSachCT;
    private javax.swing.JTable tblDsKhuyenMai;
    private javax.swing.JTable tblDsNguyenLieu;
    private javax.swing.JTable tblDsThongBao;
    private javax.swing.JLabel txtChucVu;
    private javax.swing.JLabel txtDonDaHuy;
    private javax.swing.JLabel txtDonHangTra;
    private javax.swing.JLabel txtDonHoanThanh;
    private javax.swing.JLabel txtHovaTen;
    private javax.swing.JLabel txtKHmua;
    private javax.swing.JLabel txtLuotMuaSam;
    private javax.swing.JLabel txtTiXuatLoiNhuan;
    private javax.swing.JTextField txtTimKiemCongThuc;
    private javax.swing.JTextField txtTimKiemNL;
    private javax.swing.JTextField txtTimKiemNV;
    private javax.swing.JTextField txtTimKiemThongBao;
    private javax.swing.JLabel txtTongDoanhThu;
    private javax.swing.JLabel txtTongThoiGianLamViec;
    private javax.swing.JLabel txtTrangThaiQL;
    // End of variables declaration//GEN-END:variables
    
    private void showThongTinNhanVien() throws SQLException{
        int index = this.tbDSNhanVien.getSelectedRow();
        CHAMCONG cc1 = this.listCC.get(index);
        NHANVIEN NV = variables.getNhanVien(cc1.getManv());
        variables.openInfoNhanVien(NV);
    }
    
    private void SortThongBao() throws SQLException{
        model = (DefaultTableModel) tblDsThongBao.getModel();
        while(model.getRowCount() > 0 ){
            model.removeRow(0);
        }
        
        this.listTB.sort( (p1, p2)-> p2.getMaTB().toString().compareTo(p1.getMaTB().toString()));
        for(THONGBAO item: this.listTB){
            Object[] obj = new Object[]{
                item.getMaTB(),
                item.getNoidung(),
                variables.getNgayThongBao(item.getMaTB())
                };
                model.addRow(obj);
        }    
    }
    
  
    
    
    private void SortNguyenLieu(){
        model = (DefaultTableModel) tblDsNguyenLieu.getModel();
        while(model.getRowCount() > 0 ){
            model.removeRow(0);
        }
        
        this.listNL.sort( (p1, p2)-> p2.getMaNL().toString().compareTo(p1.getMaNL().toString()));
        for(NGUYENLIEU item: this.listNL){
            Object[] obj = new Object[]{
                item.getMaNL(),
                item.getTenNL(),
                item.getDonvi()
                };
                model.addRow(obj);
        }    
    }  
    
    private void deleteThongBao() throws SQLException{
        int index = this.tblDsThongBao.getSelectedRow();
        model = (DefaultTableModel) tblDsThongBao.getModel();
        while(model.getRowCount() > 0 ){
            model.removeRow(0);
        }
        this.variables.getDB().deleteThongBao(variables.getStatement(), this.listTB.get(index).getMaTB());
        this.listTB.remove(index);
        for(THONGBAO item: this.listTB){
            Object[] obj = new Object[]{
                item.getMaTB(),
                item.getNoidung(),
                variables.getNgayThongBao(item.getMaTB())
                };
                model.addRow(obj);
        }
    }
    
    public void deleteNguyenLieu() throws SQLException{
        int index = this.tblDsNguyenLieu.getSelectedRow();
        model = (DefaultTableModel) tblDsNguyenLieu.getModel();
        while(model.getRowCount() > 0 ){
            model.removeRow(0);
        }
        this.variables.getDB().deleteNguyenLieu(variables.getStatement(), this.listNL.get(index).getMaNL());
        this.listNL.remove(index);
        for(NGUYENLIEU item: this.listNL){
            Object[] obj = new Object[]{
                item.getMaNL(),
                item.getTenNL(),
                item.getDonvi()
            };
            model.addRow(obj);
        }  
        
    }
    
    public void initTableDSNV() {
        model = (DefaultTableModel) tbDSNhanVien.getModel();
        model.setColumnIdentifiers(new Object[] {
                "MÃ NHÂN VIÊN","HỌ VÀ TÊN", "TRẠNG THÁI","GIỜ LÀM VIỆC"
        });
        model.setRowCount(0);
        
        tbDSNhanVien.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbDSNhanVien.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbDSNhanVien.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbDSNhanVien.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    public void fillTableDSNV() throws SQLException {
        fillTableItemSelection("1");
        
    }
    
    
    public  void fillTableItemSelection (String key) throws SQLException {
        String sql ;
        if (key.compareTo("1") == 0) {
            sql = "Select* FROM BANGCHAMCONG ORDER BY MANV ASC" ;
            
            List<CHAMCONG> lsfill = new ArrayList<>() ;
            
            int tt = 0 ;
            lsfill = this.variables.sortSelectionItemDSNV(sql) ;
            model = (DefaultTableModel) tbDSNhanVien.getModel();
            model.setRowCount(0);
            
             for (CHAMCONG item: lsfill ) {
                tt += item.getSogiolamviec() ;
                if (item.getManv().equals(variables.getmaNVByTAIKHOAN(this.tk.getTk()))) {
                   
                    Object[] obj = new Object[] {
                    item.getManv(),
                    variables.getHOTENNHANVIEN(item.getManv()),
                    "TRONG CA",
                    String.valueOf(item.getSogiolamviec()) 
                    } ;
                    model.addRow(obj);
                } else {
                    Object[] obj = new Object[] {
                    item.getManv(),
                    variables.getHOTENNHANVIEN(item.getManv()),
                    "OFF CA",
                    String.valueOf(item.getSogiolamviec()) 
                    } ;
                    model.addRow(obj);
                }
            }
             txtTongThoiGianLamViec.setText(String.valueOf(tt) +"h" );
            
        } else if (key.compareTo("2") == 0) {
            sql = "Select* FROM BANGCHAMCONG ORDER BY SOGIOLAMVIEC ASC" ; 
            
            List<CHAMCONG> lsfill = new ArrayList<>() ;
            
            lsfill = this.variables.sortSelectionItemDSNV(sql) ;
            model = (DefaultTableModel) tbDSNhanVien.getModel();
            model.setRowCount(0);
            for (CHAMCONG item: lsfill ) {
                
                if (item.getManv().equals(variables.getmaNVByTAIKHOAN(this.tk.getTk()))) {
                    Object[] obj = new Object[] {
                    item.getManv(),
                    variables.getHOTENNHANVIEN(item.getManv()),
                    "TRONG CA",
                    String.valueOf(item.getSogiolamviec()) 
                    } ;
                    model.addRow(obj);
                } else {
                    Object[] obj = new Object[] {
                    item.getManv(),
                    variables.getHOTENNHANVIEN(item.getManv()),
                    "OFF CA",
                    String.valueOf(item.getSogiolamviec()) 
                    } ;
                    model.addRow(obj);
                }
            }
        } else if (key.compareTo("3") == 0) {
            sql = "Select* FROM BANGCHAMCONG ORDER BY SOGIOLAMVIEC ASC" ; 
            
            List<CHAMCONG> lsfill = new ArrayList<>() ;
            
            
            lsfill = this.variables.sortSelectionItemDSNV(sql) ;
            
             Collections.sort(lsfill, new Comparator<CHAMCONG>() {
                @Override
                public int compare(CHAMCONG nv1, CHAMCONG nv2) {
                    try {
                        return  variables.getTENNHANVIEN(nv1.getManv()).compareTo(variables.getTENNHANVIEN(nv2.getManv()));
                    } catch (SQLException ex) {
                        Logger.getLogger(GD_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                    return 0;
                    }
                });
            model = (DefaultTableModel) tbDSNhanVien.getModel();
            model.setRowCount(0);
            for (CHAMCONG item: lsfill ) {
                
                if (item.getManv().equals(variables.getmaNVByTAIKHOAN(this.tk.getTk()))) {
                    Object[] obj = new Object[] {
                    item.getManv(),
                    variables.getHOTENNHANVIEN(item.getManv()),
                    "TRONG CA",
                    String.valueOf(item.getSogiolamviec()) 
                    } ;
                    model.addRow(obj);
                } else {
                    Object[] obj = new Object[] {
                    item.getManv(),
                    variables.getHOTENNHANVIEN(item.getManv()),
                    "OFF CA",
                    String.valueOf(item.getSogiolamviec()) 
                    } ;
                    model.addRow(obj);
                }
            }
        }
     
    }
    
    private void initTableDSNL() {
        model = (DefaultTableModel) tblDsNguyenLieu.getModel();
        model.setColumnIdentifiers(new Object[] {
                "MÃ NGUYÊN LIỆU","TÊN NGUYÊN LIỆU","ĐƠN VỊ"
        });
        model.setRowCount(0);
        
        tblDsNguyenLieu.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblDsNguyenLieu.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblDsNguyenLieu.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public void fillTableDSNL() throws SQLException {
        this.listNL = this.variables.loadingNguyenLieu();           
        for(NGUYENLIEU item: this.listNL){
            Object[] obj = new Object[]{
                item.getMaNL(),
                item.getTenNL(),
                item.getDonvi()
            };
            model.addRow(obj);
        }  
    }
    
    private void initTableDSTB() {
        model = (DefaultTableModel) tblDsThongBao.getModel();
        model.setColumnIdentifiers(new Object[] {
                "MÃ THÔNG BÁO","NỘI DUNG","NGÀY THÔNG BÁO"
        });
        model.setRowCount(0);
        
        tblDsThongBao.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblDsThongBao.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblDsThongBao.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    
    public void fillTableDSTB() throws SQLException {
        
        this.listTB = this.variables.loadingThongBao();   
        while(model.getRowCount() > 0 ){
            model.removeRow(0);
        }
        for(THONGBAO item: this.listTB){
            Object[] obj = new Object[]{
                item.getMaTB(),
                item.getNoidung(),
                variables.getNgayThongBao(item.getMaTB())
            };
            model.addRow(obj);
        }  
    }
    
    private void initTableDSKM() {
        model = (DefaultTableModel) tblDsKhuyenMai.getModel();
        model.setColumnIdentifiers(new Object[] {
                "MÃ KHUYẾN MÃI","MÃ MÓN" ,"LÝ DO","NGÀY BẮT ĐẦU", "NGÀY KẾT THÚC","PHẦN TRĂM"
        });
        model.setRowCount(0);
        
        tblDsKhuyenMai.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblDsKhuyenMai.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblDsKhuyenMai.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblDsKhuyenMai.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblDsKhuyenMai.getColumnModel().getColumn(4).setPreferredWidth(100);
    }
    private void fillTableDSKM() throws SQLException {
        this.listCTKM = this.variables.loadingKhuyenMai();           
        for(CT_KM item: this.listCTKM){
            Object[] obj = new Object[]{
                item.getMaKM(),
                item.getMaMon(),
                variables.getLyDoKhuyenMai(item.getMaKM()),
                item.getNgayBD(),
                item.getNgayKT(),
                item.getPhantram()
            };
            model.addRow(obj);
        }  
    }
    private void initTableDSCT() {
        model = (DefaultTableModel) tblDanhSachCT.getModel();
        model.setColumnIdentifiers(new Object[] {
                "TÊN MÓN" ,"TÊN NGUYÊN LIỆU", "CÁCH LÀM"
        });
        model.setRowCount(0);
        
        tblDanhSachCT.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblDanhSachCT.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblDanhSachCT.getColumnModel().getColumn(2).setPreferredWidth(100);
        
    }
    private void fillTableDSCT() throws SQLException {
        this.listCTM = this.variables.loadingDSCT();           
        for(CT_MON item: this.listCTM){
            Object[] obj = new Object[]{
                variables.getMon(item.getMaMon()),
                item.getMaNL(),
                item.getCachlam()
            };
            model.addRow(obj);
        }  
    }
}
