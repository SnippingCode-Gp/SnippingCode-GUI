package run;

import importCode.ImportCodeController;
import importCode.ImportCodeModel;
import importCode.ImportCodeView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import SnippingCode.Domain.Code;
import SnippingCode.Service.FileOperation;

public class ImportCode {

	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();
		Process process;
		try {
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				return line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}

	public void run(String workspacePath) {
		ImportCodeModel model = new ImportCodeModel();
		ImportCodeView view = new ImportCodeView();
		FileOperation fileOperation = new FileOperation();
		List<Code> codes = fileOperation.parseXmlFile();
		String[] arr = new String[codes.size()];
		for (int i = 0; i < codes.size(); ++i)
			arr[i] = codes.get(i).getName();
		view.setCodesNameList(arr);
		ImportCodeController controller = new ImportCodeController(model, view);
		controller.setWorkspacePath(workspacePath);
		view.setVisible(true);
	}

}
