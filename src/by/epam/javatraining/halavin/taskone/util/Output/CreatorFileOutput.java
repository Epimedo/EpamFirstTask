package by.epam.javatraining.halavin.taskone.util.Output;

public class CreatorFileOutput implements Creator,EmptyCreator{

	@Override
	public Output create(String str) {
		FileOutput fout =  new FileOutput(str);
		fout.setFilename(InfoForFile.FILENAMEOUTPUT.getStr());
		return fout;
	}

	@Override
	public Output create() {
		FileOutput fout =  new FileOutput();
		fout.setFilename(InfoForFile.FILENAMEOUTPUT.getStr());
		return fout;
	}

	
}
