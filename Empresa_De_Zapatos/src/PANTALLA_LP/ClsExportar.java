package PANTALLA_LP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;

import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;

/**
 * Clase para exportar en PDF o EXCEL
 *
 * @author Alex Salazar
 * @author David Requeta
 */
public class ClsExportar {

	/**
	 * constructor
	 * 
	 * @throws IOException lanza excepcion
	 */
	public ClsExportar(JTable table) throws IOException {
		Exportar(table);
	}

	private void Exportar(JTable t) throws IOException {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "xls");
		FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Archivos de PDF", "pdf");
		chooser.setFileFilter(filter);
		chooser.setFileFilter(filter1);
		chooser.setDialogTitle("Guardar archivo");
		chooser.setAcceptAllFileFilterUsed(false);
		if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			String ruta = chooser.getFileFilter().getDescription();

			if (ruta.equals("Archivos de Excel")) {

				try {
					ruta = chooser.getSelectedFile().toString().concat(".xls");
					File archivoXLS = new File(ruta);
					if (archivoXLS.exists()) {
						archivoXLS.delete();
					}
					archivoXLS.createNewFile();
					Workbook libro = new HSSFWorkbook();
					FileOutputStream archivo = new FileOutputStream(archivoXLS);
					Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
					hoja.setDisplayGridlines(false);
					for (int f = 0; f < t.getRowCount(); f++) {
						Row fila = hoja.createRow(f);
						for (int c = 0; c < t.getColumnCount(); c++) {
							Cell celda = fila.createCell(c);
							if (f == 0) {
								celda.setCellValue(t.getColumnName(c));
							}
						}
					}
					int filaInicio = 1;
					for (int f = 0; f < t.getRowCount(); f++) {
						Row fila = hoja.createRow(filaInicio);
						filaInicio++;
						for (int c = 0; c < t.getColumnCount(); c++) {
							Cell celda = fila.createCell(c);
							if (t.getValueAt(f, c) instanceof Double) {
								celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
							} else if (t.getValueAt(f, c) instanceof Float) {
								celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
							} else {
								celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
							}
						}
					}
					libro.write(archivo);
					archivo.close();
				} catch (IOException | NumberFormatException e) {
					throw e;
				}
			}

			if (ruta.equals("Archivos de PDF")) {
				try {

					/**
					 * Creamos el documento e indicamos el nombre del fichero.
					 */
					Document document = new Document();
					try {
						PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile() + ".pdf"));
					} catch (FileNotFoundException fileNotFoundException) {

					}
					document.open();

					Anchor anchor = new Anchor();
					anchor.setName("");

					Chapter catPart = new Chapter(new Paragraph(anchor), 1);

					Paragraph subPara = new Paragraph("");
					Section subCatPart = catPart.addSection(subPara);
					subCatPart.add(new Paragraph(""));

					PdfPTable table = new PdfPTable(t.getColumnCount());

					PdfPCell columnHeader;

					for (int column = 0; column < t.getColumnCount(); column++) {
						columnHeader = new PdfPCell(new Phrase(t.getColumnName(column)));
						columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
						table.addCell(columnHeader);
					}
					table.setHeaderRows(1);

					for (int row = 0; row < t.getRowCount(); row++) {
						for (int column = 0; column < t.getColumnCount(); column++) {
							table.addCell(t.getValueAt(row, column).toString());
						}
					}
					subCatPart.add(table);

					document.add(catPart);

					document.close();

				} catch (DocumentException documentException) {

				}
			}
		}

	}
}
