File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\1925566\\eclipse-workspace\\maven_project\\src\\test\\resources\\scr.png");
		FileUtils.copyFile(srcFile, DestFile);
