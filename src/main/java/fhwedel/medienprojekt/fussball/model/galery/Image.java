package fhwedel.medienprojekt.fussball.model.galery;

import org.springframework.web.multipart.MultipartFile;

public class Image {
	private String name;
	private String url;
	private MultipartFile file;
	
	public Image() {}

	/**
	 * @return der Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name Name der gesetzt werden soll
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return die URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url URL die gesetzt werden soll
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return die Datei
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file Datei die gesetzt werden soll
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
