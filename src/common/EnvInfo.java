package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* get to environment information */
public class EnvInfo {
	Properties properties;
	
    /* Contractor */
    public EnvInfo() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("info.properties");
        this.properties = new Properties();
        properties.load(is);
        is.close();
    }
    /* getter */
    public String getPropertiesMasterPass(String key) {
    	return this.properties.getProperty(key);
    }
}
