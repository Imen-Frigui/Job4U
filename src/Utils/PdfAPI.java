/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import Entities.Postulation;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

/*public class PDFCreator {
   private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
   private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/pidev";
   private static final String DB_USER = "root";
   private static final String DB_PASSWORD = "";
   private static final Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

   public static void CreatePDF() {
      try {
         Class.forName(DB_DRIVER);
          try (Connection conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `postulation`"); ResultSet rs = stmt.executeQuery()) {
              
              Document document = new Document(PageSize.A4.rotate());
              PdfWriter.getInstance(document, new FileOutputStream("sample.pdf"));
              document.open();
              
              PdfPTable table = new PdfPTable(4);
              table.setWidthPercentage(100);
              
              addTableHeader(table);
              while (rs.next()) {
                  int id_pos = rs.getInt("id_pos");
                  String date = rs.getString("date");
                  String Simple_user = rs.getString("simple_user");
                  String email = rs.getString("email");
                  addTableRow(table, id_pos, date, Simple_user, email);
              }
              
              document.add(table);
              document.close();
          }
      } catch (ClassNotFoundException | SQLException | DocumentException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static void addTableHeader(PdfPTable table) {
      PdfPCell cell = new PdfPCell(new Paragraph("Table Header", font));
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      table.addCell(cell);

      cell = new PdfPCell(new Paragraph("id_pos", font));
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      table.addCell(cell);

      cell = new PdfPCell(new Paragraph("date", font));
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      table.addCell(cell);

      cell = new PdfPCell(new Paragraph("SimpleUser", font));
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      table.addCell(cell);

      cell = new PdfPCell(new Paragraph("Email", font));
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      table.addCell(cell);
   }

   private static void addTableRow(PdfPTable table, int id_pos, String date, String Simple_user, String email) {
      table.addCell(String.valueOf(id_pos));
      table.addCell(date);
      table.addCell(Simple_user);
      table.addCell(email);
   }
}*/
public class PdfAPI {

    Connection cnx;
    PreparedStatement ste;
     private static final Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public PdfAPI() {
        cnx = MyDB.getInstance().getCon();

    }
    Document doc = new Document();

    public void listAllPostulations() throws SQLException, FileNotFoundException, DocumentException, IOException {
        try {
            String requete = "SELECT * FROM `postulation`";
            ste = cnx.prepareStatement(requete);
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }

        ResultSet rs = ste.executeQuery("SELECT * FROM `postulation`");
        PdfWriter.getInstance(doc, new FileOutputStream("./postulation.pdf"));

        doc.open();
        //Image image = Image.getInstance("C:\\Users\\user\\Documents\\NetBeansProjects\\Job4U\\src\\ressources\\logo.png");

        
         //doc.add(image);
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste des postulations  "));
        doc.add(new Paragraph("   "));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase("id_pos", FontFactory.getFont("Comic Sans MS", 15)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("date", FontFactory.getFont("Comic Sans MS", 15)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("simple_user", FontFactory.getFont("Comic Sans MS", 15)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("email", FontFactory.getFont("Comic Sans MS", 15)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        //cell = new PdfPCell(new Phrase("Prix", FontFactory.getFont("Comic Sans MS", 15)));
        //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        //table.addCell(cell);
        while (rs.next()) {

            Postulation c = new Postulation(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4));

            c.setId_pos(rs.getInt(1));
            c.setDate(rs.getDate(2));
            c.setSimple_user(rs.getString(3));
            c.setEmail(rs.getString(4));
            int id_pos = 0;
     

            cell = new PdfPCell(new Phrase(Integer.toString(id_pos, 0), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dateString = sdf.format(c.getDate());
            Phrase phrase = new Phrase(dateString, FontFactory.getFont("Comic Sans MS", 12));
            cell = new PdfPCell(phrase);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(c.getSimple_user(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(c.getEmail(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
          

              table.addCell(cell);
        }

        doc.add(table);
        doc.close();
        File file = new File("C:\\Users\\user\\Documents\\NetBeansProjects\\Job4U\\src\\ressources\\postulation.fxml"); // Create a new file object
        if (!file.exists()) { // Check if the file doesn't exist
           file.createNewFile(); // Create the new file
        }
        Desktop.getDesktop().open(new File("./postulation.pdf"));
    }
}
