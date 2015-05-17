/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tickets;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author YorleydeMaría
 */
public class excel_Manage {
  public static void showExelData(List sheetsData) {
        //
        // Recorre la lista que contiene las hojas del libro de excel 
        //
        for (int i = 0; i < sheetsData.size(); i++) {
            List list = (List) sheetsData.get(i);
            for (int j = 0; j < list.size(); j++) {
                Cell cell = (Cell) list.get(j);
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    System.out.print(cell.getNumericCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    System.out.print(cell.getRichStringCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                    System.out.print(cell.getBooleanCellValue());
                }
                if (j < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }
    
    public static List readExcel(String path) throws IOException{
        //String path1 = System.getProperty("user.home")+"/ejemploExcelJava.xls";
        String path1=path;
        List<List> sheetData = new ArrayList();
        FileInputStream FlujoDeDatos = null;

        try {
            FlujoDeDatos = new FileInputStream(path1);
            if (FlujoDeDatos == null) {
                System.out.println("No se encuentra el archivo");
            // No se encuentra la plantilla - aqui puedes enviar un mensaje de log o lo que quieras
            return null;
            }
            // Si todo ha ido bien
	    HSSFWorkbook workbook = new HSSFWorkbook(FlujoDeDatos);
            //
            // Get the first sheet on the workbook.
            //
            HSSFSheet sheet = workbook.getSheetAt(0);

            // When we have a sheet object in hand we can iterator on
            // each sheet's rows and on each row's cells. We store the
            // data read on an ArrayList so that we can printed the
            // content of the excel to the console.
            //
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();           
                Iterator cells = row.cellIterator();
                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                //  System.out.println("Añadiendo Celda: " + cell.toString());
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (FlujoDeDatos!= null) {
                FlujoDeDatos.close();
            }
        }
        //showExelData(sheetData);
        return sheetData;
    }

    public static void createFinalExcel(String[] args, String fecha)throws Exception{
         /*La ruta donde se creará el archivo*/
        /*Se crea el objeto de tipo File con la ruta del archivo*/
        String rutaArchivo = System.getProperty("user.home")+"/ejemploExcelJava.xls";
        File archivoXLS = new File(rutaArchivo);
        /*Si el archivo existe se elimina*/
        if(archivoXLS.exists()) archivoXLS.delete();
        /*Se crea el archivo*/
        archivoXLS.createNewFile();
        
        /*Se crea el libro de excel usando el objeto de tipo Workbook*/
        Workbook libro = new HSSFWorkbook();
        /*Se inicializa el flujo de datos con el archivo xls*/
        FileOutputStream archivo = new FileOutputStream(archivoXLS);
        
        /*Utilizamos la clase Sheet para crear una nueva hoja de trabajo dentro del libro que creamos anteriormente*/
        HashMap<String,Sheet> hojas = new HashMap<String,Sheet>();
        for(int m=0;m<3;m++){
            hojas.put("hoja"+m, libro.createSheet("Mi hoja de trabajo "+m));            
        }
        /*La clase Row nos permitirá crear las filas*/
        /*Cada fila tendrá 10 celdas de datos*/
        /*Creamos la celda a partir de la fila actual*/
        /*Si la fila es la número 0, estableceremos los encabezados*/
        for(int y=0;y<3;y++){
            for(int f=0;f<10;f++){
                Sheet hoja=hojas.get("hoja"+y);
                Row fila = hoja.createRow(f);
                for(int c=0;c<10;c++){
                    Cell celda = fila.createCell(c);            
                    if(f==0){
                        switch(c){
                            case 0:
                                celda.setCellValue("Fecha y Hora de recepcion");
                                break;
                            case 1:
                                celda.setCellValue("ID_Cliente");
                                break;
                            case 2:
                                celda.setCellValue("Asunto");
                                break;
                            case 3:
                                celda.setCellValue("Ticket_ID");
                                break;
                            case 4:
                                celda.setCellValue("Categoria");
                                break;
                            case 5:
                                celda.setCellValue("Empleado_ID");
                                break;
                            case 6:
                                celda.setCellValue("Fecha y hora de atención");
                                break;
                            case 7:
                                celda.setCellValue("Tiempo en segundos");
                                break;
                            case 8:
                                celda.setCellValue("Comentario");
                                break;
                            case 9:
                                celda.setCellValue("Estado");
                                break;                                
                        }

                    }else{
                        /*Aca se escriben los datos */
                        celda.setCellValue("YORLEY "+c+","+f);
                    }
                }
            }
    }
        
        /*Escribimos en el libro*/
        libro.write(archivo);
        /*Cerramos el flujo de datos*/
        archivo.close();
        showExelData(readExcel(rutaArchivo));
        /*Y abrimos el archivo con la clase Desktop*/
       Desktop.getDesktop().open(archivoXLS); 
    }
    
    public static void main(String[] args) throws Exception{
       excel_Manage.readExcel(System.getProperty("user.home")+"/contraseñas.xls");
        
    } 
    
    
    
    
    
    
    
}
