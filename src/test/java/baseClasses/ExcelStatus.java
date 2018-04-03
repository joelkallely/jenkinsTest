package baseClasses;

import java.io.IOException;

public class ExcelStatus {

	public static void main(String[] args) throws IOException {
		ExcelHelper oldFile = new ExcelHelper();
		ExcelHelper newFile = new ExcelHelper();
		newFile.setExcelFile("Automation Status", "Test Cases");
		oldFile.setExcelFile("Automation Status", "Sheet1");
		int i = 0;
		int j = 0;
		int countOld = 0;
		String oldCase = "";
		System.out.println("Initial\n");
		String newCase = "";
		for(i=0;i<=75;i++) {
				countOld++;
			oldCase = oldFile.getCell(i, 1).toString();
			System.out.println(oldCase);
			for(j=1;j<=4353;j++) {
				
				if(oldCase.contentEquals(newFile.getCell(j, 0).toString())) {
					System.out.println(newFile.getCell(j, 0).toString());
					newFile.setCell(j, 10, "Yes");
				}
			}
			
		}
		System.out.println(countOld);
	}
}
