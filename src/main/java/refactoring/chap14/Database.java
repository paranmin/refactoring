package refactoring.chap14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Database {
	private final Properties properties;
	private final String fileName;

	public Database(String fileName) {
		this.fileName = fileName;
		this.properties = new Properties();
		try (InputStream is = new FileInputStream(fileName);){
			properties.load(is);
			// properties.loadFromXML(is); // 파일명을 xml로 받든지, txt-> xml로 변경 처리 fileName.replace(".txt", ".xml"))
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void set(String key, String value) {
		properties.setProperty(key, value);
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public void update() throws FileNotFoundException, IOException {
		properties.store(new FileOutputStream(fileName), "");
		properties.storeToXML(new FileOutputStream(fileName.replace(".txt", ".xml")), "");
	}

	public Properties getProperties() {
		return properties;
	}

}
