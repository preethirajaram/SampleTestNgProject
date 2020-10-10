package regSuits_Utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
	static Logger log = Logger.getLogger(SuiteListener.class.getName());
	String filePath = System.getProperty("user.dir")+"\\Screenshots\\";
	File file = new File(filePath);
	@Override
    public void onStart(ISuite suite) {
		log.info("*********** ON_SUITE_START ***********");
        System.out.println("Start suite " + suite.getName());
        try {
			FileUtils.cleanDirectory(file);
		} catch (IOException e) {
			log.info("File not found");
			e.printStackTrace();
		}
            
    }
 
    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Finish suite " + suite.getName());
        log.info("*********** ON_SUITE_FINISH ***********");
    }

}
