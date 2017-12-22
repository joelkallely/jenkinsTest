package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelHelper {
Sheet sh = null;
FileInputStream inputFile = null;
Workbook workbook = new HSSFWorkbook();
String file = "";	
	
    public void setExcelFile(String filename, String sheet)
    {
    

		try {
			workbook = new HSSFWorkbook(new FileInputStream(new File("ExcelFiles\\"+filename+".xls")));
			file = "ExcelFiles\\"+filename+".xls";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sh = workbook.getSheet(sheet);
		
    }
    public void setCell(int r,int c,String val) throws IOException{
    	Row row = sh.getRow(r);
        Cell cell = row.getCell(c);       
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(val);
        FileOutputStream outFile =new FileOutputStream(new File(file));  //Creating new file
        workbook.write(outFile);   //printing the data in the new file
        outFile.close();           //closing the new file
    }
	public CharSequence getCell(int row,int col){
		CharSequence CellGetContent = "";
	if(sh.getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_STRING)
	{
    
		CellGetContent = sh.getRow(row).getCell(col).toString();
    
	}
	else if(sh.getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_NUMERIC)
	{
		double num = sh.getRow(row).getCell(col).getNumericCellValue();
		int n = (int)num;
		CellGetContent = String.valueOf(n);
	}
    return CellGetContent;
    }
    public int numRows()
    {
    	return sh.getPhysicalNumberOfRows();
    }
    public void createNewExcelFile(String filename, String msisdn) throws IOException{
    	CreationHelper createHelper = workbook.getCreationHelper();
    	FileOutputStream fileOut = new FileOutputStream("ExcelFiles\\"+filename+".xls");
    	sh = workbook.createSheet(filename);
    	Row row1 = sh.createRow((short) 0);
   	 
    	// inserting first row cell value
    	row1.createCell(0).setCellValue(
    	createHelper.createRichTextString("MSISDN"));
    	 
    	row1.createCell(1).setCellValue(
    	createHelper.createRichTextString("First Name"));
    	 
    	row1.createCell(2).setCellValue(
    	createHelper.createRichTextString("Last Name"));
    	 
    	row1.createCell(3).setCellValue(
    	createHelper.createRichTextString("Country"));
    	 
    	row1.createCell(4).setCellValue(
    	createHelper.createRichTextString("Email id"));
    	
    	row1.createCell(5).setCellValue(
    	createHelper.createRichTextString("Language1"));
    	    	
    	row1.createCell(6).setCellValue(
    	createHelper.createRichTextString("Language2"));
    	
    	row1.createCell(7).setCellValue(
    	createHelper.createRichTextString("Balance"));
    	
    	row1.createCell(8).setCellValue(
    	createHelper.createRichTextString("Boolean"));
    	
    	String[] country = {"India","USA","Pakisthan","Korea"};
    	String[] languages = {"Malayalam","English","Korean","Hindi"};
    	String[] Secondlanguages = {"Tamil","Spanish","Mandarin","Urdu"};
    	String[] bool = {"Yes","No"};
    	
    	
    	 Random r = new Random();
    	 String alphabet = "abcdefghijklmnopqrstuvwxyz";
 	    final int N = 6;
    	for(int i=1; i<=50; i++){
    	///////random name generation
    	    StringBuilder sb = new StringBuilder();
    	    for (int j = 0; j < N; j++) {
    	        sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
    	    }
    	    String randomFirstName = sb.toString();
    	    StringBuilder sb1 = new StringBuilder();
    	    for (int j = 0; j < N; j++) {
    	        sb1.append(alphabet.charAt(r.nextInt(alphabet.length())));
    	    }
    	    String randomLastName = sb1.toString();
    	///////random name generation
    	    int countrySelect = r.nextInt(4);
    	    int languageSelect = r.nextInt(4);
    	    int secondlanguageSelect = r.nextInt(4);
    	    int boolSelect = r.nextInt(2);
    	    int balance = r.nextInt(400);
    		Row row = sh.createRow((short) i);
    		
        	row.createCell(0).setCellValue(
        	createHelper.createRichTextString(msisdn+String.format("%04d",i)));
        	 
        	row.createCell(1).setCellValue(
        	createHelper.createRichTextString(randomFirstName));
        	 
        	row.createCell(2).setCellValue(
        	createHelper.createRichTextString(randomLastName));
        	 
        	row.createCell(3).setCellValue(
        	createHelper.createRichTextString(country[countrySelect]));
        	 
        	row.createCell(4).setCellValue(
        	createHelper.createRichTextString(randomFirstName+"@gmail.com"));
        	
        	row.createCell(5).setCellValue(
        	createHelper.createRichTextString(languages[languageSelect]));
        	    	
        	row.createCell(6).setCellValue(
        	createHelper.createRichTextString(Secondlanguages[secondlanguageSelect]));
        	
        	row.createCell(7).setCellValue(
        	createHelper.createRichTextString(String.valueOf(balance)));

        	
        	row.createCell(8).setCellValue(
        	createHelper.createRichTextString(bool[boolSelect]));

    	}
    	
    	workbook.write(fileOut);
    	fileOut.close();
    	
    }
	
	
    
}

