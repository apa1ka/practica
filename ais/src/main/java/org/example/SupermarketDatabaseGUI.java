package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SupermarketDatabaseGUI extends JFrame {

    private JTable customerTable;
    private JTable employeeTable;
    private JTable orderTable;
    private JTable ordertitemTable;
    private JTable productTable;
    private JTable supplierTable;
    private JTable warehouseTable;
    private JTable saleTable;

    private DefaultTableModel customerTableModel;
    private DefaultTableModel employeeTableModel;
    private DefaultTableModel orderTableModel;
    private DefaultTableModel ordertitemTableModel;
    private DefaultTableModel productTableModel;
    private DefaultTableModel supplierTableModel;
    private DefaultTableModel warehouseTableModel;
    private DefaultTableModel saleTableModel;

    private Connection connection;

    public SupermarketDatabaseGUI() {
        super("Supermarket");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Создаем таблицы
        customerTable = new JTable();
        employeeTable = new JTable();
        orderTable = new JTable();
        ordertitemTable = new JTable();
        productTable = new JTable();
        supplierTable = new JTable();
        warehouseTable = new JTable();
        saleTable = new JTable();

        // Создаем модели таблиц
        customerTableModel = new DefaultTableModel();
        employeeTableModel = new DefaultTableModel();
        orderTableModel = new DefaultTableModel();
        ordertitemTableModel = new DefaultTableModel();
        productTableModel = new DefaultTableModel();
        supplierTableModel = new DefaultTableModel();
        warehouseTableModel = new DefaultTableModel();
        saleTableModel = new DefaultTableModel();

        // Устанавливаем модели для таблиц
        customerTable.setModel(customerTableModel);
        employeeTable.setModel(employeeTableModel);
        orderTable.setModel(orderTableModel);
        ordertitemTable.setModel(ordertitemTableModel);
        productTable.setModel(productTableModel);
        supplierTable.setModel(supplierTableModel);
        warehouseTable.setModel(warehouseTableModel);
        saleTable.setModel(saleTableModel);

        // Создаем вкладки
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("customer", new JScrollPane(customerTable));
        tabbedPane.addTab("employee", new JScrollPane(employeeTable));
        tabbedPane.addTab("order", new JScrollPane(orderTable));
        tabbedPane.addTab("ordertitem", new JScrollPane(ordertitemTable));
        tabbedPane.addTab("product", new JScrollPane(productTable));
        tabbedPane.addTab("supplier", new JScrollPane(supplierTable));
        tabbedPane.addTab("warehouse", new JScrollPane(warehouseTable));
        tabbedPane.addTab("sale", new JScrollPane(saleTable));

        // Создаем кнопку "Обновить"
        JButton updateButton = new JButton("update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTables();
            }
        });

        // Добавляем кнопку в панель инструментов
        JToolBar toolBar = new JToolBar();
        toolBar.add(updateButton);

        // Добавляем вкладки и кнопку в фрейм
        getContentPane().add(toolBar, BorderLayout.NORTH);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        // Устанавливаем соединение с базой данных
        connectToDatabase();

        // Заполняем таблицы
        updateTables();

        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "35147629d");
            System.out.println("Соединение с базой данных установлено.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ошибка при подключении к базе данных: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTables() {
        try {

            updateСustomerTable();
            updateEmployeeTable();
            updateOrderTable();
            updateOrdertitemTable();
            updateProductTable();
            updateSupplierTable();
            updateWarehouseTable();
            updateSaleTable();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ошибка при обновлении данных: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Методы для обновления таблиц
    private void updateСustomerTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Сustomer");
        customerTableModel.setDataVector(getResultSetData(rs), new String[]{"СustomerID", "СustomerName", "address", "email"});
        rs.close();
        stmt.close();
    }

    private void updateEmployeeTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
        employeeTableModel.setDataVector(getResultSetData(rs), new String[]{"EmployeeID", "EmployeeName", "address", "phone"});
        rs.close();
        stmt.close();
    }

    private void updateOrderTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Order");
        orderTableModel.setDataVector(getResultSetData(rs), new String[]{"Order", "OrderDate", "supplioerID", "warehouseID"});
        rs.close();
        stmt.close();
    }

    private void updateOrdertitemTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Ordertitem");
        ordertitemTableModel.setDataVector(getResultSetData(rs), new String[]{"OrderID", "productID", "quantity", "price"});
        rs.close();
        stmt.close();
    }

    private void updateProductTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
        productTableModel.setDataVector(getResultSetData(rs), new String[]{"Product", "ProductName", "description", "unitPrice", "price", "supplierID"});
        rs.close();
        stmt.close();
    }

    private void updateSupplierTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Supplier");
        supplierTableModel.setDataVector(getResultSetData(rs), new String[]{"Supplier", "SupplierName", "address", "phone", "contactPerson"});
        rs.close();
        stmt.close();
    }

    private void updateWarehouseTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Warehouse");
        warehouseTableModel.setDataVector(getResultSetData(rs), new String[]{"WarehouseID", "WarehouseName", "address"});
        rs.close();
        stmt.close();
    }

    private void updateSaleTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Sale");
        saleTableModel.setDataVector(getResultSetData(rs), new String[]{"SaleID", "SaleDate", "employeeID", "customerID"});
        rs.close();
        stmt.close();
    }

    private Object[][] getResultSetData(ResultSet rs) throws SQLException {
        // Получаем количество столбцов
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Получаем количество строк
        rs.last();
        int rowCount = rs.getRow();
        rs.beforeFirst();

        // Создаем двумерный массив для хранения данных
        Object[][] data = new Object[rowCount][columnCount];

        // Заполняем массив данными
        int row = 0;
        while (rs.next()) {
            for (int col = 0; col < columnCount; col++) {
                data[row][col] = rs.getObject(col + 1);
            }
            row++;
        }
        return data;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SupermarketDatabaseGUI();
            }
        });
    }
}
